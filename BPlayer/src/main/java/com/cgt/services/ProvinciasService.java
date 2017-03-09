package com.cgt.services;

import java.util.List;

import com.cgt.dto.ProvinciaDto;
import com.cgt.dto.UsuariosDto;

public interface ProvinciasService {
	
	/**
	 * Devuelve todas las provincias
	 * @return
	 */
	public List<ProvinciaDto> findAll();
	
	/**
	 * Devuelve todas las provincias asociadas al usuariosDto
	 * @param usuariosDto
	 * @return
	 */
	public List<ProvinciaDto> findProvinciasAsociadasAusuario(UsuariosDto usuariosDto);

}
