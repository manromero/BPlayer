/*
 * Created on 6 abr 2016 ( Time 20:03:18 )
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
// This Bean has a basic Primary Key (not composite) 

package com.cgt.entity;

import java.io.Serializable;

//import javax.validation.constraints.* ;
//import org.hibernate.validator.constraints.* ;


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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Persistent class for entity stored in table "CESIONES"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="CESIONES", schema="CINETI" )
// Define named queries here
@NamedQueries({ 
	@NamedQuery(name = "CesionesEntity.countAll", query = "SELECT COUNT(x) FROM CesionesEntity x"),
	@NamedQuery(name = "findCesionesEntityByIdProvincia", query = "SELECT c FROM CesionesEntity c WHERE c.entidades.localidades.idProvincia = :idProvincia ORDER BY c.fecCesion DESC"),
	@NamedQuery(name = "findCesionesByIdLocalidad", query = "SELECT c FROM CesionesEntity c WHERE c.entidades.idLocalidades = :idLocalidades ORDER BY c.fecCesion DESC"),
	@NamedQuery(name = "findCesionesByIdEntidad", query = "SELECT c FROM CesionesEntity c WHERE c.idEntidades = :idEntidades ORDER BY c.fecCesion DESC")
})
@SequenceGenerator(name= "cesiones_id_seq_gen", sequenceName="CINETI.SEQ_CESIONES", allocationSize=5,initialValue=1)
public class CesionesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "cesiones_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="ID_CESION", nullable=false)
    private Long idCesion;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
	@Column(name="ID_EQUIPAMIENTO")
    private Long idEquipamiento;
	
	@Column(name="ID_ENTIDAD")
    private Long idEntidades;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name="FEC_CESION", nullable=false)
    private Date fecCesion;
    
    @OneToOne(cascade=CascadeType.ALL)  
    @JoinColumn(name="ID_EQUIPAMIENTO", referencedColumnName="ID", insertable=false, updatable=false)
    private EquipamientoEntity equipamiento;

    @Column(name="OBSERVACIONES", length=300)
    private String observaciones ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FEC_PREV_BAJA")
    private Date fecPrevBaja;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FEC_BAJA")
    private Date fecBaja;

    @Column(name="MOTIVO_BAJA", length=300)
    private String motivoBaja;
	
    @ManyToOne
    @JoinColumn(name="ID_ENTIDAD", insertable=false, updatable=false)
    private EntidadesEntity entidades;
	

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CesionesEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdCesion( Long idCesion ) {
        this.idCesion = idCesion ;
    }
    public Long getIdCesion() {
        return this.idCesion;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------

    public Long getIdEquipamiento() {
		return idEquipamiento;
	}

	public void setIdEquipamiento(Long idEquipamiento) {
		this.idEquipamiento = idEquipamiento;
	}

	
    public void setFecCesion( Date fecCesion ) {
        this.fecCesion = fecCesion;
    }
    
    public Date getFecCesion() {
        return this.fecCesion;
    }

    public void setObservaciones( String observaciones ) {
        this.observaciones = observaciones;
    }
    
    public String getObservaciones() {
        return this.observaciones;
    }

    public void setFecPrevBaja( Date fecPrevBaja ) {
        this.fecPrevBaja = fecPrevBaja;
    }
    
    public Date getFecPrevBaja() {
        return this.fecPrevBaja;
    }
    
    public void setFecBaja( Date fecBaja ) {
        this.fecBaja = fecBaja;
    }
    
    public Date getFecBaja() {
        return this.fecBaja;
    }

    public void setMotivoBaja( String motivoBaja ) {
        this.motivoBaja = motivoBaja;
    }
    
    public String getMotivoBaja() {
        return this.motivoBaja;
    }

    public Long getIdEntidades() {
		return idEntidades;
	}

	public void setIdEntidades(Long idEntidades) {
		this.idEntidades = idEntidades;
	}

	public EntidadesEntity getEntidades() {
		return entidades;
	}

	public void setEntidades(EntidadesEntity entidades) {
		this.entidades = entidades;
	}

	public void setEquipamiento( EquipamientoEntity equipamiento ) {
        this.equipamiento = equipamiento;
    }
    public EquipamientoEntity getEquipamiento() {
        return this.equipamiento;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------

	@Override
	public String toString() {
		return "CesionesEntity [idCesion=" + idCesion + ", idEquipamiento=" + idEquipamiento + ", idEntidades="
				+ idEntidades + ", fecCesion=" + fecCesion + ", equipamiento=" + equipamiento + ", observaciones="
				+ observaciones + ", fecPrevBaja=" + fecPrevBaja + ", fecBaja=" + fecBaja + ", motivoBaja=" + motivoBaja + ", entidades=" + entidades
				+ "]";
	}

}