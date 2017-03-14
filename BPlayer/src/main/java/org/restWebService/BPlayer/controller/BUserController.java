package org.restWebService.BPlayer.controller;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.service.BUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("buser")
public class BUserController {

	@Autowired
	private BUserService bUserService;

    @RequestMapping("/findByUsername/{username}")
    public BUser findUserByName(@PathVariable("username") String name) {
    	BUser res = bUserService.findByUsername(name);
        return res;
    }
}
