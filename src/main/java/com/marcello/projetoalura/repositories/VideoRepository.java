package com.marcello.projetoalura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcello.projetoalura.entities.Video;


public interface VideoRepository extends JpaRepository<Video, String> {

	List<Video> findByTituloIgnoreCase(String text);
	
	
	}
