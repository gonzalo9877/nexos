package com.credibanco.assessment.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.model.Autor;
import com.credibanco.assessment.library.repository.AutorJPA;
import com.credibanco.assessment.library.service.AutorServicio;

@Service
public class AutorServicioImpl implements AutorServicio{

	@Autowired
	private AutorJPA autorDao;
	
	@Override
	public Autor obtenerPorId(Long id) throws Exception {
		Optional<Autor> opt =  autorDao.findById(id);
		if(opt.isPresent()) {
			Autor autor = opt.get();
			return autor;
		} else {
			throw new Exception("Autor no encontrado");
		}
	}

	@Override
	public Autor insertarLibro(Autor autor) {
		
		return autorDao.save(autor);
	}

	@Override
	public void eliminarLibro(Long idAutor) {
		autorDao.deleteById(idAutor);
		
	}

	@Override
	public Autor actualizarLibro(Autor autor) {
		return autorDao.save(autor);
	}

	@Override
	public List<Autor> obtenerTodos() {
		return autorDao.findAll();
	}

}
