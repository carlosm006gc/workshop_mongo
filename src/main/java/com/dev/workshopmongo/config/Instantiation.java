package com.dev.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.dev.workshopmongo.dto.AutorDto;
import com.dev.workshopmongo.dto.ComentarioDTO;
import com.dev.workshopmongo.entities.Post;
import com.dev.workshopmongo.entities.Usuario;
import com.dev.workshopmongo.repository.PostRepository;
import com.dev.workshopmongo.repository.UsuarioRepository;

@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UsuarioRepository repository;

	@Autowired
	private PostRepository postRepository;

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

		repository.deleteAll();
		postRepository.deleteAll();

		Usuario maria = new Usuario(null, "Maria Brown", "maria@gmail.com");
		Usuario alex = new Usuario(null, "Alex Green", "alex@gmail.com");
		Usuario bob = new Usuario(null, "Bob Grey", "bob@gmail.com");

		repository.saveAll(Arrays.asList(maria, alex, bob));

		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu viagem", "Vou viajar para São Paulo. Abraços!",
				new AutorDto(maria));
		Post post2 = new Post(null, sdf.parse("2018/03/23"), "Bom dia", "Acordei feliz hoje!", new AutorDto(maria));

		ComentarioDTO c1 = new ComentarioDTO("Boa viagem mano!",sdf.parse("21/03/2018"), new AutorDto(alex));
		ComentarioDTO c2 = new ComentarioDTO("Aproveite!",sdf.parse("22/03/2018"), new AutorDto(bob));
		ComentarioDTO c3 = new ComentarioDTO("Tenha um ótimo dia!",sdf.parse("23/03/2018"), new AutorDto(alex));
		
		post1.getComentarios().addAll(Arrays.asList(c1, c2));
		post2.getComentarios().addAll(Arrays.asList(c3));
		
		postRepository.saveAll(Arrays.asList(post1, post2));
		
		maria.getPosts().addAll(Arrays.asList(post1, post2));
		repository.save(maria);
	}

}