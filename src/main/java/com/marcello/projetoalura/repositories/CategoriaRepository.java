package com.marcello.projetoalura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcello.projetoalura.entities.Categoria;
import com.marcello.projetoalura.entities.Video;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

	
	
}
