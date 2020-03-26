/**
*  Implementación de la clase Profesor
*  @file Profesor.java
*  @author Andres Salas andres.salas@estudiante.uam.es
*		   Francisco Vicente francisco.vicentel@estudiante.uam.es
*  @version 1.0
*  @date 22-02-2017
*/
package eps.uam.ads.p2.autoescuela.personas;

/**
 * La clase Profesor proporciona la funcionalidad asociada para manejar los 
 * profesires que trabajan o han trabajado para la autoescuela. Es hija de
 * la clase persona, con lo que hereda sus elementos.
 */
public class Profesor extends Persona  {
	/*Atributos*/
	private String numSS;
	private int antiguedad;
	
	/**
	*  se trata del constructor de la clase
	*
	*  @param dni : dni de la persona introducida
	*  @param nombre : nombre de la persona introducida
	*  @param apellidos : apellidos de la persona introducida
	*  @param telefono : telefono de la persona introducida
	*  @param numSS : numero de la seguridad solical del profesor a crear
	*  @param antiguedad : anyos que el profesor lleva trabajando para la autoescuala
	*/
	public Profesor(int dni, String nombre, String apellidos, String numSS, int antiguedad, int telefono){
		super(dni,nombre,apellidos,telefono);
		this.numSS = numSS;
		this.antiguedad = antiguedad;
		}
	
	/*Redefinicion de la funcion toString para que imprima esta clase como nos interesa*/
	@Override
	public String toString() {
		return super.toString() + "\n\tNumSeguridadSocial: " + numSS + "\n\tAntiguedad: " + antiguedad;
	}

	/*Lista de setters y getters*/
	public String getNumSS() {
		return numSS;
	}

	public void setNumSS(String numSS) {
		this.numSS = numSS;
	}

	public int getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(int antiguedad) {
		this.antiguedad = antiguedad;
	}
}
