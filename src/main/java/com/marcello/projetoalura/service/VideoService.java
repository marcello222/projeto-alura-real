package com.marcello.projetoalura.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.marcello.projetoalura.entities.Video;
import com.marcello.projetoalura.repositories.VideoRepository;
import com.marcello.projetoalura.service.exception.DatabaseException;
import com.marcello.projetoalura.service.exception.ResourceNotFoundException;

@Service
public class VideoService {

	@Autowired
	public VideoRepository repository;

	public List<Video> findAll() {
		return repository.findAll();
	}

	public Video findById(String id) {
		Optional<Video> obj = repository.findById(id);
		return obj.get();
	}

	public Video insert(Video obj) {
		return repository.save(obj);
	}

	public Video update(String id, Video obj) {
		try {
			Video entity = repository.getOne(id);
			updateVideo(entity, obj);
			return repository.save(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateVideo(Video entity, Video obj) {
		entity.setDescricao(obj.getDescricao());
		entity.setTitulo(obj.getTitulo());
		entity.setUrl(obj.getUrl());

	}

	public void delete(String id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}

	
	public List<Video> findByTitulo(String text) {
		return repository.findByTituloIgnoreCase(text);
	}

}
