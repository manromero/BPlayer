package com.cgt.services;

import java.util.List;

import com.cgt.dto.CesDocumentosDto;

public interface CesDocumentosService {
	
	/**
	 * Devolver documentos de cesion
	 * @param idCesion
	 * @return
	 */
	public List<CesDocumentosDto> findCesDocumentosByIdCesion(Long idCesion);

}
