package com.cgt.dao;

import java.util.List;

import com.cgt.entity.CesDocumentosEntity;

public interface CesDocumentosDao {
	
	/**
	 * Devolver documentos de cesion
	 * @param idCesion
	 * @return
	 */
	public List<CesDocumentosEntity> findCesDocumentosByIdCesion(Long idCesion);

}