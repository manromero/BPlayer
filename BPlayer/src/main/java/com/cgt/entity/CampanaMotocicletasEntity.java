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
 * Persistent class for entity stored in table "CAMP_MOTOCICLETAS"
 *
 * VS
 *
 */

@Entity
@Table(name="CAMP_MOTOCICLETAS", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CampanaMotocicletasEntity.countAll", query="SELECT COUNT(x) FROM CampanaMotocicletasEntity x" )
} )
@SequenceGenerator(name= "campanaMotocicletas_id_seq_gen", sequenceName="CINETI.SEQ_CAMP_MOTOCICLETAS", allocationSize=5,initialValue=100)
public class CampanaMotocicletasEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "campanaMotocicletas_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="id_camp_motocicletas", nullable=false)
    private Long idCampanaMotocicletas       ;

    @Column(name="id_adhesion")
    private Long idAdhesion   ;
    
    @ManyToOne
    @JoinColumn(name="ID_ADHESION", referencedColumnName="ID_ADHESION", insertable=false, updatable=false)
    private CampanaAdhesionEntity campanaAdhesion;
    
    @Column(name="fecha_camp_moto")
    private Date fechaCampanaMotocicletas;
    
    @Column(name="id_tipo_camp_motocicletas")
    private Long idTipoCampanaMotocicletas   ;
    
    @ManyToOne
    @JoinColumn(name="id_tipo_camp_motocicletas", referencedColumnName="id_tipo_camp_motocicletas", insertable=false, updatable=false)
    private TipoCampanaMotocicletasEntity tipoCampanaMotocicletas;
    
    @Column(name="numMotoControladas")
    private Long numMotoControladas;
    
    @Column(name="numMotoDenunciadas")
    private Long numMotoDenunciadas;
    
    @Column(name="numDenunciasForm")
    private Long numDenunciasForm;
    
    @Column(name="alcolemiaPositiva")
    private Long alcolemiaPositiva;
	    
 
	@Column(name="drogasPositivas")
 	private Long drogasPositivas;
 	    
    @Column(name="excesoVelocidad")
 	private Long excesoVelocidad;
 	    
    @Column(name="adelantamAntirreglam")
 	private Long adelantamAntirreglam;
 	    
    @Column(name="utilizacionCasco")
 	private Long utilizacionCasco;
 	
    
    @Column(name="ocultacionMatricula")
 	private Long ocultacionMatricula;
 	
    @Column(name="placaNoVisible")
 	private Long placaNoVisible;
 	    
    @Column(name="ITV")
 	private Long itv;
 	


	@Column(name="sinSeguro")
 	private Long sinSeguro;
 	    
    @Column(name="permisoCirculacion")
 	private Long permisoCirculacion;
 	
    @Column(name="docConductor")
 	private Long docConductor;
 	
    @Column(name="otrasDenuncias")
 	private Long otrasDenuncias;
     

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CampanaMotocicletasEntity() {
		super();
    }


    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
  
    
	public Long getIdCampanaMotocicletas() {
		return idCampanaMotocicletas;
	}

	public void setIdCampanaMotocicletas(Long idCampanaMotocicletas) {
		this.idCampanaMotocicletas = idCampanaMotocicletas;
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

	public Date getFechaCampanaMotocicletas() {
		return fechaCampanaMotocicletas;
	}

	public void setFechaCampanaMotocicletas(Date fechaCampanaMotocicletas) {
		this.fechaCampanaMotocicletas = fechaCampanaMotocicletas;
	}

	public Long getIdTipoCampanaMotocicletas() {
		return idTipoCampanaMotocicletas;
	}

	public void setIdTipoCampanaMotocicletas(Long idTipoCampanaMotocicletas) {
		this.idTipoCampanaMotocicletas = idTipoCampanaMotocicletas;
	}

	public TipoCampanaMotocicletasEntity getTipoCampanaMotocicletas() {
		return tipoCampanaMotocicletas;
	}

	public void setTipoCampanaMotocicletas(TipoCampanaMotocicletasEntity tipoCampanaMotocicletas) {
		this.tipoCampanaMotocicletas = tipoCampanaMotocicletas;
	}

   public Long getNumMotoControladas() {
		return numMotoControladas;
	}

	public void setNumMotoControladas(Long numMotoControladas) {
		this.numMotoControladas = numMotoControladas;
	}

	public Long getNumMotoDenunciadas() {
		return numMotoDenunciadas;
	}

	public void setNumMotoDenunciadas(Long numMotoDenunciadas) {
		this.numMotoDenunciadas = numMotoDenunciadas;
	}

	public Long getNumDenunciasForm() {
		return numDenunciasForm;
	}

	public void setNumDenunciasForm(Long numDenunciasForm) {
		this.numDenunciasForm = numDenunciasForm;
	}
	
	public Long getAlcolemiaPositiva() {
		return alcolemiaPositiva;
	}

	public void setAlcolemiaPositiva(Long alcolemiaPositiva) {
		this.alcolemiaPositiva = alcolemiaPositiva;
	}

	public Long getDrogasPositivas() {
		return drogasPositivas;
	}

	public void setDrogasPositivas(Long drogasPositivas) {
		this.drogasPositivas = drogasPositivas;
	}

	public Long getExcesoVelocidad() {
		return excesoVelocidad;
	}

	public void setExcesoVelocidad(Long excesoVelocidad) {
		this.excesoVelocidad = excesoVelocidad;
	}

	public Long getAdelantamAntirreglam() {
		return adelantamAntirreglam;
	}

	public void setAdelantamAntirreglam(Long adelantamAntirreglam) {
		this.adelantamAntirreglam = adelantamAntirreglam;
	}

	public Long getUtilizacionCasco() {
		return utilizacionCasco;
	}

	public void setUtilizacionCasco(Long utilizacionCasco) {
		this.utilizacionCasco = utilizacionCasco;
	}

	public Long getOcultacionMatricula() {
		return ocultacionMatricula;
	}

	public void setOcultacionMatricula(Long ocultacionMatricula) {
		this.ocultacionMatricula = ocultacionMatricula;
	}

	public Long getPlacaNoVisible() {
		return placaNoVisible;
	}

	public void setPlacaNoVisible(Long placaNoVisible) {
		this.placaNoVisible = placaNoVisible;
	}

    public Long getItv() {
		return itv;
	}

	public void setItv(Long itv) {
		this.itv = itv;
	}

	public Long getSinSeguro() {
		return sinSeguro;
	}

	public void setSinSeguro(Long sinSeguro) {
		this.sinSeguro = sinSeguro;
	}

	public Long getPermisoCirculacion() {
		return permisoCirculacion;
	}

	public void setPermisoCirculacion(Long permisoCirculacion) {
		this.permisoCirculacion = permisoCirculacion;
	}

	public Long getDocConductor() {
		return docConductor;
	}

	public void setDocConductor(Long docConductor) {
		this.docConductor = docConductor;
	}

	public Long getOtrasDenuncias() {
		return otrasDenuncias;
	}

	public void setOtrasDenuncias(Long otrasDenuncias) {
		this.otrasDenuncias = otrasDenuncias;
	}



	@Override
	public String toString() {
		return "CampanaMotocicletasEntity [idCampanaMotocicletas=" + idCampanaMotocicletas + ", idAdhesion="
				+ idAdhesion + ", campanaAdhesion=" + campanaAdhesion + ", fechaCampanaMotocicletas="
				+ fechaCampanaMotocicletas + ", idTipoCampanaMotocicletas=" + idTipoCampanaMotocicletas
				+ ", tipoCampanaMotocicletas=" + tipoCampanaMotocicletas + ", numMotoControladas=" + numMotoControladas
				+ ", numMotoDenunciadas=" + numMotoDenunciadas + ", numDenunciasForm=" + numDenunciasForm
				+ ", alcolemiaPositiva=" + alcolemiaPositiva + ", drogasPositivas=" + drogasPositivas
				+ ", excesoVelocidad=" + excesoVelocidad + ", adelantamAntirreglam=" + adelantamAntirreglam
				+ ", utilizacionCasco=" + utilizacionCasco + ", ocultacionMatricula=" + ocultacionMatricula
				+ ", placaNoVisible=" + placaNoVisible + ", itv=" + itv + ", sinSeguro=" + sinSeguro
				+ ", permisoCirculacion=" + permisoCirculacion + ", docConductor=" + docConductor + ", otrasDenuncias="
				+ otrasDenuncias + "]";
	}




	
}
