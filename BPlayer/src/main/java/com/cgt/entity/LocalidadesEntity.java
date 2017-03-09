/*
 * Created on 6 abr 2016 ( Time 20:03:19 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a composite Primary Key  


package com.cgt.entity;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "LOCALIDADES"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="LOCALIDADES", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name = "LocalidadesEntity.countAll", query="SELECT COUNT(x) FROM LocalidadesEntity x" ),
  @NamedQuery ( name = "findLocalidadesEntityByIdLocalidad", query="SELECT l FROM LocalidadesEntity l WHERE l.idProvincia = :idProvincia ORDER BY l.descLocalidad ASC")
} )
@SequenceGenerator(name= "localidades_id_seq_gen", sequenceName="CINETI.SEQ_LOCALIDADES", allocationSize=5,initialValue=100)
public class LocalidadesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( EMBEDDED IN AN EXTERNAL CLASS )  
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "localidades_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="ID_LOCALIDAD", nullable=false)
    private Long idLocalidad    ;
    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    

    
    @Column(name="DESC_LOCALIDAD", length=100)
    private String     descLocalidad ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FEC_BAJA")
    private Date       fecBaja      ;
    
    @Column(name="ID_PROVINCIA", nullable=false)
    private Long idProvincia  ;
    
    @Column(name="NUM_HABITANTES", nullable=false)
    private Integer numHabitantes;


    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
    @ManyToOne
    @JoinColumn(name="ID_PROVINCIA", referencedColumnName="ID_PROVINCIA", insertable=false, updatable=false)
    private ProvinciasEntity provincia  ;
	

	/*
    @OneToMany(fetch = FetchType.EAGER, mappedBy="localidades", targetEntity=EntidadesEntity.class)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<EntidadesEntity> listOfEntidades;
    */
	//----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public LocalidadesEntity() {
		super();
	}
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE COMPOSITE KEY 
    //----------------------------------------------------------------------

	public Long getIdLocalidad() {
		return idLocalidad;
	}

	public void setIdLocalidad(Long idLocalidad) {
		this.idLocalidad = idLocalidad;
	}
  


    public ProvinciasEntity getProvincia() {
		return provincia;
	}

	public void setProvincia(ProvinciasEntity provincia) {
		this.provincia = provincia;
	}
    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : DESC_LOCALIDAD ( VARCHAR2 ) 
    public void setDescLocalidad( String descLocalidad ) {
        this.descLocalidad = descLocalidad;
    }
    public String getDescLocalidad() {
        return this.descLocalidad;
    }

    //--- DATABASE MAPPING : FEC_BAJA ( DATE ) 
    public void setFecBaja( Date fecBaja ) {
        this.fecBaja = fecBaja;
    }
    public Date getFecBaja() {
        return this.fecBaja;
    }
    
    
    public Integer getNumHabitantes(){
    	return numHabitantes;
    }
    
    public void setNumHabitantes(Integer numHabitantes){
    	this.numHabitantes=numHabitantes;
    }


    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR LINKS
    //----------------------------------------------------------------------

    public void setIdProvincia( Long value ) {
        this.idProvincia = value;
    }
    public Long getIdProvincia() {
        return this.idProvincia;
    }
    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------

	@Override
	public String toString() {
		return "LocalidadesEntity [idLocalidad=" + idLocalidad + ", descLocalidad=" + descLocalidad + ", fecBaja="
				+ fecBaja + ", idProvincia=" + idProvincia + ", provincia=" + provincia + ", numHabitantes" + numHabitantes + "]";
	}


}