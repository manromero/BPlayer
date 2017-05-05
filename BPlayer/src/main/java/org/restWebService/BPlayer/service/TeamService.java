package org.restWebService.BPlayer.service;

import java.util.ArrayList;
import java.util.List;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.domain.Organization;
import org.restWebService.BPlayer.domain.Team;
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
	private OrganizationService organizationService;
	
	@Autowired
	private PlayerService playerService;

	/**
	 * Almacena o actualiza un equipo si es un administrador
	 * @param bUser
	 * @param teamDto
	 * @return
	 */
	public TeamDto save(BUser bUser, TeamDto teamDto) {
		TeamDto res = new TeamDto();
		List<String> errores = validateTeamDto(teamDto);
		if(errores.isEmpty()){
			Boolean isAnAdministrator = organizationService.checkOrganizationIsAdministratedByBUser(teamDto.getIdOrganization(), bUser.getId());
			if(!isAnAdministrator){
				errores.add("The BUser must be an administrator of the organization");
			}
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
	 * Devuelve el numero de equipos que tiene una determinada organization
	 * @param idOrganization
	 * @return
	 */
	public Integer countTeamsByIdOrganization(Long idOrganization){
		Integer res = null;
		if(idOrganization!=null){
			res = teamRepository.findTeamsByIdOrganization(idOrganization).size();
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
	 * Elimina un equipo si somos uno de los administradores y el equipo no tiene jugadores
	 * @param bUser
	 * @param idTeam
	 * @return
	 */
	public List<String> deleteTeam(BUser bUser, Long idTeam) {
		List<String> res = new ArrayList<>();
		if(bUser==null){
			res.add("BUser can not be null");
		}else if(idTeam==null){
			res.add("Team can not be null");
		}else{
			Team team = teamRepository.findOne(idTeam);
			Boolean isAnAdministrator = organizationService.checkOrganizationIsAdministratedByBUser(team.getOrganization().getId(), bUser.getId());
			if(!isAnAdministrator){
				res.add("The BUser must be an administrator of the organization of the team");
			}else{
				//Se comprueba que no tiene players
				Integer numberOfPlayer = playerService.countPlayersByIdTeam(idTeam);
				if(numberOfPlayer.compareTo(0)>0){
					res.add("It's not possible to delete a team with players");
				}else{
					teamRepository.delete(team);
				}
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
	private List<TeamDto> convertListEntityToListDto(List<Team> entities){
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
