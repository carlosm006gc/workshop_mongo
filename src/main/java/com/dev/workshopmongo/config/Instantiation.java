package com.dev.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dev.workshopmongo.entities.Usuario;
import com.dev.workshopmongo.repository.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired 
	private UsuarioRepository repository;
	
	@Override
	public void run(String... args) throws Exception {
		
		repository.deleteAll();

		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

		repository.saveAll(Arrays.asList(maria, alex, bob));
	}

}