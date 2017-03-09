package com.cgt.services;

import java.util.List;

import com.cgt.dto.EquipamientoDto;

public interface EquipamientoService {
	
	/**
	 * Devuelve los equipamientos con estado disponible
	 * @return
	 */
	public List<EquipamientoDto> findEquipamientosDisponibles();
	
	/**
	 * Devuelve los equipamientos con estado disponible y de un tipo determinado
	 * @param idTipoEquipamiento
	 * @return
	 */
	public List<EquipamientoDto> findEquipamientosDisponiblesByIdTipoEquipamiento(Long idTipoEquipamiento);

}
