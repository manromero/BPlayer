package com.cgt.dao;

import java.util.List;

import com.cgt.entity.ConveniosEntity;

/**
 * Interfaz del Dao de Convenio
 * @author manromero
 *
 */
public interface ConveniosDao {
	
	/**
	 * Devuelve el ConveniosEntity por su id
	 * @param idConvenio
	 * @return
	 */
	public ConveniosEntity findById(Long idConvenio);
	
	/**
	 * Devuelve la lista de ConveniosEntity que tengan una determinada provincia
	 * @param idProvincia
	 * @return
	 */
	public List<ConveniosEntity> findConveniosByIdProvincia(Long idProvincia);
	
	/**
	 * Devuelve la lista de ConveniosEntity que tengan una determinada localidad
	 * @param idProvincia
	 * @return
	 */
	public List<ConveniosEntity> findConveniosByIdLocalidad(Long idLocalidades);
	
	/**
	 * Devuelve la lista de ConveniosEntity que tengan una determinada entidad
	 * @param idProvincia
	 * @return
	 */
	public List<ConveniosEntity> findConveniosByIdEntidad(Long idEntidades);

}
