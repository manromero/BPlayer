package com.cgt.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.cgt.dao.UsuarioDao;
import com.cgt.dao.generic.GenericDaoImpl;
import com.cgt.entity.UsuariosEntity;



/**
 * Implementación de los métodos del Dao de Evento
 * @author apascual
 *
 */
@Repository
public class UsuarioDaoImpl extends GenericDaoImpl<UsuariosEntity, Long> implements UsuarioDao {
	
	/**
	 * Constructor en el que le asignamos el entitymanager para poder acceder a base de datos
	 */
	public UsuarioDaoImpl() {
		super(UsuariosEntity.class);
	}
	
	@Override
	public UsuariosEntity findUsuarioById(Long id) {
		return super.getElementById(id);
	}
	
	public List<UsuariosEntity> findAllUsuarios(){
		List<UsuariosEntity> listaUsuarios = super.findByNamedQuery("encontrarTodos");
		return listaUsuarios;
	}

	@Override
	public UsuariosEntity findUsuarioByCodigoUsu(String codigoUsu) {
		Map<String, Object> map = new HashMap<>();
		map.put("username", codigoUsu);
		List<UsuariosEntity> listaUsuarios = super.findByNamedQuery("findByCodUsuAndActivo", map);
		if(!listaUsuarios.isEmpty()){
			return listaUsuarios.get(0);
		}else{
			return null;
		}
	}
	
}
