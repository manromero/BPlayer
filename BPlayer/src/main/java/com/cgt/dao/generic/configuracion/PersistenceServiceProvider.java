/*
 * Generated by Telosys Tools Generator ( version 2.1.1 )
 */
package com.cgt.dao.generic.configuracion;

/**
 * @author apascual
 * Muy simple proveedor de servicio de persistencia (sólo para pruebas)
 *
 */
public class PersistenceServiceProvider {

	private final static String SERVICES_ROOT_PACKAGE = PersistenceServiceProvider.class.getPackage().getName() + ".services" ;
	/**
	 * Tipo de Implementación (El 1 es JPA, el 2 sería por ejemplo LPA...)
	 */
	public final static int FAKE = 0 ;
	public final static int JPA  = 1 ;
	public final static int LPA  = 2 ;
	public final static int PERSISTENCE_IMPLEMENTATION_TYPE = JPA ;
	/**
	 * Nombre de la unidad de persistencia definida en el archivo "persistence.xml"
	 */
	public static final String JPA_PERSISTENCE_UNIT_NAME = "persistence-unit1";
	/**
	 * Returns a persistence service for the default persistence implementation
	 * @param entityClass
	 * @return
	 */
	public final static <T> T getService( Class<T> entityClass ) {
		return getService( entityClass, PERSISTENCE_IMPLEMENTATION_TYPE );
	}
	
	/**
	 * Devuelve un servicio de persistencia de la aplicación dado una implementación de persistencia 
	 * (En nuestro caso JPA)
	 * @param serviceInterface
	 * @param implementationType
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public final static <T> T getService( Class<T> serviceInterface, int implementationType ) {
		
		
		if ( serviceInterface != null ) {
			
			//--- 1) Definimos el nombre completo de la clase
			String pkg    = "" ;
			String suffix = "" ;

			switch ( implementationType ) {
			
			case JPA :
				pkg = SERVICES_ROOT_PACKAGE + ".jpa" ;
				suffix = "JPA" ;
				break ;
				
			case LPA :
				pkg = SERVICES_ROOT_PACKAGE + ".lpa" ;
				suffix = "LPA" ;
				break ;
				
			case FAKE :
				pkg = SERVICES_ROOT_PACKAGE + ".fake" ;
				suffix = "FAKE" ;
				break ;
				
			default :
				throw new RuntimeException("Tipo de implementación desconocido !");
			}
			String serviceClassName = pkg + "." + serviceInterface.getSimpleName() + suffix ;
			
			//--- 2) Intentamos cargar la clase
			Class<?> clazz ;
			Object instance = null ;
			try {
				 clazz = Class.forName(serviceClassName) ;
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("No se puede cargar la clase " + serviceClassName, e);
			}

			if ( serviceInterface.isAssignableFrom(clazz) ) {

				//--- 3) Intentamos crear una instancia de esta clase
				try {
					instance = clazz.newInstance();
				} catch (InstantiationException e) {
					throw new RuntimeException("No se puede crear la instancia para la clase " + serviceClassName + " (InstantiationException)", e);
				} catch (IllegalAccessException e) {
					throw new RuntimeException("No se puede crear la instancia para la clase " + serviceClassName + " (IllegalAccessException)", e);
				}
				return (T) instance ;
				
			}
			else {
				throw new RuntimeException("Clase " + serviceClassName + " no es una implementación de " + serviceInterface.getSimpleName() );
			}
		}
		else {
			throw new IllegalArgumentException("El argumento del entity es nulo!");
		}
	}
	
}

