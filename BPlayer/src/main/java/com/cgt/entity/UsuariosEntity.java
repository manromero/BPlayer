package com.cgt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author apascual
 *
 */
@Entity
@Table(name = "USUARIOS", schema = "CINETI")
@NamedQueries({ 
	@NamedQuery(name = "encontrarTodos", query = "SELECT u FROM UsuariosEntity u"),
	@NamedQuery(name = "findByCodUsuAndActivo", query = "SELECT u FROM UsuariosEntity u where u.codigoUsuario =:username and u.fecBaja is null")
})
@SequenceGenerator(name = "usuarios_id_seq_gen", sequenceName = "CINETI.SEQ_USUARIOS", allocationSize = 5, initialValue = 100)
public class UsuariosEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "usuarios_id_seq_gen", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_USUARIO", nullable = false)
	private Long idUsuario;

	@Column(name = "CODIGO_USU", length = 50)
	private String codigoUsuario;

	@Column(name = "ID_PROVINCIA")
	private Long idProvincia;

	@Column(name = "CLAVE", length = 50)
	private String clave;

	@Column(name = "NOM_APE", length = 100)
	private String nomApe;

	@Column(name = "EMAIL", length = 256)
	private String email;

	@Column(name = "ADMIN", length = 1)
	private String admin;

	@Column(name = "OBSERVACIONES", length = 500)
	private String observaciones;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_CREACION")
	private Date fecCreacion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "FEC_BAJA")
	private Date fecBaja;

	@ManyToOne
	@JoinColumn(name = "ID_PROVINCIA", referencedColumnName = "ID_PROVINCIA", insertable = false, updatable = false)
	private ProvinciasEntity provincias;
	
	//Constructor
	public UsuariosEntity() {
		super();
	}

	// ----------------------------------------------------------------------
	//GETTERS AND SETTERS
	// ----------------------------------------------------------------------
	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public void setClave(String clave) {
		this.clave = clave;
	}

	public String getClave() {
		return this.clave;
	}

	public void setNomApe(String nomApe) {
		this.nomApe = nomApe;
	}

	public String getNomApe() {
		return this.nomApe;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}

	public String getAdmin() {
		return this.admin;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public String getObservaciones() {
		return this.observaciones;
	}

	public void setFecCreacion(Date fecCreacion) {
		this.fecCreacion = fecCreacion;
	}

	public Date getFecCreacion() {
		return this.fecCreacion;
	}

	public void setFecBaja(Date fecBaja) {
		this.fecBaja = fecBaja;
	}

	public Date getFecBaja() {
		return this.fecBaja;
	}

	public String getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(String codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public ProvinciasEntity getProvincias() {
		return provincias;
	}

	public void setProvincias(ProvinciasEntity provincias) {
		this.provincias = provincias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
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
		UsuariosEntity other = (UsuariosEntity) obj;
		if (idUsuario == null) {
			if (other.idUsuario != null)
				return false;
		} else if (!idUsuario.equals(other.idUsuario))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "UsuariosEntity [idUsuario=" + idUsuario + ", codigoUsuario=" + codigoUsuario + ", idProvincia="
				+ idProvincia + ", clave=" + clave + ", nomApe=" + nomApe + ", email=" + email + ", admin=" + admin
				+ ", observaciones=" + observaciones + ", fecCreacion=" + fecCreacion + ", fecBaja=" + fecBaja
				+ ", provincias=" + provincias + "]";
	}

}
