package com.dev.workshopmongo.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.workshopmongo.controllers.util.URL;
import com.dev.workshopmongo.entities.Post;
import com.dev.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

	@Autowired
	private PostService postService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Post> findById(@PathVariable String id) {
		Post post = postService.findById(id);
		return ResponseEntity.ok().body(post);
	}

	@RequestMapping(value = "/buscaTitulo", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> findByTitulo(@RequestParam(value = "texto", defaultValue = "") String texto) {
		texto = URL.decodeParam(texto);
		List<Post> list = postService.findByTitulo(texto);
		return ResponseEntity.ok().body(list);
	}

	@RequestMapping(value = "/fullSearch", method = RequestMethod.GET)
	public ResponseEntity<List<Post>> fullSearch(
			@RequestParam(value = "texto", defaultValue = "") String texto, 
			@RequestParam(value = "minData", defaultValue = "") String minData, 
			@RequestParam(value = "maxData", defaultValue = "") String maxData) {
		texto = URL.decodeParam(texto);
		Date min = URL.convertData(minData, new Date(0L));
		Date max = URL.convertData(maxData, new Date());
		List<Post> list = postService.fullSearch(texto, min, max);
		return ResponseEntity.ok().body(list);
	}

}