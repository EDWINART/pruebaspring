package com.aval.arbol.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.aval.arbol.dto.ResponseDTO;
import com.aval.arbol.service.ArbolService;


@RestController
public class ArbolController {
	
	@Autowired
	private ArbolService arbolService;
	
	@RequestMapping(value = "/add", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ResponseDTO> addNodes(@RequestBody String values){
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO = arbolService.agregarNodo(values);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/ancestor", method = RequestMethod.POST, produces = "application/json")
	public ResponseEntity<ResponseDTO> findAncestor(@RequestBody String values){
		ResponseDTO responseDTO = new ResponseDTO();
		responseDTO = arbolService.buscarAncestro(values);
		return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
	}

}
