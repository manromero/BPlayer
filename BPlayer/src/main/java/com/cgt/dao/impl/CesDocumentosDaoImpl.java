package com.cgt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cgt.dao.CesDocumentosDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.CesDocumentosEntity;

/**
 * Implementación de los métodos del Dao de CesDocumentosEntity
 * @author manromero
 *
 */
@Repository
public class CesDocumentosDaoImpl extends GenericDaoImpl<CesDocumentosEntity, Long> implements CesDocumentosDao {
	
	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public CesDocumentosDaoImpl() {
		super(CesDocumentosEntity.class);
	}

	@Override
	public List<CesDocumentosEntity> findCesDocumentosByIdCesion(Long idCesion) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idCesion", idCesion);
		return super.findByNamedQuery("findCesDocumentosByIdCesion", queryParameters);
	}

}
