package com.credibanco.assessment.library.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

public class EditorialDTO {

	private Long id;
	@NotEmpty
	private String nombre;
	@NotEmpty
	private String direccion;
	@NotEmpty
	private String telefono;
	private String email;
	@NotNull
	private int maxLibrosRegistrados;
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
	
	
}
