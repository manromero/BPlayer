package com.cgt.dao;

import java.util.List;

import com.cgt.entity.EntidadesEntity;

public interface EntidadesDao {
	
	/**
	 * Devuelve las entidades asociadas a una determinada localidad
	 * @param idLocalidades
	 * @return
	 */
	public List<EntidadesEntity> findByIdLocalidad(Long idLocalidades);

}
