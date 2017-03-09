package com.cgt.entity;

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

@Entity
@Table(name="EQUIPAMIENTO" , schema="CINETI" )
//Define named queries here
@NamedQueries ( {
	@NamedQuery ( name = "findEquipamientosDisponibles", query="SELECT i FROM EquipamientoEntity i WHERE i.idEstadoEquipamiento = 1" ),
	@NamedQuery( name = "findEquipamientosDisponiblesByIdTipoEquipamiento", query = "SELECT i FROM EquipamientoEntity i WHERE i.idEstadoEquipamiento = 1 and i.idTipoEquipamiento = :idTipoEquipamiento"),
} )
@SequenceGenerator(name= "equipamiento_id_seq_gen", sequenceName="CINETI.SEQ_EQUIPAMIENTO", allocationSize=5,initialValue=100)
public class EquipamientoEntity {

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Id 
	@GeneratedValue(generator = "equipamiento_id_seq_gen", strategy = GenerationType.SEQUENCE)
	@Column(name="ID")
	private Long id;
	
	@Column(name="ID_TIPO_EQUIPAMIENTO")
	private Long idTipoEquipamiento;
	
	@Column(name="ID_PROVINCIA")
	private Long idProvincia;
	
	@Column(name="ID_ESTADO")
	private Long idEstadoEquipamiento;

	@Column(name="NUM_SERIE")
	private String numSerie;
	
	@Column(name="MARCA")
	private String marca;
	
	@Column(name="MODELO")
	private String modelo;
	
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_ADQUISICION")
	private Date fecAdquisicion;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_PROX_VERIFICACION")
	private Date fecProxVerificacion;

    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="FEC_BAJA")
	private Date fecBaja;

    @Column(name="OBSERVACIONES", length=500)
    private String observaciones;

	@ManyToOne
    @JoinColumn(name="ID_PROVINCIA", referencedColumnName="ID_PROVINCIA", insertable=false, updatable=false)
    private ProvinciasEntity provincias;

    
    @ManyToOne
    @JoinColumn(name="ID_ESTADO", referencedColumnName="ID_ESTADO", insertable=false, updatable=false)
    private EstadoEquipamientoEntity estado;
	
	@ManyToOne
	@JoinColumn(name="ID_TIPO_EQUIPAMIENTO", referencedColumnName="ID_TIPO_EQUIPAMIENTO", insertable=false, updatable=false)
	private TipoEquipamientoEntity tipoEquipamiento;
	
    public ProvinciasEntity getProvincias() {
		return provincias;
	}

	public void setProvincias(ProvinciasEntity provincias) {
		this.provincias = provincias;
	}

	public EstadoEquipamientoEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadoEquipamientoEntity estadoEquipamiento) {
		this.estado = estadoEquipamiento;
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
	
	public Date getFecAdquisicion() {
		return fecAdquisicion;
	}

	public void setFecAdquisicion(Date fecAdquisicion) {
		this.fecAdquisicion = fecAdquisicion;
	}

	public Date getFecProxVerificacion() {
		return fecProxVerificacion;
	}

	public void setFecProxVerificacion(Date fecProxRev) {
		this.fecProxVerificacion = fecProxRev;
	}

	public Date getFecBaja() {
		return fecBaja;
	}

	public void setFecBaja(Date fecBaja) {
		this.fecBaja = fecBaja;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Long getIdTipoEquipamiento() {
		return idTipoEquipamiento;
	}

	public void setIdTipoEquipamiento(Long idTipoEquipamiento) {
		this.idTipoEquipamiento = idTipoEquipamiento;
	}

	public Long getIdProvincia() {
		return idProvincia;
	}

	public void setIdProvincia(Long idProvincia) {
		this.idProvincia = idProvincia;
	}

	public Long getIdEstadoEquipamiento() {
		return idEstadoEquipamiento;
	}

	public void setIdEstadoEquipamiento(Long idEstadoEquipamiento) {
		this.idEstadoEquipamiento = idEstadoEquipamiento;
	}

	public TipoEquipamientoEntity getTipoEquipamiento() {
		return tipoEquipamiento;
	}

	public void setTipoEquipamiento(TipoEquipamientoEntity tipoEquipamiento) {
		this.tipoEquipamiento = tipoEquipamiento;
	}

	@Override
	public String toString() {
		return "EquipamientoEntity [id=" + id + ", idTipoEquipamiento=" + idTipoEquipamiento + ", idProvincia="
				+ idProvincia + ", idEstadoEquipamiento=" + idEstadoEquipamiento + ", numSerie=" + numSerie + ", marca="
				+ marca + ", modelo=" + modelo + ", fecAdquisicion=" + fecAdquisicion + ", fecProxVerificacion=" + fecProxVerificacion
				+ ", fecBaja=" + fecBaja + ", observaciones=" + observaciones + ", provincias=" + provincias
				+ ", estado=" + estado + ", tipoEquipamiento=" + tipoEquipamiento + "]";
	}
	
}
