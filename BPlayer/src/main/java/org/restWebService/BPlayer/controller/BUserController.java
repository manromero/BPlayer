package org.restWebService.BPlayer.controller;

import java.util.List;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.dto.BUserDto;
import org.restWebService.BPlayer.dto.BUserToRegisterDto;
import org.restWebService.BPlayer.service.BUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bUser")
public class BUserController {

	@Autowired
	private BUserService bUserService;
	
    @RequestMapping(value="/findByUsername/{username}")
    public BUser findUserByName(@PathVariable("username") String name) {
    	BUser res = bUserService.findByUsername(name);
        return res;
    }

	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public BUserToRegisterDto registerBUser(@RequestBody BUserToRegisterDto bUserToRegisterDto) {
		BUserToRegisterDto res = bUserService.register(bUserToRegisterDto);
		return res;
    }
	
	@RequestMapping(value="/findListBUserToBeAdministrator/{idOrganization}")
	public List<BUserDto> findListBUserToBeAdministrator(@PathVariable("idOrganization") Long idOrganization) {
		List<BUserDto> res = bUserService.findListBUserToBeAdministrator(idOrganization);
		return res;
	}
	
	@RequestMapping(value="/addBUserToOrganization/{idBUser}/{idOrganization}")
	public List<BUserDto> addBUserToOrganization(@PathVariable("idBUser") Long idBUser, @PathVariable("idOrganization") Long idOrganization){
		List<BUserDto> res = bUserService.addBUserToOrganization(idBUser, idOrganization);
		return res;
	}
    
}
