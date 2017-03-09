package com.cgt.dao;

import java.util.List;

import com.cgt.entity.TipoEquipamientoEntity;

/**
 * Interfaz del Dao de TipoEquipamientoEntity
 * @author manromero
 *
 */
public interface TipoEquipamientoDao {
	
	/**
	 * Devuelve todo los tipo de equipamiento que existen
	 * @return
	 */
	public List<TipoEquipamientoEntity> findAll();

}
