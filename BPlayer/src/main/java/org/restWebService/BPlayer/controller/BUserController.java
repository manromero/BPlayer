package org.restWebService.BPlayer.controller;

import javax.servlet.http.HttpServletRequest;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.dto.BUserToRegisterDto;
import org.restWebService.BPlayer.service.BUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("buser")
public class BUserController {

	@Autowired
	private BUserService bUserService;
	
    @RequestMapping(value="/findByUsername/{username}")
    public BUser findUserByName(@PathVariable("username") String name) {
    	BUser res = bUserService.findByUsername(name);
        return res;
    }

	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public BUserToRegisterDto save(@RequestBody BUserToRegisterDto bUserToRegisterDto, HttpServletRequest req) {
		BUserToRegisterDto res = bUserService.register(bUserToRegisterDto);
		return res;
    }
    
}
