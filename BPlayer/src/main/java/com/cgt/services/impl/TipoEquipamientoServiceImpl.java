package com.cgt.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.TipoEquipamientoConverter;
import com.cgt.dao.TipoEquipamientoDao;
import com.cgt.dto.TipoEquipamientoDto;
import com.cgt.entity.TipoEquipamientoEntity;
import com.cgt.services.TipoEquipamientoService;

/**
 * Servicio de TipoEquipamientoEntity
 * @author manromero
 *
 */
@Service
public class TipoEquipamientoServiceImpl implements TipoEquipamientoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7524026182571736058L;
	
	@Autowired
	private TipoEquipamientoDao tipoEquipamientoDao;
	
	@Resource
	private TipoEquipamientoConverter tipoEquipamientoConverter;

	@Override
	public List<TipoEquipamientoDto> findAll() {
		List<TipoEquipamientoEntity> entities = tipoEquipamientoDao.findAll();
		List<TipoEquipamientoDto> res = tipoEquipamientoConverter.convertListEntityToListDto(entities);
		return res;
	}

}
