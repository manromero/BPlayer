package com.cgt.dao.generic.configuracion;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author apascual
 *
 */
public class JpaEnvironments {

	private final static JpaEnvironments singleInstance = new JpaEnvironments();
	
	private final Map<String,JpaEnvironment> environments ;

	private JpaEnvironments() {
		super();
		this.environments = new HashMap<String,JpaEnvironment>();
	}
	
	public final static JpaEnvironments getInstance() {
		return singleInstance ;
	}
	
	public JpaEnvironment getJpaEnvironment(final String peristanceUnitName ) {
		JpaEnvironment env = environments.get(peristanceUnitName) ;
		if ( env == null ) {
			env = createNewJpaEnvironment( peristanceUnitName );
		}
		return env ;
	}

	private synchronized JpaEnvironment createNewJpaEnvironment(final String peristanceUnitName ) {
		JpaEnvironment env = environments.get(peristanceUnitName) ; //Doble comprobación
		if ( env == null ) {
			env = new JpaEnvironment(peristanceUnitName);
			environments.put(peristanceUnitName, env);
		}
		return env ;
	}
}
