package com.cgt.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cgt.dao.TipoEquipamientoDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.TipoEquipamientoEntity;

/**
 * Implementación de los métodos del Dao de TipoEquipamientoEntity
 * @author manromero
 *
 */
@Repository
public class TipoEquipamientoDaoImpl extends GenericDaoImpl<TipoEquipamientoEntity, Long> implements TipoEquipamientoDao {
	
	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public TipoEquipamientoDaoImpl() {
		super(TipoEquipamientoEntity.class);
	}
	
	@Override
	public List<TipoEquipamientoEntity> findAll(){
		return super.findAll();
	}

}
