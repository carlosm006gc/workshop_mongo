package com.dev.workshopmongo.Controllers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.workshopmongo.entities.Usuario;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioController {
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Usuario>> findAll(){
		Usuario maria = new Usuario("1", "maria", "maria@gmail.com");
		Usuario alex = new Usuario("2", "alex", "alex@gmail.com");
		List<Usuario> list = new ArrayList<>();
		list.addAll(Arrays.asList(maria, alex));
		return ResponseEntity.ok().body(list);
	} 

}
