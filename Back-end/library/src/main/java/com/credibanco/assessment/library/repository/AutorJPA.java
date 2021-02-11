package com.credibanco.assessment.library.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessment.library.model.Autor;

public interface AutorJPA extends JpaRepository<Autor, Long> {
	List<Autor> findAllByNombreCompletoContaining(String nombreCompleto);
}
