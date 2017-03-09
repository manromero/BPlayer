package com.cgt.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.CesDocumentosConverter;
import com.cgt.dao.CesDocumentosDao;
import com.cgt.dto.CesDocumentosDto;
import com.cgt.entity.CesDocumentosEntity;
import com.cgt.services.CesDocumentosService;

/**
 * Servicio de CesDocumentosEntity
 * @author manromero
 *
 */
@Service
public class CesDocumentosServiceImpl implements CesDocumentosService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3238396711539280758L;
	
	@Autowired
	private CesDocumentosDao cesDocumentosDao;
	
	@Resource
	private CesDocumentosConverter cesDocumentosConverter;

	@Override
	public List<CesDocumentosDto> findCesDocumentosByIdCesion(Long idCesion) {
		List<CesDocumentosDto> res = new ArrayList<>();
		if(idCesion!=null){
			List<CesDocumentosEntity> entities = cesDocumentosDao.findCesDocumentosByIdCesion(idCesion);
			res = cesDocumentosConverter.convertListEntityToListDto(entities);
		}
		return res;
	}
	
}