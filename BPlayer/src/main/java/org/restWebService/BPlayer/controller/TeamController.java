package org.restWebService.BPlayer.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.dto.DetailedTeamDto;
import org.restWebService.BPlayer.dto.TeamDto;
import org.restWebService.BPlayer.service.BUserService;
import org.restWebService.BPlayer.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("team")
public class TeamController {
	
	@Autowired
	private TeamService teamService;
	
	@Autowired
	private BUserService bUserService;
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
    public TeamDto create(@RequestBody TeamDto teamDto, HttpServletRequest req) {
		BUser bUser = bUserService.findByUsername(req.getUserPrincipal().getName());
		TeamDto res = teamService.save(bUser, teamDto);
		return res;
    }
	
	@RequestMapping(value = "/findTeamsByIdOrganization/{idOrganization}")
	public List<TeamDto> findByIdOrganization(@PathVariable("idOrganization") Long idOrganization) {
		List<TeamDto> res = teamService.findTeamsByIdOrganization(idOrganization);
		return res;
	}
	
	@RequestMapping(value = "/findDetailedTeamByIdTeam/{idTeam}")
	public DetailedTeamDto findDetailedTeamByIdTeam(@PathVariable("idTeam") Long idTeam){
		DetailedTeamDto res = teamService.findDetailedTeamByIdTeam(idTeam);
		return res;
	}
	
	@RequestMapping(value = "/deleteTeamByIdTeam/{idTeam}")
	public List<String> deleteTeamByIdTeam(@PathVariable("idTeam") Long idTeam, HttpServletRequest req){
		BUser bUser = bUserService.findByUsername(req.getUserPrincipal().getName());
		List<String> res = teamService.deleteTeam(bUser, idTeam);
		return res;
	}

}
