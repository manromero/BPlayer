/*
 * Created on 3 06 2016 ( Time 20:03:19 )
 * VS
 */
// This Bean has a basic Primary Key (not composite) 

package com.cgt.entity;

import java.io.Serializable;
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

/**
 * Persistent class for entity stored in table "CAMP_CTRASSECUNDARIAS"
 *
 * VS
 *
 */

@Entity
@Table(name="CAMP_CTRASSECUNDARIAS", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CampanaCtrasSecundariasEntity.countAll", query="SELECT COUNT(x) FROM CampanaCtrasSecundariasEntity x" )
} )
@SequenceGenerator(name= "campanaCtrasSecundarias_id_seq_gen", sequenceName="CINETI.SEQ_CAMP_CTRASSECUNDARIAS", allocationSize=5,initialValue=100)
public class CampanaCtrasSecundariasEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "campanaCtrasSecundarias_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="id_camp_ctrassecundarias", nullable=false)
    private Long idCampanaCtrasSecundarias       ;

    @Column(name="id_adhesion")
    private Long idAdhesion   ;
    
    @ManyToOne
    @JoinColumn(name="ID_ADHESION", referencedColumnName="ID_ADHESION", insertable=false, updatable=false)
    private CampanaAdhesionEntity campanaAdhesion;
    
    @Column(name="fecha_camp_ctrassecundarias")
    private Date fechaCampanaCtrasSecundarias;
    

	@Column(name="numVehControlados")
	private Long numVehControlados;
	
	@Column(name="numVehDenunciados")
	private Long numVehDenunciados;
	
	@Column(name="numAdelantAntirregl")
	private Long numAdelantAntirregl;
	
	@Column(name="numExcesoVelocidad")
	private Long numExcesoVelocidad;
	
	@Column(name="numStop")
	private Long numStop;
	
	@Column(name="numCedaPaso")
	private Long numCedaPaso;
	
	@Column(name="numAlcoholPositivas")
	private Long numAlcoholPositivas;
	
	@Column(name="numDrogasPositivas")
	private Long numDrogasPositivas;
	
	@Column(name="numCinturon")
	private Long numCinturon;
	
	@Column(name="numStmasRetencion")
	private Long numStmasRetencion;
	
	@Column(name="numUsoTelefono")
	private Long numUsoTelefono;
	
	@Column(name="numUsoAuriculares")
	private Long numUsoAuriculares;
	
	@Column(name="numManipulPantallas")
	private Long numManipulPantallas;
	
	@Column(name="numOtrasDistracciones")
	private Long numOtrasDistracciones;
	
	@Column(name="numDocumCondutor")
	private Long numDocumCondutor;
	
	@Column(name="numDocumVehiculo")
	private Long numDocumVehiculo;
	
	@Column(name="numDeficTecnicas")
	private Long numDeficTecnicas;
	
	@Column(name="numInmovilizDefTecn")
	private Long numInmovilizDefTecn;
	
	@Column(name="numOtrasInfracciones")
	private Long numOtrasInfracciones;
    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CampanaCtrasSecundariasEntity() {
		super();
    }


    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
  
  
    
	public Long getIdCampanaCtrasSecundarias() {
		return idCampanaCtrasSecundarias;
	}

	public void setIdCampanaCtrasSecundarias(Long idCampanaCtrasSecundarias) {
		this.idCampanaCtrasSecundarias = idCampanaCtrasSecundarias;
	}

	public Long getIdAdhesion() {
		return idAdhesion;
	}

	public void setIdAdhesion(Long idAdhesion) {
		this.idAdhesion = idAdhesion;
	}

	public CampanaAdhesionEntity getCampanaAdhesion() {
		return campanaAdhesion;
	}

	public void setCampanaAdhesion(CampanaAdhesionEntity campanaAdhesion) {
		this.campanaAdhesion = campanaAdhesion;
	}

	public Date getFechaCampanaCtrasSecundarias() {
		return fechaCampanaCtrasSecundarias;
	}

	public void setFechaCampanaCtrasSecundarias(Date fechaCampanaCtrasSecundarias) {
		this.fechaCampanaCtrasSecundarias = fechaCampanaCtrasSecundarias;
	}

	public Long getNumVehControlados() {
		return numVehControlados;
	}

	public void setNumVehControlados(Long numVehControlados) {
		this.numVehControlados = numVehControlados;
	}

	public Long getNumVehDenunciados() {
		return numVehDenunciados;
	}

	public void setNumVehDenunciados(Long numVehDenunciados) {
		this.numVehDenunciados = numVehDenunciados;
	}

	public Long getNumAdelantAntirregl() {
		return numAdelantAntirregl;
	}

	public void setNumAdelantAntirregl(Long numAdelantAntirregl) {
		this.numAdelantAntirregl = numAdelantAntirregl;
	}

	public Long getNumExcesoVelocidad() {
		return numExcesoVelocidad;
	}

	public void setNumExcesoVelocidad(Long numExcesoVelocidad) {
		this.numExcesoVelocidad = numExcesoVelocidad;
	}

	public Long getNumStop() {
		return numStop;
	}

	public void setNumStop(Long numStop) {
		this.numStop = numStop;
	}

	public Long getNumCedaPaso() {
		return numCedaPaso;
	}

	public void setNumCedaPaso(Long numCedaPaso) {
		this.numCedaPaso = numCedaPaso;
	}

	public Long getNumAlcoholPositivas() {
		return numAlcoholPositivas;
	}

	public void setNumAlcoholPositivas(Long numAlcoholPositivas) {
		this.numAlcoholPositivas = numAlcoholPositivas;
	}

	public Long getNumDrogasPositivas() {
		return numDrogasPositivas;
	}

	public void setNumDrogasPositivas(Long numDrogasPositivas) {
		this.numDrogasPositivas = numDrogasPositivas;
	}

	public Long getNumCinturon() {
		return numCinturon;
	}

	public void setNumCinturon(Long numCinturon) {
		this.numCinturon = numCinturon;
	}

	public Long getNumStmasRetencion() {
		return numStmasRetencion;
	}


	public void setNumStmasRetencion(Long numStmasRetencion) {
		this.numStmasRetencion = numStmasRetencion;
	}

	public Long getNumUsoTelefono() {
		return numUsoTelefono;
	}

	public void setNumUsoTelefono(Long numUsoTelefono) {
		this.numUsoTelefono = numUsoTelefono;
	}

	public Long getNumUsoAuriculares() {
		return numUsoAuriculares;
	}

	public void setNumUsoAuriculares(Long numUsoAuriculares) {
		this.numUsoAuriculares = numUsoAuriculares;
	}

	public Long getNumManipulPantallas() {
		return numManipulPantallas;
	}

	public void setNumManipulPantallas(Long numManipulPantallas) {
		this.numManipulPantallas = numManipulPantallas;
	}

	public Long getNumOtrasDistracciones() {
		return numOtrasDistracciones;
	}

	public void setNumOtrasDistracciones(Long numOtrasDistracciones) {
		this.numOtrasDistracciones = numOtrasDistracciones;
	}

	public Long getNumDocumCondutor() {
		return numDocumCondutor;
	}

	public void setNumDocumCondutor(Long numDocumCondutor) {
		this.numDocumCondutor = numDocumCondutor;
	}

	public Long getNumDocumVehiculo() {
		return numDocumVehiculo;
	}

	public void setNumDocumVehiculo(Long numDocumVehiculo) {
		this.numDocumVehiculo = numDocumVehiculo;
	}

	public Long getNumDeficTecnicas() {
		return numDeficTecnicas;
	}

	public void setNumDeficTecnicas(Long numDeficTecnicas) {
		this.numDeficTecnicas = numDeficTecnicas;
	}

	public Long getNumInmovilizDefTecn() {
		return numInmovilizDefTecn;
	}

	public void setNumInmovilizDefTecn(Long numInmovilizDefTecn) {
		this.numInmovilizDefTecn = numInmovilizDefTecn;
	}

	public Long getNumOtrasInfracciones() {
		return numOtrasInfracciones;
	}

	public void setNumOtrasInfracciones(Long numOtrasInfracciones) {
		this.numOtrasInfracciones = numOtrasInfracciones;
	}



	@Override
	public String toString() {
		return "CampanaCtrasSecundariasEntity [idCampanaCtrasSecundarias=" + idCampanaCtrasSecundarias + ", idAdhesion="
				+ idAdhesion + ", campanaAdhesion=" + campanaAdhesion + ", fechaCampanaCtrasSecundarias="
				+ fechaCampanaCtrasSecundarias + ", numVehControlados=" + numVehControlados + ", numVehDenunciados="
				+ numVehDenunciados + ", numAdelantAntirregl=" + numAdelantAntirregl + ", numExcesoVelocidad="
				+ numExcesoVelocidad + ", numStop=" + numStop + ", numCedaPaso=" + numCedaPaso
				+ ", numAlcoholPositivas=" + numAlcoholPositivas + ", numDrogasPositivas=" + numDrogasPositivas
				+ ", numCinturon=" + numCinturon + ", numStmasRetencion=" + numStmasRetencion + ", numUsoTelefono="
				+ numUsoTelefono + ", numUsoAuriculares=" + numUsoAuriculares + ", numManipulPantallas="
				+ numManipulPantallas + ", numOtrasDistracciones=" + numOtrasDistracciones + ", numDocumCondutor="
				+ numDocumCondutor + ", numDocumVehiculo=" + numDocumVehiculo + ", numDeficTecnicas=" + numDeficTecnicas
				+ ", numInmovilizDefTecn=" + numInmovilizDefTecn + ", numOtrasInfracciones=" + numOtrasInfracciones
				+ "]";
	}


	
}
