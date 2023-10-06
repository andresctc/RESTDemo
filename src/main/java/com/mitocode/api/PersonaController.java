package com.mitocode.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@RestController
@RequestMapping("/persona")
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
	
	@GetMapping(value = "/listar/{id}")
	public Optional<Persona> listarId(@PathVariable("id") Integer id) {
		Optional<Persona> persona = Optional.ofNullable(new Persona());
		try {
			persona = service.listarId(id);
		} catch (Exception e) {
			new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return persona;
	}

	@PostMapping(value = "/registrar")
	public ResponseEntity<Integer> regisgtrar(@RequestBody Persona persona) {
		int resultado=0;
		try {
			service.registrar(persona);
			resultado=1;
		} catch (Exception e) {
			new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}
	
	@DeleteMapping(value = "/eliminar/{id}")
	public ResponseEntity<Integer> eliminar(@PathVariable Integer id) {
		int resultado=0;
		try {
			service.eliminar(id);
			resultado=1;
		} catch (Exception e) {
			return new ResponseEntity<Integer>(resultado, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Integer>(resultado, HttpStatus.OK);
	}

}
