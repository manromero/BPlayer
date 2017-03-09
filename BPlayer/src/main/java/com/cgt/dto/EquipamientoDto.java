package com.cgt.dto;

import java.io.Serializable;
import java.util.Date;

public class EquipamientoDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7446963428658664705L;
	
	private Long id;
	private TipoEquipamientoDto tipoEquipamientoDto;
	private String numSerie;
	private String marca;
	private String modelo;
	private Date fechaProximaRevision;
	//TODO faltan atributos
	
	public EquipamientoDto() {
		super();
		this.tipoEquipamientoDto = new TipoEquipamientoDto();
	}
	
	public EquipamientoDto(Long id, TipoEquipamientoDto tipoEquipamientoDto, String numSerie, String marca,
			String modelo, Date fechaProximaRevision) {
		super();
		this.id = id;
		this.tipoEquipamientoDto = tipoEquipamientoDto;
		this.numSerie = numSerie;
		this.marca = marca;
		this.modelo = modelo;
		this.fechaProximaRevision = fechaProximaRevision;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoEquipamientoDto getTipoEquipamientoDto() {
		return tipoEquipamientoDto;
	}

	public void setTipoEquipamientoDto(TipoEquipamientoDto tipoEquipamientoDto) {
		this.tipoEquipamientoDto = tipoEquipamientoDto;
	}

	public String getNumSerie() {
		return numSerie;
	}

	public void setNumSerie(String numSerie) {
		this.numSerie = numSerie;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public Date getFechaProximaRevision() {
		return fechaProximaRevision;
	}

	public void setFechaProximaRevision(Date fechaProximaRevision) {
		this.fechaProximaRevision = fechaProximaRevision;
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
		EquipamientoDto other = (EquipamientoDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "EquipamientoDto [id=" + id + ", tipoEquipamientoDto=" + tipoEquipamientoDto + ", numSerie=" + numSerie
				+ ", marca=" + marca + ", modelo=" + modelo + ", fechaProximaRevision=" + fechaProximaRevision + "]";
	}
	
}
