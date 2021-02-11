package com.credibanco.assessment.library.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.repository.EditorialJPA;
import com.credibanco.assessment.library.service.EditorialServicio;

@Service
public class EditorialServiceImpl implements EditorialServicio {

	@Autowired
	private EditorialJPA editorialDao;
	
	@Override
	public Editorial obtenerPorId(Long id) throws Exception {
		Optional<Editorial> opt =  editorialDao.findById(id);
		if(opt.isPresent()) {
			Editorial Editorial = opt.get();
			return Editorial;
		} else {
			throw new Exception("Editorial no encontrado");
		}
	}

	@Override
	public Editorial insertarLibro(Editorial Editorial) {
		
		return editorialDao.save(Editorial);
	}

	@Override
	public void eliminarLibro(Long idEditorial) {
		editorialDao.deleteById(idEditorial);
		
	}

	@Override
	public Editorial actualizarLibro(Editorial Editorial) {
		return editorialDao.save(Editorial);
	}

	@Override
	public List<Editorial> obtenerTodos() {
		return editorialDao.findAll();
	}

}
