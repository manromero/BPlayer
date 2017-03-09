/*
 * Created on 6 abr 2016 ( Time 20:03:18 )
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

import org.hibernate.validator.constraints.Range;

/**
 * Persistent class for entity stored in table "VEHICULO"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="VEHICULO", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="VehiculoEntity.countAll", query="SELECT COUNT(x) FROM VehiculoEntity x" )
} )
@SequenceGenerator(name= "vehiculo_id_seq_gen", sequenceName="CINETI.SEQ_VEHICULO", allocationSize=5,initialValue=100)
public class VehiculoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    
    @Id
    @GeneratedValue(generator = "vehiculo_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="ID_VEHICULO", nullable=false)
    private Long     idVehiculo     ;

    @Column(name="ID_EQUIPAMIENTO")
    private Long idEquipamiento   ;


	@OneToOne(cascade=CascadeType.ALL)  
	@JoinColumn(name="ID_EQUIPAMIENTO", referencedColumnName="ID", insertable=false, updatable=false )
    private EquipamientoEntity     equipamiento     ;

    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    


	@Column(name="NUM_KM")
	@Range(min = 0)
    private Integer     numKm       ;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public VehiculoEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    
    public Long getIdEquipamiento() {
		return idEquipamiento;
	}

	public void setIdEquipamiento(Long idEquipamiento) {
		this.idEquipamiento = idEquipamiento;
	}

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    

    //--- DATABASE MAPPING : NUM_KM ( INTEGER ) 
    public void setNumKm( Integer numKm ) {
        this.numKm = numKm;
    }
    public Integer getNumKm() {
        return this.numKm;
    }
  
	public Long getIdVehiculo() {
		return idVehiculo;
	}

	public void setIdVehiculo(Long idVehiculo) {
		this.idVehiculo = idVehiculo;
	}

	public EquipamientoEntity getEquipamiento() {
		return equipamiento;
	}

	public void setEquipamiento(EquipamientoEntity equipamiento) {
		this.equipamiento = equipamiento;
	}

	@Override
	public String toString() {
		return "CinemometroEntity [idVehiculo=" + idVehiculo + ", idEquipamiento=" + idEquipamiento
				+ ", equipamiento=" + equipamiento + ", numKm=" + numKm + "]";
	} 
	

}