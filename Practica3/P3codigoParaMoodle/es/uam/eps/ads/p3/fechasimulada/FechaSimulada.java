package es.uam.eps.ads.p3.fechasimulada;

import java.time.LocalDate;
/**
 * Clase auxiliar para permitir pruebas de la Práctica 3 con "fechas simuladas" y controladas
 * @author Profesores ADS
 *
 */
public class FechaSimulada {
	
	// inicializacion por defecto a una fecha fija, NO CAMBIAR
	private static LocalDate fechaSimulada 
	                     =  LocalDate.now().withDayOfMonth(1).withMonth(3).withYear(2017);

	/**
	 * Avanza numDias la fecha simulada actual
	 * @param numDias
	 */
	public static void avanzar(int numDias) {
		fechaSimulada = fechaSimulada.plusDays(numDias);
	}
	
	/**
	 * Restablece la fecha simulada a la fecha real de hoy en ejecución
	 */
	public static void restablecerHoyReal() {
		fechaSimulada =  LocalDate.now();
	}
	

	/**
	 * Retorna la fecha simulada actual o fecha simulada de "hoy". No es la fecha real de hoy.
	 * @return fecha simulada actual
	 */
	public static LocalDate getHoy() {
		return fechaSimulada;
	}
	
	/**
	 * Se fija la fecha simulada con los valores de dia, mes y año dados como parámetros
	 * @param dia
	 * @param mes
	 * @param anyo
	 * @return fecha simulada actual con los valores dados como parámetros
	 */
	public static LocalDate fijarFecha(int dia, int mes, int anyo) {
		fechaSimulada = fechaSimulada.withDayOfMonth(dia).withMonth(mes).withYear(anyo);
		return fechaSimulada;
	}

}
