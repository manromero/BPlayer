package com.cgt.services;

import java.util.List;

import com.cgt.dto.PersContactoDto;

public interface PersContactoService {
	
	/**
	 * Devuelve las personas de contacto asociadas a una entidad
	 * @param idEntidad
	 * @return
	 */
	public List<PersContactoDto> findByIdEntidad(Long idEntidad);
	
	/**
	 * Devuelve las personas de contacto asociadas a una cesion
	 * @param iCesion
	 * @return
	 */
	public List<PersContactoDto> findByIdCesion(Long idCesion);
	
	/**
	 * Devuelve las personas de contacto asociadas a un contacto
	 * @param idConvenio
	 * @return
	 */
	public List<PersContactoDto> findByIdConvenio(Long idConvenio);

}
