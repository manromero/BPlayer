package com.cgt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cgt.dao.EquipamientoDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.EquipamientoEntity;

/**
 * Implementación de los métodos del Dao de EquipamientoEntity
 * @author manromero
 *
 */
@Repository
public class EquipamientoDaoImpl extends GenericDaoImpl<EquipamientoEntity, Long> implements EquipamientoDao {
	
	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public EquipamientoDaoImpl() {
		super(EquipamientoEntity.class);
	}

	@Override
	public List<EquipamientoEntity> findEquipamientosDisponibles() {
		return super.findByNamedQuery("findEquipamientosDisponibles");
	}

	@Override
	public List<EquipamientoEntity> findEquipamientosDisponiblesByIdTipoEquipamiento(Long idTipoEquipamiento) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idTipoEquipamiento", idTipoEquipamiento);
		return super.findByNamedQuery("findEquipamientosDisponiblesByIdTipoEquipamiento", queryParameters);
	}
	
	

}
