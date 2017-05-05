package org.restWebService.BPlayer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.dto.PlayerDto;
import org.restWebService.BPlayer.service.BUserService;
import org.restWebService.BPlayer.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("player")
public class PlayerController {
	
	@Autowired
	private PlayerService playerService;
	
	@Autowired
	private BUserService bUserService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public PlayerDto create(@RequestBody PlayerDto playerDto, HttpServletRequest req) {
		BUser bUser = bUserService.findByUsername(req.getUserPrincipal().getName());
		PlayerDto res = playerService.save(bUser, playerDto);
		return res;
    }
	
	@RequestMapping(value = "/findPlayersByIdOrganization/{idOrganization}")
	public List<PlayerDto> findPlayersByIdOrganization(@PathVariable("idOrganization") Long idOrganization) {
		List<PlayerDto> res = playerService.findPlayersByIdOrganization(idOrganization);
		return res;
	}
	
	@RequestMapping(value="/addPlayerToTeam/{idPlayer}/{idTeam}")
	public List<PlayerDto> addPlayerToTeam(@PathVariable("idPlayer") Long idPlayer, @PathVariable("idTeam") Long idTeam){
		List<PlayerDto> res = playerService.addPlayerToTeam(idPlayer, idTeam);
		return res;
	}
	
}
