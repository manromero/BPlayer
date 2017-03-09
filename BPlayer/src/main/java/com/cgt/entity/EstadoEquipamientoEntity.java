/*
 * Created on 6 abr 2016 ( Time 20:03:18 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.cgt.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "ESTADO_EQUIPAMIENTO"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="ESTADO_EQUIPAMIENTO", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="EstadoEquipamientoEntity.countAll", query="SELECT COUNT(x) FROM EstadoEquipamientoEntity x" )
} )
@SequenceGenerator(name= "estadoEquipamiento_id_seq_gen", sequenceName="CINETI.SEQ_ESTADO_EQUIPAMIENTO", allocationSize=5,initialValue=100)
public class EstadoEquipamientoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "estadoEquipamiento_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="ID_ESTADO", nullable=false)
    private Long idEstado;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="DESC_ESTADO", length=100)
    private String descEstado;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public EstadoEquipamientoEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdEstado( Long idEstado ) {
        this.idEstado = idEstado ;
    }
    public Long getIdEstado() {
        return this.idEstado;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : DESC_ESTADO ( VARCHAR2 ) 
    public void setDescEstado( String descEstado ) {
        this.descEstado = descEstado;
    }
    public String getDescEstado() {
        return this.descEstado;
    }

    @Override
	public String toString() {
		return "EstadoEquipamientoEntity [idEstado=" + idEstado + ", descEstado=" + descEstado + "]";
	} 

}
