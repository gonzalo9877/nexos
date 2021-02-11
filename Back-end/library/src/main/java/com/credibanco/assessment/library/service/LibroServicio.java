package com.credibanco.assessment.library.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.credibanco.assessment.library.model.Libro;
import com.credibanco.assessment.library.util.TipoFiltro;

public interface LibroServicio {

	List<Libro> obtenerTodos();

	Page<Libro> todosPaginado(int paginaTamano, int paginaNumero);

	Libro insertarLibro(Libro libro) throws Exception;

	Libro actualizarLibro(Libro libro) throws Exception;

	void eliminarLibro(Long idLibro);

	Libro obtenerPorId(Long id) throws Exception;

	Libro obtenerFiltrado(TipoFiltro tipo, String busqueda);

}
