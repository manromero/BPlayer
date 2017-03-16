package org.restWebService.BPlayer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Organization extends DomainEntity {
	
	private String name;
	//Relaciones
	@ManyToMany(fetch=FetchType.LAZY)
	private List<BUser> followers;
	@ManyToMany(fetch=FetchType.LAZY)
	private List<BUser> administrators;
	@ManyToOne
	private BUser creater;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<BUser> getFollowers() {
		return followers;
	}
	
	public void setFollowers(List<BUser> followers) {
		this.followers = followers;
	}
	
	public List<BUser> getAdministrators() {
		return administrators;
	}
	
	public void setAdministrators(List<BUser> administrators) {
		this.administrators = administrators;
	}
	
	public BUser getCreater() {
		return creater;
	}
	
	public void setCreater(BUser creater) {
		this.creater = creater;
	}

}
