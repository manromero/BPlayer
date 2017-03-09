package com.cgt.dto;

import java.io.Serializable;
import java.util.Date;

public class PersContactoDto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3341532690171985945L;
	
	private Long id;
	private Long idEntidad;
	private String nombre;
	private String cargo;
	private String telefono;
	private String email;
	private String fax;
	private String direccion;
	private String observaciones;
	private Date fechaActualizacion;
	
	public PersContactoDto() {
		super();
	}

	public PersContactoDto(Long id, Long idEntidad, String nombre, String cargo, String telefono, String email,
			String fax, String direccion, String observaciones, Date fechaActualizacion) {
		super();
		this.id = id;
		this.idEntidad = idEntidad;
		this.nombre = nombre;
		this.cargo = cargo;
		this.telefono = telefono;
		this.email = email;
		this.fax = fax;
		this.direccion = direccion;
		this.observaciones = observaciones;
		this.fechaActualizacion = fechaActualizacion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdEntidad() {
		return idEntidad;
	}

	public void setIdEntidad(Long idEntidad) {
		this.idEntidad = idEntidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Date getFechaActualizacion() {
		return fechaActualizacion;
	}

	public void setFechaActualizacion(Date fechaActualizacion) {
		this.fechaActualizacion = fechaActualizacion;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersContactoDto other = (PersContactoDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "PersContactoDto [id=" + id + ", idEntidad=" + idEntidad + ", nombre=" + nombre + ", cargo=" + cargo
				+ ", telefono=" + telefono + ", email=" + email + ", fax=" + fax + ", direccion=" + direccion
				+ ", observaciones=" + observaciones + ", fechaActualizacion=" + fechaActualizacion + "]";
	}

}
