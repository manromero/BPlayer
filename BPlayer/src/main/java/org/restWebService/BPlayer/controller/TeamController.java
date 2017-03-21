package org.restWebService.BPlayer.controller;

import org.restWebService.BPlayer.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;

}
