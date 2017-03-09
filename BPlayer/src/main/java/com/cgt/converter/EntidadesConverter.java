package com.cgt.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cgt.dto.EntidadDto;
import com.cgt.entity.EntidadesEntity;

/**
 * Conversor de EntidadesEntity
 * @author manromero
 *
 */
@Component
public class EntidadesConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1635004471722549835L;
	
	@Resource
	private LocalidadesConverter localidadesConverter;
	
	/**
	 * Convierte EntidadDto en EntidadesEntity
	 * @param dto
	 * @return
	 */
	public EntidadesEntity convertDtoToEntity(EntidadDto dto){
		EntidadesEntity entity = new EntidadesEntity();
		if(dto!=null){
			entity.setIdEntidad(dto.getId());
			entity.setNombre(dto.getDescripcion());
			if(dto.getLocalidadDto()!=null){
				entity.setIdLocalidades(dto.getLocalidadDto().getId());
			}
		}
		return entity;
	}
	
	/**
	 * Convierte EntidadesEntity en EntidadDto
	 * @param entity
	 * @return
	 */
	public EntidadDto convertEntityToDto(EntidadesEntity entity){
		EntidadDto dto = new EntidadDto();
		if(entity!=null){
			dto.setId(entity.getIdEntidad());
			dto.setDescripcion(entity.getNombre());
			if(entity.getLocalidades()!=null){
				dto.setLocalidadDto(localidadesConverter.convertEntityToDto(entity.getLocalidades()));
			}
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de EntidadDto en una lista de EntidadesEntity
	 * @param dtos
	 * @return
	 */
	public List<EntidadesEntity> convertListDtoToListEntity(List<EntidadDto> dtos){
		List<EntidadesEntity> entities = new ArrayList<>();
		if(dtos!=null){
			for(EntidadDto dto : dtos){
				EntidadesEntity entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	/**
	 * Convierte una lista de EntidadesEntity en una lista de EntidadDto
	 * @param entities
	 * @return
	 */
	public List<EntidadDto> convertListEntityToListDto(List<EntidadesEntity> entities){
		List<EntidadDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(EntidadesEntity entity : entities){
				EntidadDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
