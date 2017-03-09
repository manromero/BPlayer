package com.cgt.services;

import java.util.List;

import com.cgt.dto.ConvenioDto;

public interface ConveniosService {
	
	/**
	 * Devuelve una lista de ConvenioDto que esten asociadas a una determinada provincia
	 * @return
	 */
	public List<ConvenioDto> findConveniosByIdProvincia(Long idProvincia);
	
	/**
	 * Devuelve una lista de ConvenioDto que esten asociadas a una determinada localidad
	 * @return
	 */
	public List<ConvenioDto> findConveniosByIdLocalidad(Long idLocalidad);
	
	/**
	 * Devuelve una lista de ConvenioDto que esten asociadas a una determinada entidad
	 * @return
	 */
	public List<ConvenioDto> findConveniosByIdEntidad(Long idEntidad);

}
