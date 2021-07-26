package com.marcello.projetoalura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcello.projetoalura.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
