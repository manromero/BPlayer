/*
 * Created on 3 06 2016 ( Time 20:03:19 )
 * VS
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
 * Persistent class for entity stored in table "TIPO_CAMP_VEHICULO"
 *
 * VS
 *
 */

@Entity
@Table(name="TIPO_CAMP_VEHICULO", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TipoCampanaVehiculoEntity.countAll", query="SELECT COUNT(x) FROM TipoCampanaVehiculoEntity x" )
} )
@SequenceGenerator(name= "tipoCampVehiculo_id_seq_gen", sequenceName="CINETI.SEQ_TIPO_CAMP_VEHICULO", allocationSize=5,initialValue=100)
public class TipoCampanaVehiculoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "tipoCampVehiculo_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="id_tipo_camp_vehiculo", nullable=false)
    private Long idTipo       ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="DESC_TIPO_CAMP_VEHICULO", length=100)
    private String     descTipo     ;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TipoCampanaVehiculoEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdTipo( Long idTipo ) {
        this.idTipo = idTipo ;
    }
    public Long getIdTipo() {
        return this.idTipo;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : DESC_TIPO ( VARCHAR2 ) 
    public void setDescTipo( String descTipo ) {
        this.descTipo = descTipo;
    }
    public String getDescTipo() {
        return this.descTipo;
    }



    @Override
	public String toString() {
		return "TipoCampanaVehiculoEntity [idTipo=" + idTipo + ", descTipo=" + descTipo + "]";
	} 

}
