package com.cgt.dao;

import java.util.List;

import com.cgt.entity.ProvinciasEntity;

/**
 * Interfaz del Dao de ProvinciasEntity
 * @author manromero
 *
 */
public interface ProvinciasDao {
	
	/**
	 * Devuelve todas ProvinciasEntity
	 */
	public List<ProvinciasEntity> findAll();
	
	/**
	 * Devuelve las provincias asociadas al idUsuario
	 * @return
	 */
	public List<ProvinciasEntity> findByUsuarioId(Long idUsuario); 

}
