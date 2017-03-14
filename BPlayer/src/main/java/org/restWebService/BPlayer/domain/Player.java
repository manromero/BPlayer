package org.restWebService.BPlayer.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Player extends DomainEntity {

	private String name;
	private String surname;
	private Date birthDate;
	private String position;
	private Integer grade;
	private Double height;
	private byte[] imagen;
	//Relaciones
	@ManyToOne
	private Organization organization;
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Team> listTeam;
	@OneToOne(mappedBy="player",fetch=FetchType.LAZY)
	private PlayerStatistics playerStatistics;
	@OneToMany(mappedBy="player",fetch=FetchType.LAZY)
	private List<MatchPlayerStatictics> listMatchPlayerStatictics;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}
	
	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	public Date getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	
	public String getPosition() {
		return position;
	}
	
	public void setPosition(String position) {
		this.position = position;
	}
	
	public Integer getGrade() {
		return grade;
	}
	
	public void setGrade(Integer grade) {
		this.grade = grade;
	}
	
	public Double getHeight() {
		return height;
	}
	
	public void setHeight(Double height) {
		this.height = height;
	}
	
	public byte[] getImagen() {
		return imagen;
	}
	
	public void setImagen(byte[] imagen) {
		this.imagen = imagen;
	}
	
	public Organization getOrganization() {
		return organization;
	}
	
	public void setOrganization(Organization organization) {
		this.organization = organization;
	}
	
	public List<Team> getListTeam() {
		return listTeam;
	}
	
	public void setListTeam(List<Team> listTeam) {
		this.listTeam = listTeam;
	}
	
	public PlayerStatistics getPlayerStatistics() {
		return playerStatistics;
	}
	
	public void setPlayerStatistics(PlayerStatistics playerStatistics) {
		this.playerStatistics = playerStatistics;
	}
	
	public List<MatchPlayerStatictics> getListMatchPlayerStatictics() {
		return listMatchPlayerStatictics;
	}
	
	public void setListMatchPlayerStatictics(
			List<MatchPlayerStatictics> listMatchPlayerStatictics) {
		this.listMatchPlayerStatictics = listMatchPlayerStatictics;
	}
	
}
