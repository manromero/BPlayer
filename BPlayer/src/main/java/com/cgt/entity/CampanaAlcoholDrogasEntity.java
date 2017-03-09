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
 * Persistent class for entity stored in table "CAMP_ALCOHOLDROGAS"
 *
 * VS
 *
 */

@Entity
@Table(name="CAMP_ALCOHOLDROGAS", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="CampanaAlcoholDrogasEntity.countAll", query="SELECT COUNT(x) FROM CampanaAlcoholDrogasEntity x" )
} )
@SequenceGenerator(name= "campanaAlcoholDrogas_id_seq_gen", sequenceName="CINETI.SEQ_CAMP_ALCOHOLDROGAS", allocationSize=5,initialValue=100)
public class CampanaAlcoholDrogasEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "campanaAlcoholDrogas_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="id_camp_alcoholdrogas", nullable=false)
    private Long idCampanaAlcoholDrogas       ;

    @Column(name="id_adhesion")
    private Long idAdhesion   ;
    
    @ManyToOne
    @JoinColumn(name="ID_ADHESION", referencedColumnName="ID_ADHESION", insertable=false, updatable=false)
    private CampanaAdhesionEntity campanaAdhesion;
    
    @Column(name="fecha_camp_alcoholdrogas")
    private Date fechaCampanaAlcoholDrogas;
    
    @Column(name="id_tipo_camp_alcoholdrogas")
    private Long idTipoCampanaAlcoholDrogas   ;
    
  	@Column(name="numPruebasRealizadasAlc")
	private Long numPruebasRealizadasAlc;
	
	@Column(name="numPositivo015")
	private Long numPositivo015;
	
	@Column(name="numPositivo025")
	private Long numPositivo025;
	
	@Column(name="codigoPenal")
	private Long codigoPenal;
	
	@Column(name="numTotalPositivasAlc")
	private Long numTotalPositivasAlc;
	
	@Column(name="numDiligDenunciaNegPruebaAlc")
	private Long numDiligDenunciaNegPruebaAlc;
	
	@Column(name="numExtracSangreSolicAlc")
	private Long numExtracSangreSolicAlc;
	
	@Column(name="numPruebasRealizadasDrogas")
	private Long numPruebasRealizadasDrogas;
	
	@Column(name="numDiligenciasDrogas")
	private Long numDiligenciasDrogas;
	
	@Column(name="numDenunciasDrogas")	
	private Long numDenunciasDrogas;
	
	@Column(name="numTotalPositivasDrogas")
	private Long numTotalPositivasDrogas;
	
	@Column(name="numCocaina")
	private Long numCocaina;
	
	@Column(name="numAnfetamina")
	private Long numAnfetamina;
	
	@Column(name="numCannabis")
	private Long numCannabis;
	
	@Column(name="numOpioides")
	private Long numOpioides;
	
	@Column(name="numMetanfetamina")
	private Long numMetanfetamina;
	
	@Column(name="numNegativasSignoClinicDrogas")
	private Long numNegativasSignoClinicDrogas;
	
	@Column(name="numDiligDenunciaNegPruebaDrogas")
	private Long numDiligDenunciaNegPruebaDrogas;
	
	@Column(name="numExtracSangreSolicDrogas")
	private Long numExtracSangreSolicDrogas;
	
	@Column(name="numImposibilidadSalivar")
	private Long numImposibilidadSalivar;

    //----------------------------------------------------------------------
    // CONSTRUCTOR(S)
    //----------------------------------------------------------------------
    public CampanaAlcoholDrogasEntity() {
		super();
    }


    
    //----------------------------------------------------------------------
    // GETTER & SETTER FOR THE KEY FIELD
    //----------------------------------------------------------------------
  
  
    
	public Long getIdCampanaAlcoholDrogas() {
		return idCampanaAlcoholDrogas;
	}

	public void setIdCampanaAlcoholDrogas(Long idCampanaAlcoholDrogas) {
		this.idCampanaAlcoholDrogas = idCampanaAlcoholDrogas;
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

	public Date getFechaCampanaAlcoholDrogas() {
		return fechaCampanaAlcoholDrogas;
	}

	public void setFechaCampanaAlcoholDrogas(Date fechaCampanaAlcoholDrogas) {
		this.fechaCampanaAlcoholDrogas = fechaCampanaAlcoholDrogas;
	}

	public Long getIdTipoCampanaAlcoholDrogas() {
		return idTipoCampanaAlcoholDrogas;
	}

	public void setIdTipoCampanaAlcoholDrogas(Long idTipoCampanaAlcoholDrogas) {
		this.idTipoCampanaAlcoholDrogas = idTipoCampanaAlcoholDrogas;
	}
	public Long getNumPruebasRealizadasAlc() {
		return numPruebasRealizadasAlc;
	}

	public void setNumPruebasRealizadasAlc(Long numPruebasRealizadasAlc) {
		this.numPruebasRealizadasAlc = numPruebasRealizadasAlc;
	}

	public Long getNumPositivo015() {
		return numPositivo015;
	}

	public void setNumPositivo015(Long numPositivo015) {
		this.numPositivo015 = numPositivo015;
	}

	public Long getNumPositivo025() {
		return numPositivo025;
	}

	public void setNumPositivo025(Long numPositivo025) {
		this.numPositivo025 = numPositivo025;
	}

	public Long getCodigoPenal() {
		return codigoPenal;
	}

	public void setCodigoPenal(Long codigoPenal) {
		this.codigoPenal = codigoPenal;
	}

	public Long getNumTotalPositivasAlc() {
		return numTotalPositivasAlc;
	}

	public void setNumTotalPositivasAlc(Long numTotalPositivasAlc) {
		this.numTotalPositivasAlc = numTotalPositivasAlc;
	}

	public Long getNumDiligDenunciaNegPruebaAlc() {
		return numDiligDenunciaNegPruebaAlc;
	}

	public void setNumDiligDenunciaNegPruebaAlc(Long numDiligDenunciaNegPruebaAlc) {
		this.numDiligDenunciaNegPruebaAlc = numDiligDenunciaNegPruebaAlc;
	}

	public Long getNumExtracSangreSolicAlc() {
		return numExtracSangreSolicAlc;
	}

	public void setNumExtracSangreSolicAlc(Long numExtracSangreSolicAlc) {
		this.numExtracSangreSolicAlc = numExtracSangreSolicAlc;
	}

	public Long getNumPruebasRealizadasDrogas() {
		return numPruebasRealizadasDrogas;
	}

	public void setNumPruebasRealizadasDrogas(Long numPruebasRealizadasDrogas) {
		this.numPruebasRealizadasDrogas = numPruebasRealizadasDrogas;
	}

	public Long getNumDiligenciasDrogas() {
		return numDiligenciasDrogas;
	}

	public void setNumDiligenciasDrogas(Long numDiligenciasDrogas) {
		this.numDiligenciasDrogas = numDiligenciasDrogas;
	}

	public Long getNumDenunciasDrogas() {
		return numDenunciasDrogas;
	}

	public void setNumDenunciasDrogas(Long numDenunciasDrogas) {
		this.numDenunciasDrogas = numDenunciasDrogas;
	}

	public Long getNumTotalPositivasDrogas() {
		return numTotalPositivasDrogas;
	}

	public void setNumTotalPositivasDrogas(Long numTotalPositivasDrogas) {
		this.numTotalPositivasDrogas = numTotalPositivasDrogas;
	}

	public Long getNumCocaina() {
		return numCocaina;
	}

	public void setNumCocaina(Long numCocaina) {
		this.numCocaina = numCocaina;
	}

	public Long getNumAnfetamina() {
		return numAnfetamina;
	}

	public void setNumAnfetamina(Long numAnfetamina) {
		this.numAnfetamina = numAnfetamina;
	}

	public Long getNumCannabis() {
		return numCannabis;
	}

	public void setNumCannabis(Long numCannabis) {
		this.numCannabis = numCannabis;
	}

	public Long getNumOpioides() {
		return numOpioides;
	}

	public void setNumOpioides(Long numOpioides) {
		this.numOpioides = numOpioides;
	}

	public Long getNumMetanfetamina() {
		return numMetanfetamina;
	}

	public void setNumMetanfetamina(Long numMetanfetamina) {
		this.numMetanfetamina = numMetanfetamina;
	}

	public Long getNumNegativasSignoClinicDrogas() {
		return numNegativasSignoClinicDrogas;
	}

	public void setNumNegativasSignoClinicDrogas(Long numNegativasSignoClinicDrogas) {
		this.numNegativasSignoClinicDrogas = numNegativasSignoClinicDrogas;
	}

	public Long getNumDiligDenunciaNegPruebaDrogas() {
		return numDiligDenunciaNegPruebaDrogas;
	}

	public void setNumDiligDenunciaNegPruebaDrogas(Long numDiligDenunciaNegPruebaDrogas) {
		this.numDiligDenunciaNegPruebaDrogas = numDiligDenunciaNegPruebaDrogas;
	}

	public Long getNumExtracSangreSolicDrogas() {
		return numExtracSangreSolicDrogas;
	}

	public void setNumExtracSangreSolicDrogas(Long numExtracSangreSolicDrogas) {
		this.numExtracSangreSolicDrogas = numExtracSangreSolicDrogas;
	}

	public Long getNumImposibilidadSalivar() {
		return numImposibilidadSalivar;
	}

	public void setNumImposibilidadSalivar(Long numImposibilidadSalivar) {
		this.numImposibilidadSalivar = numImposibilidadSalivar;
	}

	@Override
	public String toString() {
		return "CampanaAlcoholDrogasEntity [idCampanaAlcoholDrogas=" + idCampanaAlcoholDrogas + ", idAdhesion="
				+ idAdhesion + ", campanaAdhesion=" + campanaAdhesion + ", fechaCampanaAlcoholDrogas="
				+ fechaCampanaAlcoholDrogas + ", idTipoCampanaAlcoholDrogas=" + idTipoCampanaAlcoholDrogas
				+ ", numPruebasRealizadasAlc="
				+ numPruebasRealizadasAlc + ", numPositivo015=" + numPositivo015 + ", numPositivo025=" + numPositivo025
				+ ", codigoPenal=" + codigoPenal + ", numTotalPositivasAlc=" + numTotalPositivasAlc
				+ ", numDiligDenunciaNegPruebaAlc=" + numDiligDenunciaNegPruebaAlc + ", numExtracSangreSolicAlc="
				+ numExtracSangreSolicAlc + ", numPruebasRealizadasDrogas=" + numPruebasRealizadasDrogas
				+ ", numDiligenciasDrogas=" + numDiligenciasDrogas + ", numDenunciasDrogas=" + numDenunciasDrogas
				+ ", numTotalPositivasDrogas=" + numTotalPositivasDrogas + ", numCocaina=" + numCocaina
				+ ", numAnfetamina=" + numAnfetamina + ", numCannabis=" + numCannabis + ", numOpioides=" + numOpioides
				+ ", numMetanfetamina=" + numMetanfetamina + ", numNegativasSignoClinicDrogas="
				+ numNegativasSignoClinicDrogas + ", numDiligDenunciaNegPruebaDrogas=" + numDiligDenunciaNegPruebaDrogas
				+ ", numExtracSangreSolicDrogas=" + numExtracSangreSolicDrogas + ", numImposibilidadSalivar="
				+ numImposibilidadSalivar + "]";
	}


	
}
