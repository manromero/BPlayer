package com.cgt.dao;

import java.util.List;

import com.cgt.entity.ConvDocumentosEntity;

public interface ConvDocumentosDao {
	
	/**
	 * Devolver documentos de convenios
	 * @param idCesion
	 * @return
	 */
	public List<ConvDocumentosEntity> findConvDocumentosByIdConvenio(Long idConvenio);

}
