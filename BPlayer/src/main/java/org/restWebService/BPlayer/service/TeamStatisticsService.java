package org.restWebService.BPlayer.service;

import org.restWebService.BPlayer.repository.TeamStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamStatisticsService {
	
	@Autowired
	private TeamStatisticsRepository teamStatisticsRepository;

}
