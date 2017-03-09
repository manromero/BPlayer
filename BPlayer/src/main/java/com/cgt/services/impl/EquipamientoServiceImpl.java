package com.cgt.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.EquipamientoConverter;
import com.cgt.dao.EquipamientoDao;
import com.cgt.dto.EquipamientoDto;
import com.cgt.entity.EquipamientoEntity;
import com.cgt.services.EquipamientoService;

/**
 * Servicio de EquipamientoEntity
 * @author manromero
 *
 */
@Service
public class EquipamientoServiceImpl implements EquipamientoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7366078024827784859L;
	
	@Autowired
	private EquipamientoDao equipamientoDao;
	
	@Resource
	private EquipamientoConverter equipamientoConverter;

	@Override
	public List<EquipamientoDto> findEquipamientosDisponibles() {
		List<EquipamientoEntity> entities =  equipamientoDao.findEquipamientosDisponibles();
		List<EquipamientoDto> res = equipamientoConverter.convertListEntityToListDto(entities);
		return res;
	}

	@Override
	public List<EquipamientoDto> findEquipamientosDisponiblesByIdTipoEquipamiento(Long idTipoEquipamiento) {
		List<EquipamientoDto> res = new ArrayList<>();
		if(idTipoEquipamiento!=null){
			List<EquipamientoEntity> entities =  equipamientoDao.findEquipamientosDisponiblesByIdTipoEquipamiento(idTipoEquipamiento);
			res = equipamientoConverter.convertListEntityToListDto(entities);
		}
		return res;
	}

}
