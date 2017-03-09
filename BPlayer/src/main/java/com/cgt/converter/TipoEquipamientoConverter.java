package com.cgt.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cgt.dto.TipoEquipamientoDto;
import com.cgt.entity.TipoEquipamientoEntity;

/**
 * Conversor de TipoEquipamientoEntity
 * @author manromero
 *
 */
@Component
public class TipoEquipamientoConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6378542910839332209L;
	
	/**
	 * Convierte TipoEquipamientoDto en TipoEquipamientoEntity
	 * @param dto
	 * @return
	 */
	public TipoEquipamientoEntity convertDtoToEntity(TipoEquipamientoDto dto){
		TipoEquipamientoEntity entity = new TipoEquipamientoEntity();
		if(dto!=null){
			entity.setIdTipoEquipamiento(dto.getId());
			entity.setDescTipoEquipamiento(dto.getDescripcion());
		}
		return entity;
	}
	
	/**
	 * Convierte TipoEquipamientoEntity en TipoEquipamientoDto
	 * @param entity
	 * @return
	 */
	public TipoEquipamientoDto convertEntityToDto(TipoEquipamientoEntity entity){
		TipoEquipamientoDto dto = new TipoEquipamientoDto();
		if(entity!=null){
			dto.setId(entity.getIdTipoEquipamiento());
			dto.setDescripcion(entity.getDescTipoEquipamiento());
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de TipoEquipamientoEntity en una lista de TipoEquipamientoDto
	 * @param entities
	 * @return
	 */
	public List<TipoEquipamientoDto> convertListEntityToListDto(List<TipoEquipamientoEntity> entities){
		List<TipoEquipamientoDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(TipoEquipamientoEntity entity : entities){
				TipoEquipamientoDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
	/**
	 * Convierte una lista de TipoEquipamientoDto en una lista de TipoEquipamientoEntity
	 * @param dtos
	 * @return
	 */
	public List<TipoEquipamientoEntity> convertLisDtoToListEntity(List<TipoEquipamientoDto> dtos){
		List<TipoEquipamientoEntity> entities = new ArrayList<>();
		if(dtos!=null){
			for(TipoEquipamientoDto dto : dtos){
				TipoEquipamientoEntity entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}

}
