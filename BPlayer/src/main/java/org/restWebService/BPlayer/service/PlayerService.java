package org.restWebService.BPlayer.service;

import java.util.ArrayList;
import java.util.List;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.domain.Organization;
import org.restWebService.BPlayer.domain.Player;
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

}
