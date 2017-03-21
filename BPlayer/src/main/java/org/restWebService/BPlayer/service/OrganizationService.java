package org.restWebService.BPlayer.service;

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
	
	public OrganizationDto save(BUser bUser, Organization organization){
		OrganizationDto res = null;
		if(bUser!=null && organization!=null){
			organization.setCreater(bUser);
			Organization aux = organizationRepository.save(organization);
			res = converDomainToDto(aux);
		}
		return res;
	}
	
	//Converters
	public OrganizationDto converDomainToDto(Organization organization){
		OrganizationDto res = null;
		if(organization!=null){
			res = new OrganizationDto();
			res.setName(organization.getName());
			res.setbUserId(organization.getCreater().getId());
		}
		return res;
	}

}
