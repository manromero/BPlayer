package org.restWebService.BPlayer.service;

import org.restWebService.BPlayer.repository.PlayerStatisticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerStatisticsService {
	
	@Autowired
	private PlayerStatisticsRepository playerStatisticsRepository;

}
