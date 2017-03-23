package org.restWebService.BPlayer.service;

import java.util.ArrayList;
import java.util.List;

import org.restWebService.BPlayer.domain.BUser;
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
		//TODO faltan validaciones
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
		//TODO faltan validaciones
		BUser res = null;
		if(username!=null && !username.equals("") && password!=null && !password.equals("")){
			res = bUserRepository.findByUsernameAndPassword(username,password);
		}
		return res;
	}

	/**
	 * 
	 * @param bUserToRegisterDto
	 * @return
	 */
	public BUserToRegisterDto register(BUserToRegisterDto bUserToRegisterDto) {
		BUserToRegisterDto res = new BUserToRegisterDto();
		List<String> errores = validateRegister(bUserToRegisterDto);
		if(errores.isEmpty()){
			//TODO
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
	private List<String> validateRegister(BUserToRegisterDto bUserToRegisterDto){
		List<String> res = new ArrayList<>();
		if(bUserToRegisterDto==null){
			res.add("The new BUser cannot be null");
		}else{
			if(bUserToRegisterDto.getUsername()==null || bUserToRegisterDto.getUsername().trim().equals("")){
				res.add("The file Username cannot be null");
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
			if(bUserToRegisterDto.getPassword()==null || bUserToRegisterDto.getPassword().trim().equals("")){
				res.add("The file Password cannot be null");
			}else if(bUserToRegisterDto.getRPassword()==null || bUserToRegisterDto.getRPassword().trim().equals("")){
				res.add("The file Repeat Password cannot be null");
			}else if(!bUserToRegisterDto.getPassword().equals(bUserToRegisterDto.getRPassword())){
				res.add("The file Password and Repeat Password do not match");
			}
		}
		return res;
	}

}
