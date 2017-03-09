package com.cgt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cgt.dao.LocalidadesDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.LocalidadesEntity;

/**
 * Implementación de los métodos del Dao de LocalidadesEntity
 * @author manromero
 *
 */
@Repository
public class LocalidadesDaoImpl extends GenericDaoImpl<LocalidadesEntity, Long> implements LocalidadesDao  {
	
	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public LocalidadesDaoImpl() {
		super(LocalidadesEntity.class);
	}

	@Override
	public List<LocalidadesEntity> findByIdProvincia(Long idProvincia) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idProvincia", idProvincia);
		return super.findByNamedQuery("findLocalidadesEntityByIdLocalidad", queryParameters);
	}

}
