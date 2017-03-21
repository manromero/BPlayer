package org.restWebService.BPlayer.service;

import org.restWebService.BPlayer.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
	
	@Autowired
	private MatchRepository matchRepository;

}
