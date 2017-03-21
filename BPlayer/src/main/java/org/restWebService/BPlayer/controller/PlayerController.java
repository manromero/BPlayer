package org.restWebService.BPlayer.controller;

import org.restWebService.BPlayer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;

}
