package com.credibanco.assessment.library.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "editorial")
public class Editorial {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nombre")
	@NotEmpty
	private String nombre;
	
	@Column(name = "direccion")
	@NotEmpty
	private String direccion;
	
	@Column(name = "telefono")
	@NotEmpty
	private String telefono;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "max_libros")
	@NotNull
	private int maxLibrosRegistrados;
	
	@ManyToMany(mappedBy = "editoriales")
	private Set<Libro> libros;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getMaxLibrosRegistrados() {
		return maxLibrosRegistrados;
	}

	public void setMaxLibrosRegistrados(int maxLibrosRegistrados) {
		this.maxLibrosRegistrados = maxLibrosRegistrados;
	}

	public Set<Libro> getLibros() {
		return libros;
	}

	public void setLibros(Set<Libro> libros) {
		this.libros = libros;
	}
	
}
