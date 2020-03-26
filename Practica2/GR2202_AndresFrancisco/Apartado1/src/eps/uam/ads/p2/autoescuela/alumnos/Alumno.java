/**
*  Implementación de la clase Alumno
*
*  @file Alumno.java
*  @author Andres Salas andres.salas@estudiante.uam.es
*		   Francisco Vicente francisco.vicentel@estudiante.uam.es
*  @version 1.0
*  @date 15-02-2017
*/
package eps.uam.ads.p2.autoescuela.alumnos;

import eps.uam.ads.p2.autoescuela.fechas.Fecha;

/**
 * La clase Alumno proporciona la funcionalidad asociada para manejar los 
 * alumnos matriculados en la autoescuela
 */
public class Alumno {
	/*Atributos*/
	private int dni;
	private String nombre;
	private String apellidos;
	private String direccion;
	private int telefono;
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
	public Alumno(int dni, String nombre, String apellidos, String direccion, int telefono, int dia, int mes, int anyo){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.direccion = direccion;
		this.telefono = telefono;
		this.fechaMatricula = new Fecha(dia,mes,anyo);
	}

	/*Redefinicion de la funcion toString para que imprima esta clase como nos interesa*/
	@Override
	public String toString() {
		return "<dni: " + dni + ">\n\tNombre y apellidos: " + nombre + " " + apellidos + "\n\tDireccion: " + direccion
				+ "\n\tTeléfono: " + telefono + "\n\tFecha de matriculación: " + fechaMatricula;
	}

	/*Getters y setters*/
	public int getDni(){
		return dni;
	}
	
	public void setDni(int dni){
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
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
	
	public String getNombreYApellidos(){
		return getNombre() + " " + getApellidos();
	}
	
	public void setNombreYApellidos(String nombre, String apellidos){
		setNombre(nombre);
		setApellidos(apellidos);
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
