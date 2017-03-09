package com.cgt.dto;

import java.io.Serializable;

public class EstadoEquipamientoDto implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2866537682994810873L;
	
	private Long id;
	private String descripcion;
	
	public EstadoEquipamientoDto(){
		super();
	}

	public EstadoEquipamientoDto(Long id, String descripcion) {
		super();
		this.id = id;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
		EstadoEquipamientoDto other = (EstadoEquipamientoDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EstadoEquipamientoDto [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
