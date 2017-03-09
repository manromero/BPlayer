package com.cgt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cgt.dao.ConvDocumentosDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.ConvDocumentosEntity;

/**
 * Implementación de los métodos del Dao de ConvDocumentosEntity
 * @author manromero
 *
 */
@Repository
public class ConvDocumentosDaoImpl extends GenericDaoImpl<ConvDocumentosEntity, Long> implements ConvDocumentosDao {
	
	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public ConvDocumentosDaoImpl() {
		super(ConvDocumentosEntity.class);
	}

	@Override
	public List<ConvDocumentosEntity> findConvDocumentosByIdConvenio(Long idConvenio) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idConvenio", idConvenio);
		return super.findByNamedQuery("findConvDocumentosByIdConvenio", queryParameters);
	}

}
