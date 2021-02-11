package com.credibanco.assessment.library.service;

import java.util.List;

import com.credibanco.assessment.library.model.Autor;

public interface AutorServicio {

	Autor obtenerPorId(Long id) throws Exception;

	Autor insertarLibro(Autor autor);

	void eliminarLibro(Long idAutor);

	Autor actualizarLibro(Autor dtoAModelo);

	List<Autor> obtenerTodos();


}
