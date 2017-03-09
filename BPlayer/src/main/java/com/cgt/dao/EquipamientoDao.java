package com.cgt.dao;

import java.util.List;

import com.cgt.entity.EquipamientoEntity;

public interface EquipamientoDao {
	
	/**
	 * Devuelve los equipamientos con estado disponible
	 * @return
	 */
	public List<EquipamientoEntity> findEquipamientosDisponibles();
	
	/**
	 * Devuelve los equipamientos con estado disponible y de un tipo determinado
	 * @param idTipoEquipamiento
	 * @return
	 */
	public List<EquipamientoEntity> findEquipamientosDisponiblesByIdTipoEquipamiento(Long idTipoEquipamiento);

}
