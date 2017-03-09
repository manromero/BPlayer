package com.cgt.converter;

import java.io.Serializable;

import org.springframework.stereotype.Component;

import com.cgt.dto.UsuariosDto;
import com.cgt.entity.UsuariosEntity;
/**
 * Conversor de Usuarios
 * @author apascual
 *
 */
@Component
public class UsuariosConverter implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5743403369325781573L;

	/**
	 * Conversión de DTO a Entity
	 * @param dto
	 * @return entity
	 */
	public UsuariosEntity convertDtoToEntity(UsuariosDto dto){
		UsuariosEntity entity = new UsuariosEntity();
		if(dto != null){
			entity.setIdUsuario(dto.getIdUsuario());
			entity.setCodigoUsuario(dto.getCodigoUsuario());
			entity.setClave(dto.getClave());
			entity.setIdProvincia(dto.getIdProvincia());
			entity.setNomApe(dto.getNomApe());
			entity.setEmail(dto.getEmail());
			entity.setAdmin(dto.getAdmin());
			entity.setObservaciones(dto.getObservaciones());
			entity.setFecCreacion(dto.getFecCreacion());
			entity.setFecBaja(dto.getFecBaja());
		}
		return entity;
	}
	
	/**
	 * Conversión de Entity to DTO
	 * @param entity
	 * @return dto
	 */
	public UsuariosDto convertEntityToDto(UsuariosEntity entity){
		UsuariosDto dto = new UsuariosDto();
		if(dto != null){
			dto.setIdUsuario(entity.getIdUsuario());
			dto.setCodigoUsuario(entity.getCodigoUsuario());
			//No le devuelvo el campo contraseña informado por seguridad
			dto.setClave(null);
			dto.setIdProvincia(entity.getIdProvincia());
			dto.setNomApe(entity.getNomApe());
			dto.setEmail(entity.getEmail());
			dto.setAdmin(entity.getAdmin());
			dto.setObservaciones(entity.getObservaciones());
			//La fecha de creación y de baja no la devuelvo porque lo veo innecesario
		}
		return dto;
	}
}
