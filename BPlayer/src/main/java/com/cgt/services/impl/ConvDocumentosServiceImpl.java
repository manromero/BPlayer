package com.cgt.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.ConvDocumentosConverter;
import com.cgt.dao.ConvDocumentosDao;
import com.cgt.dto.ConvDocumentosDto;
import com.cgt.entity.ConvDocumentosEntity;
import com.cgt.services.ConvDocumentosService;

/**
 * Servicio de ConvDocumentosEntity
 * @author manromero
 *
 */
@Service
public class ConvDocumentosServiceImpl implements ConvDocumentosService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2173156038649340898L;
	
	@Autowired
	private ConvDocumentosDao convDocumentosDao;
	
	@Resource
	private ConvDocumentosConverter convDocumentosConverter;

	@Override
	public List<ConvDocumentosDto> findConvDocumentosByIdConvenio(Long idConvenio) {
		List<ConvDocumentosDto> res = new ArrayList<>();
		if(idConvenio!=null){
			List<ConvDocumentosEntity> entities = convDocumentosDao.findConvDocumentosByIdConvenio(idConvenio);
			res = convDocumentosConverter.convertListEntityToListDto(entities);
		}
		return res;
	}

}