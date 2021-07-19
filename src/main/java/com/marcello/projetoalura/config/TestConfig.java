package com.marcello.projetoalura.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcello.projetoalura.entities.Video;
import com.marcello.projetoalura.repositories.VideoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private VideoRepository videoRepository;

	@Override
	public void run(String... args) throws Exception {

		Video v1 = new Video(null, "Lavoura", "Agronegocio", " , ");
		Video v2 = new Video(null, "Pintado", "Pesca", " , ");
		videoRepository.saveAll(Arrays.asList(v1, v2));

	}

}
