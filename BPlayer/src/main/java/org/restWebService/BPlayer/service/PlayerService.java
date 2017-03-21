package org.restWebService.BPlayer.service;

import org.restWebService.BPlayer.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;

}
