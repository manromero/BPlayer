package com.cgt.services;

import com.cgt.dto.UsuariosDto;

/**
 * Interfaz de prueba
 * 
 * @author apascual
 *
 */
public interface UsuarioService {

	/**
	 * Devuelve el usuario que coincida con el id de usuario que le pasamos por parámetro
	 * 
	 * @param idUsuario
	 * @return dto
	 */
	public UsuariosDto findById(Long idUsuario);

	/**
	 * Devuelve el usuario que coincida con el username que le pasamos por parámetro
	 * 
	 * @param username
	 * @return dto
	 */
	public UsuariosDto findByUsername(String username);

}
