package com.cgt.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.CesionesConverter;
import com.cgt.dao.CesionesDao;
import com.cgt.dto.CesDocumentosDto;
import com.cgt.dto.CesionDto;
import com.cgt.dto.PersContactoDto;
import com.cgt.entity.CesionesEntity;
import com.cgt.services.CesDocumentosService;
import com.cgt.services.CesionesService;
import com.cgt.services.PersContactoService;

/**
 * Servicio de CesionesEntity
 * @author manromero
 *
 */
@Service
public class CesionesServiceImpl implements CesionesService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1065110001718937878L;
	
	@Autowired
	private CesionesDao cesionesDao;
	
	@Autowired
	private PersContactoService persContactoService;
	
	@Autowired
	private CesDocumentosService cesDocumentosService;
	
	@Resource
	private CesionesConverter cesionesConverter;
	
	public CesionesServiceImpl(){
		super();
	}

	@Override
	public List<CesionDto> findCesionesByIdProvincia(Long idProvincia) {
		List<CesionDto> res = new ArrayList<>();
		if(idProvincia!=null){
			List<CesionesEntity> entities = cesionesDao.findCesionesByIdProvincia(idProvincia);
			res = cesionesConverter.convertListEntityToListDto(entities);
		}
		return res;
	}

	@Override
	public List<CesionDto> findCesionesByIdLocalidad(Long idLocalidad) {
		List<CesionDto> res = new ArrayList<>();
		if(idLocalidad!=null){
			List<CesionesEntity> entities = cesionesDao.findCesionesByIdLocalidad(idLocalidad);
			res = cesionesConverter.convertListEntityToListDto(entities);
		}
		return res;
	}

	@Override
	public List<CesionDto> findCesionesByIdEntidad(Long idEntidad) {
		List<CesionDto> res = new ArrayList<>();
		if(idEntidad!=null){
			List<CesionesEntity> entities = cesionesDao.findCesionesByIdEntidad(idEntidad);
			res = cesionesConverter.convertListEntityToListDto(entities);
		}
		return res;
	}
	
	@Override
	public CesionDto findByIdCesion(Long idCesion) {
		CesionDto cesionDto = new CesionDto();
		if(idCesion!=null){
			CesionesEntity entity = cesionesDao.findById(idCesion); 
			cesionDto = cesionesConverter.convertEntityToDto(entity);
		}
		return cesionDto;
	}

	@Override
	public CesionDto findCesionFullByIdCesion(Long idCesion) {
		CesionDto res = new CesionDto();
		if(idCesion!=null){
			res = findByIdCesion(idCesion);
			List<PersContactoDto> listPersContactoDto = persContactoService.findByIdCesion(idCesion);
			res.setListPersContactoDto(listPersContactoDto);
			List<CesDocumentosDto> listCesDocumentosDto = cesDocumentosService.findCesDocumentosByIdCesion(idCesion);
			res.setListCesDocumentosDto(listCesDocumentosDto);
		}
		return res;
	}

}
