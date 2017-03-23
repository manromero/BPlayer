package org.restWebService.BPlayer.dto;

import java.util.ArrayList;
import java.util.List;

public abstract class Dto {
	
	private List<String> errores;
	
	public Dto(){
		this.errores = new ArrayList<>();
	}

	public List<String> getErrores() {
		return errores;
	}

	public void setErrores(List<String> errores) {
		this.errores = errores;
	}

}
