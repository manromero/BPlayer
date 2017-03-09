package com.cgt.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.EntidadesConverter;
import com.cgt.dao.EntidadesDao;
import com.cgt.dto.EntidadDto;
import com.cgt.entity.EntidadesEntity;
import com.cgt.services.EntidadesService;

/**
 * Servicio de EntidadesEntity
 * @author manromero
 *
 */
@Service
public class EntidadesServiceImpl implements EntidadesService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1681610342531784642L;
	
	@Autowired
	private EntidadesDao entidadesDao;
	
	@Resource
	private EntidadesConverter entidadesConverter;

	@Override
	public List<EntidadDto> findByIdLocalidad(Long idLocalidad) {
		List<EntidadDto> res = new ArrayList<>();
		if(idLocalidad!=null){
			List<EntidadesEntity> entities = entidadesDao.findByIdLocalidad(idLocalidad);
			res = entidadesConverter.convertListEntityToListDto(entities);
		}
		return res;
	}

}
