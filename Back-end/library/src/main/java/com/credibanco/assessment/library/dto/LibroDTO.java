package com.credibanco.assessment.library.dto;

import java.util.List;

import javax.validation.constraints.NotEmpty;

public class LibroDTO {

	private Long id;
	@NotEmpty
	private String titulo;
	private String anio;
	@NotEmpty
	private String genero;
	@NotEmpty
	private String numeroPaginas;
	@NotEmpty
	private List<AutorDTO> autores;
	@NotEmpty
	private List<EditorialDTO> editoriales;

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

	public List<AutorDTO> getAutores() {
		return autores;
	}

	public void setAutores(List<AutorDTO> autores) {
		this.autores = autores;
	}

	public List<EditorialDTO> getEditoriales() {
		return editoriales;
	}

	public void setEditoriales(List<EditorialDTO> editoriales) {
		this.editoriales = editoriales;
	}
	
	
}
