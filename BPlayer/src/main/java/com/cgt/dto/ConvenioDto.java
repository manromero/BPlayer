package com.cgt.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * DTO de ConveniosEntity
 * @author manromero
 *
 */
public class ConvenioDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2863235958101225390L;
	
	private Long id;
	private String objeto;
	private EntidadDto entidadDto;
	private Date fechaFirma;
	private Date fechaInicio;
	private Date fechaBaja;
	private String observaciones;
	private String motivoBaja;
	private List<PersContactoDto> listPersContactoDto;
	private List<ConvDocumentosDto> listConvDocumentosDto;
	
	public ConvenioDto(){
		super();
		this.entidadDto = new EntidadDto();
		this.listPersContactoDto = new ArrayList<>();
		this.listConvDocumentosDto = new ArrayList<>();
	}

	public ConvenioDto(Long id, String objeto, EntidadDto entidadDto, Date fechaFirma, Date fechaInicio, Date fechaBaja,
			String observaciones, String motivoBaja, List<PersContactoDto> listPersContactoDto,
			List<ConvDocumentosDto> listConvDocumentosDto) {
		super();
		this.id = id;
		this.objeto = objeto;
		this.entidadDto = entidadDto;
		this.fechaFirma = fechaFirma;
		this.fechaInicio = fechaInicio;
		this.fechaBaja = fechaBaja;
		this.observaciones = observaciones;
		this.motivoBaja = motivoBaja;
		this.listPersContactoDto = listPersContactoDto;
		this.listConvDocumentosDto = listConvDocumentosDto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getObjeto() {
		return objeto;
	}

	public void setObjeto(String objeto) {
		this.objeto = objeto;
	}

	public EntidadDto getEntidadDto() {
		return entidadDto;
	}

	public void setEntidadDto(EntidadDto entidadDto) {
		this.entidadDto = entidadDto;
	}

	public Date getFechaFirma() {
		return fechaFirma;
	}

	public void setFechaFirma(Date fechaFirma) {
		this.fechaFirma = fechaFirma;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
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

	public List<ConvDocumentosDto> getListConvDocumentosDto() {
		return listConvDocumentosDto;
	}

	public void setListConvDocumentosDto(List<ConvDocumentosDto> listConvDocumentosDto) {
		this.listConvDocumentosDto = listConvDocumentosDto;
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
		ConvenioDto other = (ConvenioDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConvenioDto [id=" + id + ", objeto=" + objeto + ", entidadDto=" + entidadDto + ", fechaFirma="
				+ fechaFirma + ", fechaInicio=" + fechaInicio + ", fechaBaja=" + fechaBaja + ", observaciones="
				+ observaciones + ", motivoBaja=" + motivoBaja + ", listPersContactoDto=" + listPersContactoDto
				+ ", listConvDocumentosDto=" + listConvDocumentosDto + "]";
	}

}