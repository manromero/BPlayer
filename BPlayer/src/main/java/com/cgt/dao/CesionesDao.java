package com.cgt.dao;

import java.util.List;

import com.cgt.entity.CesionesEntity;

/**
 * Interfaz del Dao de Cesion
 * @author manromero
 *
 */
public interface CesionesDao {
	
	/**
	 * Devuelve el CesionesEntity por su id
	 * @param idCesion
	 * @return
	 */
	public CesionesEntity findById(Long idCesion);
	
	/**
	 * Devuelve la lista de CesionesEntity que tengan una determinada provincia
	 * @param idProvincia
	 * @return
	 */
	public List<CesionesEntity> findCesionesByIdProvincia(Long idProvincia);
	
	/**
	 * Devuelve la lista de CesionesEntity que tengan una determinada localidad
	 * @param idLocalidades
	 * @return
	 */
	public List<CesionesEntity> findCesionesByIdLocalidad(Long idLocalidades);
	
	/**
	 * Devuelve la lista de CesionesEntity que tengan una determinada entidad
	 * @param idEntidad
	 * @return
	 */
	public List<CesionesEntity> findCesionesByIdEntidad(Long idEntidades);

}
