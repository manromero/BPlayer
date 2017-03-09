package com.cgt.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cgt.dto.CesDocumentosDto;
import com.cgt.entity.CesDocumentosEntity;

/**
 * Conversor de CesDocumentosEntity
 * @author manromero
 *
 */
@Component
public class CesDocumentosConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8508892201931572588L;
	
	/**
	 * Convierte CesDocumentosDto en CesDocumentosEntity
	 * @param dto
	 * @return
	 */
	public CesDocumentosEntity convertDtoToEntity(CesDocumentosDto dto){
		CesDocumentosEntity entity = new CesDocumentosEntity();
		if(dto!=null){
			entity.setIdDocumento(dto.getId());
			entity.setIdCesion(dto.getIdCesion());
			entity.setTipoDocumento(dto.getTipoDocumento());
			entity.setNombre(dto.getNombre());
			entity.setDescripcion(dto.getDescripcion());
			entity.setFecSubida(dto.getFecSubida());
			entity.setFormato(dto.getFormato());
			entity.setSize(dto.getSize());
			entity.setData(dto.getData());;
		}
		return entity;
	}
	
	/**
	 * Convierte CesDocumentosEntity en CesDocumentosDto
	 * @param entity
	 * @return
	 */
	public CesDocumentosDto convertEntityToDto(CesDocumentosEntity entity){
		CesDocumentosDto dto = new CesDocumentosDto();
		if(entity!=null){
			dto.setId(entity.getIdDocumento());
			dto.setIdCesion(entity.getIdCesion());
			dto.setTipoDocumento(entity.getTipoDocumento());
			dto.setNombre(entity.getNombre());
			dto.setDescripcion(entity.getDescripcion());
			dto.setFecSubida(entity.getFecSubida());
			dto.setFormato(entity.getFormato());
			dto.setSize(entity.getSize());
			dto.setData(entity.getData());
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de CesDocumentosDto en una lista de CesDocumentosEntity
	 * @param dtos
	 * @return
	 */
	public List<CesDocumentosEntity> convertListDtoToListEntity(List<CesDocumentosDto> dtos){
		List<CesDocumentosEntity> entities = new ArrayList<>();
		if(dtos!=null){
			for(CesDocumentosDto dto : dtos){
				CesDocumentosEntity entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	/**
	 * Convierte una lista de CesDocumentosEntity en una lista de CesDocumentosDto
	 * @param entities
	 * @return
	 */
	public List<CesDocumentosDto> convertListEntityToListDto(List<CesDocumentosEntity> entities){
		List<CesDocumentosDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(CesDocumentosEntity entity : entities){
				CesDocumentosDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
