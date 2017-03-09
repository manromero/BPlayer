package com.cgt.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cgt.dto.EquipamientoDto;
import com.cgt.entity.EquipamientoEntity;

/**
 * Conversor de EquipamientoEntity
 * @author manromero
 *
 */
@Component
public class EquipamientoConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1594027930663964155L;
	
	@Resource
	private TipoEquipamientoConverter tipoEquipamientoConverter;
	
	/**
	 * Convierte EquipamientoDto en EquipamientoEntity
	 * @param dto
	 * @return
	 */
	public EquipamientoEntity converDtoToEntity(EquipamientoDto	dto){
		EquipamientoEntity entity = new EquipamientoEntity();
		if(dto!=null){
			entity.setId(dto.getId());
			entity.setNumSerie(dto.getNumSerie());
			entity.setMarca(dto.getMarca());
			entity.setModelo(dto.getModelo());
			entity.setFecProxVerificacion(dto.getFechaProximaRevision());
			if(dto.getTipoEquipamientoDto()!=null)
				entity.setIdTipoEquipamiento(dto.getTipoEquipamientoDto().getId());
			
		}
		return entity;
	}
	
	/**
	 * Convierte EquipamientoEntity en EquipamientoDto
	 * @param entity
	 * @return
	 */
	public EquipamientoDto convertEntityToDto(EquipamientoEntity entity){
		EquipamientoDto dto = new EquipamientoDto();
		if(entity!=null){
			dto.setId(entity.getId());
			dto.setNumSerie(entity.getNumSerie());
			dto.setMarca(entity.getMarca());
			dto.setModelo(entity.getModelo());
			dto.setFechaProximaRevision(entity.getFecProxVerificacion());
			if(entity.getTipoEquipamiento()!=null){
				dto.setTipoEquipamientoDto(tipoEquipamientoConverter.convertEntityToDto(entity.getTipoEquipamiento()));
			}
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de EquipamientoDto en una lista de EquipamientoEntity
	 * @param dtos
	 * @return
	 */
	public List<EquipamientoEntity> convertListDtoToListEntity(List<EquipamientoDto> dtos){
		List<EquipamientoEntity> entities = new ArrayList<>();
		if(dtos!=null){
			for(EquipamientoDto dto : dtos){
				EquipamientoEntity entity = converDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	/**
	 * Convierte una lista de EquipamientoEntity en una lista de EquipamientoDto
	 * @param entities
	 * @return
	 */
	public List<EquipamientoDto> convertListEntityToListDto(List<EquipamientoEntity> entities){
		List<EquipamientoDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(EquipamientoEntity entity : entities){
				EquipamientoDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
