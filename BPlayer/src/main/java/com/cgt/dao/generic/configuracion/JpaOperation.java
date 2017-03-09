package com.cgt.dao.generic.configuracion;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;


/**
 * 
 * @author apascual
 *
 */
public interface JpaOperation {

	/**
	 * Ejecuta una operación JPA usando el entitymanager dado
	 * @param em EntityManager que vamos a usar
	 * @return Object
	 * @throws PersistenceException
	 */
	public Object ejecutar(EntityManager em) throws PersistenceException;
	
}
