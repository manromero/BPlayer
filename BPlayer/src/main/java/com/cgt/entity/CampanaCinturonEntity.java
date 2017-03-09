/*
 * Created on 3 06 2016 ( Time 20:03:19 )
 * VS
 */
// This Bean has a basic Primary Key (not composite) 

package com.cgt.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
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

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Persistent class for entity stored in table "CAMP_CINTURON"
 *
 * VS
 *
 */

@Entity
@Table(name="CAMP_CINTURON", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CampanaCinturonEntity.countAll", query="SELECT COUNT(x) FROM CampanaCinturonEntity x" )
} )
@SequenceGenerator(name= "campanaCinturon_id_seq_gen", sequenceName="CINETI.SEQ_CAMP_CINTURON", allocationSize=20,initialValue=2000)
public class CampanaCinturonEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "campanaCinturon_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="id_camp_cinturon", nullable=false)
    private Long idCampanaCinturon       ;

    @Column(name="id_adhesion")
    private Long idAdhesion   ;
    
    @ManyToOne
    @JoinColumn(name="ID_ADHESION", referencedColumnName="ID_ADHESION", insertable=false, updatable=false)
    private CampanaAdhesionEntity campanaAdhesion;
    
    @Column(name="fecha_camp_cint")
    private Date fechaCampanaCinturon;
    
    @Column(name="id_tipo_camp_cinturon")
    private Long idTipoCampanaCinturon   ;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_camp_cinturon", referencedColumnName="id_tipo_camp_cinturon", insertable=false, updatable=false)
    private TipoCampanaCinturonEntity tipoCampanaCinturon;
    
    @Column(name="numSiConductor")
	private Long numSiConductor;  
	
	@Column(name="numNoConductor")
	private Long numNoConductor;   
	
	@Column(name="numSiPasajeroDel")
	private Long numSiPasajeroDel; 
	
	@Column(name="numNoPasajeroDel")
	private Long numNoPasajeroDel; 
	
	@Column(name="numSiPasajeroTras")
	private Long numSiPasajeroTras;
	
	@Column(name="numNoPasajeroTras")  
	private Long numNoPasajeroTras;
	
	@Column(name="numSiInfanDel")
	private Long numSiInfanDel; 
	
	@Column(name="numNoInfanDel")
	private Long numNoInfanDel; 
	
	@Column(name="numSiInfanTras")   
	private Long numSiInfanTras;
	
	@Column(name="numNoInfanTras")   
	private Long numNoInfanTras; 

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CampanaCinturonEntity() {
		super();
    }


    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
  
    
	public Long getIdCampanaCinturon() {
		return idCampanaCinturon;
	}

	public void setIdCampanaCinturon(Long idCampanaCinturon) {
		this.idCampanaCinturon = idCampanaCinturon;
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

	public Date getFechaCampanaCinturon() {
		return fechaCampanaCinturon;
	}

	public void setFechaCampanaCinturon(Date fechaCampanaCinturon) {
		this.fechaCampanaCinturon = fechaCampanaCinturon;
	}

	public Long getIdTipoCampanaCinturon() {
		return idTipoCampanaCinturon;
	}

	public void setIdTipoCampanaCinturon(Long idTipoCampanaCinturon) {
		this.idTipoCampanaCinturon = idTipoCampanaCinturon;
	}

	public TipoCampanaCinturonEntity getTipoCampanaCinturon() {
		return tipoCampanaCinturon;
	}

	public void setTipoCampanaCinturon(TipoCampanaCinturonEntity tipoCampanaCinturon) {
		this.tipoCampanaCinturon = tipoCampanaCinturon;
	}

	public Long getNumSiConductor() {
		return numSiConductor;
	}

	public void setNumSiConductor(Long numSiConductor) {
		this.numSiConductor = numSiConductor;
	}

	public Long getNumNoConductor() {
		return numNoConductor;
	}

	public void setNumNoConductor(Long numNoConductor) {
		this.numNoConductor = numNoConductor;
	}

	public Long getNumSiPasajeroDel() {
		return numSiPasajeroDel;
	}

	public void setNumSiPasajeroDel(Long numSiPasajeroDel) {
		this.numSiPasajeroDel = numSiPasajeroDel;
	}

	public Long getNumNoPasajeroDel() {
		return numNoPasajeroDel;
	}

	public void setNumNoPasajeroDel(Long numNoPasajeroDel) {
		this.numNoPasajeroDel = numNoPasajeroDel;
	}

	public Long getNumSiPasajeroTras() {
		return numSiPasajeroTras;
	}

	public void setNumSiPasajeroTras(Long numSiPasajeroTras) {
		this.numSiPasajeroTras = numSiPasajeroTras;
	}

	public Long getNumNoPasajeroTras() {
		return numNoPasajeroTras;
	}

	public void setNumNoPasajeroTras(Long numNoPasajeroTras) {
		this.numNoPasajeroTras = numNoPasajeroTras;
	}

	public Long getNumSiInfanDel() {
		return numSiInfanDel;
	}

	public void setNumSiInfanDel(Long numSiInfanDel) {
		this.numSiInfanDel = numSiInfanDel;
	}

	public Long getNumNoInfanDel() {
		return numNoInfanDel;
	}

	public void setNumNoInfanDel(Long numNoInfanDel) {
		this.numNoInfanDel = numNoInfanDel;
	}

	public Long getNumSiInfanTras() {
		return numSiInfanTras;
	}

	public void setNumSiInfanTras(Long numSiInfanTras) {
		this.numSiInfanTras = numSiInfanTras;
	}

	public Long getNumNoInfanTras() {
		return numNoInfanTras;
	}

	public void setNumNoInfanTras(Long numNoInfanTras) {
		this.numNoInfanTras = numNoInfanTras;
	}

	@Override
	public String toString() {
		return "CampanaCinturonEntity [idCampanaCinturon=" + idCampanaCinturon + ", idAdhesion=" + idAdhesion
				+ ", campanaAdhesion=" + campanaAdhesion + ", fechaCampanaCinturon=" + fechaCampanaCinturon
				+ ", idTipoCampanaCinturon=" + idTipoCampanaCinturon + ", tipoCampanaCinturon=" + tipoCampanaCinturon
				+ ", numSiConductor=" + numSiConductor + ", numNoConductor=" + numNoConductor + ", numSiPasajeroDel="
				+ numSiPasajeroDel + ", numNoPasajeroDel=" + numNoPasajeroDel + ", numSiPasajeroTras="
				+ numSiPasajeroTras + ", numNoPasajeroTras=" + numNoPasajeroTras + ", numSiInfanDel=" + numSiInfanDel
				+ ", numNoInfanDel=" + numNoInfanDel + ", numSiInfanTras=" + numSiInfanTras + ", numNoInfanTras="
				+ numNoInfanTras + "]";
	}

   
	
}
