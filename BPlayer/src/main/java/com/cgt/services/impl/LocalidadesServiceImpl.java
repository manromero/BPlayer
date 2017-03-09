package com.cgt.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.LocalidadesConverter;
import com.cgt.dao.LocalidadesDao;
import com.cgt.dto.LocalidadDto;
import com.cgt.entity.LocalidadesEntity;
import com.cgt.services.LocalidadesService;

/**
 * Servicio de LocalidadesEntity
 * @author manromero
 *
 */
@Service
public class LocalidadesServiceImpl implements LocalidadesService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5681148657187107409L;
	
	@Autowired
	private LocalidadesDao localidadesDao;
	
	@Resource
	private LocalidadesConverter localidadesConverter;

	@Override
	public List<LocalidadDto> findByIdProvincia(Long idProvincia) {
		List<LocalidadDto> res = new ArrayList<>();
		if(idProvincia!=null){
			List<LocalidadesEntity> entities = localidadesDao.findByIdProvincia(idProvincia);
			res = localidadesConverter.convertListEntityToListDto(entities);
		}
		return res;
	}

}
