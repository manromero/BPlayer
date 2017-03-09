package com.cgt.services.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgt.converter.PersContactoConverter;
import com.cgt.dao.PersContactoDao;
import com.cgt.dto.PersContactoDto;
import com.cgt.entity.PersContactoEntity;
import com.cgt.services.PersContactoService;

/**
 * Servicio de PersContactoEntity
 * @author manromero
 *
 */
@Service
public class PersContactoServiceImpl implements PersContactoService, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5949160190510224206L;
	
	@Autowired
	private PersContactoDao persContactoDao;
	
	@Resource
	private PersContactoConverter persContactoConverter;

	@Override
	public List<PersContactoDto> findByIdEntidad(Long idEntidad) {
		List<PersContactoDto> res = new ArrayList<>();
		if(idEntidad!=null){
			List<PersContactoEntity> entities = persContactoDao.findByIdEntidad(idEntidad);
			res = persContactoConverter.convertListEntityToListDto(entities);
		}
		return res;
	}

	@Override
	public List<PersContactoDto> findByIdCesion(Long idCesion) {
		List<PersContactoDto> res = new ArrayList<>();
		if(idCesion!=null){
			List<PersContactoEntity> entities = persContactoDao.findByIdCesion(idCesion);
			res = persContactoConverter.convertListEntityToListDto(entities);
		}
		return res;
	}

	@Override
	public List<PersContactoDto> findByIdConvenio(Long idConvenio) {
		List<PersContactoDto> res = new ArrayList<>();
		if(idConvenio!=null){
			List<PersContactoEntity> entities = persContactoDao.findByIdConvenio(idConvenio);
			res = persContactoConverter.convertListEntityToListDto(entities);
		}
		return res;
	}

}