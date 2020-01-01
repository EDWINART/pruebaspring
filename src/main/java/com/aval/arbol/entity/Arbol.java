package com.aval.arbol.entity;

public class Arbol {

	private Nodo raiz;
	
	public Arbol() {
		
	}

	public Arbol(Nodo raiz) {
		this.raiz = raiz;
	}

	public Arbol(int valor) {
		this.raiz = new Nodo(valor);
	}

	public Nodo getRaiz() {
		return raiz;
	}

	public void setRaiz(Nodo raiz) {
		this.raiz = raiz;
	}

}
