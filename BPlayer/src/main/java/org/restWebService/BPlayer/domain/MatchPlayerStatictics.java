package org.restWebService.BPlayer.domain;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class MatchPlayerStatictics extends DomainEntity {
	
	private Integer onePointBaskets;
	private Integer twoPointBaskets;
	private Integer threePointBaskets;
	private Integer fauls;
	//Relaciones
	@ManyToOne
	private Player player;
	@ManyToOne
	private Match match;
	
	public Integer getOnePointBaskets() {
		return onePointBaskets;
	}
	
	public void setOnePointBaskets(Integer onePointBaskets) {
		this.onePointBaskets = onePointBaskets;
	}
	
	public Integer getTwoPointBaskets() {
		return twoPointBaskets;
	}
	
	public void setTwoPointBaskets(Integer twoPointBaskets) {
		this.twoPointBaskets = twoPointBaskets;
	}
	
	public Integer getThreePointBaskets() {
		return threePointBaskets;
	}
	
	public void setThreePointBaskets(Integer threePointBaskets) {
		this.threePointBaskets = threePointBaskets;
	}
	
	public Integer getFauls() {
		return fauls;
	}
	
	public void setFauls(Integer fauls) {
		this.fauls = fauls;
	}
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public Match getMatch() {
		return match;
	}
	
	public void setMatch(Match match) {
		this.match = match;
	}
	
}
