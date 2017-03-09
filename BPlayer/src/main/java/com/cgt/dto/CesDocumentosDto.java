package com.cgt.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class CesDocumentosDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -455864694624625846L;
	
	private Long id;
	private Long idCesion;
	private String tipoDocumento;
	private String nombre;
	private String descripcion;
	private Date fecSubida;
	private String formato;
	private Long size;
	private byte[] data;
	
	public CesDocumentosDto() {
		super();
	}

	public CesDocumentosDto(Long id, Long idCesion, String tipoDocumento, String nombre, String descripcion,
			Date fecSubida, String formato, Long size, byte[] data) {
		super();
		this.id = id;
		this.idCesion = idCesion;
		this.tipoDocumento = tipoDocumento;
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fecSubida = fecSubida;
		this.formato = formato;
		this.size = size;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getIdCesion() {
		return idCesion;
	}

	public void setIdCesion(Long idCesion) {
		this.idCesion = idCesion;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFecSubida() {
		return fecSubida;
	}

	public void setFecSubida(Date fecSubida) {
		this.fecSubida = fecSubida;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
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
		CesDocumentosDto other = (CesDocumentosDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "CesDocumentosDto [id=" + id + ", idCesion=" + idCesion + ", tipoDocumento=" + tipoDocumento
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecSubida=" + fecSubida + ", formato="
				+ formato + ", size=" + size + ", data=" + Arrays.toString(data) + "]";
	}

}