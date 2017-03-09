package com.cgt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cgt.dao.PersContactoDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.PersContactoEntity;

/**
 * Implementación de los métodos del Dao de PersContactoEntity
 * @author manromero
 *
 */
@Repository
public class PersContactoDaoImpl extends GenericDaoImpl<PersContactoEntity, Long> implements PersContactoDao {
	
	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public PersContactoDaoImpl() {
		super(PersContactoEntity.class);
	}

	@Override
	public List<PersContactoEntity> findByIdEntidad(Long idEntidad) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idEntidad", idEntidad);
		return super.findByNamedQuery("findPersContactoEntityByIdEntidad", queryParameters);
	}

	@Override
	public List<PersContactoEntity> findByIdCesion(Long idCesion) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idCesion", idCesion);
		return super.findByNamedQuery("findPersContactoEntityByIdCesion", queryParameters);
	}

	@Override
	public List<PersContactoEntity> findByIdConvenio(Long idConvenio) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idConvenio", idConvenio);
		return super.findByNamedQuery("findPersContactoEntityByIdConvenio", queryParameters);
	}

}
