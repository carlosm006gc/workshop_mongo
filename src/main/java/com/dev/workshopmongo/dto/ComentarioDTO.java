package com.dev.workshopmongo.dto;

import java.io.Serializable;
import java.util.Date;

public class ComentarioDTO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String texto;
	private Date data;
	private AutorDto autorDto;

	public ComentarioDTO() {
	}

	public ComentarioDTO(String texto, Date data, AutorDto autorDto) {
		this.texto = texto;
		this.data = data;
		this.autorDto = autorDto;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public AutorDto getAutorDto() {
		return autorDto;
	}

	public void setAutorDto(AutorDto autorDto) {
		this.autorDto = autorDto;
	}

}
