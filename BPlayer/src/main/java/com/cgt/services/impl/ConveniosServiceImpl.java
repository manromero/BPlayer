package com.cgt.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.ConveniosConverter;
import com.cgt.dao.ConveniosDao;
import com.cgt.dto.ConvenioDto;
import com.cgt.entity.ConveniosEntity;
import com.cgt.services.ConveniosService;

/**
 * Servicio de ConveniosEntiy
 * @author manromero
 *
 */
@Service
public class ConveniosServiceImpl implements ConveniosService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4966759601558607315L;
	
	@Autowired
	private ConveniosDao conveniosDao;
	
	@Resource
	private ConveniosConverter conveniosConverter;
	
	public ConveniosServiceImpl(){
		super();
	}

	@Override
	public List<ConvenioDto> findConveniosByIdProvincia(Long idProvincia) {
		List<ConvenioDto> res = new ArrayList<>();
		if(idProvincia!=null){
			List<ConveniosEntity> entities = conveniosDao.findConveniosByIdProvincia(idProvincia);
			res = conveniosConverter.convertListEntityToListDto(entities); 
		}
		return res;
	}

	@Override
	public List<ConvenioDto> findConveniosByIdLocalidad(Long idLocalidad) {
		List<ConvenioDto> res = new ArrayList<>();
		if(idLocalidad!=null){
			List<ConveniosEntity> entities = conveniosDao.findConveniosByIdLocalidad(idLocalidad);
			res = conveniosConverter.convertListEntityToListDto(entities); 
		}
		return res;
	}

	@Override
	public List<ConvenioDto> findConveniosByIdEntidad(Long idEntidad) {
		List<ConvenioDto> res = new ArrayList<>();
		if(idEntidad!=null){
			List<ConveniosEntity> entities = conveniosDao.findConveniosByIdEntidad(idEntidad);
			res = conveniosConverter.convertListEntityToListDto(entities); 
		}
		return res;
	}

}
