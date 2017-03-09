package com.cgt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cgt.dao.CesionesDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.CesionesEntity;

/**
 * Implementación de los métodos del Dao de CesionesEntiy
 * @author manromero
 *
 */
@Repository
public class CesionesDaoImpl extends GenericDaoImpl<CesionesEntity, Long> implements CesionesDao {
	
	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public CesionesDaoImpl() {
		super(CesionesEntity.class);
	}

	@Override
	public CesionesEntity findById(Long idCesion) {
		CesionesEntity res = super.getElementById(idCesion);
		return res;
	}

	@Override
	public List<CesionesEntity> findCesionesByIdProvincia(Long idProvincia) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idProvincia", idProvincia);
		return super.findByNamedQuery("findCesionesEntityByIdProvincia", queryParameters);
	}

	@Override
	public List<CesionesEntity> findCesionesByIdLocalidad(Long idLocalidades) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idLocalidades", idLocalidades);
		return super.findByNamedQuery("findCesionesByIdLocalidad", queryParameters);
	}

	@Override
	public List<CesionesEntity> findCesionesByIdEntidad(Long idEntidades) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idEntidades", idEntidades);
		return super.findByNamedQuery("findCesionesByIdEntidad", queryParameters);
	}

}
