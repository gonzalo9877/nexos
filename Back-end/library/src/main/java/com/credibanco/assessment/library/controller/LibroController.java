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

import com.credibanco.assessment.library.api.client.LibroConversor;
import com.credibanco.assessment.library.dto.LibroDTO;
import com.credibanco.assessment.library.service.LibroServicio;
import com.credibanco.assessment.library.util.TipoFiltro;

@RestController
@RequestMapping("libro")
@CrossOrigin
public class LibroController {

	private final Logger logger = LogManager.getLogger(LibroController.class);

	@Autowired
	private LibroServicio servicio;

	@Autowired
	private LibroConversor conversor;

	@GetMapping
	public List<LibroDTO> obtenerTodos() {
		try {
			return conversor.listaModeloADto(servicio.obtenerTodos());
		} finally {
			logger.info("finalizando consumo api obtenerTodos");
		}
	}

	@GetMapping("/obtener-por-id/{id}")
	public LibroDTO obtenerLibro(@RequestParam(value = "id") Long id) throws Exception {

		try {
			return conversor.modeloADto(servicio.obtenerPorId(id));
		} finally {
			logger.info("finalizando consumo api obtenerLibro");
		}
	}

	@GetMapping("/obtener-por-filtro/{tipo}/{busqueda}")
	public LibroDTO obtenerLibro(@RequestParam(value = "tipo") TipoFiltro tipo,
			@RequestParam(value = "busqueda") String busqueda) {

		try {
			return conversor.modeloADto(servicio.obtenerFiltrado(tipo, busqueda));
		} finally {
			logger.info("finalizando consumo api obtenerLibro");
		}
	}

	@GetMapping("/Pagina")
	public List<LibroDTO> pagina(@RequestParam(value = "paginaTamano") int paginaTamano,
			@RequestParam(value = "paginaNumero") int paginaNumero) {

		try {
			return conversor.listaModeloADto(servicio.todosPaginado(paginaTamano, paginaNumero).getContent());
		} finally {
			logger.info("finalizando consumo api pagina");
		}
	}

	@PostMapping
	public LibroDTO insertarLibro(@RequestBody LibroDTO libro) throws Exception {
		try {
			return conversor.modeloADto(servicio.insertarLibro(conversor.dtoAModelo(libro)));
		} finally {
			logger.info("finalizando consumo api insertarLibro");
		}
	}

	@PutMapping
	public LibroDTO actualizarLibro(@RequestBody LibroDTO libro) throws Exception {
		try {
			return conversor.modeloADto(servicio.actualizarLibro(conversor.dtoAModelo(libro)));
		} finally {
			logger.info("finalizando consumo api actualizarLibro");
		}
	}

	@DeleteMapping("/{id}")
	public void eliminarLibro(@RequestParam(value = "id") Long idLibro) {
		try {
			servicio.eliminarLibro(idLibro);
		} finally {
			logger.info("finalizando consumo api eliminarLibro");
		}
	}
}
