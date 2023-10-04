package com.mitocode.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@RestController
@RequestMapping("/persona/api/v1")
@CrossOrigin("*")
public class PersonaController {
	
	@Autowired
	private IPersonaService service;

	@GetMapping(value = "/listar")
	public ResponseEntity<List<Persona>> listar() {
		List<Persona> lista = new ArrayList<>();
		try {
			lista = service.listar();
		} catch (Exception e) {
			return new ResponseEntity<List<Persona>>(lista, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Persona>>(lista, HttpStatus.OK);
		
	}


}
