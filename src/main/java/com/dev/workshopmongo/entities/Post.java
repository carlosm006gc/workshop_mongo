package com.dev.workshopmongo.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.dev.workshopmongo.dto.AutorDto;

public class Post implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;
	private Date data;
	private String titulo;
	private String corpo;

	private AutorDto autor;

	public Post() {
	}

	public Post(String id, Date data, String titulo, String corpo, AutorDto autor) {
		super();
		this.id = id;
		this.data = data;
		this.titulo = titulo;
		this.corpo = corpo;
		this.autor = autor;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCorpo() {
		return corpo;
	}

	public void setCorpo(String corpo) {
		this.corpo = corpo;
	}

	public AutorDto getAutor() {
		return autor;
	}

	public void setAutor(AutorDto autor) {
		this.autor = autor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return Objects.equals(id, other.id);
	}

}
