package com.marcello.projetoalura.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marcello.projetoalura.entities.Video;

public interface VideoRepository extends JpaRepository<Video, Long> {

}
