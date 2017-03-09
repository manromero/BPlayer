package com.cgt.managedbean;

import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.rmi.PortableRemoteObject;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.cgt.dto.UsuariosDto;
import com.cgt.services.UsuarioService;
import com.cgt.util.Constantes;

import es.uv.irtic.lisitt.incitar.Seguridad.componentes.consulta.SeguridadInterfaceRemote;
import es.uv.irtic.lisitt.incitar.Seguridad.entidades.Usuario;
import es.uv.irtic.lisitt.incitar.Seguridad.utiles.ISeguridad;
	
@ManagedBean
@Scope("session")
@SessionScoped
@Component
public class LoginManagedBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2093937779327067095L;
	
	//Log4j
	private static final Logger logger = Logger.getLogger(LoginManagedBean.class);
		
	//Atributos para login
	private String username;
	private String password;
	
	//Atributo Usuario Logado
	public static UsuariosDto usuarioLogado;
	
	@Autowired
	public UsuarioService usuarioService;
	
	public LoginManagedBean(){
		super();
		this.username = null;
		this.password = null;
	}
	
	@PostConstruct
	public void init(){
		this.username = null;
		this.password = null;
	}
	
	/*
	 **************************************************************************************************** 
	 * **************************************************************************************************
	 * ***********************************Métodos propios del ManagedBean********************************
	 * **************************************************************************************************
	 * **************************************************************************************************
	 */
	/**
	 * Método que valida el login del usuario. Si es correcto, redirige a la pantalla index.xhtml
	 * @return String que devuelve para que se valore en el faces-config y redirija donde proceda
	 * @throws NamingException 
	 */
	public String login() throws NamingException{
		//Login con el middleware que conecta con el ldap de Madrid
		//Realizamos el proceso de instanciación del proxy al ejb del componente
//			Properties env = new Properties();
//			env.put("jboss.naming.client.ejb.context", true);
//			env.put("java.naming.factory.url.pkgs", "org.jboss.ejb.client.naming");
//			InitialContext remoteContext = new InitialContext(env);
			//------------------------------------
			// Proxy al EJB de Seguridad
			//------------------------------------
//			String sgrJNDI = "ejb:SeguridadEAR/SeguridadEJB/SeguridadBean!es.uv.irtic.lisitt.incitar.Seguridad.componentes.consulta.SeguridadInterfaceRemote";
			
		if(this.username != null && !"".equals(this.username) && this.password != null && !"".equals(this.password)){
//			HashMap<String, Object> userPass = new HashMap<String, Object>();
//			userPass.put(ISeguridad.Autenticacion.LOGIN_USUARIO, username);
//			userPass.put(ISeguridad.Autenticacion.PASSWORD_USUARIO, password);
			
			//Esto para hacer LOGIN contra LDAP de Madrid
//			SeguridadInterfaceLocal sgr_ir = (SeguridadInterfaceLocal) remoteContext.lookup(sgrJNDI);
			
			//De forma remota tal como esta en el proyecto de ejemplo
//				Object refSeguridad = remoteContext.lookup(sgrJNDI);
//				SeguridadInterfaceRemote sgr_ir = (SeguridadInterfaceRemote) PortableRemoteObject.narrow(refSeguridad, SeguridadInterfaceRemote.class);
//			Usuario usuarioAutenticado = sgr_ir.autenticacion(userPass);
//			if(usuarioAutenticado != null){

				usuarioLogado = usuarioService.findByUsername(this.username);
				if(usuarioLogado != null){
					username = Constantes.CADENA_VACIA;
					password = Constantes.CADENA_VACIA;
					//Guardamos el usuario logado en la sesion de JSF
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioLogado);
					return "entidades";
				}else{
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en el login", "Revise su usuario y contraseña"));
					FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", null);
				}
			}else{
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en el login", "Revise su usuario y contraseña"));
				FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", null);
			}

//		}else{
//			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error en el login", "Revise su usuario y contraseña"));
//			FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", null);
//		}
		return Constantes.CADENA_VACIA;
	}
	
	/**
	 * Hacemos logout y liberamos la session del usuario.
	 * @return redirigimos al login (login.xhtml)
	 */
	public String logout() throws IOException{
		logger.info("USERNAME: " + username + ". Fecha LogOut: " + new Date());
		//Eliminamos el usuario logado
		usuarioLogado = null;
		//cerramos conexion de JSF
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
		//redirección mediante faces-config.xml
		return "login";
	}
	
	/**
	 * Método que se llama desde los xhtml para comprobar que el usuario está logado. Si no lo está no debe dejar ver la página
	 * @return
	 */
	public Boolean verificarSesion(){
		Boolean estado;
		if(FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario") == null){
			estado = Boolean.FALSE;
		}else{
			estado = Boolean.TRUE;
		}
		return estado;
	}
	
	/**
	 * Redirecciona al login
	 * @return
	 */
	public String redirigeALogin(){
		return "login";
	}
	
	
	/*
	 **************************************************************************************************** 
	 * **************************************************************************************************
	 * ****************************************GETTERS AND SETTERS***************************************
	 * **************************************************************************************************
	 * **************************************************************************************************
	 */
	public String getUsername(){
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UsuariosDto getUsuarioLogado() {
		return usuarioLogado;
	}

	public void setUsuarioLogado(UsuariosDto usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}

}
