package com.cgt.dto;

import java.io.Serializable;

public class ProvinciaDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8444858160397314149L;
	
	private Long id;
	private String descripcion;
	
	public ProvinciaDto(){
		super();
	}
	
	public ProvinciaDto(Long id, String descripcion) {
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
		ProvinciaDto other = (ProvinciaDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ProvinciaDto [id=" + id + ", descripcion=" + descripcion + "]";
	}
	
}
