package org.restWebService.BPlayer.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Result extends DomainEntity {
	
	private Integer homeTeamScore;
	private Integer awayTeamScore;
	//Relaciones
	@OneToOne
	private Match match;
	
	public Integer getHomeTeamScore() {
		return homeTeamScore;
	}
	
	public void setHomeTeamScore(Integer homeTeamScore) {
		this.homeTeamScore = homeTeamScore;
	}
	
	public Integer getAwayTeamScore() {
		return awayTeamScore;
	}
	
	public void setAwayTeamScore(Integer awayTeamScore) {
		this.awayTeamScore = awayTeamScore;
	}
	
	public Match getMatch() {
		return match;
	}
	
	public void setMatch(Match match) {
		this.match = match;
	}

}
