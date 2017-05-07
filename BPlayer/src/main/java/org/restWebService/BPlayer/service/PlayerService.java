package org.restWebService.BPlayer.service;

import java.util.ArrayList;
import java.util.List;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.domain.Organization;
import org.restWebService.BPlayer.domain.Player;
import org.restWebService.BPlayer.domain.Team;
import org.restWebService.BPlayer.dto.BUserDto;
import org.restWebService.BPlayer.dto.PlayerDto;
import org.restWebService.BPlayer.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {
	
	@Autowired
	private PlayerRepository playerRepository;
	
	@Autowired
	private BUserService bUserService;
	
	@Autowired
	private TeamService teamService;

	/**
	 * Actualiza o almacena un jugador
	 * @param bUser
	 * @param playerDto
	 * @return
	 */
	public PlayerDto save(BUser bUser, PlayerDto playerDto) {
		PlayerDto res = new PlayerDto();
		List<String> errores = validatePlayerDto(playerDto);
		if(errores.isEmpty()){
			errores.addAll(checkPlayerOrganizationIsAdministratedByBUser(bUser,playerDto));
		}		
		if(errores.isEmpty()){
			Player player = convertDtoToEntity(playerDto);
			Player aux = playerRepository.save(player);
			res = convertEntityToDto(aux);
		}else{
			res.setErrores(errores);
		}
		return res;
	}
	
	/**
	 * Devuelve la lista de jugadores que tiene una organization
	 * @param idOrganization
	 * @return
	 */
	public List<PlayerDto> findPlayersByIdOrganization(Long idOrganization) {
		List<PlayerDto> res = new ArrayList<>();
		if(idOrganization!=null){
			List<Player> entities = playerRepository.findPlayersByIdOrganization(idOrganization);
			res = convertListEntityToListDto(entities);
		}
		return res;
	}
	
	/**
	 * Devuelve los players asociados a un equipo
	 * @param idTeam
	 * @return
	 */
	public List<PlayerDto> findPlayersByIdTeam(Long idTeam) {
		List<PlayerDto> res = new ArrayList<>();
		if(idTeam!=null){
			List<Player> entities = playerRepository.findPlayersByIdTeam(idTeam);
			res = convertListEntityToListDto(entities);
		}
		return res;
	}
	
	/**
	 * Devuelve la lista de jugadores que podrian be added to a team, es decir, aquellos que esten en la organizacion
	 * pero que no esten en el team
	 * @param idTeam
	 * @return
	 */
	public List<PlayerDto> findListPlayerToAddTeam(Long idTeam) {
		List<PlayerDto> res = new ArrayList<>();
		if(idTeam!=null){
			List<Player> entities = playerRepository.findListPlayerToAddTeam(idTeam);
			res = convertListEntityToListDto(entities);
		}
		return res;
	}
	
	/**
	 * Añade un palyer a un team, y devuelve los jugadores de un equipo
	 * @param idBUser
	 * @param idOrganization
	 * @return
	 */
	public List<PlayerDto> addPlayerToTeam(Long idPlayer, Long idTeam) {
		List<PlayerDto> res = new ArrayList<>();
		if(idPlayer!=null && idTeam!=null){
			Team team = teamService.findOne(idTeam);
			Player player = playerRepository.findOne(idPlayer);
			team.getListPlayer().add(player);
			teamService.save(team);
			res = findPlayersByIdTeam(idTeam);
		}
		return res;
	}
	
	/**
	 * Devuelve el numero de jugadores que tiene un determinado equip
	 * @param idTeam
	 * @return
	 */
	public Integer countPlayersByIdTeam(Long idTeam) {
		Integer res = null;
		if(idTeam!=null){
			res = playerRepository.findPlayersByIdTeam(idTeam).size();
		}
		return res;
	}
	
	/**
	 * Indica si el usuario administra la organization
	 * @param bUser
	 * @param playerDto
	 * @return
	 */
	private List<String> checkPlayerOrganizationIsAdministratedByBUser(BUser bUser, PlayerDto playerDto) {
		List<String> res = new ArrayList<>();
		res.addAll(bUserService.validateBUser(bUser));
		if(res.isEmpty()){
			//Las comprobaciones sobre el TeamDto ya estan realizadas en validateTeamDto
			List<BUserDto> administrators = bUserService.finAdministratorsByIdOrganization(playerDto.getIdOrganization());
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
	 * Valida un player dto, si la cadena no esta vacia, contiene una lista de errores
	 * @param playerDto
	 * @return
	 */
	private List<String> validatePlayerDto(PlayerDto playerDto) {
		List<String> res = new ArrayList<>();
		if(playerDto==null){
			res.add("Player can not be null");
		}else{
			if(playerDto.getName()==null || playerDto.getName().trim().equals("")){
				res.add("The file Name cannot be null");
			}
			if(playerDto.getSurname()==null || playerDto.getSurname().trim().equals("")){
				res.add("The file Name cannot be null");
			}
			if(playerDto.getIdOrganization()==null || playerDto.getIdOrganization().equals(0l)){
				res.add("The file Organization can not be null");
			}
			//TODO para futuro validar que el resto de campos, por ejemplo que las posiciones esten en unos determinados valores
		}
		return res;
	}
	
	//CONVERTERS
	
	/**
	 * Convert Dto to Entity
	 * @param dto
	 * @return
	 */
	private Player convertDtoToEntity(PlayerDto dto) {
		Player entity = null;
		if(dto!=null){
			if(dto.getId()!=0l){
				entity = playerRepository.findOne(dto.getId());
			}else{
				entity = new Player();
			}
			//Indicamos la organization
			Organization organization = new Organization();
			organization.setId(dto.getIdOrganization());
			entity.setOrganization(organization);
			//Indicamos el resto de campos
			entity.setName(dto.getName());
			entity.setSurname(dto.getSurname());
		    entity.setGrade(dto.getGrade());
			entity.setPosition(dto.getPosition());
			entity.setHeight(dto.getHeight());
			entity.setBirthDate(dto.getBirthDate());
		}
		return entity;
	}
	
	/**
	 * Convert Entity to Dto
	 * @param entity
	 * @return
	 */
	private PlayerDto convertEntityToDto(Player entity) {
		PlayerDto dto = null;
		if(entity!=null){
			dto = new PlayerDto();
			dto.setId(entity.getId());
			dto.setIdOrganization(entity.getOrganization().getId());
			dto.setName(entity.getName());
			dto.setSurname(entity.getSurname());
			dto.setGrade(entity.getGrade());
			dto.setPosition(entity.getPosition());
			dto.setHeight(entity.getHeight());
			dto.setBirthDate(entity.getBirthDate());
		}
		return dto;
	}
	
	/**
	 * Convert List Entity to List Dto
	 * @param entities
	 * @return
	 */
	private List<PlayerDto> convertListEntityToListDto(List<Player> entities) {
		List<PlayerDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(Player entity : entities ){
				PlayerDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
