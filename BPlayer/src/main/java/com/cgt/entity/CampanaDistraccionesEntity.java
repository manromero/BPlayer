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
 * Persistent class for entity stored in table "CAMP_DISTRACCIONES"
 *
 * VS
 *
 */

@Entity
@Table(name="CAMP_DISTRACCIONES", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CampanaDistraccionesEntity.countAll", query="SELECT COUNT(x) FROM CampanaDistraccionesEntity x" )
} )
@SequenceGenerator(name= "campanaDistracciones_id_seq_gen", sequenceName="CINETI.SEQ_CAMP_DISTRACCIONES", allocationSize=5,initialValue=100)
public class CampanaDistraccionesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "campanaDistracciones_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="id_camp_DISTRACCIONES", nullable=false)
    private Long idCampanaDistracciones       ;

    @Column(name="id_adhesion")
    private Long idAdhesion   ;
    
    @ManyToOne
    @JoinColumn(name="ID_ADHESION", referencedColumnName="ID_ADHESION", insertable=false, updatable=false)
    private CampanaAdhesionEntity campanaAdhesion;
    
    @Column(name="fecha_camp_DISTRACCIONES")
    private Date fechaCampanaDistracciones;
    
    @Column(name="numVehControlados")
    private Long numVehControlados;
	
	@Column(name="numVehDeletenidos")
	private Long numVehDeletenidos;

	@Column(name="numDenUtilizMovil")
	private Long numDenUtilizMovil;

	@Column(name="numDenUtilizCascos")
	private Long numDenUtilizCascos;

	@Column(name="numDenUtilizPantallas")
	private Long numDenUtilizPantallas;

	@Column(name="numDenOtrasDistracciones")
	private Long numDenOtrasDistracciones;

	@Column(name="numManosLibres")
	private Long numManosLibres;
     

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CampanaDistraccionesEntity() {
		super();
    }


    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
  
    
	public Long getIdCampanaDistracciones() {
		return idCampanaDistracciones;
	}

	public void setIdCampanaDistracciones(Long idCampanaDistracciones) {
		this.idCampanaDistracciones = idCampanaDistracciones;
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

	public Date getFechaCampanaDistracciones() {
		return fechaCampanaDistracciones;
	}

	public void setFechaCampanaDistracciones(Date fechaCampanaDistracciones) {
		this.fechaCampanaDistracciones = fechaCampanaDistracciones;
	}



	public Long getNumVehControlados() {
		return numVehControlados;
	}



	public void setNumVehControlados(Long numVehControlados) {
		this.numVehControlados = numVehControlados;
	}



	public Long getNumVehDeletenidos() {
		return numVehDeletenidos;
	}



	public void setNumVehDeletenidos(Long numVehDeletenidos) {
		this.numVehDeletenidos = numVehDeletenidos;
	}



	public Long getNumDenUtilizMovil() {
		return numDenUtilizMovil;
	}



	public void setNumDenUtilizMovil(Long numDenUtilizMovil) {
		this.numDenUtilizMovil = numDenUtilizMovil;
	}



	public Long getNumDenUtilizCascos() {
		return numDenUtilizCascos;
	}



	public void setNumDenUtilizCascos(Long numDenUtilizCascos) {
		this.numDenUtilizCascos = numDenUtilizCascos;
	}



	public Long getNumDenUtilizPantallas() {
		return numDenUtilizPantallas;
	}



	public void setNumDenUtilizPantallas(Long numDenUtilizPantallas) {
		this.numDenUtilizPantallas = numDenUtilizPantallas;
	}



	public Long getNumDenOtrasDistracciones() {
		return numDenOtrasDistracciones;
	}



	public void setNumDenOtrasDistracciones(Long numDenOtrasDistracciones) {
		this.numDenOtrasDistracciones = numDenOtrasDistracciones;
	}



	public Long getNumManosLibres() {
		return numManosLibres;
	}



	public void setNumManosLibres(Long numManosLibres) {
		this.numManosLibres = numManosLibres;
	}



	@Override
	public String toString() {
		return "CampanaDistraccionesEntity [idCampanaDistracciones=" + idCampanaDistracciones + ", idAdhesion="
				+ idAdhesion + ", campanaAdhesion=" + campanaAdhesion + ", fechaCampanaDistracciones="
				+ fechaCampanaDistracciones + ", numVehControlados=" + numVehControlados + ", numVehDeletenidos="
				+ numVehDeletenidos + ", numDenUtilizMovil=" + numDenUtilizMovil + ", numDenUtilizCascos="
				+ numDenUtilizCascos + ", numDenUtilizPantallas=" + numDenUtilizPantallas
				+ ", numDenOtrasDistracciones=" + numDenOtrasDistracciones + ", numManosLibres=" + numManosLibres + "]";
	}



	
}
