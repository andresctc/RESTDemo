package com.mitocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mitocode.model.Persona;

public interface IPersonaDAO extends JpaRepository<Persona, Integer>{
	
}
