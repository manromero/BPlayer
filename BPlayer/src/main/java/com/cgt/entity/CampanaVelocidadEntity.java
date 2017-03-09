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
 * Persistent class for entity stored in table "CAMP_VELOCIDAD"
 *
 * VS
 *
 */

@Entity
@Table(name="CAMP_VELOCIDAD", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CampanaVelocidadEntity.countAll", query="SELECT COUNT(x) FROM CampanaVelocidadEntity x" )
} )
@SequenceGenerator(name= "campanaVelocidad_id_seq_gen", sequenceName="CINETI.SEQ_CAMP_VELOCIDAD", allocationSize=5,initialValue=100)
public class CampanaVelocidadEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "campanaVelocidad_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="id_camp_velocidad", nullable=false)
    private Long idCampanaVelocidad       ;

    @Column(name="id_adhesion")
    private Long idAdhesion   ;
    
    @ManyToOne
    @JoinColumn(name="ID_ADHESION", referencedColumnName="ID_ADHESION", insertable=false, updatable=false)
    private CampanaAdhesionEntity campanaAdhesion;
    
    @Column(name="fecha_camp_velocidad")
    private Date fechaCampanaVelocidad;
    
    @Column(name="numControladosUrb")
    private Long numControladosUrb;
    
    @Column(name="numDenunciadosUrb")
    private Long numDenunciadosUrb;
     
    @Column(name="nunNotificadosUrb")
    private Long nunNotificadosUrb;
    
    @Column(name="numAplicacionArtUrb")
    private Long numAplicacionArtUrb;
    
    @Column(name="numControladosTrav")
    private Long numControladosTrav;
    
    @Column(name="numDenunciadosTrav")
    private Long numDenunciadosTrav;
    
    @Column(name="nunNotificadosTrav")
    private Long nunNotificadosTrav;
    
    @Column(name="numAplicacionArtTrav")
    private Long numAplicacionArtTrav;
     

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CampanaVelocidadEntity() {
		super();
    }


    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
  
    
	public Long getIdCampanaVelocidad() {
		return idCampanaVelocidad;
	}

	public void setIdCampanaVelocidad(Long idCampanaVelocidad) {
		this.idCampanaVelocidad = idCampanaVelocidad;
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

	public Date getFechaCampanaVelocidad() {
		return fechaCampanaVelocidad;
	}

	public void setFechaCampanaVelocidad(Date fechaCampanaVelocidad) {
		this.fechaCampanaVelocidad = fechaCampanaVelocidad;
	}



	public Long getNumControladosUrb() {
		return numControladosUrb;
	}



	public void setNumControladosUrb(Long numControladosUrb) {
		this.numControladosUrb = numControladosUrb;
	}



	public Long getNumDenunciadosUrb() {
		return numDenunciadosUrb;
	}



	public void setNumDenunciadosUrb(Long numDenunciadosUrb) {
		this.numDenunciadosUrb = numDenunciadosUrb;
	}



	public Long getNunNotificadosUrb() {
		return nunNotificadosUrb;
	}



	public void setNunNotificadosUrb(Long nunNotificadosUrb) {
		this.nunNotificadosUrb = nunNotificadosUrb;
	}



	public Long getNumAplicacionArtUrb() {
		return numAplicacionArtUrb;
	}



	public void setNumAplicacionArtUrb(Long numAplicacionArtUrb) {
		this.numAplicacionArtUrb = numAplicacionArtUrb;
	}



	public Long getNumControladosTrav() {
		return numControladosTrav;
	}



	public void setNumControladosTrav(Long numControladosTrav) {
		this.numControladosTrav = numControladosTrav;
	}



	public Long getNumDenunciadosTrav() {
		return numDenunciadosTrav;
	}



	public void setNumDenunciadosTrav(Long numDenunciadosTrav) {
		this.numDenunciadosTrav = numDenunciadosTrav;
	}



	public Long getNunNotificadosTrav() {
		return nunNotificadosTrav;
	}



	public void setNunNotificadosTrav(Long nunNotificadosTrav) {
		this.nunNotificadosTrav = nunNotificadosTrav;
	}



	public Long getNumAplicacionArtTrav() {
		return numAplicacionArtTrav;
	}



	public void setNumAplicacionArtTrav(Long numAplicacionArtTrav) {
		this.numAplicacionArtTrav = numAplicacionArtTrav;
	}



	@Override
	public String toString() {
		return "CampanaVelocidadEntity [idCampanaVelocidad=" + idCampanaVelocidad + ", idAdhesion=" + idAdhesion
				+ ", campanaAdhesion=" + campanaAdhesion + ", fechaCampanaVelocidad=" + fechaCampanaVelocidad
				+ ", numControladosUrb=" + numControladosUrb + ", numDenunciadosUrb=" + numDenunciadosUrb
				+ ", nunNotificadosUrb=" + nunNotificadosUrb + ", numAplicacionArtUrb=" + numAplicacionArtUrb
				+ ", numControladosTrav=" + numControladosTrav + ", numDenunciadosTrav=" + numDenunciadosTrav
				+ ", nunNotificadosTrav=" + nunNotificadosTrav + ", numAplicacionArtTrav=" + numAplicacionArtTrav + "]";
	}

	
}
