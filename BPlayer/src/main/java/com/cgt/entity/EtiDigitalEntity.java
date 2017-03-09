/*
 * Created on 6 abr 2016 ( Time 20:03:19 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

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
 * Persistent class for entity stored in table "ETI_DIGITAL"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="ETI_DIGITAL", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="EtiDigitalEntity.countAll", query="SELECT COUNT(x) FROM EtiDigitalEntity x" )
} )
@SequenceGenerator(name= "etiDigital_id_seq_gen", sequenceName="CINETI.SEQ_ETI_DIGITAL", allocationSize=5,initialValue=100)
public class EtiDigitalEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "etiDigital_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="ID_ETI_DIGITAL", nullable=false, length=50)
    private Long     idEtiDigital     ;


    @Column(name="ID_EQUIPAMIENTO")
	private Long idEquipamiento;
    
	@Column(name="CARGADOR_MODELO", length=50)
    private String     cargadorModelo ;

   	
    @OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="ID_EQUIPAMIENTO", referencedColumnName="ID", insertable=false, updatable=false)
    private EquipamientoEntity     equipamiento     ;

	public EquipamientoEntity getEquipamiento() {
		return equipamiento;
	}


	public void setEquipamiento(EquipamientoEntity equipamiento) {
		this.equipamiento = equipamiento;
	}


	public Long getIdEtiDigital() {
		return idEtiDigital;
	}


	public void setIdEtiDigital(Long idEtiDigital) {
		this.idEtiDigital = idEtiDigital;
	}


   	public Long getIdEquipamiento() {
		return idEquipamiento;
	}


	public void setIdEquipamiento(Long idEquipamiento) {
		this.idEquipamiento = idEquipamiento;
	}

	public String getCargadorModelo() {
		return cargadorModelo;
	}


	public void setCargadorModelo(String cargadorModelo) {
		this.cargadorModelo = cargadorModelo;
	}


	@Override
	public String toString() {
		return "EtiDigitalEntity [idEtiDigital=" + idEtiDigital + ", idEquipamiento=" + idEquipamiento
				+ ", cargadorModelo=" + cargadorModelo + ", equipamiento=" + equipamiento + "]";
	}


}
