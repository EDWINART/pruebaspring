package com.aval.arbol.entity;

public class Nodo {

	private Nodo padre;
	private Nodo hojaDerecha;
	private Nodo hojaIzquierda;
	private int valor;

	public Nodo(int valor) {
		this.valor = valor;
	}

	public Nodo getPadre() {
		return padre;
	}

	public void setPadre(Nodo padre) {
		this.padre = padre;
	}

	public Nodo getHojaDerecha() {
		return hojaDerecha;
	}

	public void setHojaDerecha(Nodo hojaDerecha) {
		this.hojaDerecha = hojaDerecha;
	}

	public Nodo getHojaIzquierda() {
		return hojaIzquierda;
	}

	public void setHojaIzquierda(Nodo hojaIzquierda) {
		this.hojaIzquierda = hojaIzquierda;
	}

	public int getValor() {
		return valor;
	}

	public void setValor(int valor) {
		this.valor = valor;
	}

}
