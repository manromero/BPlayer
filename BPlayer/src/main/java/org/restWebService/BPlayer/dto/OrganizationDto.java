package org.restWebService.BPlayer.dto;

public class OrganizationDto extends Dto {
	
	private long id;
	private String name;
	private Long bUserId;
	
	public OrganizationDto(){
		super();
	}
	
	public Long getId(){
		return id;
	}
	
	public void setId(long id){
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Long getbUserId() {
		return bUserId;
	}
	
	public void setbUserId(Long bUserId) {
		this.bUserId = bUserId;
	}
	
}
