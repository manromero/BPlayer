package com.cgt.dao;

import java.util.List;

import com.cgt.entity.PersContactoEntity;

public interface PersContactoDao {
	
	/**
	 * Devuelve las personas de contacto asociadas a una entidad
	 * @param idEntidad
	 * @return
	 */
	public List<PersContactoEntity> findByIdEntidad(Long idEntidad);
	
	/**
	 * Devuelve las personas de contacto asociadas a una cesion
	 * @param iCesion
	 * @return
	 */
	public List<PersContactoEntity> findByIdCesion(Long idCesion);
	
	/**
	 * Devuelve las personas de contacto asociadas a un contacto
	 * @param idConvenio
	 * @return
	 */
	public List<PersContactoEntity> findByIdConvenio(Long idConvenio);

}
