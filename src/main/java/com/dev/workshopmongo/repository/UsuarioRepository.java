package com.dev.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.dev.workshopmongo.entities.Usuario;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String>{

}
