package org.restWebService.BPlayer.dto;

import java.util.List;

public class DetailedOrganizationDto extends Dto {
	
	private long id;
	private String name;
	private String creatorName;
	private List<TeamDto> teams;
	private List<BUserDto> administrators;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public String getCreatorName() {
		return creatorName;
	}
	
	public void setCreatorName(String creatorName) {
		this.creatorName = creatorName;
	}
	
	public List<TeamDto> getTeams() {
		return teams;
	}
	
	public void setTeams(List<TeamDto> teams) {
		this.teams = teams;
	}
	
	public List<BUserDto> getAdministrators() {
		return administrators;
	}
	
	public void setAdministrators(List<BUserDto> administrators) {
		this.administrators = administrators;
	}

}
