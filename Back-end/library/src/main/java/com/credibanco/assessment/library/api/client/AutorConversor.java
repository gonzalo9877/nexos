package com.credibanco.assessment.library.api.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.credibanco.assessment.library.dto.AutorDTO;
import com.credibanco.assessment.library.model.Autor;

@Component
public class AutorConversor {

	public AutorDTO modeloADto(Autor modelo) {
		
		AutorDTO autorDto = new AutorDTO();
		autorDto.setId(modelo.getId());
		autorDto.setNombreCompleto(modelo.getNombreCompleto());
		autorDto.setEmail(modelo.getEmail());
		autorDto.setCiudad(modelo.getCiudad());
		autorDto.setFechaNacimiento(modelo.getFechaNacimiento());
		
		return autorDto;
	}

	public Autor dtoAModelo(AutorDTO dto) {
		
		Autor autorModelo = new Autor();
		autorModelo.setId(dto.getId());
		autorModelo.setNombreCompleto(dto.getNombreCompleto());
		autorModelo.setEmail(dto.getEmail());
		autorModelo.setCiudad(dto.getCiudad());
		autorModelo.setFechaNacimiento(dto.getFechaNacimiento());
		
		return autorModelo;
	}

	public List<AutorDTO> listaModeloADto(List<Autor> listaModelo) {
		List<AutorDTO> listaDto = new ArrayList<>();
		listaModelo.forEach(modelo -> listaDto.add(modeloADto(modelo)));
		return listaDto;
	}

}
