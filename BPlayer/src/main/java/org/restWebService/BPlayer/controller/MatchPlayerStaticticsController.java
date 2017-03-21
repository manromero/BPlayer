package org.restWebService.BPlayer.controller;

import org.restWebService.BPlayer.service.MatchPlayerStaticticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("matchPlayerStatictics")
public class MatchPlayerStaticticsController {
	
	@Autowired
	private MatchPlayerStaticticsService matchPlayerStaticticsService;

}
