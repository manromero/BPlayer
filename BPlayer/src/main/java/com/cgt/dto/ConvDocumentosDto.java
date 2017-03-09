package com.cgt.dto;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;

public class ConvDocumentosDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1879658680114235320L;
	
	private Long id;
	private Long idConvenio;
	private String tipoDocumento;
	private String nombre;
	private String descripcion;
	private Date fecSubida;
	private String formato;
	private Long size;
	private byte[] data;
	
	public ConvDocumentosDto() {
		super();
	}

	public ConvDocumentosDto(Long id, Long idConvenio, String tipoDocumento, String nombre, String descripcion,
			Date fecSubida, String formato, Long size, byte[] data) {
		super();
		this.id = id;
		this.idConvenio = idConvenio;
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

	public Long getIdConvenio() {
		return idConvenio;
	}

	public void setIdConvenio(Long idConvenio) {
		this.idConvenio = idConvenio;
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
		ConvDocumentosDto other = (ConvDocumentosDto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ConvDocumentosDto [id=" + id + ", idConvenio=" + idConvenio + ", tipoDocumento=" + tipoDocumento
				+ ", nombre=" + nombre + ", descripcion=" + descripcion + ", fecSubida=" + fecSubida + ", formato="
				+ formato + ", size=" + size + ", data=" + Arrays.toString(data) + "]";
	}

}