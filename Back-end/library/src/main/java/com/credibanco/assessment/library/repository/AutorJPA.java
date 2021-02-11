package com.credibanco.assessment.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.credibanco.assessment.library.model.Autor;

public interface AutorJPA extends JpaRepository<Autor, Long> {

}
