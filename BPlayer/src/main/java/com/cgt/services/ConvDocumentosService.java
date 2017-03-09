package com.cgt.services;

import java.util.List;

import com.cgt.dto.ConvDocumentosDto;

public interface ConvDocumentosService {
	
	/**
	 * Devolver documentos de convenios
	 * @param idCesion
	 * @return
	 */
	public List<ConvDocumentosDto> findConvDocumentosByIdConvenio(Long idConvenio);

}
