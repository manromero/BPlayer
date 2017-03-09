package com.cgt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cgt.dao.EntidadesDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.EntidadesEntity;

/**
 * Implementación de los métodos del Dao de EntidadesEntity
 * @author manromero
 *
 */
@Repository
public class EntidadesDaoImpl extends GenericDaoImpl<EntidadesEntity, Long> implements EntidadesDao  {
	
	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public EntidadesDaoImpl() {
		super(EntidadesEntity.class);
	}

	@Override
	public List<EntidadesEntity> findByIdLocalidad(Long idLocalidades) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idLocalidades", idLocalidades);
		return super.findByNamedQuery("findEndidadesEntityByIdLocalidad", queryParameters);
	}

}
