package com.dev.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.workshopmongo.entities.Post;
import com.dev.workshopmongo.repository.PostRepository;
import com.dev.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository postRepository;

	public List<Post> findByTitulo(String texto) {
		return postRepository.findByTitulo(texto);
	}

	public Post findById(String id) {
		Optional<Post> post = postRepository.findById(id);
		return post.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> fullSearch(String texto, Date minData, Date maxData) {
		maxData = new Date(maxData.getTime() + 24 * 60 * 60 * 1000);
		return postRepository.fullSearch(texto, minData, maxData);
	}

}