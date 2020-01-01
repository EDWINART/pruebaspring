package com.aval.arbol.service;

import com.aval.arbol.dto.ResponseDTO;

public interface ArbolService {
	
	public abstract ResponseDTO agregarNodo(String values);
	
	public abstract ResponseDTO buscarAncestro(String values);

}
