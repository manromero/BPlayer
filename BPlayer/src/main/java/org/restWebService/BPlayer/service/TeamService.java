package org.restWebService.BPlayer.service;

import org.restWebService.BPlayer.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;

}
