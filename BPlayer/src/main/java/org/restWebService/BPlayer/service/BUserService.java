package org.restWebService.BPlayer.service;

import org.restWebService.BPlayer.domain.BUser;
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

}
