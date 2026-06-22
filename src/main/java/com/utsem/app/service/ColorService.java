package com.utsem.app.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.utsem.app.dto.ColorDTO;
import com.utsem.app.model.Color;
import com.utsem.app.repo.ColorRepo;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ColorService {

	@Autowired
	ColorRepo colorRepo;

	@Autowired
	ModelMapper mapper;

	public List<ColorDTO> listar() {
		return colorRepo.findAll().stream().map(color -> mapper.map(color, ColorDTO.class)).toList();
	}

	public void guardar(ColorDTO colorDTO) {

	    if (colorDTO.getId() != null) {

	        Color color = colorRepo.findById(colorDTO.getId())
	                .orElseThrow(() ->
	                        new EntityNotFoundException("Color no encontrado"));

	        color.setNombreJonatanMG(colorDTO.getNombreJonatanMG());

	        colorRepo.save(color);

	    } else {

	        colorRepo.save(
	                mapper.map(colorDTO, Color.class));
	    }
	}

	public ColorDTO obtenerColorId(Long id) {

	    Color color = colorRepo.findById(id)
	            .orElseThrow(() ->
	                    new EntityNotFoundException("Color no encontrado"));

	    return mapper.map(color, ColorDTO.class);
	}

	public void eliminar(Long id) {
		colorRepo.deleteById(id);
	}
}