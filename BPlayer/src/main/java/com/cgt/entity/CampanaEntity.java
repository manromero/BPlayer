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
 * Persistent class for entity stored in table "CAMPANA"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="CAMPANA", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CampanaEntity.countAll", query="SELECT COUNT(x) FROM CampanaEntity x" )
} )
@SequenceGenerator(name= "campana_id_seq_gen", sequenceName="CINETI.SEQ_CAMPANA", allocationSize=5,initialValue=100)
public class CampanaEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "campana_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="ID_CAMPANA", nullable=false)
    private Long idCampana    ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="ID_TIPO_CAMPANA")
    private Long idTipoCampana   ;
  
	@Column(name="ID_ESTADO")
    private Long idEstadoCampana   ;
    
	@Column(name="DESC_CAMPANA", length=100)
    private String     descCampana  ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FEC_INI")
    private Date       fecIni       ;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="FEC_FIN")
    private Date       fecFin       ;

    @Column(name="REQUIERE_EQUIPAMIENTO", length=1)
    private String     requiereEquipamiento ;

    @Column(name="OBSERVACIONES", length=500)
    private String     observaciones ;



    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------
//    @OneToMany(mappedBy="campana", targetEntity=CampanaAdhesionEntity.class)
//    private List<CampanaAdhesionEntity> listOfCampanaAdhesion;

    @ManyToOne
    @JoinColumn(name="ID_ESTADO", referencedColumnName="ID_ESTADO", insertable=false, updatable=false)
    private EstadoCampanaEntity estado;

    @ManyToOne
    @JoinColumn(name="ID_TIPO_CAMPANA", referencedColumnName="ID_TIPO", insertable=false, updatable=false)
    private TipoCampanaEntity tipoCampana ;

   
	//----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CampanaEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdCampana( Long idCampana ) {
        this.idCampana = idCampana ;
    }
    public Long getIdCampana() {
        return this.idCampana;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : DESC_CAMPANA ( VARCHAR2 ) 
    
    public Long getIdTipoCampana() {
		return idTipoCampana;
	}

	public void setIdTipoCampana(Long idTipoCampana) {
		this.idTipoCampana = idTipoCampana;
	}


    public void setDescCampana( String descCampana ) {
        this.descCampana = descCampana;
    }
    public String getDescCampana() {
        return this.descCampana;
    }

    //--- DATABASE MAPPING : FEC_INI ( DATE ) 
    public void setFecIni( Date fecIni ) {
        this.fecIni = fecIni;
    }
    public Date getFecIni() {
        return this.fecIni;
    }

    //--- DATABASE MAPPING : FEC_FIN ( DATE ) 
    public void setFecFin( Date fecFin ) {
        this.fecFin = fecFin;
    }
    public Date getFecFin() {
        return this.fecFin;
    }

    //--- DATABASE MAPPING : REQUIERE_EQUIPAMIENTO ( VARCHAR2 ) 
    public void setRequiereEquipamiento( String requiereEquipamiento ) {
        this.requiereEquipamiento = requiereEquipamiento;
    }
    public String getRequiereEquipamiento() {
        return this.requiereEquipamiento;
    }

    public Long getIdEstadoCampana() {
		return idEstadoCampana;
	}

	public void setIdEstadoCampana(Long idEstadoCampana) {
		this.idEstadoCampana = idEstadoCampana;
	}

	public EstadoCampanaEntity getEstado() {
		return estado;
	}

	public void setEstado(EstadoCampanaEntity estado) {
		this.estado = estado;
	}

	public TipoCampanaEntity getTipoCampana() {
		return tipoCampana;
	}

	public void setTipoCampana(TipoCampanaEntity tipoCampana) {
		this.tipoCampana = tipoCampana;
	}

	//--- DATABASE MAPPING : OBSERVACIONES ( VARCHAR2 ) 
    public void setObservaciones( String observaciones ) {
        this.observaciones = observaciones;
    }
    public String getObservaciones() {
        return this.observaciones;
    }

	@Override
	public String toString() {
		return "CampanaEntity [idCampana=" + idCampana + ", idTipoCampana=" + idTipoCampana + ", idEstadoCampana="
				+ idEstadoCampana + ", descCampana=" + descCampana + ", fecIni=" + fecIni + ", fecFin=" + fecFin
				+ ", requiereEquipamiento=" + requiereEquipamiento + ", observaciones=" + observaciones + ", estado="
				+ estado + ", tipoCampana=" + tipoCampana + "]";
	}


    
}