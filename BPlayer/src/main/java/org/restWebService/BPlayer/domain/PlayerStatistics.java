package org.restWebService.BPlayer.domain;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class PlayerStatistics extends DomainEntity {
	
	private Integer totalGames;
	private Integer totalWin;
	private Integer totalLose;
	private Integer totalDraw;
	private Integer onePointBaskets;
	private Integer twoPointBaskets;
	private Integer threePointBaskets;
	//Relaciones
	@OneToOne
	private Player player;
	
	public Integer getTotalGames() {
		return totalGames;
	}
	
	public void setTotalGames(Integer totalGames) {
		this.totalGames = totalGames;
	}
	
	public Integer getTotalWin() {
		return totalWin;
	}
	
	public void setTotalWin(Integer totalWin) {
		this.totalWin = totalWin;
	}
	
	public Integer getTotalLose() {
		return totalLose;
	}
	
	public void setTotalLose(Integer totalLose) {
		this.totalLose = totalLose;
	}
	
	public Integer getTotalDraw() {
		return totalDraw;
	}
	
	public void setTotalDraw(Integer totalDraw) {
		this.totalDraw = totalDraw;
	}
	
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
	
	public Player getPlayer() {
		return player;
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}

}
