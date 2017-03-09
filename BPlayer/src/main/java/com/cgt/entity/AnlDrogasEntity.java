package com.cgt.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * 
 * @author apascual
 *
 */
@Entity
@Table(name = "ANL_DROGAS", schema = "CINETI")
@NamedQueries({ 
	@NamedQuery(name = "findAll", query = "SELECT a FROM AnlDrogasEntity a") 
})
@SequenceGenerator(name = "anlDroga_id_seq_gen", sequenceName = "CINETI.SEQ_ANL_DROGAS", allocationSize = 5, initialValue = 100)
public class AnlDrogasEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "anlDroga_id_seq_gen", strategy = GenerationType.SEQUENCE)
	@Column(name = "ID_ANL_DROGAS")
	private Long idAnlDroga;

	@Column(name = "ID_EQUIPAMIENTO")
	private Long idEquipamiento;

	@Column(name = "IMPRESORA", length = 100)
	private String impresora;

	@Column(name = "TECLADO", length = 100)
	private String teclado;

	@Column(name = "CARGADOR_MODELO", length = 50)
	private String cargadorModelo;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ID_EQUIPAMIENTO", referencedColumnName = "ID", insertable = false, updatable = false)
	private EquipamientoEntity equipamiento;

	public Long getIdEquipamiento() {
		return idEquipamiento;
	}

	public void setIdEquipamiento(Long idEquipamiento) {
		this.idEquipamiento = idEquipamiento;
	}

	public Long getIdAnlDroga() {
		return idAnlDroga;
	}

	public void setIdAnlDroga(Long idAnlDroga) {
		this.idAnlDroga = idAnlDroga;
	}

	public String getImpresora() {
		return impresora;
	}

	public void setImpresora(String impresora) {
		this.impresora = impresora;
	}

	public String getTeclado() {
		return teclado;
	}

	public void setTeclado(String teclado) {
		this.teclado = teclado;
	}

	public String getCargadorModelo() {
		return cargadorModelo;
	}

	public void setCargadorModelo(String cargadorModelo) {
		this.cargadorModelo = cargadorModelo;
	}

	public EquipamientoEntity getEquipamiento() {
		return equipamiento;
	}

	public void setEquipamiento(EquipamientoEntity equipamiento) {
		this.equipamiento = equipamiento;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idAnlDroga == null) ? 0 : idAnlDroga.hashCode());
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
		AnlDrogasEntity other = (AnlDrogasEntity) obj;
		if (idAnlDroga == null) {
			if (other.idAnlDroga != null)
				return false;
		} else if (!idAnlDroga.equals(other.idAnlDroga))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "AnlDrogasEntity [idAnlDroga=" + idAnlDroga + ", idEquipamiento=" + idEquipamiento + ", impresora="
				+ impresora + ", teclado=" + teclado + ", cargadorModelo=" + cargadorModelo + ", equipamiento="
				+ equipamiento + "]";
	}

}
