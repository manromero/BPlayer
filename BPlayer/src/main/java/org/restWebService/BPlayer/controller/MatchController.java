package org.restWebService.BPlayer.controller;

import javax.servlet.http.HttpServletRequest;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.dto.MatchDto;
import org.restWebService.BPlayer.service.BUserService;
import org.restWebService.BPlayer.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("match")
public class MatchController {
	
	@Autowired
	private MatchService matchService;
	
	@Autowired
	private BUserService bUserService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public MatchDto create(@RequestBody MatchDto matchDto, HttpServletRequest req){
		BUser bUser = bUserService.findByUsername(req.getUserPrincipal().getName());
		MatchDto res = matchService.save(bUser, matchDto);
		return res;
	}

}
