package org.restWebService.BPlayer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Team extends DomainEntity {
	
	private String name;
	private byte[] logo;
	//Relaciones
	@ManyToOne
	private Organization organization;
	@OneToOne(mappedBy="team")
	private TeamStatistics teamStatistics;
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Player> listPlayer;
	@OneToMany(mappedBy="homeTeam",fetch=FetchType.LAZY)
	private List<Match> listMatchHomeTeam;
	@OneToMany(mappedBy="awayTeam",fetch=FetchType.LAZY)
	private List<Match> listMatchAwayTeam;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public byte[] getLogo() {
		return logo;
	}
	
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	
	public Organization getOrganization() {
		return organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	public TeamStatistics getTeamStatistics() {
		return teamStatistics;
	}
	
	public void setTeamStatistics(TeamStatistics teamStatistics) {
		this.teamStatistics = teamStatistics;
	}
	
	public List<Player> getListPlayer() {
		return listPlayer;
	}
	
	public void setListPlayer(List<Player> listPlayer) {
		this.listPlayer = listPlayer;
	}
	
	public List<Match> getListMatchHomeTeam() {
		return listMatchHomeTeam;
	}
	
	public void setListMatchHomeTeam(List<Match> listMatchHomeTeam) {
		this.listMatchHomeTeam = listMatchHomeTeam;
	}
	
	public List<Match> getListMatchAwayTeam() {
		return listMatchAwayTeam;
	}
	
	public void setListMatchAwayTeam(List<Match> listMatchAwayTeam) {
		this.listMatchAwayTeam = listMatchAwayTeam;
	}

}
