// This Bean has a basic Primary Key (not composite) 

package com.cgt.entity;

import java.io.Serializable;
import java.util.Date;

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
 * Persistent class for entity stored in table "VERIF_DOCUMENTOS"
 *
 * @author 
 *
 */

@Entity
@Table(name="VERIF_DOCUMENTOS", schema="CINETI" )
// Define named queries here
@NamedQueries ( {
  @NamedQuery ( name="VerifDocumentosEntity.countAll", query="SELECT COUNT(x) FROM VerifDocumentosEntity x" )
} )
@SequenceGenerator(name= "verifDoc_id_seq_gen", sequenceName="CINETI.SEQ_VERIF_DOCUMENTOS", allocationSize=5,initialValue=100)
public class VerifDocumentosEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    //----------------------------------------------------------------------
    // ENTITY PRIMARY KEY ( BASED ON A SINGLE FIELD )
    //----------------------------------------------------------------------
    @Id
    @GeneratedValue(generator = "verifDoc_id_seq_gen", strategy = GenerationType.SEQUENCE)
    @Column(name="ID_DOCUMENTO")
    private Long     idDocumento     ;


    //----------------------------------------------------------------------
    // ENTITY DATA FIELDS 
    //----------------------------------------------------------------------    
    @Column(name="TIPO_DOC",length=100)
    private String     tipoDocumento     ;


	@Column(name="NOMBRE", length=100)
    private String     nombre    ;
	
	@Column(name="DESCRIPCION", length=250)
    private String     descripcion    ;

    @Column(name="FEC_SUBIDA", nullable=false)
    private Date     fecSubida      ;

    @Column(name="FORMATO", length=50)
    private String     formato ;

    @Column(name="ID_VERIFICACION", nullable=false)
	private Long    idVerif     ;
    
    @Column(name="SIZE")
    private Long size;
    
    @Column(name="DATA")
    private byte[] data;
    
    

	public Long getIdDocumento() {
		return idDocumento;
	}

	public void setIdDocumento(Long idDocumento) {
		this.idDocumento = idDocumento;
	}

	public String getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getFecSubida() {
		return fecSubida;
	}

	public void setFecSubida(Date fecSubida) {
		this.fecSubida = fecSubida;
	}

	public String getFormato() {
		return formato;
	}

	public void setFormato(String formato) {
		this.formato = formato;
	}	

	public Long getIdVerif() {
		return idVerif;
	}

	public void setIdVerif(Long idVerif) {
		this.idVerif = idVerif;
	}

	public Long getSize() {
		return size;
	}

	public void setSize(Long size) {
		this.size = size;
	}
	
	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "VerifDocumentosEntity [idDocumento=" + idDocumento + ", tipoDocumento=" + tipoDocumento + ", nombre="
				+ nombre + ", descripcion=" + descripcion + ", fecSubida=" + fecSubida + ", formato=" + formato
				+ ", idVerif=" + idVerif + ", size=" + size + "]";
	}

	
}