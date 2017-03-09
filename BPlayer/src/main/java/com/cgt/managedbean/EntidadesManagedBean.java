package com.cgt.managedbean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cgt.dto.CesionDto;
import com.cgt.dto.ConvenioDto;
import com.cgt.dto.EntidadDto;
import com.cgt.dto.EquipamientoDto;
import com.cgt.dto.EstadoEquipamientoDto;
import com.cgt.dto.LocalidadDto;
import com.cgt.dto.PersContactoDto;
import com.cgt.dto.ProvinciaDto;
import com.cgt.dto.TipoEquipamientoDto;
import com.cgt.services.CesionesService;
import com.cgt.services.ConveniosService;
import com.cgt.services.EntidadesService;
import com.cgt.services.EquipamientoService;
import com.cgt.services.EstadoEquipamientoService;
import com.cgt.services.LocalidadesService;
import com.cgt.services.ProvinciasService;
import com.cgt.services.TipoEquipamientoService;

@ManagedBean
@Scope("session")
@SessionScoped
@Component
public class EntidadesManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4397567972062588660L;
	
	//Log4j
	private static final Logger logger = Logger.getLogger(EntidadesManagedBean.class);
	
	@Autowired
	private ProvinciasService provinciasService;
	
	@Autowired
	private LocalidadesService localidadesService;
	
	@Autowired
	private EntidadesService entidadesService;
	
	@Autowired
	private CesionesService cesionesService;
	
	@Autowired
	private ConveniosService conveniosService;
	
	@Autowired
	private TipoEquipamientoService tipoEquipamientoService;
	
	@Autowired
	private EstadoEquipamientoService estadoEquipamientoService;
	
	@Autowired
	private EquipamientoService equipamientoService;
	
	private List<CesionDto> listCesionDto; //Convenios que aparareceran en el fieldSet "Convenios"
	private List<ConvenioDto> listConvenioDto; //Cesiones que aparareceran en el fieldSet "Cesiones"
	private List<ProvinciaDto> listProvinciaDto; //Provincias que tiene asociado un usuario
	private List<LocalidadDto> listLocalidadDto; //Localidades que tiene asociada una determinada provincia
	private List<EntidadDto> listEntidadDto; //Entidades que tiene asociada una determinada localidad
	
	private Long filtroProvincia; //Provincia Seleccionada en el filtro
	private Long filtroLocalidad; //Localidad seleccionada en el filtro
	private Long filtroEntidad; //Entidad seleccionada en el filtro
	
	//Variables Dialog cesiones
	private CesionDto cesionDtoSelected; //Cesion Seleccionada de la tabla cesiones
	private List<TipoEquipamientoDto> listTipoEquipamientoDto;//Posibles tipos de un equipamientos. Se muestran en el dialog de cesiones
	private Long filtroTipoEquipamiento;//TipoEquipamientoSeleccionado
	private List<EstadoEquipamientoDto> listEstadoEquipamientoDto;//Posibles estados de un equipamiento. Se muestran en el dialog de cesiones
	private List<EquipamientoDto> listEquipamientoDtoDisponibles;//Son aquellos que tienen estado disponible
	private List<PersContactoDto> listPersContactoDtoEntidad;//Personas de contacto que tiene una determinada entidad
		
	//Variables Dialog convenios
	
	@PostConstruct
	public void init(){
		logger.info("Accediendo a EntidadesManagedBean");
		inicializarVariables();
	}
	
	public String irAEntidades(){
		inicializarVariables();
		return "entidades";
	}
	
	/**
	 * Inicializas las variables del ManagedBean
	 */
	public void inicializarVariables(){
		listProvinciaDto = provinciasService.findProvinciasAsociadasAusuario(LoginManagedBean.usuarioLogado);
		listLocalidadDto = new ArrayList<>(); //Hasta que no se selecciones una provincia no se rellenara
		listEntidadDto = new ArrayList<>(); //Hasta que no se seleccione una localidad no se rellenara
		listCesionDto = new ArrayList<>(); //Hasta que no se seleccione una provincia, municipio o entidad no se rellenará
		listConvenioDto = new ArrayList<>(); //Hasta que no se seleccione una provincia, municipio o entidad no se rellenará
		filtroProvincia = 0l;
		filtroLocalidad = 0l;
		filtroEntidad = 0l;
		cesionDtoSelected = new CesionDto();
		listTipoEquipamientoDto = tipoEquipamientoService.findAll();
		filtroTipoEquipamiento = 0l;
		listEstadoEquipamientoDto = estadoEquipamientoService.findAll();
		listEquipamientoDtoDisponibles = equipamientoService.findEquipamientosDisponibles();
		listPersContactoDtoEntidad = new ArrayList<>();
	}
	
	/**
	 * A esta funcion se llama cuando se selecciona una provincia en el fielSet "Filtro"
	 * Si se ha seleccionado una provincia se muestran las cesiones y convenios con dicha provincia
	 * En caso contrario no se mostrara ninguna cesion ni convenio
	 */
	public void onFiltroProvinciaChange(){
		listLocalidadDto.clear();
		listEntidadDto.clear();
		filtroLocalidad = 0l;
		filtroEntidad = 0l;
		listCesionDto.clear();
		listConvenioDto.clear();
		if(!filtroProvincia.equals(0l)){
			//Se actualizan las variables del filtro
			listLocalidadDto = localidadesService.findByIdProvincia(filtroProvincia);
			//Se actualizan las cesiones y los convenios
			listCesionDto = cesionesService.findCesionesByIdProvincia(filtroProvincia);
			listConvenioDto = conveniosService.findConveniosByIdProvincia(filtroProvincia);
		}
	}
	
	/**
	 * A esta funcion se llama cuando se selecciona una localidad en el fielSet "Filtro"
	 * Si se ha seleccionado una localidad se muestran las cesiones y convenios con dicha localidad
	 * en caso contrario se muestra las de la localidad
	 */
	public void onFiltroLocalidadChange(){
		listEntidadDto.clear();
		filtroEntidad = 0l;
		listCesionDto.clear();
		listConvenioDto.clear();
		if(!filtroLocalidad.equals(0l)){
			listEntidadDto = entidadesService.findByIdLocalidad(filtroLocalidad);
			//filtrar cesiones y convenios por filtroLocalidad
			listCesionDto = cesionesService.findCesionesByIdLocalidad(filtroLocalidad);
			listConvenioDto = conveniosService.findConveniosByIdLocalidad(filtroLocalidad);
		}else{
			//Actualizamos como si solo se hubiera seleccionado una provincia
			onFiltroProvinciaChange();
		}
	}
	
	/**
	 * A esta funcion se llama cuando se selecciona una entidad
	 * Si se ha seleccionado una entidad se muestran las cesiones y convenios con dicha entidad
	 * en caso contrario se muestra las de la localidad
	 */
	public void onFiltroEntidadChange(){
		listCesionDto.clear();
		listConvenioDto.clear();
		if(!filtroEntidad.equals(0l)){
			//filtrar cesiones y convenios por filtroEntidad
			listCesionDto = cesionesService.findCesionesByIdEntidad(filtroEntidad);
			listConvenioDto = conveniosService.findConveniosByIdEntidad(filtroEntidad);
		}else{
			//Actualizamos como si solo se hubiera seleccionado una localidad
			onFiltroLocalidadChange();
		}
	}
	
	/**
	 * A esta funcion se llama cuando se selcciona un equipamiento
	 * cesionDtoSelected tendrá ademas el equipamiento, contactos y documentos asociados 
	 */
	public void onCesionSelected(SelectEvent event){
		Long idCesionDtoSelected = ((CesionDto) event.getObject()).getId();
		cesionDtoSelected = cesionesService.findCesionFullByIdCesion(idCesionDtoSelected);
	}
	
	/**
	 * A esta funcion se llama cuando se selecciona un tipo de equipamiento en cesiones
	 * Si se selecciona un tipo de equipamiento filtra por ese tipo
	 * en caso contrario muestra todos los equipamientos disponibles
	 */
	public void onDialogCesionesTipoEquipamientoChange(){
		if(!filtroTipoEquipamiento.equals(0l)){
			listEquipamientoDtoDisponibles = equipamientoService.findEquipamientosDisponiblesByIdTipoEquipamiento(filtroTipoEquipamiento);
		}else{
			listEquipamientoDtoDisponibles = equipamientoService.findEquipamientosDisponibles();
		}
	}
	
	/*
	 **************************************************************************************************** 
	 * **************************************************************************************************
	 * ****************************************GETTERS AND SETTERS***************************************
	 * **************************************************************************************************
	 * **************************************************************************************************
	 */

	public List<CesionDto> getListCesionDto() {
		return listCesionDto;
	}

	public void setListCesionDto(List<CesionDto> listCesionDto) {
		this.listCesionDto = listCesionDto;
	}

	public List<ConvenioDto> getListConvenioDto() {
		return listConvenioDto;
	}

	public void setListConvenioDto(List<ConvenioDto> listConvenioDto) {
		this.listConvenioDto = listConvenioDto;
	}

	public List<ProvinciaDto> getListProvinciaDto() {
		return listProvinciaDto;
	}

	public void setListProvinciaDto(List<ProvinciaDto> listProvinciaDto) {
		this.listProvinciaDto = listProvinciaDto;
	}

	public Long getFiltroProvincia() {
		return filtroProvincia;
	}

	public void setFiltroProvincia(Long filtroProvincia) {
		this.filtroProvincia = filtroProvincia;
	}

	public Long getFiltroLocalidad() {
		return filtroLocalidad;
	}

	public void setFiltroLocalidad(Long filtroLocalidad) {
		this.filtroLocalidad = filtroLocalidad;
	}

	public Long getFiltroEntidad() {
		return filtroEntidad;
	}

	public void setFiltroEntidad(Long filtroEntidad) {
		this.filtroEntidad = filtroEntidad;
	}

	public List<LocalidadDto> getListLocalidadDto() {
		return listLocalidadDto;
	}

	public void setListLocalidadDto(List<LocalidadDto> listLocalidadDto) {
		this.listLocalidadDto = listLocalidadDto;
	}

	public List<EntidadDto> getListEntidadDto() {
		return listEntidadDto;
	}

	public void setListEntidadDto(List<EntidadDto> listEntidadDto) {
		this.listEntidadDto = listEntidadDto;
	}
	
	public CesionDto getCesionDtoSelected() {
		return cesionDtoSelected;
	}

	public void setCesionDtoSelected(CesionDto cesionDtoSelected) {
		this.cesionDtoSelected = cesionDtoSelected;
	}
	
	public List<TipoEquipamientoDto> getListTipoEquipamientoDto() {
		return listTipoEquipamientoDto;
	}

	public void setListTipoEquipamientoDto(List<TipoEquipamientoDto> listTipoEquipamientoDto) {
		this.listTipoEquipamientoDto = listTipoEquipamientoDto;
	}

	public Long getFiltroTipoEquipamiento() {
		return filtroTipoEquipamiento;
	}

	public void setFiltroTipoEquipamiento(Long filtroTipoEquipamiento) {
		this.filtroTipoEquipamiento = filtroTipoEquipamiento;
	}

	public List<EstadoEquipamientoDto> getListEstadoEquipamientoDto() {
		return listEstadoEquipamientoDto;
	}

	public void setListEstadoEquipamientoDto(List<EstadoEquipamientoDto> listEstadoEquipamientoDto) {
		this.listEstadoEquipamientoDto = listEstadoEquipamientoDto;
	}

	public List<EquipamientoDto> getListEquipamientoDtoDisponibles() {
		return listEquipamientoDtoDisponibles;
	}

	public void setListEquipamientoDtoDisponibles(List<EquipamientoDto> listEquipamientoDtoDisponibles) {
		this.listEquipamientoDtoDisponibles = listEquipamientoDtoDisponibles;
	}

	public List<PersContactoDto> getListPersContactoDtoEntidad() {
		return listPersContactoDtoEntidad;
	}

	public void setListPersContactoDtoEntidad(List<PersContactoDto> listPersContactoDtoEntidad) {
		this.listPersContactoDtoEntidad = listPersContactoDtoEntidad;
	}
	
}