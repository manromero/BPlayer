package com.cgt.dao;

import java.util.List;

import com.cgt.entity.LocalidadesEntity;

public interface LocalidadesDao {
	
	/**
	 * Devuelve las localidades asociadas a una provincia
	 * @param idProvincia
	 * @return
	 */
	public List<LocalidadesEntity> findByIdProvincia(Long idProvincia);

}
