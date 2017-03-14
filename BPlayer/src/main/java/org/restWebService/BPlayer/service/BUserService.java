package org.restWebService.BPlayer.service;

import org.restWebService.BPlayer.domain.BUser;
import org.restWebService.BPlayer.repository.BUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BUserService {
	
	@Autowired
	private BUserRepository bUserRepository;
	
	public BUser findByUsername(String username){
		BUser res = new BUser();
		if(username!=null && !username.equals("")){
			res = bUserRepository.findByUsername(username);
		}
		return res;
	}

}
