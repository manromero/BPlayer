/*
 * Created on 3 06 2016 ( Time 20:03:19 )
 * VS
 */
// This Bean has a basic Primary Key (not composite) 

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

/**
 * Persistent class for entity stored in table "CAMP_VEHICULO"
 *
 * VS
 *
 */

@Entity
@Table(name="CAMP_VEHICULO", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CampanaVehiculoEntity.countAll", query="SELECT COUNT(x) FROM CampanaVehiculoEntity x" )
} )
@SequenceGenerator(name= "campanaVehiculo_id_seq_gen", sequenceName="CINETI.SEQ_CAMP_VEHICULO", allocationSize=5,initialValue=100)
public class CampanaVehiculoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "campanaVehiculo_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="id_camp_vehiculo", nullable=false)
    private Long idCampanaVehiculo       ;

    @Column(name="id_adhesion")
    private Long idAdhesion   ;
    
    @ManyToOne
    @JoinColumn(name="ID_ADHESION", referencedColumnName="ID_ADHESION", insertable=false, updatable=false)
    private CampanaAdhesionEntity campanaAdhesion;
    
    @Column(name="fecha_camp_vehiculo")
    private Date fechaCampanaVehiculo;
    
    @Column(name="id_tipo_camp_vehiculo")
    private Long idTipoCampanaVehiculo   ;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_camp_vehiculo", referencedColumnName="id_tipo_camp_vehiculo", insertable=false, updatable=false)
    private TipoCampanaVehiculoEntity tipoCampanaVehiculo;
    
    @Column(name="numVehControlados")
    private Long numVehControlados; 
    
    @Column(name="numVehDenunciados")
    private Long numVehDenunciados;
    
    @Column(name="numNeumaticos")
    private Long numNeumaticos;
    
    @Column(name="numDocumentacion")
    private Long numDocumentacion;
    
    @Column(name="numMatricula")
    private Long numMatricula;
    
    @Column(name="numAlumbrado")
    private Long numAlumbrado;
    
    @Column(name="numOtrosMotivos")
    private Long numOtrosMotivos;
    
    
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CampanaVehiculoEntity() {
		super();
    }


    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
  
    
	public Long getIdCampanaVehiculo() {
		return idCampanaVehiculo;
	}

	public void setIdCampanaVehiculo(Long idCampanaVehiculo) {
		this.idCampanaVehiculo = idCampanaVehiculo;
	}

	public Long getIdAdhesion() {
		return idAdhesion;
	}

	public void setIdAdhesion(Long idAdhesion) {
		this.idAdhesion = idAdhesion;
	}

	public CampanaAdhesionEntity getCampanaAdhesion() {
		return campanaAdhesion;
	}

	public void setCampanaAdhesion(CampanaAdhesionEntity campanaAdhesion) {
		this.campanaAdhesion = campanaAdhesion;
	}

	public Date getFechaCampanaVehiculo() {
		return fechaCampanaVehiculo;
	}

	public void setFechaCampanaVehiculo(Date fechaCampanaVehiculo) {
		this.fechaCampanaVehiculo = fechaCampanaVehiculo;
	}

	public Long getIdTipoCampanaVehiculo() {
		return idTipoCampanaVehiculo;
	}

	public void setIdTipoCampanaVehiculo(Long idTipoCampanaVehiculo) {
		this.idTipoCampanaVehiculo = idTipoCampanaVehiculo;
	}

	public TipoCampanaVehiculoEntity getTipoCampanaVehiculo() {
		return tipoCampanaVehiculo;
	}

	public void setTipoCampanaVehiculo(TipoCampanaVehiculoEntity tipoCampanaVehiculo) {
		this.tipoCampanaVehiculo = tipoCampanaVehiculo;
	}



	public Long getNumVehControlados() {
		return numVehControlados;
	}



	public void setNumVehControlados(Long numVehControlados) {
		this.numVehControlados = numVehControlados;
	}



	public Long getNumVehDenunciados() {
		return numVehDenunciados;
	}



	public void setNumVehDenunciados(Long numVehDenunciados) {
		this.numVehDenunciados = numVehDenunciados;
	}



	public Long getNumNeumaticos() {
		return numNeumaticos;
	}



	public void setNumNeumaticos(Long numNeumaticos) {
		this.numNeumaticos = numNeumaticos;
	}



	public Long getNumDocumentacion() {
		return numDocumentacion;
	}



	public void setNumDocumentacion(Long numDocumentacion) {
		this.numDocumentacion = numDocumentacion;
	}



	public Long getNumMatricula() {
		return numMatricula;
	}



	public void setNumMatricula(Long numMatricula) {
		this.numMatricula = numMatricula;
	}



	public Long getNumAlumbrado() {
		return numAlumbrado;
	}



	public void setNumAlumbrado(Long numAlumbrado) {
		this.numAlumbrado = numAlumbrado;
	}



	public Long getNumOtrosMotivos() {
		return numOtrosMotivos;
	}



	public void setNumOtrosMotivos(Long numOtrosMotivos) {
		this.numOtrosMotivos = numOtrosMotivos;
	}



	@Override
	public String toString() {
		return "CampanaVehiculoEntity [idCampanaVehiculo=" + idCampanaVehiculo + ", idAdhesion=" + idAdhesion
				+ ", campanaAdhesion=" + campanaAdhesion + ", fechaCampanaVehiculo=" + fechaCampanaVehiculo
				+ ", idTipoCampanaVehiculo=" + idTipoCampanaVehiculo + ", tipoCampanaVehiculo=" + tipoCampanaVehiculo
				+ ", numVehControlados=" + numVehControlados + ", numVehDenunciados=" + numVehDenunciados
				+ ", numNeumaticos=" + numNeumaticos + ", numDocumentacion=" + numDocumentacion + ", numMatricula="
				+ numMatricula + ", numAlumbrado=" + numAlumbrado + ", numOtrosMotivos=" + numOtrosMotivos + "]";
	}

   
	
}
