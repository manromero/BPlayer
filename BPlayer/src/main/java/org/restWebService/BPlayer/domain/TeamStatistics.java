package org.restWebService.BPlayer.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class TeamStatistics extends DomainEntity {
	
	private Integer played;
	private Integer won;
	private Integer losed;
	private Integer drawed;
	private Integer points;
	private Integer againstPoints;
	//Relaciones
	@OneToOne
	private Team team;
	
	public Integer getPlayed() {
		return played;
	}
	
	public void setPlayed(Integer played) {
		this.played = played;
	}
	
	public Integer getWon() {
		return won;
	}
	
	public void setWon(Integer won) {
		this.won = won;
	}
	
	public Integer getLosed() {
		return losed;
	}
	
	public void setLosed(Integer losed) {
		this.losed = losed;
	}
	
	public Integer getDrawed() {
		return drawed;
	}
	
	public void setDrawed(Integer drawed) {
		this.drawed = drawed;
	}
	
	public Integer getPoints() {
		return points;
	}
	
	public void setPoints(Integer points) {
		this.points = points;
	}
	
	public Integer getAgainstPoints() {
		return againstPoints;
	}
	
	public void setAgainstPoints(Integer againstPoints) {
		this.againstPoints = againstPoints;
	}
	
	public Team getTeam() {
		return team;
	}
	
	public void setTeam(Team team) {
		this.team = team;
	}
	
}
