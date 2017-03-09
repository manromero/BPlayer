package com.cgt.services;

import java.util.List;

import com.cgt.dto.EstadoEquipamientoDto;

public interface EstadoEquipamientoService {

	/**
	 * Devuelve todos los posibles estados que puede tener un equipamiento
	 * @return
	 */
	public List<EstadoEquipamientoDto> findAll();

}
