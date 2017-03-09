package com.cgt.services;

import java.util.List;

import com.cgt.dto.CesionDto;

public interface CesionesService {
	
	/**
	 * Devuelve una lista de CesionDto que esten asociadas a una determinada provincia
	 * @return
	 */
	public List<CesionDto> findCesionesByIdProvincia(Long idProvincia);
	
	/**
	 * Devuelve una lista de CesionDto que esten asociadas a una determinada localidad
	 * @return
	 */
	public List<CesionDto> findCesionesByIdLocalidad(Long idLocalidad);
	
	/**
	 * Devuelve una lista de CesionDto que esten asociadas a una determinada entidad
	 * @return
	 */
	public List<CesionDto> findCesionesByIdEntidad(Long idEntidad);
	
	/**
	 * Devuelve la cesion seleccionada por su id. 
	 * En la cesion NO se incluiran:
	 * listPersContactoDto, lista de persContacto de la cesion
	 * listCesDocumentosDto, lista de documentos de la cesion
	 * @return
	 */
	public CesionDto findByIdCesion(Long idCesion);

	/**
	 * Devuelve la cesion seleccionada por su id. 
	 * En la cesion se incluiran además:
	 * listPersContactoDto, lista de persContacto de la cesion
	 * listCesDocumentosDto, lista de documentos de la cesion
	 * @return
	 */
	public CesionDto findCesionFullByIdCesion(Long idCesion);


}
