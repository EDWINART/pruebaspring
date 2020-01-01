package com.aval.arbol.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aval.arbol.dto.ResponseDTO;
import com.aval.arbol.entity.Arbol;
import com.aval.arbol.entity.Nodo;
import com.aval.arbol.service.ArbolService;

@Service
public class ArbolServiceImpl implements ArbolService {

	Arbol arbol = new Arbol();

	@Override
	public ResponseDTO agregarNodo(String values) {
		ResponseDTO responseDTO = new ResponseDTO();
		String[] valueElements = values.split(",");
		int[] valueNumber = new int[valueElements.length];
		try {
			valueNumber = transfValues(valueElements);
		} catch (NumberFormatException e) {
			responseDTO.setMessage("Formato de numero incorrecto");
		}

		for (int value : valueNumber) {
			add(value);
		}
		responseDTO.setMessage("Nodos agregados con exito");
		imprimirEntreConNivel();

		return responseDTO;
	}

	@Override
	public ResponseDTO buscarAncestro(String values) {
		ResponseDTO responseDTO = new ResponseDTO();
		Nodo ancestro;

		String[] valueElements = values.split(",");

		if (valueElements.length > 2) {
			responseDTO.setMessage("Debe ingresar unicamente dos valores enteros");
			return responseDTO;
		} else {
			int[] valueNumber = new int[valueElements.length];
			valueNumber = transfValues(valueElements);

			Nodo root = arbol.getRaiz();

			int p = valueNumber[0];
			int q = valueNumber[1];

			ancestro = findAncestor(root, p, q);
			responseDTO.setMessage("El ancestro de " + p + " y " + q + "es: " + ancestro.getValor());

		}

		return responseDTO;
	}

	public boolean existe(int info) {
		Nodo reco = arbol.getRaiz();
		while (reco != null) {
			if (info == reco.getValor())
				return true;
			else if (info > reco.getValor())
				reco = reco.getHojaDerecha();
			else
				reco = reco.getHojaIzquierda();
		}
		return false;
	}

	public void add(int value) {
		if (!existe(value)) {
			Nodo nodo = new Nodo(value);
			if (arbol.getRaiz() == null) {
				arbol.setRaiz(nodo);
			} else {
				Nodo anterior = null, reco;
				reco = arbol.getRaiz();
				while (reco != null) {
					anterior = reco;
					if (nodo.getValor() < reco.getValor())
						reco = reco.getHojaIzquierda();
					else
						reco = reco.getHojaDerecha();
				}
				if (nodo.getValor() < anterior.getValor())
					anterior.setHojaIzquierda(nodo);
				else
					anterior.setHojaDerecha(nodo);
			}
		}

	}

	public int[] transfValues(String[] valueElements) throws NumberFormatException {
		int[] valueNumber = new int[valueElements.length];
		int index = 0;

		for (String value : valueElements) {
			valueNumber[index] = Integer.valueOf(value);
			index++;
		}
		return valueNumber;
	}

	private void imprimirEntreConNivel(Nodo reco, int nivel) {
		if (reco != null) {
			imprimirEntreConNivel(reco.getHojaIzquierda(), nivel + 1);
			System.out.print(reco.getValor() + " (" + nivel + ") - ");
			imprimirEntreConNivel(reco.getHojaDerecha(), nivel + 1);
		}
	}

	public void imprimirEntreConNivel() {
		imprimirEntreConNivel(arbol.getRaiz(), 1);
		System.out.println();
	}

	Nodo findAncestor(Nodo root, int p, int q) {

		if (root == null) {
			return null;
		}

		if (root.getValor() == p || root.getValor() == q) {
			return root;
		} else {

			Nodo l = findAncestor(root.getHojaIzquierda(), p, q);

			Nodo r = findAncestor(root.getHojaDerecha(), p, q);

			if ((l != null) && (r != null)) {
				return root;
			}

			else if (!(l == null)) {
				return l;
			} else {
				return r;
			}
		}
	}

}
