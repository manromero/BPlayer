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
 * Persistent class for entity stored in table "CAMP_TTEESCOLAR"
 *
 * VS
 *
 */

@Entity
@Table(name="CAMP_TTEESCOLAR", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CampanaTteEscolarEntity.countAll", query="SELECT COUNT(x) FROM CampanaTteEscolarEntity x" )
} )
@SequenceGenerator(name= "campanaTteEscolar_id_seq_gen", sequenceName="CINETI.SEQ_CAMP_TTEESCOLAR", allocationSize=5,initialValue=100)
public class CampanaTteEscolarEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "campanaTteEscolar_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="id_camp_TTEESCOLAR", nullable=false)
    private Long idCampanaTteEscolar       ;

    @Column(name="id_adhesion")
    private Long idAdhesion   ;
    
    @ManyToOne
    @JoinColumn(name="ID_ADHESION", referencedColumnName="ID_ADHESION", insertable=false, updatable=false)
    private CampanaAdhesionEntity campanaAdhesion;
    
    @Column(name="fecha_camp_TTEESCOLAR")
    private Date fechaCampanaTteEscolar;
    
    @Column(name="numControlados")
    private Long numControlados;
    
    @Column(name="numDenunciados")
   	private Long numDenunciados;
   	
    @Column(name="numAutorizEspecial")
   	private Long numAutorizEspecial;
   	
    @Column(name="numExcesoVelocidad")
   	private Long numExcesoVelocidad;
   	
    @Column(name="numAlcoholPositiva")
   	private Long numAlcoholPositiva;
   	
    @Column(name="numItv")
   	private Long numItv;
   	
    @Column(name="numSeguro")
   	private Long numSeguro;
   	
    @Column(name="numPuertasEmerg")
   	private Long numPuertasEmerg;

    @Column(name="numAcompanante")
   	private Long numAcompanante;
   	
    @Column(name="numPermisoConduccion")
   	private Long numPermisoConduccion;
   	
    @Column(name="numDispLuminoso")
   	private Long numDispLuminoso;
   	
    @Column(name="numSenalTteEscolar")
   	private Long numSenalTteEscolar;
   	
    @Column(name="numManipTacografo")
   	private Long numManipTacografo;
   	
    @Column(name="numExcesoConducSup50")
   	private Long numExcesoConducSup50;
   	
    @Column(name="numExcesoConducInf50")
   	private Long numExcesoConducInf50;
     

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CampanaTteEscolarEntity() {
		super();
    }


    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
  
    
	public Long getIdCampanaTteEscolar() {
		return idCampanaTteEscolar;
	}

	public void setIdCampanaTteEscolar(Long idCampanaTteEscolar) {
		this.idCampanaTteEscolar = idCampanaTteEscolar;
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

	public Date getFechaCampanaTteEscolar() {
		return fechaCampanaTteEscolar;
	}

	public void setFechaCampanaTteEscolar(Date fechaCampanaTteEscolar) {
		this.fechaCampanaTteEscolar = fechaCampanaTteEscolar;
	}



	public Long getNumControlados() {
		return numControlados;
	}



	public void setNumControlados(Long numControlados) {
		this.numControlados = numControlados;
	}



	public Long getNumDenunciados() {
		return numDenunciados;
	}



	public void setNumDenunciados(Long numDenunciados) {
		this.numDenunciados = numDenunciados;
	}



	public Long getNumAutorizEspecial() {
		return numAutorizEspecial;
	}



	public void setNumAutorizEspecial(Long numAutorizEspecial) {
		this.numAutorizEspecial = numAutorizEspecial;
	}



	public Long getNumExcesoVelocidad() {
		return numExcesoVelocidad;
	}



	public void setNumExcesoVelocidad(Long numExcesoVelocidad) {
		this.numExcesoVelocidad = numExcesoVelocidad;
	}



	public Long getNumAlcoholPositiva() {
		return numAlcoholPositiva;
	}



	public void setNumAlcoholPositiva(Long numAlcoholPositiva) {
		this.numAlcoholPositiva = numAlcoholPositiva;
	}



	public Long getNumItv() {
		return numItv;
	}



	public void setNumItv(Long numItv) {
		this.numItv = numItv;
	}



	public Long getNumSeguro() {
		return numSeguro;
	}



	public void setNumSeguro(Long numSeguro) {
		this.numSeguro = numSeguro;
	}



	public Long getNumPuertasEmerg() {
		return numPuertasEmerg;
	}



	public void setNumPuertasEmerg(Long numPuertasEmerg) {
		this.numPuertasEmerg = numPuertasEmerg;
	}



	public Long getNumAcompanante() {
		return numAcompanante;
	}



	public void setNumAcompanante(Long numAcompanante) {
		this.numAcompanante = numAcompanante;
	}



	public Long getNumPermisoConduccion() {
		return numPermisoConduccion;
	}



	public void setNumPermisoConduccion(Long numPermisoConduccion) {
		this.numPermisoConduccion = numPermisoConduccion;
	}



	public Long getNumDispLuminoso() {
		return numDispLuminoso;
	}



	public void setNumDispLuminoso(Long numDispLuminoso) {
		this.numDispLuminoso = numDispLuminoso;
	}



	public Long getNumSenalTteEscolar() {
		return numSenalTteEscolar;
	}



	public void setNumSenalTteEscolar(Long numSenalTteEscolar) {
		this.numSenalTteEscolar = numSenalTteEscolar;
	}



	public Long getNumManipTacografo() {
		return numManipTacografo;
	}



	public void setNumManipTacografo(Long numManipTacografo) {
		this.numManipTacografo = numManipTacografo;
	}



	public Long getNumExcesoConducSup50() {
		return numExcesoConducSup50;
	}



	public void setNumExcesoConducSup50(Long numExcesoConducSup50) {
		this.numExcesoConducSup50 = numExcesoConducSup50;
	}



	public Long getNumExcesoConducInf50() {
		return numExcesoConducInf50;
	}



	public void setNumExcesoConducInf50(Long numExcesoConducInf50) {
		this.numExcesoConducInf50 = numExcesoConducInf50;
	}



	@Override
	public String toString() {
		return "CampanaTteEscolarEntity [idCampanaTteEscolar=" + idCampanaTteEscolar + ", idAdhesion=" + idAdhesion
				+ ", campanaAdhesion=" + campanaAdhesion + ", fechaCampanaTteEscolar=" + fechaCampanaTteEscolar
				+ ", numControlados=" + numControlados + ", numDenunciados=" + numDenunciados + ", numAutorizEspecial="
				+ numAutorizEspecial + ", numExcesoVelocidad=" + numExcesoVelocidad + ", numAlcoholPositiva="
				+ numAlcoholPositiva + ", numItv=" + numItv + ", numSeguro=" + numSeguro + ", numPuertasEmerg="
				+ numPuertasEmerg + ", numAcompanante=" + numAcompanante + ", numPermisoConduccion="
				+ numPermisoConduccion + ", numDispLuminoso=" + numDispLuminoso + ", numSenalTteEscolar="
				+ numSenalTteEscolar + ", numManipTacografo=" + numManipTacografo + ", numExcesoConducSup50="
				+ numExcesoConducSup50 + ", numExcesoConducInf50=" + numExcesoConducInf50 + "]";
	}



	
}
