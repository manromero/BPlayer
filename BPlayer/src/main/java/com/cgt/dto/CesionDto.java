package com.cgt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO de CesionesEntity
 * @author manromero
 *
 */
public class CesionDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3474577335217112524L;
	
	private Long id;
	private EntidadDto entidadDto;
	private EquipamientoDto equipamientoDto;
	private Date fechaCesion;
	private Date fechaPrevistaBaja;
	private Date fechaBaja;
	private String observaciones;
	private String motivoBaja;
	private List<PersContactoDto> listPersContactoDto;
	private List<CesDocumentosDto> listCesDocumentosDto;
	
	public CesionDto(){
		super();
		this.entidadDto = new EntidadDto();
		this.equipamientoDto = new EquipamientoDto();
		this.listPersContactoDto = new ArrayList<>();
	}

	public CesionDto(Long id, EntidadDto entidadDto, EquipamientoDto equipamientoDto, Date fechaCesion,
			Date fechaPrevistaBaja, Date fechaBaja, String observaciones, String motivoBaja,
			List<PersContactoDto> listPersContactoDto, List<CesDocumentosDto> listCesDocumentosDto) {
		super();
		this.id = id;
		this.entidadDto = entidadDto;
		this.equipamientoDto = equipamientoDto;
		this.fechaCesion = fechaCesion;
		this.fechaPrevistaBaja = fechaPrevistaBaja;
		this.fechaBaja = fechaBaja;
		this.observaciones = observaciones;
		this.motivoBaja = motivoBaja;
		this.listPersContactoDto = listPersContactoDto;
		this.listCesDocumentosDto = listCesDocumentosDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public EntidadDto getEntidadDto() {
		return entidadDto;
	}

	public void setEntidadDto(EntidadDto entidadDto) {
		this.entidadDto = entidadDto;
	}

	public EquipamientoDto getEquipamientoDto() {
		return equipamientoDto;
	}

	public void setEquipamientoDto(EquipamientoDto equipamientoDto) {
		this.equipamientoDto = equipamientoDto;
	}

	public Date getFechaCesion() {
		return fechaCesion;
	}

	public void setFechaCesion(Date fechaCesion) {
		this.fechaCesion = fechaCesion;
	}

	public Date getFechaPrevistaBaja() {
		return fechaPrevistaBaja;
	}

	public void setFechaPrevistaBaja(Date fechaPrevistaBaja) {
		this.fechaPrevistaBaja = fechaPrevistaBaja;
	}

	public Date getFechaBaja() {
		return fechaBaja;
	}

	public void setFechaBaja(Date fechaBaja) {
		this.fechaBaja = fechaBaja;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getMotivoBaja() {
		return motivoBaja;
	}

	public void setMotivoBaja(String motivoBaja) {
		this.motivoBaja = motivoBaja;
	}

	public List<PersContactoDto> getListPersContactoDto() {
		return listPersContactoDto;
	}

	public void setListPersContactoDto(List<PersContactoDto> listPersContactoDto) {
		this.listPersContactoDto = listPersContactoDto;
	}

	public List<CesDocumentosDto> getListCesDocumentosDto() {
		return listCesDocumentosDto;
	}

	public void setListCesDocumentosDto(List<CesDocumentosDto> listCesDocumentosDto) {
		this.listCesDocumentosDto = listCesDocumentosDto;
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
		CesionDto other = (CesionDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CesionDto [id=" + id + ", entidadDto=" + entidadDto + ", equipamientoDto=" + equipamientoDto
				+ ", fechaCesion=" + fechaCesion + ", fechaPrevistaBaja=" + fechaPrevistaBaja + ", fechaBaja="
				+ fechaBaja + ", observaciones=" + observaciones + ", motivoBaja=" + motivoBaja
				+ ", listPersContactoDto=" + listPersContactoDto + ", listCesDocumentosDto=" + listCesDocumentosDto
				+ "]";
	}
	
}
