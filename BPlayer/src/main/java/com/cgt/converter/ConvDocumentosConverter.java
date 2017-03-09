package com.cgt.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cgt.dto.ConvDocumentosDto;
import com.cgt.entity.ConvDocumentosEntity;

/**
 * Conversor de ConvDocumentosEntity
 * @author manromero
 *
 */
@Component
public class ConvDocumentosConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -352489906708788195L;
	
	/**
	 * Convierte ConvDocumentosDto en ConvDocumentosEntity
	 * @param dto
	 * @return
	 */
	public ConvDocumentosEntity convertDtoToEntity(ConvDocumentosDto dto){
		ConvDocumentosEntity entity = new ConvDocumentosEntity();
		if(dto!=null){
			entity.setIdDocumento(dto.getId());
			entity.setIdConvenio(dto.getIdConvenio());
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
	 * Convierte ConvDocumentosEntity en ConvDocumentosDto
	 * @param entity
	 * @return
	 */
	public ConvDocumentosDto convertEntityToDto(ConvDocumentosEntity entity){
		ConvDocumentosDto dto = new ConvDocumentosDto();
		if(entity!=null){
			dto.setId(entity.getIdDocumento());
			dto.setIdConvenio(entity.getIdConvenio());
			dto.setTipoDocumento(entity.getTipoDocumento());
			dto.setNombre(entity.getNombre());
			dto.setDescripcion(entity.getDescripcion());
			dto.setFecSubida(dto.getFecSubida());
			dto.setFormato(entity.getFormato());
			dto.setSize(entity.getSize());
			dto.setData(entity.getData());
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de ConvDocumentosDto en una lista de ConvDocumentosEntity
	 * @param dtos
	 * @return
	 */
	public List<ConvDocumentosEntity> convertListDtoToListEntity(List<ConvDocumentosDto> dtos){
		List<ConvDocumentosEntity> entities = new ArrayList<>();
		if(dtos!=null){
			for(ConvDocumentosDto dto : dtos){
				ConvDocumentosEntity entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	/**
	 * Convierte una lista de ConvDocumentosEntity en una lista de ConvDocumentosDto
	 * @param entities
	 * @return
	 */
	public List<ConvDocumentosDto> convertListEntityToListDto(List<ConvDocumentosEntity> entities){
		List<ConvDocumentosDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(ConvDocumentosEntity entity : entities){
				ConvDocumentosDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}