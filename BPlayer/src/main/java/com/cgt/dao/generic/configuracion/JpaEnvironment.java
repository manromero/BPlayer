package com.cgt.dao.generic.configuracion;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;

/**
 * 
 * @author apascual
 *
 */
public class JpaEnvironment {

	private final String persistenceUnitName;
	private final EntityManagerFactory emf;

	/**
	 * Constructor
	 * 
	 * @param persistenceUnitName nombre de la unidad de persistencia JPA usada
	 */
	public JpaEnvironment(String persistenceUnitName) {
		super();
		this.persistenceUnitName = persistenceUnitName;
		this.emf = Persistence.createEntityManagerFactory(persistenceUnitName);
	}

	public final String getPersistenceUnitName() {
		return this.persistenceUnitName;
	}

	public final Object executeWithTransaction(JpaOperation operation) throws PersistenceException {
		Object result = null;
		EntityManager em = emf.createEntityManager();
		try {
			EntityTransaction transaction = em.getTransaction();
			try {
				// Empieza la transacción
				transaction.begin();
				// Ejecutamos la operación actual
				// EntityManager
				result = operation.ejecutar(em);
				// Commit Transaction
				transaction.commit();
			} finally {
				// Rollback Transaction si la transacción aún sigue activo (No hace commit)
				if (transaction.isActive())
					transaction.rollback();
			}
		} finally {
			//Garantizamos que se cierre el EntityManager
			em.close();
		}
		return result;
	}

	public final Object executeWithoutTransaction(JpaOperation operation) throws PersistenceException {
		Object result = null;
		EntityManager em = emf.createEntityManager();
		try {
			// Ejecutamos la operación con el entitymanager actual
			result = operation.ejecutar(em);
		} finally {
			//Garantizamos que se cierre el EntityManager
			em.close();
		}
		return result;
	}
}
