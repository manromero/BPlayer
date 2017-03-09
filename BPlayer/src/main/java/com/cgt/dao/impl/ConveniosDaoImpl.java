package com.cgt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cgt.dao.ConveniosDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.ConveniosEntity;

/**
 * Implementación de los métodos del Dao de ConveniosEntity
 * @author manromero
 *
 */
@Repository
public class ConveniosDaoImpl extends GenericDaoImpl<ConveniosEntity, Long> implements ConveniosDao {
	
	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public ConveniosDaoImpl() {
		super(ConveniosEntity.class);
	}

	@Override
	public ConveniosEntity findById(Long idConvenio) {
		ConveniosEntity res = super.getElementById(idConvenio);
		return res;
	}

	@Override
	public List<ConveniosEntity> findConveniosByIdProvincia(Long idProvincia) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idProvincia", idProvincia);
		return super.findByNamedQuery("findConveniosEntityByIdProvincia", queryParameters);
	}

	@Override
	public List<ConveniosEntity> findConveniosByIdLocalidad(Long idLocalidades) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idLocalidades", idLocalidades);
		return super.findByNamedQuery("findConveniosByIdLocalidad", queryParameters);
	}

	@Override
	public List<ConveniosEntity> findConveniosByIdEntidad(Long idEntidades) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idEntidades", idEntidades);
		return super.findByNamedQuery("findConveniosByIdEntidad", queryParameters);
	}

}
