package com.credibanco.assessment.library.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "libro")
public class Libro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "titulo")
	@NotEmpty
	private String titulo;
	
	@Column(name = "anio")
	private String anio;
	
	@Column(name = "genero")
	@NotEmpty
	private String genero;
	
	@Column(name = "numero_paginas")
	@NotEmpty
	private String numeroPaginas;
	
	@ManyToMany
	@JoinTable(
			  name = "libro_editorial", 
			  joinColumns = @JoinColumn(name = "libro_id"), 
			  inverseJoinColumns = @JoinColumn(name = "editorial_id"))
	private Set<Editorial> editoriales;
	
	@ManyToMany
	@JoinTable(
			  name = "libro_autor", 
			  joinColumns = @JoinColumn(name = "libro_id"), 
			  inverseJoinColumns = @JoinColumn(name = "autor_id"))
	private Set<Autor> autores;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public String getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(String numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public Set<Editorial> getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(Set<Editorial> editoriales) {
		this.editoriales = editoriales;
	}

	public Set<Autor> getAutores() {
		return autores;
	}

	public void setAutores(Set<Autor> autores) {
		this.autores = autores;
	}
	
}
