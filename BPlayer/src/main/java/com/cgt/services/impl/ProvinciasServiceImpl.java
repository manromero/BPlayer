package com.cgt.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.ProvinciasConverter;
import com.cgt.dao.ProvinciasDao;
import com.cgt.dto.ProvinciaDto;
import com.cgt.dto.UsuariosDto;
import com.cgt.entity.ProvinciasEntity;
import com.cgt.services.ProvinciasService;


/**
 * Servicio de ProvinciasEntity
 * @author manromero
 *
 */
@Service
public class ProvinciasServiceImpl implements ProvinciasService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -831748421041988856L;
	
	@Autowired
	private ProvinciasDao provinciasDao;
	
	@Resource
	private ProvinciasConverter provinciasConverter;

	@Override
	public List<ProvinciaDto> findAll() {
		List<ProvinciasEntity> entities = provinciasDao.findAll();
		List<ProvinciaDto> res = provinciasConverter.convertListEntityToListDto(entities);
		return res;
	}

	@Override
	public List<ProvinciaDto> findProvinciasAsociadasAusuario(UsuariosDto usuariosDto) {
		List<ProvinciaDto> res = new ArrayList<>();
		if(usuariosDto!=null){
			List<ProvinciasEntity> entities = provinciasDao.findByUsuarioId(usuariosDto.getIdUsuario());
			res = provinciasConverter.convertListEntityToListDto(entities);
		}
		return res;
	}

}
