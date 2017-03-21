package org.restWebService.BPlayer.controller;

import org.restWebService.BPlayer.service.PlayerStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("playerStatistics")
public class PlayerStatisticsController {
	
	@Autowired
	private PlayerStatisticsService playerStatisticsService;

}
