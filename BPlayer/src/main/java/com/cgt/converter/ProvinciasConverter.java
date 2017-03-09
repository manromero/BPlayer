package com.cgt.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cgt.dto.ProvinciaDto;
import com.cgt.entity.ProvinciasEntity;

/**
 * Conversor de ProvinciasEntity
 * @author manromero
 *
 */
@Component
public class ProvinciasConverter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5603560335101303092L;

	/**
	 * Convierte ProvinciasEntity en ProvinciaDto
	 * @param entity
	 * @return
	 */
	public ProvinciaDto convertEntityToDto(ProvinciasEntity entity){
		ProvinciaDto dto = new ProvinciaDto();
		if(entity!=null){
			dto.setId(entity.getIdProvincia());
			dto.setDescripcion(entity.getDescProvincia());
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de ProvinciasEntity en una lista de ProvinciaDto
	 * @param entities
	 * @return
	 */
	public List<ProvinciaDto> convertListEntityToListDto(List<ProvinciasEntity> entities){
		List<ProvinciaDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(ProvinciasEntity entity : entities){
				ProvinciaDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
