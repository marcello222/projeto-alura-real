package com.marcello.projetoalura.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.marcello.projetoalura.entities.Video;


@EnableJpaRepositories
public interface VideoRepository extends JpaRepository<Video, Long> {


	
	}
