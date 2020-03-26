/**
*  Implementación de la clase TrabajaEn
*
*  @file TrabajaEn.java
*  @author Andres Salas andres.salas@estudiante.uam.es
*		   Francisco Vicente francisco.vicentel@estudiante.uam.es
*  @version 1.0
*  @date 25-02-2017
*/
package eps.uam.ads.p2.autoescuela;

import eps.uam.ads.p2.autoescuela.fechas.Fecha;
import eps.uam.ads.p2.autoescuela.personas.Profesor;

/**
 * La clase TrabajaEn proporciona la funcionalidad necesaria para relacionar 
 * a cada uno de los profesores con la autoescuela donde trabajan o han trabajado
 * y con las fechas de inicio y fin pertinentes.
 */
public class TrabajaEn {
	/*Atributos*/
	private Fecha fechaIni;
	private Fecha fechaFin;
	private double sueldo;
	private Profesor profesor;
	
	/**
	*  se trata del constructor de la clase
	*
	*  @param dia1 : fecha
	*  @param mes1 : fecha
	*  @param anyo1 : fecha
	*  @param sueldo : cantidad de dinero especificada en el contrato
	*  @param profesor : el profesor contratado
	*  
	*/
	public TrabajaEn(int dia1, int mes1, int anyo1,double sueldo,Profesor profesor){
		fechaIni = new Fecha(dia1,mes1,anyo1);
		this.sueldo = sueldo;
		this.profesor = profesor;
		}

	/*Redefinicion de la funcion toString para que imprima esta clase como nos interesa*/
	@Override
	public String toString() {
		return "\n\tPROFESOR:" + profesor + "\n\tSueldo: " + sueldo + "\n\tFechaIni: " + fechaIni + "\n\tFechaFin: " + fechaFin + "\n";
	}

	public Fecha getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Fecha fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Fecha getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Fecha fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}	
}
