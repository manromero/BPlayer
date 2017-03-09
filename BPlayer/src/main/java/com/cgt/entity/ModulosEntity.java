/*
 * Created on 6 abr 2016 ( Time 20:03:19 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.cgt.entity;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;



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
 * Persistent class for entity stored in table "MODULOS"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="MODULOS", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="ModulosEntity.countAll", query="SELECT COUNT(x) FROM ModulosEntity x" )
} )
@SequenceGenerator(name= "modulos_id_seq_gen", sequenceName="CINETI.SEQ_MODULOS", allocationSize=5,initialValue=100)
public class ModulosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "modulos_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="ID_MODULO", nullable=false)
    private Long idModulo     ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="DESC_MODULO", length=50)
    private String     descModulo   ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public ModulosEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdModulo( Long idModulo ) {
        this.idModulo = idModulo ;
    }
    public Long getIdModulo() {
        return this.idModulo;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : DESC_MODULO ( VARCHAR2 ) 
    public void setDescModulo( String descModulo ) {
        this.descModulo = descModulo;
    }
    public String getDescModulo() {
        return this.descModulo;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append("["); 
        sb.append(idModulo);
        sb.append("]:"); 
        sb.append(descModulo);
        return sb.toString(); 
    } 

}
