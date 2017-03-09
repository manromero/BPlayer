package com.cgt.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cgt.dto.CesionDto;
import com.cgt.entity.CesionesEntity;

/**
 * Conversor de CesionesEntity
 * @author manromero
 *
 */
@Component
public class CesionesConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2896103438701046963L;
	
	@Resource
	private EntidadesConverter entidadesConverter;
	
	@Resource
	private EquipamientoConverter equipamientoConverter;
	
	/**
	 * Convierte CesionDto en CesionesEntity
	 * @param dto
	 * @return
	 */
	public CesionesEntity convertDtoToEntity(CesionDto dto){
		CesionesEntity entity = new CesionesEntity();
		if(dto!=null){
			entity.setIdCesion(dto.getId());
			if(dto.getEquipamientoDto()!=null){
				entity.setIdEquipamiento(dto.getEquipamientoDto().getId());
			}
			if(dto.getEntidadDto()!=null){
				entity.setIdEntidades(dto.getEntidadDto().getId());
			}
			entity.setFecCesion(dto.getFechaCesion());
			entity.setObservaciones(dto.getObservaciones());
			entity.setFecPrevBaja(dto.getFechaPrevistaBaja());
			entity.setFecBaja(dto.getFechaBaja());
			entity.setMotivoBaja(dto.getMotivoBaja());
		}
		return entity;
	}
	
	/**
	 * Convierte CesionesEntity en CesionDto
	 * @param entity
	 * @return
	 */
	public CesionDto convertEntityToDto(CesionesEntity entity){
		CesionDto dto = null;
		if(entity!=null){
			dto = new CesionDto();
			dto.setId(entity.getIdCesion());
			if(entity.getEntidades()!=null){
				dto.setEntidadDto(entidadesConverter.convertEntityToDto(entity.getEntidades()));
			}
			if(entity.getEquipamiento()!=null){
				dto.setEquipamientoDto(equipamientoConverter.convertEntityToDto(entity.getEquipamiento()));
			}
			dto.setFechaCesion(entity.getFecCesion());
			dto.setFechaPrevistaBaja(entity.getFecPrevBaja());
			dto.setFechaBaja(entity.getFecBaja());
			dto.setObservaciones(entity.getObservaciones());
			dto.setMotivoBaja(entity.getMotivoBaja());
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de CesionDto en una lista de CesionesEntity
	 * @param dtos
	 * @return
	 */
	public List<CesionesEntity> convertListDtoToListEntity(List<CesionDto> dtos){
		List<CesionesEntity> entities = new ArrayList<>();
		if(dtos!=null){
			for(CesionDto dto : dtos){
				CesionesEntity entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	/**
	 * Convierte una lista de CesionesEntity en una lista de CesionDto
	 * @param entities
	 * @return
	 */
	public List<CesionDto> convertListEntityToListDto(List<CesionesEntity> entities){
		List<CesionDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(CesionesEntity entity : entities){
				CesionDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
