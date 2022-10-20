package com.dev.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dev.workshopmongo.dto.UsuarioDto;
import com.dev.workshopmongo.entities.Usuario;
import com.dev.workshopmongo.repository.UsuarioRepository;
import com.dev.workshopmongo.services.exception.ObjectNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository repository;
	
	public List<Usuario> findAll(){
		return repository.findAll();
	}
	
	public Usuario findById(String id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public Usuario insert(Usuario usuario) {
		return repository.insert(usuario);
	}
	
	public Usuario fromDto(UsuarioDto usuarioDto) {
		return new Usuario(usuarioDto.getId(),usuarioDto.getNome(), usuarioDto.getEmail());
	}
}
