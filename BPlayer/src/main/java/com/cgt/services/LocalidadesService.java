package com.cgt.services;

import java.util.List;

import com.cgt.dto.LocalidadDto;

public interface LocalidadesService {

	/**
	 * Devuelve las localidades que tiene una provincia determinada
	 * @param idProvincia
	 * @return
	 */
	public List<LocalidadDto> findByIdProvincia(Long idProvincia);
	
}
