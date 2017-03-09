package com.cgt.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cgt.dto.EstadoEquipamientoDto;
import com.cgt.entity.EstadoEquipamientoEntity;

/**
 * Conversor de EstadoEquipamientoEntity
 * @author manromero
 *
 */
@Component
public class EstadoEquipamientoConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3860947943198401023L;
	
	/**
	 * Convierte EstadoEquipamientoDto en EstadoEquipamientoEntity
	 * @param dto
	 * @return
	 */
	public EstadoEquipamientoEntity convertDtoToEntity(EstadoEquipamientoDto dto){
		EstadoEquipamientoEntity entity = new EstadoEquipamientoEntity();
		if(dto!=null){
			entity.setIdEstado(dto.getId());
			entity.setDescEstado(dto.getDescripcion());
		}
		return entity;
	}
	
	/**
	 * Convierte EstadoEquipamientoEntity en EstadoEquipamientoDto
	 * @param entity
	 * @return
	 */
	public EstadoEquipamientoDto convertEntityToDto(EstadoEquipamientoEntity entity){
		EstadoEquipamientoDto dto = new EstadoEquipamientoDto();
		if(entity!=null){
			dto.setId(entity.getIdEstado());
			dto.setDescripcion(entity.getDescEstado());
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de EstadoEquipamientoDto en una lista de EstadoEquipamientoEntity
	 * @param dtos
	 * @return
	 */
	public List<EstadoEquipamientoEntity> convertListDtoToListEntity(List<EstadoEquipamientoDto> dtos){
		List<EstadoEquipamientoEntity> entities = new ArrayList<>();
		if(dtos!=null){
			for(EstadoEquipamientoDto dto : dtos){
				EstadoEquipamientoEntity entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	/**
	 * Convierte una lista de EstadoEquipamientoEntity en una lista de EstadoEquipamientoDto
	 * @param entities
	 * @return
	 */
	public List<EstadoEquipamientoDto> convertListEntityToListDto(List<EstadoEquipamientoEntity> entities){
		List<EstadoEquipamientoDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(EstadoEquipamientoEntity entity : entities){
				EstadoEquipamientoDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
