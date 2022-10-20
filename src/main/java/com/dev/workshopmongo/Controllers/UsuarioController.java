package com.dev.workshopmongo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dev.workshopmongo.dto.UsuarioDto;
import com.dev.workshopmongo.entities.Usuario;
import com.dev.workshopmongo.services.UsuarioService;

@RestController
@RequestMapping(value = "/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UsuarioDto>> findAll(){
		List<Usuario> list = service.findAll();
		List<UsuarioDto> listDto = list.stream().map(x -> new UsuarioDto(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDto);
	} 

}
