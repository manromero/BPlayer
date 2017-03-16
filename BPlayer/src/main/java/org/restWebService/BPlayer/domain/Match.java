package org.restWebService.BPlayer.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Match extends DomainEntity {
	
	private Date date;
	private Integer numQuarter;
	private Integer quarterTime;
	private Integer numRest;
	private Integer restTime;
	private Integer faulsAllowedTeam;
	private Integer faulsAllowedPlayer;
	private Integer homeTeamScore;
	private Integer awayTeamScore;
	@Enumerated(EnumType.STRING)
	private MatchStatus matchStatus;
	//Relaciones
	@ManyToOne
	private Team homeTeam;
	@ManyToOne
	private Team awayTeam;
	@OneToMany(mappedBy="match",fetch=FetchType.LAZY)
	private List<MatchPlayerStatictics> listMatchPlayerStatictics;

	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Integer getNumQuarter() {
		return numQuarter;
	}
	
	public void setNumQuarter(Integer numQuarter) {
		this.numQuarter = numQuarter;
	}
	
	public Integer getQuarterTime() {
		return quarterTime;
	}
	
	public void setQuarterTime(Integer quarterTime) {
		this.quarterTime = quarterTime;
	}
	
	public Integer getNumRest() {
		return numRest;
	}
	
	public void setNumRest(Integer numRest) {
		this.numRest = numRest;
	}
	
	public Integer getRestTime() {
		return restTime;
	}
	
	public void setRestTime(Integer restTime) {
		this.restTime = restTime;
	}
	
	public Integer getFaulsAllowedTeam() {
		return faulsAllowedTeam;
	}
	
	public void setFaulsAllowedTeam(Integer faulsAllowedTeam) {
		this.faulsAllowedTeam = faulsAllowedTeam;
	}
	
	public Integer getFaulsAllowedPlayer() {
		return faulsAllowedPlayer;
	}
	
	public void setFaulsAllowedPlayer(Integer faulsAllowedPlayer) {
		this.faulsAllowedPlayer = faulsAllowedPlayer;
	}
	
	public Team getHomeTeam() {
		return homeTeam;
	}
	
	public void setHomeTeam(Team homeTeam) {
		this.homeTeam = homeTeam;
	}
	public Team getAwayTeam() {
		return awayTeam;
	}
	
	public void setAwayTeam(Team awayTeam) {
		this.awayTeam = awayTeam;
	}
	
	public List<MatchPlayerStatictics> getListMatchPlayerStatictics() {
		return listMatchPlayerStatictics;
	}
	
	public void setListMatchPlayerStatictics(List<MatchPlayerStatictics> listMatchPlayerStatictics) {
		this.listMatchPlayerStatictics = listMatchPlayerStatictics;
	}

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

	public MatchStatus getMatchStatus() {
		return matchStatus;
	}

	public void setMatchStatus(MatchStatus matchStatus) {
		this.matchStatus = matchStatus;
	}
	
}
