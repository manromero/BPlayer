package org.restWebService.BPlayer.dto;

public class BUserDto extends Dto {
	
	private long id;
	private String username;
	
	public BUserDto(){
		super();
	}
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}

}
