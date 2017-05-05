package org.restWebService.BPlayer.dto;

import java.util.ArrayList;
import java.util.List;

public class DetailedTeamDto extends Dto {
	
	private long id;
	private String name;
	private OrganizationDto organizationDto;
	private List<PlayerDto> listPlayerDto;
	
	public DetailedTeamDto(){
		super();
		listPlayerDto = new ArrayList<>();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OrganizationDto getOrganizationDto() {
		return organizationDto;
	}

	public void setOrganizationDto(OrganizationDto organizationDto) {
		this.organizationDto = organizationDto;
	}

	public List<PlayerDto> getListPlayerDto() {
		return listPlayerDto;
	}

	public void setListPlayerDto(List<PlayerDto> listPlayerDto) {
		this.listPlayerDto = listPlayerDto;
	}

}
