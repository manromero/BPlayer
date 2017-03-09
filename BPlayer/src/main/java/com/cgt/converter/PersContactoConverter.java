package com.cgt.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.cgt.dto.PersContactoDto;
import com.cgt.entity.PersContactoEntity;

/**
 * Conversor de PersContactoEntity
 * @author manromero
 *
 */
@Component
public class PersContactoConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5643195105101511170L;
	
	/**
	 * Convierte PersContactoDto en PersContactoEntity
	 * @param dto
	 * @return
	 */
	public PersContactoEntity convertDtoToEntity(PersContactoDto dto){
		PersContactoEntity entity = new PersContactoEntity();
		if(dto!=null){
			entity.setIdPersona(dto.getId());
			entity.setIdEntidad(dto.getIdEntidad());
			entity.setNombre(dto.getNombre());
			entity.setCargo(dto.getCargo());
			entity.setTelefonos(dto.getTelefono());
			entity.setEmail(dto.getEmail());
			entity.setFax(dto.getFax());
			entity.setDireccion(dto.getDireccion());
			entity.setObservaciones(dto.getObservaciones());
		}
		return entity;
	}
	
	/**
	 * Convierte PersContactoEntity en PersContactoDto
	 * @param entity
	 * @return
	 */
	public PersContactoDto convertEntityToDto(PersContactoEntity entity){
		PersContactoDto dto = new PersContactoDto();
		if(entity!=null){
			dto.setId(entity.getIdPersona());
			dto.setIdEntidad(entity.getIdEntidad());
			dto.setNombre(entity.getNombre());
			dto.setCargo(entity.getCargo());
			dto.setTelefono(entity.getTelefonos());
			dto.setEmail(entity.getEmail());
			dto.setFax(entity.getFax());
			dto.setDireccion(entity.getDireccion());
			dto.setObservaciones(entity.getObservaciones());
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de PersContactoDto en una lista de PersContactoEntity
	 * @param dtos
	 * @return
	 */
	public List<PersContactoEntity> convertListDtoToListEntity(List<PersContactoDto> dtos){
		List<PersContactoEntity> entities = new ArrayList<>();
		if(dtos!=null){
			for(PersContactoDto dto : dtos){
				PersContactoEntity entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	/**
	 * Convierte una lista de PersContactoEntity en una lista de PersContactoDto
	 * @param entities
	 * @return
	 */
	public List<PersContactoDto> convertListEntityToListDto(List<PersContactoEntity> entities){
		List<PersContactoDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(PersContactoEntity entity : entities){
				PersContactoDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
