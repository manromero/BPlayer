package com.cgt.managedbean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@ManagedBean
@Scope("session")
@SessionScoped
@Component
public class CampanasManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3596689200156928640L;
	
	//Log4j
	private static final Logger logger = Logger.getLogger(CampanasManagedBean.class);
	
	@PostConstruct
	public void init(){
		logger.info("Accediendo a CampanasManagedBean");
	}
	
	public String irACampanas(){
		return "campanas";
	}

}
