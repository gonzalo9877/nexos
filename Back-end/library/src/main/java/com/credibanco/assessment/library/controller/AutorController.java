package com.credibanco.assessment.library.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.credibanco.assessment.library.api.client.AutorConversor;
import com.credibanco.assessment.library.dto.AutorDTO;
import com.credibanco.assessment.library.service.AutorServicio;

@RestController
@RequestMapping("autor")
@CrossOrigin
public class AutorController {

	private final Logger logger = LogManager.getLogger(LibroController.class);

	@Autowired
	private AutorServicio servicio;

	@Autowired
	private AutorConversor conversor;

	@GetMapping
	public List<AutorDTO> obtenerTodos() {
		try {
			return conversor.listaModeloADto(servicio.obtenerTodos());
		} finally {
			logger.info("finalizando consumo api obtenerTodos");
		}
	}

	@GetMapping("/obtener-por-id/{id}")
	public AutorDTO obtenerLibro(@RequestParam(value = "id") Long id) throws Exception {

		try {
			return conversor.modeloADto(servicio.obtenerPorId(id));
		} finally {
			logger.info("finalizando consumo api obtenerLibro");
		}
	}

	@PostMapping
	public AutorDTO insertarLibro(@RequestBody AutorDTO libro) throws Exception {
		try {
			return conversor.modeloADto(servicio.insertarLibro(conversor.dtoAModelo(libro)));
		} finally {
			logger.info("finalizando consumo api insertarLibro");
		}
	}

	@PutMapping
	public AutorDTO actualizarLibro(@RequestBody AutorDTO libro) throws Exception {
		try {
			return conversor.modeloADto(servicio.actualizarLibro(conversor.dtoAModelo(libro)));
		} finally {
			logger.info("finalizando consumo api actualizarLibro");
		}
	}

	@DeleteMapping("/{id}")
	public void eliminarLibro(@RequestParam(value = "id") Long idAutor) {
		try {
			servicio.eliminarLibro(idAutor);
		} finally {
			logger.info("finalizando consumo api eliminarLibro");
		}
	}
}
