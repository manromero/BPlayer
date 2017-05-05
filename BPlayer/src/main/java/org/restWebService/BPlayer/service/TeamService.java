package org.restWebService.BPlayer.service;

import java.util.ArrayList;
import java.util.List;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.domain.Organization;
import org.restWebService.BPlayer.domain.Team;
import org.restWebService.BPlayer.dto.BUserDto;
import org.restWebService.BPlayer.dto.DetailedTeamDto;
import org.restWebService.BPlayer.dto.PlayerDto;
import org.restWebService.BPlayer.dto.TeamDto;
import org.restWebService.BPlayer.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {
	
	@Autowired
	private TeamRepository teamRepository;
	
	@Autowired
	private BUserService bUserService;
	
	@Autowired
	private OrganizationService organizationService;
	
	@Autowired
	private PlayerService playerService;

	/**
	 * Almacena o actualiza un equipo
	 * @param bUser
	 * @param teamDto
	 * @return
	 */
	public TeamDto save(BUser bUser, TeamDto teamDto) {
		TeamDto res = new TeamDto();
		List<String> errores = validateTeamDto(teamDto);
		if(errores.isEmpty()){
			errores.addAll(checkTeamOrganizationIsAdministratedByBUser(bUser,teamDto));
		}		
		if(errores.isEmpty()){
			Team team = convertDtoToEntity(teamDto);
			Team aux = teamRepository.save(team);
			res = convertEntityToDto(aux);
		}else{
			res.setErrores(errores);
		}
		return res;
	}
	
	/**
	 * Almacena/Actualiza un team
	 * @param team
	 * @return
	 */
	public Team save(Team team) {
		Team res = null;
		if(team!=null){
			res = teamRepository.save(team);
		}
		return res;
	}

	
	/**
	 * Devuelve la lista de equipos que tiene una organization
	 * @param idOrganization
	 * @return
	 */
	public List<TeamDto> findTeamsByIdOrganization(Long idOrganization) {
		List<TeamDto> res = new ArrayList<>();
		if(idOrganization!=null){
			List<Team> entities = teamRepository.findTeamsByIdOrganization(idOrganization);
			res = convertListEntityToListDto(entities);
		}
		return res;
	}
	
	/**
	 * Devuelve un equipo junto con sus detalles
	 * @param idTeam
	 * @return
	 */
	public DetailedTeamDto findDetailedTeamByIdTeam(Long idTeam) {
		DetailedTeamDto res = null;
		if(idTeam!=null && !idTeam.equals(0l)){
			Team teamEntity = teamRepository.findOne(idTeam);
			res = convertEntityToDetailedDto(teamEntity);
			List<PlayerDto> listPlayerDto = playerService.findPlayersByIdTeam(idTeam);
			res.setListPlayerDto(listPlayerDto);
		}
		return res;
	}
	
	/**
	 * Devuelve un team por su id
	 * @param idTeam
	 * @return
	 */
	public Team findOne(Long idTeam) {
		Team res = null;
		if(idTeam!=null){
			res = teamRepository.findOne(idTeam);
		}
		return res;
	}

	/**
	 * Indica si el usuario administra la organization
	 * @param bUser
	 * @param teamDto
	 * @return
	 */
	private List<String> checkTeamOrganizationIsAdministratedByBUser(BUser bUser, TeamDto teamDto) {
		List<String> res = new ArrayList<>();
		res.addAll(bUserService.validateBUser(bUser));
		if(res.isEmpty()){
			//Las comprobaciones sobre el TeamDto ya estan realizadas en validateTeamDto
			List<BUserDto> administrators = bUserService.finAdministratorsByIdOrganization(teamDto.getIdOrganization());
			boolean isAnAdministrator = false;
			for(BUserDto administrator : administrators){
				if(administrator.getId()==bUser.getId()){
					isAnAdministrator = true;
					break;
				}
			}
			if(!isAnAdministrator){
				res.add("The actual BUser is not an administrator of the organization");
			}
		}
		return res;
	}

	/**
	 * Valida un team dto, si la cadena no esta vacia, contiene una lista de errores
	 * @param teamDto
	 * @return
	 */
	private List<String> validateTeamDto(TeamDto teamDto) {
		List<String> res = new ArrayList<>();
		if(teamDto==null){
			res.add("Team can not be null");
		}else{
			if(teamDto.getName()==null || teamDto.getName().trim().equals("")){
				res.add("The file Name cannot be null");
			}
			if(teamDto.getIdOrganization()==null || teamDto.getIdOrganization().equals(0l)){
				res.add("The file Organization can not be null");
			}
		}
		return res;
	}
	
	//CONVERTERS
	
	/**
	 * Convert Dto to Entity
	 * @param dto
	 * @return
	 */
	private Team convertDtoToEntity(TeamDto dto) {
		Team entity = null;
		if(dto!=null){
			if(dto.getId()!=0l){
				entity = teamRepository.findOne(dto.getId());
			}else{
				entity = new Team();
			}
			entity.setName(dto.getName());
			//Indicamos la organization
			Organization organization = new Organization();
			organization.setId(dto.getIdOrganization());
			entity.setOrganization(organization);
		}
		return entity;
	}
	
	/**
	 * Convert Entity to Dto
	 * @param aux
	 * @return
	 */
	private TeamDto convertEntityToDto(Team entity) {
		TeamDto dto = null;
		if(entity!=null){
			dto = new TeamDto();
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setIdOrganization(entity.getOrganization().getId());
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de entity en una lista de dto
	 * @param entities
	 * @return
	 */
	public List<TeamDto> convertListEntityToListDto(List<Team> entities){
		List<TeamDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(Team entity : entities){
				TeamDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}
	
	/**
	 * Convierte en una entity en un team detailed
	 * @param entity
	 * @return
	 */
	private DetailedTeamDto convertEntityToDetailedDto(Team entity) {
		DetailedTeamDto dto = new DetailedTeamDto();
		if(entity!=null){
			dto.setId(entity.getId());
			dto.setName(entity.getName());
			dto.setOrganizationDto(organizationService.convertEntityToDto(entity.getOrganization()));
		}
		return dto;
	}

}
