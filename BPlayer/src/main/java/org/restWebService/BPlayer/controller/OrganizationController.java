package org.restWebService.BPlayer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.dto.OrganizationDto;
import org.restWebService.BPlayer.service.BUserService;
import org.restWebService.BPlayer.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("organization")
public class OrganizationController {
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private BUserService bUserService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public OrganizationDto create(@RequestBody OrganizationDto organizationDto, HttpServletRequest req) {
		BUser bUser = bUserService.findByUsername(req.getUserPrincipal().getName());
		OrganizationDto res = organizationService.save(bUser, organizationDto);
		return res;
    }
	
	@RequestMapping(value = "/findAdministratedByPrincipal")
	public List<OrganizationDto> findAdministratedByPrincipal(HttpServletRequest req){
		BUser bUser = bUserService.findByUsername(req.getUserPrincipal().getName());
		List<OrganizationDto> res = organizationService.findAdministratedByBUser(bUser);
		return res;
	}
	
}
