package com.cgt.util;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Util {
	
	//Log4j
  	private static final Logger logger = Logger.getLogger(Util.class);

	private static SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy");
	private static SimpleDateFormat formateadorConHora = new SimpleDateFormat("dd/MM/yyyy hh:mm");

	/**
	 * Convierte una fecha Date a una fecha String con formato: dd/MM/yyyy
	 * 
	 * @param fecha
	 *            de tipo Date
	 * @return fecha de tipo String dd/MM/yyyy
	 */
	public static String formateaFechaToString(Date fecha) {
		return formateador.format(fecha);
	}

	/**
	 * Convierte una fecha Date a una fecha String con formato: dd/MM/yyyy hh:mm
	 * 
	 * @param fecha
	 *            de tipo Date
	 * @return fecha de tipo String dd/MM/yyyy
	 */
	public static String formateaFechaToStringConHora(Date fecha) {
		return formateadorConHora.format(fecha);
	}

	/**
	 * Convierte una fecha String a una fecha Date con formato: dd/MM/yyyy
	 * 
	 * @param fecha
	 *            de tipo String
	 * @return fecha de tipo Date dd/MM/yyyy
	 * @throws ParseException
	 */
	public static Date formateaStringToFecha(String fecha) throws ParseException {
		return formateador.parse(fecha);
	}

	/**
	 * Convierte una fecha Date a una fecha String con formato: dd/MM/yyyy hh:mm
	 * 
	 * @param fecha
	 *            de tipo Date
	 * @return fecha de tipo String dd/MM/yyyy
	 * @throws ParseException
	 */
	public static Date formateaStringToFechaConHora(String fecha) throws ParseException {
		return formateadorConHora.parse(fecha);
	}

	public static Boolean isANumber(String numero) {
		try {
			Double.parseDouble(numero);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}
	
	public static Properties getProperties(String fichero) {

        Properties props = new Properties();
        try {
            InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(fichero);
            props.load(is);           
        } catch (IOException ex) {
        	logger.error("Error importando fichero de propiedades");
        }
        return props;
    }
	
}
