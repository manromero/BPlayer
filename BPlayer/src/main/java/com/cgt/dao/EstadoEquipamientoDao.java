package com.cgt.dao;

import java.util.List;

import com.cgt.entity.EstadoEquipamientoEntity;

public interface EstadoEquipamientoDao {
	
	/**
	 * Devuelve todos los posibles estados que puede tener un equipamiento
	 * @return
	 */
	public List<EstadoEquipamientoEntity> findAll();

}
