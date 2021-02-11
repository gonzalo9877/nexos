package com.credibanco.assessment.library.api.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.credibanco.assessment.library.dto.EditorialDTO;
import com.credibanco.assessment.library.model.Editorial;

@Component
public class EditorialConversor {

	public EditorialDTO modeloADto(Editorial modelo) {
		EditorialDTO dto = new EditorialDTO();
		dto.setId(modelo.getId());
		dto.setNombre(modelo.getNombre());
		dto.setDireccion(modelo.getDireccion());
		dto.setEmail(modelo.getEmail());
		dto.setMaxLibrosRegistrados(modelo.getMaxLibrosRegistrados());
		dto.setTelefono(modelo.getTelefono());
		return dto;
	}

	public Editorial dtoAModelo(EditorialDTO dto) {
		Editorial modelo = new Editorial();
		modelo.setId(dto.getId());
		modelo.setNombre(dto.getNombre());
		modelo.setDireccion(dto.getDireccion());
		modelo.setEmail(dto.getEmail());
		modelo.setMaxLibrosRegistrados(dto.getMaxLibrosRegistrados());
		modelo.setTelefono(dto.getTelefono());
		return modelo;
	}

	public List<EditorialDTO> listaModeloADto(List<Editorial> listaModelo) {
		List<EditorialDTO> listaDto = new ArrayList<>();
		listaModelo.forEach(modelo -> listaDto.add(modeloADto(modelo)));
		return listaDto;
	}

}
