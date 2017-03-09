package com.cgt.dto;

import java.io.Serializable;

public class EntidadDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4324932995177665263L;
	
	private Long id;
	private String descripcion;
	private LocalidadDto localidadDto;
	//TODO faltan atributos
	
	public EntidadDto(){
		super();
		this.localidadDto = new LocalidadDto();
	}

	public EntidadDto(Long id, String descripcion, LocalidadDto localidadDto) {
		super();
		this.id = id;
		this.descripcion = descripcion;
		this.localidadDto = localidadDto;
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

	public LocalidadDto getLocalidadDto() {
		return localidadDto;
	}

	public void setLocalidadDto(LocalidadDto localidadDto) {
		this.localidadDto = localidadDto;
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
		EntidadDto other = (EntidadDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EntidadDto [id=" + id + ", descripcion=" + descripcion + ", localidadDto=" + localidadDto + "]";
	}

}
