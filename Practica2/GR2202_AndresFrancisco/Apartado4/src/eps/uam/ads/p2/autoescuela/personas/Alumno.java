/**
*  Implementación de la clase Alumno
*
*  @file Alumno.java
*  @author Andres Salas andres.salas@estudiante.uam.es
*		   Francisco Vicente francisco.vicentel@estudiante.uam.es
*  @version 1.0
*  @date 25-02-2017
*/
package eps.uam.ads.p2.autoescuela.personas;

import eps.uam.ads.p2.autoescuela.fechas.Fecha;

/**
 * La clase Alumno proporciona la funcionalidad asociada para manejar los 
 * alumnos matriculados en la autoescuela. Es hija de la clase persona, 
 * por lo que hereda sus elementos.
 */
public class Alumno extends Persona {
	/*Atributos*/
	private String direccion;
	private Fecha fechaMatricula;
	private Fecha fechaSupTeorico;
	private Fecha fechaSupPractico;
	
	/**
	*  se trata del constructor de la clase
	*
	*  @param dni : dni de la persona introducida
	*  @param nombre : nombre de la persona introducida
	*  @param apellidos : apellidos de la persona introducida
	*  @param direccion : direccion del alumno introducida
	*  @param telefono : telefono de la persona introducida
	*  @param dia : fecha
	*  @param mes : fecha
	*  @param anyo : fecha
	*/
	public Alumno(int dni, String nombre, String apellidos, String direccion,int telefono,int dia, int mes, int anyo){
		super(dni,nombre,apellidos,telefono);
		this.direccion = direccion;
		this.fechaMatricula = new Fecha(dia,mes,anyo);
	}
	
	/*Redefinicion de la funcion toString para que imprima esta clase como nos interesa*/
	@Override
	public String toString() {
		return super.toString() + "\n\tDireccion: " + direccion + "\n\tFechaMatricula: " + fechaMatricula;
	}

	/*Lista de setters y getters*/
	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	
	public Fecha getFechaMatricula() {
		return fechaMatricula;
	}


	public void setFechaMatricula(Fecha fechaMatricula) {
		this.fechaMatricula = fechaMatricula;
	}


	public Fecha getFechaSupTeorico() {
		return fechaSupTeorico;
	}

	public void setFechaSupTeorico(int dia, int mes, int anyo) {
		fechaSupTeorico = new Fecha(dia,mes,anyo);
	}

	public Fecha getFechaSupPractico() {
		return fechaSupPractico;
	}

	public void setFechaSupPractico(int dia, int mes, int anyo) {
		fechaSupPractico = new Fecha(dia,mes,anyo);
	}
	
	/**
	*  Esta funcion comprueba la validez de una determinada fecha
	*
	*  @param f : la fecha a comprobar
	*  @return boolean: indica si es valida (true) o no (false)
	*/
	public boolean isFechaValida(Fecha f){
		return f.isFechaValida();
	}
}
