package com.credibanco.assessment.library.service;

import java.util.List;

import com.credibanco.assessment.library.model.Editorial;

public interface EditorialServicio {

	List<Editorial> obtenerTodos();

	Editorial obtenerPorId(Long id) throws Exception;

	Editorial actualizarLibro(Editorial editorial);

	void eliminarLibro(Long idEditorial);

	Editorial insertarLibro(Editorial editorial);

}
