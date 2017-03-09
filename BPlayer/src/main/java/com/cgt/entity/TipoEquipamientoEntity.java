/*
 * Created on 6 abr 2016 ( Time 20:03:19 )
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
 * Persistent class for entity stored in table "TIPO_EQUIPAMIENTO"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="TIPO_EQUIPAMIENTO", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="TipoEquipamientoEntity.countAll", query="SELECT COUNT(x) FROM TipoEquipamientoEntity x" )
} )
@SequenceGenerator(name= "tipoEquipamiento_id_seq_gen", sequenceName="CINETI.SEQ_TIPO_EQUIPAMIENTO", allocationSize=5,initialValue=100)
public class TipoEquipamientoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "tipoEquipamiento_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="ID_TIPO_EQUIPAMIENTO", nullable=false)
    private Long idTipoEquipamiento ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="DESC_TIPO_EQUIPAMIENTO", length=50)
    private String     descTipoEquipamiento ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
//    
//    @OneToMany(mappedBy="tipoEquipamiento", targetEntity=EquipamientoEntity.class)
//    private List<EquipamientoEntity> listOfEquipamiento;


    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public TipoEquipamientoEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdTipoEquipamiento( Long idTipoEquipamiento ) {
        this.idTipoEquipamiento = idTipoEquipamiento ;
    }
    public Long getIdTipoEquipamiento() {
        return this.idTipoEquipamiento;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : DESC_TIPO_EQUIPAMIENTO ( VARCHAR2 ) 
    public void setDescTipoEquipamiento( String descTipoEquipamiento ) {
        this.descTipoEquipamiento = descTipoEquipamiento;
    }
    public String getDescTipoEquipamiento() {
        return this.descTipoEquipamiento;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------
//    
//    public void setListOfEquipamiento( List<EquipamientoEntity> listOfEquipamiento ) {
//        this.listOfEquipamiento = listOfEquipamiento;
//    }
//    public List<EquipamientoEntity> getListOfEquipamiento() {
//        return this.listOfEquipamiento;
//    }


    @Override
	public String toString() {
		return "TipoEquipamientoEntity [idTipoEquipamiento=" + idTipoEquipamiento + ", descTipoEquipamiento="
				+ descTipoEquipamiento + "]";
	} 

}