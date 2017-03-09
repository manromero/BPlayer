package com.cgt.converter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.cgt.dto.ConvenioDto;
import com.cgt.entity.ConveniosEntity;

/**
 * Conversor de ConveniosEntity
 * @author manromero
 *
 */
@Component
public class ConveniosConverter implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1577979067007244662L;
	
	@Resource
	private EntidadesConverter entidadesConverter;
	
	/**
	 * Convierte ConvenioDto en ConveniosEntity
	 * @param dto
	 * @return
	 */
	public ConveniosEntity convertDtoToEntity(ConvenioDto dto){
		ConveniosEntity entity = new ConveniosEntity();
		if(dto!=null){
			entity.setIdConvenio(dto.getId());
			if(dto.getEntidadDto()!=null){
				entity.setIdEntidades(dto.getEntidadDto().getId());
			}
			entity.setFecIniConv(dto.getFechaInicio());
			entity.setFecFirmaConv(dto.getFechaFirma());
			entity.setObservaciones(dto.getObservaciones());
			entity.setObjetoConvenio(dto.getObjeto());
			entity.setFecBaja(dto.getFechaBaja());
			entity.setMotivoBaja(dto.getMotivoBaja());
		}
		return entity;
	}
	
	/**
	 * Convierte ConveniosEntity en ConvenioDto
	 * @param entity
	 * @return
	 */
	public ConvenioDto convertEntityToDto(ConveniosEntity entity){
		ConvenioDto dto = new ConvenioDto();
		if(entity!=null){
			dto.setId(entity.getIdConvenio());
			dto.setObjeto(entity.getObjetoConvenio());
			if(entity.getEntidades()!=null){
				dto.setEntidadDto(entidadesConverter.convertEntityToDto(entity.getEntidades()));
			}
			dto.setFechaFirma(entity.getFecFirmaConv());
			dto.setFechaInicio(entity.getFecIniConv());
			dto.setFechaBaja(entity.getFecBaja());
			dto.setObservaciones(entity.getObservaciones());
			dto.setMotivoBaja(entity.getMotivoBaja());
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de ConvenioDto en una lista de ConveniosEntity
	 * @param dtos
	 * @return
	 */
	public List<ConveniosEntity> convertListDtoToListEntity(List<ConvenioDto> dtos){
		List<ConveniosEntity> entities = new ArrayList<>();
		if(dtos!=null){
			for(ConvenioDto dto : dtos){
				ConveniosEntity entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}
	
	/**
	 * Convierte una lista de ConveniosEntity en una lista de ConvenioDto
	 * @param entities
	 * @return
	 */
	public List<ConvenioDto> convertListEntityToListDto(List<ConveniosEntity> entities){
		List<ConvenioDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(ConveniosEntity entity : entities){
				ConvenioDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
