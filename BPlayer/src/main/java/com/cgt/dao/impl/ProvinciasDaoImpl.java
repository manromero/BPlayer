package com.cgt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cgt.dao.ProvinciasDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.ProvinciasEntity;

/**
 * Implementación de los métodos del Dao de ProvinciasEntity
 * @author manromero
 *
 */
@Repository
public class ProvinciasDaoImpl extends GenericDaoImpl<ProvinciasEntity, Long> implements ProvinciasDao {

	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public ProvinciasDaoImpl() {
		super(ProvinciasEntity.class);
	}

	@Override
	public List<ProvinciasEntity> findAll(){
		return super.findAll();
	}
	
	
	@Override
	public List<ProvinciasEntity> findByUsuarioId(Long idUsuario) {
		Map<String,Object> queryParameters = new HashMap<>();
		queryParameters.put("idUsuario", idUsuario);
		return super.findByNamedQuery("findProvinciasEntityByIdUsuario", queryParameters);
	}

}
