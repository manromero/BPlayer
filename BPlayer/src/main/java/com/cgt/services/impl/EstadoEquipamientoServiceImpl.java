package com.cgt.services.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.EstadoEquipamientoConverter;
import com.cgt.dao.EstadoEquipamientoDao;
import com.cgt.dto.EstadoEquipamientoDto;
import com.cgt.entity.EstadoEquipamientoEntity;
import com.cgt.services.EstadoEquipamientoService;

/**
 * Servicio de EstadoEquipamientoEntity
 * @author manromero
 *
 */
@Service
public class EstadoEquipamientoServiceImpl implements EstadoEquipamientoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1482000847419893176L;
	
	@Autowired
	private EstadoEquipamientoDao estadoEquipamientoDao;
	
	@Resource
	private EstadoEquipamientoConverter estadoEquipamientoConverter;

	@Override
	public List<EstadoEquipamientoDto> findAll() {
		List<EstadoEquipamientoEntity> entities = estadoEquipamientoDao.findAll();
		List<EstadoEquipamientoDto> res = estadoEquipamientoConverter.convertListEntityToListDto(entities);
		return res;
	}

}
