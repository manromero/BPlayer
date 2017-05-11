package org.restWebService.BPlayer.dto;

import java.util.Date;

public class MatchDto extends Dto {
	
	private long id;
	private Long idOrganization;
	private Long idHomeTeam;
	private Long idAwayTeam;
	private Date date;
	private Integer numQuarter;
	private Integer quarterTime;
	private Integer numRest;
	private Integer restTime;
	private Integer faulsAllowedTeam;
	private Integer faulsAllowedPlayer;
	
	public MatchDto(){
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Long getIdOrganization() {
		return idOrganization;
	}

	public void setIdOrganization(Long idOrganization) {
		this.idOrganization = idOrganization;
	}

	public Long getIdHomeTeam() {
		return idHomeTeam;
	}

	public void setIdHomeTeam(Long idHomeTeam) {
		this.idHomeTeam = idHomeTeam;
	}

	public Long getIdAwayTeam() {
		return idAwayTeam;
	}

	public void setIdAwayTeam(Long idAwayTeam) {
		this.idAwayTeam = idAwayTeam;
	}

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

}
