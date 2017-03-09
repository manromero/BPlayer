package com.cgt.services;

import java.util.List;

import com.cgt.dto.EntidadDto;

public interface EntidadesService {

	/**
	 * Devuelve las entidades que tiene una determinada localidad
	 * @param idProvincia
	 * @return
	 */
	public List<EntidadDto> findByIdLocalidad(Long idLocalidad);
	
}
