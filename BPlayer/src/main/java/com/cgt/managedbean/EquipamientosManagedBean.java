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
public class EquipamientosManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8150650011998921493L;
	
	//Log4j
	private static final Logger logger = Logger.getLogger(EquipamientosManagedBean.class);
	
	@PostConstruct
	public void init(){
		logger.info("Accediendo a EquipamientosManagedBean");
	}
	
	public String irAEquipamientos(){
		return "equipamientos";
	}

}
