package org.restWebService.BPlayer.controller;

import javax.servlet.http.HttpServletRequest;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.domain.Organization;
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
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    public OrganizationDto save(@RequestBody Organization organization, HttpServletRequest req) {
		BUser bUser = bUserService.findByUsername(req.getUserPrincipal().getName());
		OrganizationDto res = organizationService.save(bUser, organization);
		return res;
    }

}
