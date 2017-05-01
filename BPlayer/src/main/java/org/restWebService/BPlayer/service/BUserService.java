package org.restWebService.BPlayer.service;

import java.util.ArrayList;
import java.util.List;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.dto.BUserDto;
import org.restWebService.BPlayer.dto.BUserToRegisterDto;
import org.restWebService.BPlayer.repository.BUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BUserService {
	
	@Autowired
	private BUserRepository bUserRepository;
	
	/**
	 * Devuelve el BUser por el username
	 * @param username
	 * @return
	 */
	public BUser findByUsername(String username){
		BUser res = null;
		if(username!=null && !username.equals("")){
			res = bUserRepository.findByUsername(username);
		}
		return res;
	}

	/**
	 * Devuelve un usuario por su nombre de usuario y su password
	 * @param username
	 * @param password
	 * @return
	 */
	public BUser findByUsernameAndPassword(String username, String password) {
		BUser res = null;
		if(username!=null && !username.equals("") && password!=null && !password.equals("")){
			res = bUserRepository.findByUsernameAndPassword(username,password);
		}
		return res;
	}
	
	/**
	 * Devuelve todos los administradores de una determinada organization
	 * @param idOrganization
	 * @return
	 */
	public List<BUserDto> finAdministratorsByIdOrganization(Long idOrganization) {
		List<BUserDto> res = new ArrayList<>();
		if(idOrganization!=null){
			List<BUser> entities = bUserRepository.finAdministratorsByIdOrganization(idOrganization);
			res = convertListEntityToListDto(entities);
		}
		return res;
	}
	
	/**
	 * Devuelve la lista de usuarios que pueden ser administradores (aun no lo son) de una organization
	 * @param idOrganization
	 * @return
	 */
	public List<BUserDto> findListBUserToBeAdministrator(Long idOrganization) {
		List<BUserDto> res = new ArrayList<>();
		if(idOrganization!=null){
			List<BUser> entities = bUserRepository.findListBUserToBeAdministrator(idOrganization);
			res = convertListEntityToListDto(entities);
		}
		return res;
	}
	
	/**
	 * Registra un nuevo usuario si no se encuentrarn errores
	 * @param bUserToRegisterDto
	 * @return
	 */
	public BUserToRegisterDto register(BUserToRegisterDto bUserToRegisterDto) {
		BUserToRegisterDto res = new BUserToRegisterDto();
		List<String> errores = validateBUserToRegisterDto(bUserToRegisterDto);
		if(errores.isEmpty()){
			BUser bUser = convertDtoToEntity(bUserToRegisterDto);
			bUserRepository.save(bUser);
		}else{
			res.setErrores(errores);
		}
		return res;
	}

	/**
	 * Valida el BUser que se va a registrar
	 * @param bUserToRegisterDto
	 * @return
	 */
	private List<String> validateBUserToRegisterDto(BUserToRegisterDto bUserToRegisterDto){
		List<String> res = new ArrayList<>();
		if(bUserToRegisterDto==null){
			res.add("The new BUser cannot be null");
		}else{
			if(bUserToRegisterDto.getUsername()==null || bUserToRegisterDto.getUsername().trim().equals("")){
				res.add("The file Username cannot be null");
			}else{
				BUser bUser = findByUsername(bUserToRegisterDto.getUsername());
				if(bUser!=null){
					res.add("There is a BUser with the same Username");
				}
			}
			if(bUserToRegisterDto.getName()==null || bUserToRegisterDto.getName().trim().equals("")){
				res.add("The file Name cannot be null");
			}
			if(bUserToRegisterDto.getSurname()==null || bUserToRegisterDto.getSurname().trim().equals("")){
				res.add("The file Surname cannot be null");
			}
			if(bUserToRegisterDto.getEmail()==null || bUserToRegisterDto.getEmail().trim().equals("")){
				res.add("The file Email cannot be null");
			}
			if(bUserToRegisterDto.getPhoneNumber()==null || bUserToRegisterDto.getPhoneNumber().trim().equals("")){
				res.add("The file Phone Number cannot be null");
			}
			if(bUserToRegisterDto.getPassword()==null || bUserToRegisterDto.getPassword().trim().equals("")){
				res.add("The file Password cannot be null");
			}else if(bUserToRegisterDto.getPassword().length()<=5){
				res.add("The file Password must have at least 5 characters");
			}else if(bUserToRegisterDto.getrPassword()==null || bUserToRegisterDto.getrPassword().trim().equals("")){
				res.add("The file Repeat Password cannot be null");
			}else if(!bUserToRegisterDto.getPassword().equals(bUserToRegisterDto.getrPassword())){
				res.add("The file Password and Repeat Password do not match");
			}
		}
		return res;
	}

	/**
	 * Valida un bUser
	 * @param bUser
	 * @return
	 */
	public List<String> validateBUser(BUser bUser) {
		List<String> res = new ArrayList<>();
		if(bUser==null){
			res.add("The BUser cannot be null");
		}else{
			if(bUser.getUsername()==null || bUser.getUsername().trim().equals("")){
				res.add("The file Username cannot be null");
			}
		}
		return res;
	}
	
	//Convertidores
	/**
	 * Convierte una BUserToRegisterDto en un BUser
	 * @param dto
	 * @return
	 */
	public BUser convertDtoToEntity(BUserToRegisterDto bUserToRegisterDto){
		BUser bUser = new BUser();
		if(bUserToRegisterDto!=null){
			bUser.setUsername(bUserToRegisterDto.getUsername());
			bUser.setName(bUserToRegisterDto.getName());
			bUser.setSurname(bUserToRegisterDto.getSurname());
			bUser.setEmail(bUserToRegisterDto.getEmail());
			bUser.setPhoneNumber(bUserToRegisterDto.getPhoneNumber());
			bUser.setPassword(bUserToRegisterDto.getPassword());
		}
		return bUser;
	}
	
	/**
	 * Convierte un entity en dto
	 * @param entity
	 * @return
	 */
	public BUserDto convertEntityToDto(BUser entity){
		BUserDto dto = new BUserDto();
		if(entity!=null){
			dto.setId(entity.getId());
			dto.setUsername(entity.getUsername());
		}
		return dto;
	}
	
	/**
	 * Convierte una lista de entities en una lista de dtos
	 * @param entities
	 * @return
	 */
	public List<BUserDto> convertListEntityToListDto(List<BUser> entities){
		List<BUserDto> dtos = new ArrayList<>();
		if(entities!=null){
			for(BUser entity : entities){
				BUserDto dto = convertEntityToDto(entity);
				dtos.add(dto);
			}
		}
		return dtos;
	}

}
