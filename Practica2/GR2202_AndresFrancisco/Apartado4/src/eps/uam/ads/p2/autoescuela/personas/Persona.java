/**
*  Implementación de la clase Persona
*
*  @file Persona.java
*  @author Andres Salas andres.salas@estudiante.uam.es
*		   Francisco Vicente francisco.vicentel@estudiante.uam.es
*  @version 1.0
*  @date 22-02-2017
*/
package eps.uam.ads.p2.autoescuela.personas;

/**
 * La clase Persona se trata de una clase abstracta que generaliza a las
 * clases Alumno y Profesor
 */
public abstract class Persona {
	/*Atributos*/
	private int dni;
	private String nombre;
	private String apellidos;
	private int telefono;
	
	/**
	*  se trata del constructor de la clase
	*
	*  @param dni : dni de la persona introducida
	*  @param nombre : nombre de la persona introducida
	*  @param apellidos : apellidos de la persona introducida
	*  @param telefono : telefono de la persona introducida
	*/
	public Persona(int dni, String nombre, String apellidos, int telefono){
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.telefono = telefono;
	}
	
	/*Redefinicion de la funcion toString para que imprima esta clase como nos interesa*/
	@Override
	public String toString() {
		return "\n\tdni: " + dni + "\n\tNombre y Apellidos: " + nombre + " " + apellidos + "\n\tTelefono: " + telefono;
	}

	/*Lista de setters y getters*/
	public int getDni() {
		return dni;
	}

	public void setDni(int dni) {
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

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public String getNombreYApellidos(){
		return getNombre() + " " + getApellidos();
	}
	
	public void setNombreYApellidos(String nombre, String apellidos){
		setNombre(nombre);
		setApellidos(apellidos);
	}
}
