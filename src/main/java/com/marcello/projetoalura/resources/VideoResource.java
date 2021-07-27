package com.marcello.projetoalura.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.marcello.projetoalura.entities.Video;
import com.marcello.projetoalura.resources.util.URL;
import com.marcello.projetoalura.service.VideoService;

@RestController
@RequestMapping(value = "/videos")
public class VideoResource {

	@Autowired
	private VideoService service;

	@GetMapping
	public ResponseEntity<List<Video>> findAll() {
		List<Video> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Video> findById(@PathVariable String id) {
		Video obj = service.findById(id);
		return ResponseEntity.ok().body(obj);
	}

	@PostMapping
	public ResponseEntity<Video> insert(@RequestBody Video obj) {
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<Video> update(@PathVariable String id, @RequestBody Video obj) {
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable String id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	
	@RequestMapping(value="/search", method=RequestMethod.GET)
	public ResponseEntity<List<Video>> findByTitulo(@RequestParam(value="text", defaultValue ="") String text) {
		text = URL.decodeParam(text);
		List<Video> list = service.findByTitulo(text);		
		return ResponseEntity.ok().body(list);		
	}

}
