package com.cgt.dao.generic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cgt.dao.generic.configuracion.JpaEnvironment;
import com.cgt.dao.generic.configuracion.JpaEnvironments;
import com.cgt.dao.generic.configuracion.JpaOperation;
import com.cgt.dao.generic.configuracion.PersistenceServiceProvider;

/**
 * DAO Genérico en el que se inicia el Entity Manager
 * @author apascual
 * 
 * @param <T>
 * @param <PK>
 */
@SuppressWarnings("unchecked")
@Repository
public abstract class GenericDaoImpl<T, PK extends java.io.Serializable> {

	//Estos tres atributos los tengo aquí para poder proveer a mis DAOIMPL del entitymanager en bruto
	private String persistenceUnitName ; 
	public static EntityManagerFactory entityManagerFactory ; 
	public static EntityManager entityManager;
	
	private static final boolean TRANSACTIONAL = true ;
	private static final Predicate[] VOID_PREDICATE_ARRAY = {};
	/**
	 * Clase de la entidad gestionada por el servicio concreto
	 */
	private final Class<T> persistentClass;
	
	/**
	 * Constructor en el que iniciamos el entity manager factory e indicamos nuestra unidad de persistencia
	 */
	public GenericDaoImpl(final Class<T> persistentClasss) {
		this.persistentClass = persistentClasss;
		//Esta parte la dejo para poder manejar yo libremente en mis DAOIMPL el EntityManager con total soltura
		if(entityManagerFactory == null){
			this.persistenceUnitName = "persistence-unit1" ;
			entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
			if(entityManagerFactory != null){
				entityManager = entityManagerFactory.createEntityManager();
			}
		}
	}
	
	/**
	 * Ejecuta una operación JPA no transaccional con un entitymanager específico<br>
	 * (Se crea al comienzo de la ejecución y se cierra al final)
	 * 
	 * @param operation Operación a ejecutar
	 * @return result Object
	 * @throws PersistenceException
	 */
	protected final Object ejecutar(JpaOperation operation) throws PersistenceException {
		return ejecutar(operation, false) ;
	}

	/**
	 * Ejecuta una operación JPA (transaccional o no) con un entitymanager específico<br>
	 * (Se crea al comienzo de la ejecución y se cierra al final)
	 * 
	 * @param operation Operación a ejecutar
	 * @param transactional true si quieres que sea transactional, false si no  
	 * @return result Object
	 * @throws PersistenceException
	 */
	protected final Object ejecutar(JpaOperation operation, boolean transactional) throws PersistenceException {
		JpaEnvironment jpaEnvironment = JpaEnvironments.getInstance().getJpaEnvironment(PersistenceServiceProvider.JPA_PERSISTENCE_UNIT_NAME);
		if ( transactional ) {
			return jpaEnvironment.executeWithTransaction(operation) ;
		}
		else {
			return jpaEnvironment.executeWithoutTransaction(operation) ;
			
		}
	}
	
	/**
	 * Encuentra entity pasándole por parámetro su id
	 * @param id Long
	 * @return Entidad
	 */
	public T getElementById(final Long id) {
		// Definición de la operación JPA
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object ejecutar(EntityManager em) throws PersistenceException {
				return em.find(persistentClass, id);
			}
		} ;
		// Ejecución de la operación JPA
		return (T) ejecutar(operation) ;
	}

	/**
	 * Devuelve una lista con todas las entidades
	 * @param <T>
	 * @param query
	 * @return Lista con todas las tuplas del entity
	 */
	public List<T> findAll() {
		// Definición de la operación JPA 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object ejecutar(EntityManager em) throws PersistenceException {
				final Query query = em.createQuery("from " + persistentClass.getName());
				return query.getResultList();
			}
		} ;
		// Ejecución de la operación JPA 
		return (List<T>) ejecutar(operation) ;
	}

	/**
	 * Devuelve una lista de entity usando un namedquery sin pasarle parámetros
	 * @param queryName
	 * @return
	 */
	public List<T> findByNamedQuery(final String queryName) {
		// Definición de la operación JPA 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object ejecutar(EntityManager em) throws PersistenceException {
				final Query query = em.createNamedQuery(queryName);
				return query.getResultList();
			}
		} ;
		// Ejecución de la operación JPA
		return (List<T>) ejecutar(operation) ;
	}

	/**
	 * Devuelve una lista de entity usando un namedquery pasándole parámetros
	 * @param String queryName
	 * @param Map<String, Object> queryParameters
	 * @return List<T>
	 */
	public List<T> findByNamedQuery(final String queryName, final Map<String, Object> queryParameters) {
		// Definición de la operación JPA 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object ejecutar(EntityManager em) throws PersistenceException {
				final Query query = em.createNamedQuery(queryName);
				final Iterator<String> i = queryParameters.keySet().iterator();
				while (i.hasNext()) {
					String key = i.next();
					query.setParameter(key, queryParameters.get(key));
				}				
				return query.getResultList();
			}
		} ;
		// Ejecución de la operación JPA 
		return (List<T>) ejecutar(operation) ;
	}

	/**
	 * Insertar entity (persist) ( TRANSACTIONAL )
	 * @param Entity
	 * @return void
	 */
	public void insert(final T entity) {
		// Definición de la operación JPA 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object ejecutar(EntityManager em) throws PersistenceException {
				em.persist(entity);
				return null;
			}
		} ;
		// Ejecución de la operación JPA 
		ejecutar(operation, TRANSACTIONAL) ;
	}

	/**
	 * guarda el entity pasado por parámetro (merge) ( TRANSACTIONAL )
	 * @param entity a guardar
	 * @return Entity
	 */
	public T guardarEntity(final T entityToSave) {
		// Definición de la operación JPA 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object ejecutar(EntityManager em) throws PersistenceException {
				T managedEntity = em.merge(entityToSave);
				return managedEntity;
			}
		} ;
		// Ejecución de la operación JPA 
		return (T) ejecutar(operation, TRANSACTIONAL) ;
	}
	
	/**
	 * Borra una entity pasándole por parámetro su PK (remove) ( TRANSACTIONAL )
	 * @param primaryKey
	 * @return boolean (true si la encuentra para eliminarla, false si no)
	 */
	public boolean deleteEntityByPK(final PK primaryKey) {
		// Definición de la operación JPA 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object ejecutar(EntityManager em) throws PersistenceException {
				final T entity = em.find(persistentClass, primaryKey);
				if (entity != null) {
					em.remove(entity);
					return Boolean.TRUE ;
				}
				else {
					return Boolean.FALSE ;
				}
			}
		} ;
		// Ejecución de la operación JPA 
		Boolean b = (Boolean) ejecutar(operation, TRANSACTIONAL) ;
		return b.booleanValue();
	}

	/**
	 * Devuelve una lista de nuestra entity pasándole parámetros <br>
	 * @param los parámetros de consulta que serán utilizados (pueden venir a null)
	 * @return
	 */
	public List<T> search( final Map<String, Object> queryParameters ) {
		if ( queryParameters != null  ) {
			return this.busquedaConParametros(queryParameters);
		}
		else {
			return this.findAll();
		}
	}
	
	/**
	 * Busca usando los parámetros de consulta que le pasamos
	 * @param los parámetros de consulta que serán utilizados (NO pueden venir a null)
	 * @return
	 */
	private List<T> busquedaConParametros( final Map<String, Object> queryParameters ) {
		// Definición de la operación JPA 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object ejecutar(EntityManager em) throws PersistenceException {
				CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
				CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(persistentClass);
				Root<T> from = criteriaQuery.from(persistentClass);

				List<Predicate> predicates = new ArrayList<Predicate>();

				for ( Map.Entry<String, Object> e : queryParameters.entrySet() ) {
					String expression = e.getKey() ;
					Object value = e.getValue() ;
					
					System.out.println("=== Criterion : " + expression + " : " + value );
					
					if ( value != null ) {
						boolean operatorFound = false ;
						int i = expression.indexOf(' ') ;
						if ( i >= 0 ) {
							String name = expression.substring(0, i);
							String oper = expression.substring(i, expression.length()).trim();
							System.out.println("name = '" + name + "'   oper = '" + oper + "'  value = '" + value + "'" );
							if ( oper.length() > 0 ) {
								operatorFound = true ;
								if ( value instanceof String ) {
									String strValue = (String) value ;
									if ( "=".equalsIgnoreCase(oper) ) {
										Predicate p = criteriaBuilder.equal( from.get(name), strValue ) ;
										predicates.add(p) ;
									}
									else if ( "like".equalsIgnoreCase(oper) ) {
										Predicate p = criteriaBuilder.like( from.<String>get(name), strValue ) ;
										predicates.add(p) ;
									}
									else {
										throw new RuntimeException("Search : invalid operator '" + oper +"' for String attribute") ;
									}
								}
								else if ( value instanceof Number ) {
									Number numValue = (Number) value ;
									if ( "=".equalsIgnoreCase(oper) ) {
										Predicate p = criteriaBuilder.equal( from.<Number>get(name), numValue ) ;
										predicates.add(p) ;
									}
									else if ( "!=".equalsIgnoreCase(oper) || "<>".equalsIgnoreCase(oper)) {
										Predicate p = criteriaBuilder.notEqual( from.<Number>get(name), numValue ) ;
										predicates.add(p) ;
									}
									else if ( ">".equalsIgnoreCase(oper) ) {
										Predicate p = criteriaBuilder.gt( from.<Number>get(name), numValue ) ;
										predicates.add(p) ;
									}
									else if ( "<".equalsIgnoreCase(oper) ) {
										Predicate p = criteriaBuilder.lt( from.<Number>get(name), numValue ) ;
										predicates.add(p) ;
									}
									else if ( ">=".equalsIgnoreCase(oper) ) {
										Predicate p = criteriaBuilder.ge( from.<Number>get(name), numValue ) ;
										predicates.add(p) ;
									}
									else if ( "<=".equalsIgnoreCase(oper) ) {
										Predicate p = criteriaBuilder.le( from.<Number>get(name), numValue ) ;
										predicates.add(p) ;
									}
									else {
										throw new RuntimeException("Search : invalid operator '" + oper +"' for Number attribute") ;
									}
								}
							}
						}
						if ( ! operatorFound ) {
							predicates.add( criteriaBuilder.equal( from.get(expression), value ) ) ;
						}
					}
				}
				
				criteriaQuery.where( predicates.toArray(VOID_PREDICATE_ARRAY) );
				
				TypedQuery<T> typedQuery = em.createQuery(criteriaQuery);
				return typedQuery.getResultList();
			}
		} ;
		// Ejecución de la operación JPA 
		return (List<T>) ejecutar(operation) ;
	}
	
	/**
	 * Elimina una entidad pasándole su ID
	 * @param id
	 * @return
	 */
	public boolean deleteById(final Long id) {
		// Definición de la operación JPA 
		JpaOperation operation = new JpaOperation() {
			@Override
			public Object ejecutar(EntityManager em) throws PersistenceException {
				final T entity = em.find(persistentClass, id);
				if (entity != null) {
					em.remove(entity);
					return Boolean.TRUE ;
				}
				else {
					return Boolean.FALSE ;
				}
			}
		} ;
		// Ejecución de la operación JPA 
		Boolean b = (Boolean) ejecutar(operation, TRANSACTIONAL) ;
		return b.booleanValue();
	}


	/**
	 * Get de la unidad de persistencia
	 * @return
	 */
	public final String getPersistenceUnitName() {
		return this.persistenceUnitName ;
	}
}
