package com.cgt.services;

import java.util.List;

import com.cgt.dto.TipoEquipamientoDto;

public interface TipoEquipamientoService {
	
	/**
	 * Devuelve todos los tipos de equipamiento que existen
	 * @return
	 */
	public List<TipoEquipamientoDto> findAll();

}
