package com.credibanco.assessment.library.api.client;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.credibanco.assessment.library.dto.AutorDTO;
import com.credibanco.assessment.library.dto.EditorialDTO;
import com.credibanco.assessment.library.dto.LibroDTO;
import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.model.Libro;

@Component
public class LibroConversor {

	public LibroDTO modeloADto(Libro modelo) {
		LibroDTO dto = new LibroDTO();
		List<AutorDTO> Autores = new ArrayList<>();
		List<EditorialDTO> editoriales = new ArrayList<>();

		dto.setId(modelo.getId());
		dto.setAnio(modelo.getAnio());
		dto.setGenero(modelo.getGenero());
		dto.setNumeroPaginas(modelo.getNumeroPaginas());
		dto.setTitulo(modelo.getTitulo());

		List<Editorial> listaModeloEditoriales = new ArrayList<>(modelo.getEditoriales());
		listaModeloEditoriales.forEach(editorialModelo -> {
			EditorialDTO editorialDto = new EditorialDTO();
			editorialDto.setId(editorialModelo.getId());
			editorialDto.setNombre(editorialModelo.getNombre());
			editorialDto.setDireccion(editorialModelo.getDireccion());
			editorialDto.setEmail(editorialModelo.getEmail());
			editorialDto.setMaxLibrosRegistrados(editorialModelo.getMaxLibrosRegistrados());
			editorialDto.setTelefono(editorialModelo.getTelefono());
			editoriales.add(editorialDto);
		});

		List<Autor> listaModeloAutor = new ArrayList<>(modelo.getAutores());
		listaModeloAutor.forEach(autorModelo -> {
			AutorDTO autorDto = new AutorDTO();
			autorDto.setId(autorModelo.getId());
			autorDto.setNombreCompleto(autorModelo.getNombreCompleto());
			autorDto.setEmail(autorModelo.getEmail());
			autorDto.setCiudad(autorModelo.getCiudad());
			autorDto.setFechaNacimiento(autorModelo.getFechaNacimiento());
			Autores.add(autorDto);
		});
		dto.setAutores(Autores);

		dto.setEditoriales(editoriales);
		return dto;
	}

	public List<LibroDTO> listaModeloADto(List<Libro> libros) {
		List<LibroDTO> listaDto = new ArrayList<>();
		libros.forEach(libro -> listaDto.add(modeloADto(libro)));
		return listaDto;
	}

	public Libro dtoAModelo(LibroDTO dto) {
		Libro modelo = new Libro();
		Set<Autor> AutoresModelo = new HashSet<>();
		Set<Editorial> editorialesModelo = new HashSet<>();

		modelo.setId(dto.getId());
		modelo.setAnio(dto.getAnio());
		modelo.setGenero(dto.getGenero());
		modelo.setNumeroPaginas(dto.getNumeroPaginas());
		modelo.setTitulo(dto.getTitulo());

		dto.getEditoriales().forEach(editorialDto -> {
			Editorial editorialModelo = new Editorial();
			editorialModelo.setId(editorialDto.getId());
			editorialModelo.setNombre(editorialDto.getNombre());
			editorialModelo.setDireccion(editorialDto.getDireccion());
			editorialModelo.setEmail(editorialDto.getEmail());
			editorialModelo.setMaxLibrosRegistrados(editorialDto.getMaxLibrosRegistrados());
			editorialModelo.setTelefono(editorialDto.getTelefono());
			editorialesModelo.add(editorialModelo);
		});

		dto.getAutores().forEach(autorDto -> {
			Autor autorModelo = new Autor();
			autorModelo.setId(autorDto.getId());
			autorModelo.setNombreCompleto(autorDto.getNombreCompleto());
			autorModelo.setEmail(autorDto.getEmail());
			autorModelo.setCiudad(autorDto.getCiudad());
			autorModelo.setFechaNacimiento(autorDto.getFechaNacimiento());
			AutoresModelo.add(autorModelo);
		});
		modelo.setAutores(AutoresModelo);

		modelo.setEditoriales(editorialesModelo);
		return modelo;
	}

	

}
