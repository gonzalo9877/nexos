package com.credibanco.assessment.library.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.model.Libro;
import com.credibanco.assessment.library.repository.AutorJPA;
import com.credibanco.assessment.library.repository.EditorialJPA;
import com.credibanco.assessment.library.repository.LibroJPA;
import com.credibanco.assessment.library.service.LibroServicio;
import com.credibanco.assessment.library.util.TipoFiltro;

@Service
public class LibroServicioImpl implements LibroServicio{

	@Autowired
	private LibroJPA libroDao;
	
	@Autowired
	private AutorJPA autorDao;
	
	@Autowired
	private EditorialJPA editorialDao;

	@Override
	public List<Libro> obtenerTodos() {
		return libroDao.findAll();
	}

	@Override
	public Page<Libro> todosPaginado(int paginaTamano, int paginaNumero) {
		Pageable page = PageRequest.of(paginaNumero, paginaTamano);
		return libroDao.findAll(page);
	}

	@Override
	public Libro insertarLibro(Libro libro) throws Exception {
		for(Autor autor : libro.getAutores()){
			if(!autorDao.findById(autor.getId()).isPresent()){
				throw new Exception("El autor no está registrado");
			}
			
		};
		for(Editorial editorial : libro.getEditoriales()){
			if(!editorialDao.findById(editorial.getId()).isPresent()){
				throw new Exception("La editorial no está registrada");
			}
			Set<Editorial> editoriales = new HashSet<>();
			editoriales.add(editorialDao.findById(editorial.getId()).get());
			int count = libroDao.countByEditorialesIn(editoriales);
			if(editorial.getMaxLibrosRegistrados() != -1 && count >= editorial.getMaxLibrosRegistrados()) {
				throw new Exception("No es posible registrar el libro, se alcanzó el máximo permitido.");
			}
		};
		return libroDao.save(libro);
	}

	@Override
	public Libro actualizarLibro(Libro libro) throws Exception {
		for(Autor autor : libro.getAutores()){
			if(!autorDao.findById(autor.getId()).isPresent()){
				throw new Exception("El autor no está registrado");
			}
			
		};
		for(Editorial editorial : libro.getEditoriales()){
			if(!editorialDao.findById(editorial.getId()).isPresent()){
				throw new Exception("La editorial no está registrada");
			}
			
		};
		return libroDao.save(libro);
	}

	@Override
	public void eliminarLibro(Long idLibro) {
		
		libroDao.deleteById(idLibro);
	}

	@Override
	public Libro obtenerPorId(Long id) throws Exception {
		
		Optional<Libro> opt = libroDao.findById(id);
		if(opt.isPresent()) {
			Libro libro = opt.get();
			return libro;
		} else {
			throw new Exception("Libro no encntrado");
		}
	}

	@Override
	public Libro obtenerFiltrado(TipoFiltro tipo, String busqueda) {
		
		return null;
	}
	
	

}
