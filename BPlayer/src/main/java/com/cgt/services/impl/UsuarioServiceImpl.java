package com.cgt.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.UsuariosConverter;
import com.cgt.dao.UsuarioDao;
import com.cgt.dto.UsuariosDto;
import com.cgt.entity.UsuariosEntity;
import com.cgt.services.UsuarioService;

/**
 * Servicio de la lógica
 * @author apascual
 *
 */
@Service
public class UsuarioServiceImpl implements UsuarioService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2183587610732402338L;
	
	@Autowired
	private UsuarioDao usuarioDao;
	@Resource
	private UsuariosConverter converter;

	public UsuarioServiceImpl() {
		super();
	}
	
	public List<UsuariosDto> encuentraTodosUsuarios(){
		List<UsuariosEntity> listaEntity = usuarioDao.findAllUsuarios();
		List<UsuariosDto> listaDto = new ArrayList<>();
		if(!listaEntity.isEmpty()){
			for(com.cgt.entity.UsuariosEntity entity: listaEntity){
				listaDto.add(converter.convertEntityToDto(entity));
			}
		}
		return listaDto;
	}

	@Override
	public UsuariosDto findById(Long idUsuario) {
		UsuariosEntity entity = usuarioDao.findUsuarioById(idUsuario);
		if(entity != null){
			return converter.convertEntityToDto(entity);
		}
		return null;
	}

	@Override
	public UsuariosDto findByUsername(String username) {
		UsuariosEntity entity = usuarioDao.findUsuarioByCodigoUsu(username);
		if(entity != null){
			return converter.convertEntityToDto(entity);
		}
		return null;
	}

}
