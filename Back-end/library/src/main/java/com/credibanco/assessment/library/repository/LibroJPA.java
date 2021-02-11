package com.credibanco.assessment.library.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessment.library.model.Libro;

public interface LibroJPA extends JpaRepository<Libro, Long>{

	Page<Libro> findAll(Pageable pageable);
}