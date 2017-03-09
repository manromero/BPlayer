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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Persistent class for entity stored in table "ENTIDADES"
 *
 * @author Telosys Tools Generator
 *
 */

@Entity
@Table(name="ENTIDADES", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name = "EntidadesEntity.countAll", query="SELECT COUNT(x) FROM EntidadesEntity x" ),
  @NamedQuery ( name = "findEndidadesEntityByIdLocalidad", query="SELECT e FROM EntidadesEntity e WHERE e.idLocalidades = :idLocalidades ORDER BY e.nombre ASC")
} )
@SequenceGenerator(name= "entidades_id_seq_gen", sequenceName="CINETI.SEQ_ENTIDADES", allocationSize=5,initialValue=100)
public class EntidadesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "entidades_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="ID_ENTIDAD", nullable=false)
    private Long idEntidad    ;


	//----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="ID_TIPO_ENTIDAD")
    private Long idTipoEntidad   ;
    
    @Column(name="NOMBRE", length=100)
    private String nombre;

    @Column(name="ID_LOCALIDAD", nullable=false)
    private Long idLocalidades;

    @Column(name="DIRECCION", length=300)
    private String direccion;

    @Column(name="CP", length=10)
    private String cp;

    @Column(name="TELEFONOS", length=100)
    private String telefonos;

    @Column(name="FAX", length=100)
    private String fax;

    @Column(name="EMAIL", length=256)
    private String email;

    @Column(name="OBSERVACIONES", length=300)
    private String observaciones ;

    //----------------------------------------------------------------------
    // ENTITY LINKS ( RELATIONSHIP )
    //----------------------------------------------------------------------

    @ManyToOne
    @JoinColumn(name="ID_TIPO_ENTIDAD", referencedColumnName="ID_TIPO", insertable=false, updatable=false)
    private TipoEntidadEntity tipoEntidad;
	
    @ManyToOne
    //@JoinColumns({
    	@JoinColumn(name="ID_LOCALIDAD", insertable=false, updatable=false)
    	//@JoinColumn(name = "ID_PROVINCIA", insertable=false, updatable=false)
    //})
    private LocalidadesEntity localidades;
	

	//----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public EntidadesEntity() {
		super();
    }
    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
    public void setIdEntidad( Long idEntidad ) {
        this.idEntidad = idEntidad ;
    }
    public Long getIdEntidad() {
        return this.idEntidad;
    }

    //----------------------------------------------------------------------
    // GETTERS & SETTERS FOR FIELDS
    //----------------------------------------------------------------------
    //--- DATABASE MAPPING : NOMBRE ( VARCHAR2 ) 

    public Long getIdTipoEntidad() {
		return idTipoEntidad;
	}

	public void setIdTipoEntidad(Long idTipoEntidad) {
		this.idTipoEntidad = idTipoEntidad;
	}
	
    public void setNombre( String nombre ) {
        this.nombre = nombre;
    }
    public String getNombre() {
        return this.nombre;
    }


    
    public Long getIdLocalidades() {
		return idLocalidades;
	}

	public void setIdLocalidades(Long idLocalidades) {
		this.idLocalidades = idLocalidades;
	}

	public TipoEntidadEntity getTipoEntidad() {
		return tipoEntidad;
	}

	public void setTipoEntidad(TipoEntidadEntity tipoEntidad) {
		this.tipoEntidad = tipoEntidad;
	}

	public LocalidadesEntity getLocalidades() {
		return localidades;
	}

	public void setLocalidades(LocalidadesEntity localidades) {
		this.localidades = localidades;
	}

    //--- DATABASE MAPPING : DIRECCION ( VARCHAR2 ) 
    public void setDireccion( String direccion ) {
        this.direccion = direccion;
    }
    public String getDireccion() {
        return this.direccion;
    }

    //--- DATABASE MAPPING : CP ( VARCHAR2 ) 
    public void setCp( String cp ) {
        this.cp = cp;
    }
    public String getCp() {
        return this.cp;
    }

    //--- DATABASE MAPPING : TELEFONOS ( VARCHAR2 ) 
    public void setTelefonos( String telefonos ) {
        this.telefonos = telefonos;
    }
    public String getTelefonos() {
        return this.telefonos;
    }

    //--- DATABASE MAPPING : FAX ( VARCHAR2 ) 
    public void setFax( String fax ) {
        this.fax = fax;
    }
    public String getFax() {
        return this.fax;
    }

    //--- DATABASE MAPPING : EMAIL ( VARCHAR2 ) 
    public void setEmail( String email ) {
        this.email = email;
    }
    public String getEmail() {
        return this.email;
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
		return "EntidadesEntity [idEntidad=" + idEntidad + ", idTipoEntidad=" + idTipoEntidad + ", nombre=" + nombre
				+ ", idLocalidades=" + idLocalidades + ", direccion=" + direccion + ", cp=" + cp + ", telefonos="
				+ telefonos + ", fax=" + fax + ", email=" + email + ", observaciones=" + observaciones
				+ ", tipoEntidad=" + tipoEntidad + ", localidades=" + localidades + "]";
	}


}