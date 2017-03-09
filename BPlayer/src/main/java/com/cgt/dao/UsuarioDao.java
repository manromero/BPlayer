package com.cgt.dao;

import java.util.List;

import com.cgt.entity.UsuariosEntity;



/**
 * Interfaz del Dao de Usuario
 * @author apascual
 *
 */
public interface UsuarioDao {
	
	/**
	 * Devolvemos el usuario que coincida con el id que le pasamos por parámetro
	 * @param id
	 * @return
	 */
	public UsuariosEntity findUsuarioById(Long id);

	/**
	 * Devuelve toda la lista de usuarios
	 * @return
	 */
	public List<UsuariosEntity> findAllUsuarios();
	
	/**
	 * Devolvemos el usuario que coincida con el CODIGO_USU que le pasamos por parámetro
	 * @param codigoUsu
	 * @return
	 */
	public UsuariosEntity findUsuarioByCodigoUsu(String codigoUsu);
}
