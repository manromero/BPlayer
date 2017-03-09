package com.cgt.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgt.dao.EstadoEquipamientoDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.EstadoEquipamientoEntity;

/**
 * Implementación de los métodos del Dao de EstadoEquipamientoEntity
 * @author manromero
 *
 */
@Repository
public class EstadoEquipamientoDaoImpl extends GenericDaoImpl<EstadoEquipamientoEntity, Long> implements EstadoEquipamientoDao {
	
	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public EstadoEquipamientoDaoImpl() {
		super(EstadoEquipamientoEntity.class);
	}
	
	@Override
	public List<EstadoEquipamientoEntity> findAll(){
		return super.findAll();
	}

}
