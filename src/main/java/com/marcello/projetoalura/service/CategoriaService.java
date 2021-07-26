package com.marcello.projetoalura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marcello.projetoalura.entities.Categoria;
import com.marcello.projetoalura.repositories.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	public CategoriaRepository repository;

	public List<Categoria> findAll() {
		return repository.findAll();
	}

	public Categoria findById(Long id) {
		Optional<Categoria> obj = repository.findById(id);
		return obj.get();
	}

}
