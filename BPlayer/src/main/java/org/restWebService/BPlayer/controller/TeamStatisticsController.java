package org.restWebService.BPlayer.controller;

import org.restWebService.BPlayer.service.TeamStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("teamStatistics")
public class TeamStatisticsController {
	
	@Autowired
	private TeamStatisticsService teamStatisticsService;

}
