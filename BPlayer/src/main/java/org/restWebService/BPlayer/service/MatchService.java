package org.restWebService.BPlayer.service;

import java.util.ArrayList;
import java.util.List;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.domain.Match;
import org.restWebService.BPlayer.domain.MatchStatus;
import org.restWebService.BPlayer.domain.Team;
import org.restWebService.BPlayer.dto.MatchDto;
import org.restWebService.BPlayer.repository.MatchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MatchService {
	
	@Autowired
	private MatchRepository matchRepository;
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private TeamService teamService;

	/**
	 * Almacena/Actualiza un partido en la base de datos
	 * @param bUser
	 * @param matchDto
	 * @return
	 */
	public MatchDto save(BUser bUser, MatchDto matchDto) {
		MatchDto res = new MatchDto();
		List<String> errores = validateMatchDto(matchDto);
		if(errores.isEmpty()){
			Boolean isAnAdministrator = organizationService.checkOrganizationIsAdministratedByBUser(matchDto.getIdOrganization(), bUser.getId());
			if(!isAnAdministrator){
				errores.add("The BUser must be an administrator of the organization");
			}
		}		
		if(errores.isEmpty()){
			Match match = convertDtoToEntity(matchDto);
			Match aux = matchRepository.save(match);
			res = convertEntityToDto(aux);
		}else{
			res.setErrores(errores);
		}
		return res;
	}

	/**
	 * Comprueba que el matchDto tiene los campos rellenados correctamente
	 * @param matchDto
	 * @return
	 */
	private List<String> validateMatchDto(MatchDto matchDto) {
		List<String> res = new ArrayList<>();
		if(matchDto!=null){
			if(matchDto.getIdOrganization()==null || matchDto.getIdOrganization().equals(0l)){
				res.add("Organization can not be null");
			}
			if(matchDto.getIdHomeTeam()==null || matchDto.getIdHomeTeam().equals(0l)){
				res.add("Home Team can not be null");
			}
			if(matchDto.getIdAwayTeam()==null || matchDto.getIdAwayTeam().equals(0l)){
				res.add("Away Team can not be null");
			}
			if(matchDto.getDate()==null){
				res.add("Date can not be null");
			}
			if(matchDto.getNumQuarter()==null || matchDto.getNumQuarter().compareTo(0)<=0){
				res.add("Number of quarters must be filled with a positive number");
			}
			if(matchDto.getQuarterTime()==null || matchDto.getQuarterTime().compareTo(0)<=0){
				res.add("Quarter time must be filled with a positive number");
			}
			
		}else{
			res.add("Match can not be null");
		}
		return res;
	}
	
	//Converters
	
	/**
	 * Convert Dto to Entity
	 * @param dto
	 * @return
	 */
	private Match convertDtoToEntity(MatchDto dto) {
		Match entity = null;
		if(dto!=null){
			if(dto.getId()!=0l){
				entity = matchRepository.findOne(dto.getId());
			}else{
				//Si se trata de un nuevo partido
				entity = new Match();
				entity.setListMatchPlayerStatictics(new ArrayList<>());
				entity.setMatchStatus(MatchStatus.NOT_PLAYED);
			}
			entity.setDate(dto.getDate());
			entity.setNumQuarter(dto.getNumQuarter());
			entity.setQuarterTime(dto.getQuarterTime());
			entity.setNumRest(dto.getNumRest());
			entity.setRestTime(dto.getRestTime());
			entity.setFaulsAllowedTeam(dto.getFaulsAllowedTeam());
			entity.setFaulsAllowedPlayer(dto.getFaulsAllowedPlayer());
			Team homeTeam = teamService.findOne(dto.getIdHomeTeam());
			Team awayTeam = teamService.findOne(dto.getIdAwayTeam());
			entity.setHomeTeam(homeTeam);
			entity.setAwayTeam(awayTeam);
		}
		return entity;
	}
	
	/**
	 * Convert Entity to Dto
	 * @param aux
	 * @return
	 */
	private MatchDto convertEntityToDto(Match entity) {
		MatchDto dto = null;
		if(entity!=null){
			dto = new MatchDto();
			dto.setId(entity.getId());
			dto.setIdOrganization(entity.getHomeTeam().getOrganization().getId());
			dto.setIdHomeTeam(entity.getHomeTeam().getId());
			dto.setIdAwayTeam(entity.getAwayTeam().getId());
			dto.setDate(entity.getDate());
			dto.setNumQuarter(entity.getNumQuarter());
			dto.setQuarterTime(entity.getQuarterTime());
			dto.setNumRest(entity.getNumRest());
			dto.setRestTime(entity.getRestTime());
			dto.setFaulsAllowedTeam(entity.getFaulsAllowedTeam());
			dto.setFaulsAllowedTeam(entity.getFaulsAllowedPlayer());
		}
		return dto;
	}

}
