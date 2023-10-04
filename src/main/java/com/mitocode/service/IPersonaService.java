package com.mitocode.service;

import java.util.List;
import java.util.Optional;

import com.mitocode.model.Persona;

public interface IPersonaService {
	
	void registrar (Persona per);
	void modificar (Persona per);
	void eliminar (Integer Id);
	List<Persona> listar();
	Optional<Persona> listarId(Integer Id);

}
