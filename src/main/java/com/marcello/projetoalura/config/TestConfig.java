package com.marcello.projetoalura.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.marcello.projetoalura.entities.Categoria;
import com.marcello.projetoalura.entities.Video;
import com.marcello.projetoalura.repositories.CategoriaRepository;
import com.marcello.projetoalura.repositories.VideoRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

	@Autowired
	private VideoRepository videoRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Terror");
		Categoria cat2 = new Categoria(null, "Romance");
		Categoria cat3 = new Categoria(null, "Comédia");
		Categoria cat4 = new Categoria(null, "Suspense");

		Video v1 = new Video(null, "Mansão mal assombrada", "Para maiores de 18 anos", " www.url.com.br", cat1);
		Video v2 = new Video(null, "Loucademia", "Classificação livre", "www.url.com.br ", cat3);
		Video v3 = new Video(null, "Titanic", "Classificação Livre", " www.url.com.br", cat2);

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3, cat4));
		videoRepository.saveAll(Arrays.asList(v1, v2, v3));

//		v1.getCategoria().add(cat1);
//		v2.getCategoria().add(cat3);
//		v3.getCategoria().add(cat2);
//		
//		videoRepository.saveAll(Arrays.asList(v1, v2, v3));
	}

}
