package org.restWebService.BPlayer.service;

import org.restWebService.BPlayer.repository.MatchPlayerStaticticsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchPlayerStaticticsService {
	
	@Autowired
	private MatchPlayerStaticticsRepository matchPlayerStaticticsRepository;
	
}
