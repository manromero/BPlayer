package org.restWebService.BPlayer.dto;

public class BUserToRegisterDto extends Dto {
	
	private String username;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String rPassword;
	
	public BUserToRegisterDto(){
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRPassword() {
		return rPassword;
	}

	public void setRPassword(String rPassword) {
		this.rPassword = rPassword;
	}
	
}
