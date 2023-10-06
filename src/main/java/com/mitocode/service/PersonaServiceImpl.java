package com.mitocode.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	private final IPersonaDAO iPersonaDAOReposotiry;

    PersonaServiceImpl(IPersonaDAO iPersonaDAOReposotiry) {
        this.iPersonaDAOReposotiry = iPersonaDAOReposotiry;
    }

	@Override
	public void registrar(Persona per) {
		iPersonaDAOReposotiry.save(per);
		
	}

	@Override
	public void modificar(Persona per) {
		iPersonaDAOReposotiry.save(per);
		
	}

	@Override
	public void eliminar(Integer Id) {
		//recuperar Entity persona
		iPersonaDAOReposotiry.deleteById(Id);
	}

	@Override
	public List<Persona> listar() {
		return iPersonaDAOReposotiry.findAll();
	}

	@Override
	public Optional<Persona> listarId(Integer id) {
		//recuperar Entity persona
		return iPersonaDAOReposotiry.findById(id);
	}

}
