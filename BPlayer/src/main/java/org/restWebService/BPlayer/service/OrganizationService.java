package org.restWebService.BPlayer.service;

import java.util.ArrayList;
import java.util.List;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.domain.Organization;
import org.restWebService.BPlayer.dto.OrganizationDto;
import org.restWebService.BPlayer.repository.OrganizationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {
	
	@Autowired
	private OrganizationRepository organizationRepository;
	
	/**
	 * Almacena o actualiza una organizacion
	 * @param bUser
	 * @param organization
	 * @return
	 */
	public OrganizationDto save(BUser bUser, OrganizationDto organizationDto){
		//TODO faltan validaciones
		OrganizationDto res = null;
		if(bUser!=null && organizationDto!=null){
			Organization organization = convertDtoToEntity(organizationDto);
			organization.setCreater(bUser);
			//El creador sera tambien uno de los administradores
			organization.getAdministrators().add(bUser);
			Organization aux = organizationRepository.save(organization);
			res = convertEntityToDto(aux);
		}
		return res;
	}
	
	/**
	 * Devuelve la lista de organizaciones por usuario
	 * @param bUser
	 * @return
	 */
	public List<OrganizationDto> findAdministratedByBUser(BUser bUser) {
		//TODO faltan validaciones
		List<OrganizationDto> res = new ArrayList<>();
		if(bUser!=null){
			List<Organization> aux = organizationRepository.findAdministratedByBUserId(bUser.getId());
			res = convertListEntityToListDto(aux);
		}
		return res;
	}
	
	//Converters
	/**
	 * Convierte una organizacion en una OrganizacionDto
	 * @param domain
	 * @return
	 */
	public OrganizationDto convertEntityToDto(Organization entity){
		OrganizationDto dto = null;
		if(entity!=null){
			dto = new OrganizationDto();
			dto.setName(entity.getName());
			dto.setbUserId(entity.getCreater().getId());
		}
		return dto;
	}
	
	/**
	 * Convierte una OrganizationDto en una Organization
	 * @param dto
	 * @return
	 */
	public Organization convertDtoToEntity(OrganizationDto dto){
		Organization entity = null;
		if(dto!=null){
			if(dto.getId()!=0l){
				entity = organizationRepository.findOne(dto.getId());
			}else{
				entity = new Organization();
			}
			entity.setName(dto.getName());
		}
		return entity;
	}
	
	/**
	 * Convierte una lista de Organization en una lista de OrganizationDto
	 * @param entities
	 * @return
	 */
	public List<OrganizationDto> convertListEntityToListDto(List<Organization> entities) {
		List<OrganizationDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(Organization entity : entities){
				OrganizationDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
	/**
	 * Convierte una lista de OrganizationDto en una lista de Organization
	 * @param dtos
	 * @return
	 */
	public List<Organization> convertListDtoToListEntity(List<OrganizationDto> dtos){
		List<Organization> entities = new ArrayList<>();
		if(dtos!=null){
			for(OrganizationDto dto : dtos){
				Organization entity = convertDtoToEntity(dto);
				entities.add(entity);
			}
		}
		return entities;
	}

}
