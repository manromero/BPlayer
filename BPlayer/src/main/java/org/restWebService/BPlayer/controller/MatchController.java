package org.restWebService.BPlayer.controller;

import org.restWebService.BPlayer.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("match")
public class MatchController {
	
	@Autowired
	private MatchService matchService;

}
