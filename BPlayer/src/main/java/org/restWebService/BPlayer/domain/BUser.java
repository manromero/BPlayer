package org.restWebService.BPlayer.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

@Entity
public class BUser extends DomainEntity {

	private String username;
	private String name;
	private String surname;
	private String email;
	private String password;
	private Byte[] imagen;
	private String phoneNumber;
	// Relaciones
	@OneToMany(mappedBy="creater",fetch=FetchType.LAZY)
	private List<Organization> createdOrganizations;
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Organization> administratedOrganizations;
	@ManyToMany(fetch=FetchType.LAZY)
	private List<Organization> followingOrganizations;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Byte[] getImagen() {
		return imagen;
	}

	public void setImagen(Byte[] imagen) {
		this.imagen = imagen;
	}

	public List<Organization> getCreatedOrganizations() {
		return createdOrganizations;
	}

	public void setCreatedOrganizations(List<Organization> createdOrganizations) {
		this.createdOrganizations = createdOrganizations;
	}

	public List<Organization> getAdministratedOrganizations() {
		return administratedOrganizations;
	}

	public void setAdministratedOrganizations(
			List<Organization> administratedOrganizations) {
		this.administratedOrganizations = administratedOrganizations;
	}

	public List<Organization> getFollowingOrganizations() {
		return followingOrganizations;
	}

	public void setFollowingOrganizations(List<Organization> followingOrganizations) {
		this.followingOrganizations = followingOrganizations;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}