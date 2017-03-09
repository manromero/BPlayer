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
 * Persistent class for entity stored in table "CAMP_CAMIONES"
 *
 * VS
 *
 */

@Entity
@Table(name="CAMP_CAMIONES", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CampanaCamionesEntity.countAll", query="SELECT COUNT(x) FROM CampanaCamionesEntity x" )
} )
@SequenceGenerator(name= "campanaCamiones_id_seq_gen", sequenceName="CINETI.SEQ_CAMP_CAMIONES", allocationSize=5,initialValue=100)
public class CampanaCamionesEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "campanaCamiones_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="id_camp_camiones", nullable=false)
    private Long idCampanaCamiones       ;

    @Column(name="id_adhesion")
    private Long idAdhesion   ;
    
    @ManyToOne
    @JoinColumn(name="ID_ADHESION", referencedColumnName="ID_ADHESION", insertable=false, updatable=false)
    private CampanaAdhesionEntity campanaAdhesion;
    
    @Column(name="fecha_camp_camiones")
    private Date fechaCampanaCamiones;
    
	@Column(name="numControlNacionales")
    private Long numControlNacionales;

	@Column(name="numControlExtranjeros")
	private Long numControlExtranjeros;

	@Column(name="numDenunciaNacionales")
	private Long numDenunciaNacionales;

	@Column(name="numDenunciaExtranjeros")
	private Long numDenunciaExtranjeros;

	@Column(name="numDenunciaInmovilizados")
	private Long numDenunciaInmovilizados;

	@Column(name="inmigracionTraficoPersonas")
	private Long inmigracionTraficoPersonas; 

	@Column(name="aprehensionDrogas")
	private Long aprehensionDrogas;

	@Column(name="intervencionArmas")
	private Long intervencionArmas;

	@Column(name="mercanciasRobadas")
	private Long mercanciasRobadas;

	@Column(name="otrosDelitosST")
	private Long otrosDelitosST;
				
	@Column(name="excesoVelocidad")
	private Long excesoVelocidad;

	@Column(name="numPositAlcoholeamia")
	private Long numPositAlcoholeamia;				

	@Column(name="numPositDrogas")
	private Long numPositDrogas;

	@Column(name="noUsoCinturon")
	private Long noUsoCinturon;			

	@Column(name="infraccionesTacografo")
	private Long infraccionesTacografo;

	@Column(name="manipulacionTacografo")
	private Long manipulacionTacografo;

	@Column(name="excesoHorasConduccion")
	private Long excesoHorasConduccion;

	@Column(name="excesoPeso")
	private Long excesoPeso;

	@Column(name="estibaDeCarga")
	private Long estibaDeCarga;

	@Column(name="relativasConductor")
	private Long relativasConductor;

	@Column(name="permisoConductor")
	private Long permisoConductor;

	@Column(name="relativasVehiculo")
	private Long relativasVehiculo;

	@Column(name="relativasCargador")
	private Long relativasCargador;

	@Column(name="deficienciasTecnVehiculo")
	private Long deficienciasTecnVehiculo;

	@Column(name="otrasDenuncias")
	private Long otrasDenuncias;
     

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CampanaCamionesEntity() {
		super();
    }


    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
  
    
	public Long getIdCampanaCamiones() {
		return idCampanaCamiones;
	}

	public void setIdCampanaCamiones(Long idCampanaCamiones) {
		this.idCampanaCamiones = idCampanaCamiones;
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

	public Date getFechaCampanaCamiones() {
		return fechaCampanaCamiones;
	}

	public void setFechaCampanaCamiones(Date fechaCampanaCamiones) {
		this.fechaCampanaCamiones = fechaCampanaCamiones;
	}

	public Long getNumControlNacionales() {
		return numControlNacionales;
	}

	public void setNumControlNacionales(Long numControlNacionales) {
		this.numControlNacionales = numControlNacionales;
	}

	public Long getNumControlExtranjeros() {
		return numControlExtranjeros;
	}

	public void setNumControlExtranjeros(Long numControlExtranjeros) {
		this.numControlExtranjeros = numControlExtranjeros;
	}

	public Long getNumDenunciaNacionales() {
		return numDenunciaNacionales;
	}

	public void setNumDenunciaNacionales(Long numDenunciaNacionales) {
		this.numDenunciaNacionales = numDenunciaNacionales;
	}

	public Long getNumDenunciaExtranjeros() {
		return numDenunciaExtranjeros;
	}

	public void setNumDenunciaExtranjeros(Long numDenunciaExtranjeros) {
		this.numDenunciaExtranjeros = numDenunciaExtranjeros;
	}

	public Long getNumDenunciaInmovilizados() {
		return numDenunciaInmovilizados;
	}

	public void setNumDenunciaInmovilizados(Long numDenunciaInmovilizados) {
		this.numDenunciaInmovilizados = numDenunciaInmovilizados;
	}

	public Long getInmigracionTraficoPersonas() {
		return inmigracionTraficoPersonas;
	}

	public void setInmigracionTraficoPersonas(Long inmigracionTraficoPersonas) {
		this.inmigracionTraficoPersonas = inmigracionTraficoPersonas;
	}

	public Long getAprehensionDrogas() {
		return aprehensionDrogas;
	}

	public void setAprehensionDrogas(Long aprehensionDrogas) {
		this.aprehensionDrogas = aprehensionDrogas;
	}

	public Long getIntervencionArmas() {
		return intervencionArmas;
	}

	public void setIntervencionArmas(Long intervencionArmas) {
		this.intervencionArmas = intervencionArmas;
	}

	public Long getMercanciasRobadas() {
		return mercanciasRobadas;
	}

	public void setMercanciasRobadas(Long mercanciasRobadas) {
		this.mercanciasRobadas = mercanciasRobadas;
	}

	public Long getOtrosDelitosST() {
		return otrosDelitosST;
	}

	public void setOtrosDelitosST(Long otrosDelitosST) {
		this.otrosDelitosST = otrosDelitosST;
	}

	public Long getExcesoVelocidad() {
		return excesoVelocidad;
	}

	public void setExcesoVelocidad(Long excesoVelocidad) {
		this.excesoVelocidad = excesoVelocidad;
	}


	public Long getNumPositAlcoholeamia() {
		return numPositAlcoholeamia;
	}

	public void setNumPositAlcoholeamia(Long numPositAlcoholeamia) {
		this.numPositAlcoholeamia = numPositAlcoholeamia;
	}

	public Long getNumPositDrogas() {
		return numPositDrogas;
	}

	public void setNumPositDrogas(Long numPositDrogas) {
		this.numPositDrogas = numPositDrogas;
	}

	public Long getNoUsoCinturon() {
		return noUsoCinturon;
	}

	public void setNoUsoCinturon(Long noUsoCinturon) {
		this.noUsoCinturon = noUsoCinturon;
	}

	public Long getInfraccionesTacografo() {
		return infraccionesTacografo;
	}

	public void setInfraccionesTacografo(Long infraccionesTacografo) {
		this.infraccionesTacografo = infraccionesTacografo;
	}

	public Long getManipulacionTacografo() {
		return manipulacionTacografo;
	}

	public void setManipulacionTacografo(Long manipulacionTacografo) {
		this.manipulacionTacografo = manipulacionTacografo;
	}

	public Long getExcesoHorasConduccion() {
		return excesoHorasConduccion;
	}

	public void setExcesoHorasConduccion(Long excesoHorasConduccion) {
		this.excesoHorasConduccion = excesoHorasConduccion;
	}

	public Long getExcesoPeso() {
		return excesoPeso;
	}

	public void setExcesoPeso(Long excesoPeso) {
		this.excesoPeso = excesoPeso;
	}

	public Long getEstibaDeCarga() {
		return estibaDeCarga;
	}

	public void setEstibaDeCarga(Long estibaDeCarga) {
		this.estibaDeCarga = estibaDeCarga;
	}

	public Long getRelativasConductor() {
		return relativasConductor;
	}

	public void setRelativasConductor(Long relativasConductor) {
		this.relativasConductor = relativasConductor;
	}

	public Long getPermisoConductor() {
		return permisoConductor;
	}

	public void setPermisoConductor(Long permisoConductor) {
		this.permisoConductor = permisoConductor;
	}

	public Long getRelativasVehiculo() {
		return relativasVehiculo;
	}

	public void setRelativasVehiculo(Long relativasVehiculo) {
		this.relativasVehiculo = relativasVehiculo;
	}

	public Long getRelativasCargador() {
		return relativasCargador;
	}

	public void setRelativasCargador(Long relativasCargador) {
		this.relativasCargador = relativasCargador;
	}

	public Long getDeficienciasTecnVehiculo() {
		return deficienciasTecnVehiculo;
	}

	public void setDeficienciasTecnVehiculo(Long deficienciasTecnVehiculo) {
		this.deficienciasTecnVehiculo = deficienciasTecnVehiculo;
	}

	public Long getOtrasDenuncias() {
		return otrasDenuncias;
	}

	public void setOtrasDenuncias(Long otrasDenuncias) {
		this.otrasDenuncias = otrasDenuncias;
	}



	@Override
	public String toString() {
		return "CampanaCamionesEntity [idCampanaCamiones=" + idCampanaCamiones + ", idAdhesion=" + idAdhesion
				+ ", campanaAdhesion=" + campanaAdhesion + ", fechaCampanaCamiones=" + fechaCampanaCamiones
				+ ", numControlNacionales=" + numControlNacionales + ", numControlExtranjeros=" + numControlExtranjeros
				+ ", numDenunciaNacionales=" + numDenunciaNacionales + ", numDenunciaExtranjeros="
				+ numDenunciaExtranjeros + ", numDenunciaInmovilizados=" + numDenunciaInmovilizados
				+ ", inmigracionTraficoPersonas=" + inmigracionTraficoPersonas + ", aprehensionDrogas="
				+ aprehensionDrogas + ", intervencionArmas=" + intervencionArmas + ", mercanciasRobadas="
				+ mercanciasRobadas + ", otrosDelitosST=" + otrosDelitosST + ", excesoVelocidad=" + excesoVelocidad
				+ ", numPositAlcoholeamia=" + numPositAlcoholeamia + ", numPositDrogas=" + numPositDrogas
				+ ", noUsoCinturon=" + noUsoCinturon + ", infraccionesTacografo=" + infraccionesTacografo
				+ ", manipulacionTacografo=" + manipulacionTacografo + ", excesoHorasConduccion="
				+ excesoHorasConduccion + ", excesoPeso=" + excesoPeso + ", estibaDeCarga=" + estibaDeCarga
				+ ", relativasConductor=" + relativasConductor + ", permisoConductor=" + permisoConductor
				+ ", relativasVehiculo=" + relativasVehiculo + ", relativasCargador=" + relativasCargador
				+ ", deficienciasTecnVehiculo=" + deficienciasTecnVehiculo + ", otrasDenuncias=" + otrasDenuncias + "]";
	}

	


	
}
