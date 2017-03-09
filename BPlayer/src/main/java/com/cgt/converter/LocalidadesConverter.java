package com.cgt.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cgt.dto.LocalidadDto;
import com.cgt.entity.LocalidadesEntity;

/**
 * Conversor de LocalidadesEntity
 * @author manromero
 *
 */
@Component
public class LocalidadesConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7261728513833709875L;
	
	/**
	 * Convierte LocalidadesEntity en LocalidadDto
	 * @param entity
	 * @return
	 */
	public LocalidadDto convertEntityToDto(LocalidadesEntity entity){
		LocalidadDto dto = new LocalidadDto();
		if(entity!=null){
			dto.setId(entity.getIdLocalidad());
			dto.setDescripcion(entity.getDescLocalidad());
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de LocalidadesEntity en una lista de LocalidadDto
	 * @param entities
	 * @return
	 */
	public List<LocalidadDto> convertListEntityToListDto(List<LocalidadesEntity> entities){
		List<LocalidadDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(LocalidadesEntity entity : entities){
				LocalidadDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
