/**
*  Implementación de la clase Autoescuela
*
*  @file Autoescuela.java
*  @author Andres Salas andres.salas@estudiante.uam.es
*		   Francisco Vicente francisco.vicentel@estudiante.uam.es
*  @version 1.0
*  @date 25-02-2017
*/
package eps.uam.ads.p2.autoescuela;

import eps.uam.ads.p2.autoescuela.personas.Profesor;
import eps.uam.ads.p2.autoescuela.TrabajaEn;
import eps.uam.ads.p2.autoescuela.fechas.Fecha;

/**
 * La clase Autoescuela proporciona la funcionalidad asociada para manejar los 
 * elementos propios de esta.
 */
public class Autoescuela {
	/*Atributos*/
	private int codigo;
	private String direccion;
	private String nombre;
	private TrabajaEn[] contrato;
	private int numMax;
	private int numAct=0;
	
	/**
	*  se trata del constructor de la clase
	*
	*  @param codigo : codigo de la nueva autoescuela
	*  @param direccion : direccion de la nueva autoescuela
	*  @param nombreAuto : nombre de la nueva autoescuela
	*  @param numMax : numero maximo de profesores para la autoescuela
	*/
	public Autoescuela(int codigo, String direccion, String nombreAuto, int numMax){
		this.codigo = codigo;
		this.direccion = direccion;
		this.nombre = nombreAuto;
		this.numMax = numMax;
		this.contrato = new TrabajaEn[this.numMax];
	}

	/**
	*  esta funcion crea nuevos contratos para la autoescuela
	*
	*  @param profesor : profesor a anyadir
	*  @param dia : fecha
	*  @param mes : fecha
	*  @param anyo : fecha
	*  @param sueldo : sueldo que recibira el nuevo profesor
	*/
	public void addContrato(Profesor profesor,int dia, int mes, int anyo,double sueldo){
		this.contrato[numAct] = new TrabajaEn(dia,mes,anyo,sueldo,profesor);
		numAct++;
	}
	
	/**
	*  esta funcion sirve para despedir profesores de una autoescuela eleiminando sus contratos
	*
	*  @param dia2 : fecha
	*  @param mes2 : fecha
	*  @param anyo2 : fecha
	*  @param dni : dni del profesor a eliminar
	*/
	public boolean deleteContrato(int dia2, int mes2, int anyo2, int dni){
		for(TrabajaEn t : this.contrato){
			if(dni == ((t.getProfesor()).getDni())){
				t.setFechaFin(new Fecha(dia2,mes2,anyo2));
				return true;
			}
		}
		return false;		
	}
	
	/*Redefinicion de la funcion toString para que imprima esta clase como nos interesa*/
	@Override
	public String toString() {
		return "\n\tCodigo: " + codigo + "\n\tNombre: " + nombre + "\n\tDireccion: " + direccion + "\n\t" + contrato[0];
	}

	/*Lista de setters y getters*/
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public TrabajaEn[] getContrato() {
		return contrato;
	}

	public void setContrato(TrabajaEn[] contrato) {
		this.contrato = contrato;
	}

	public int getNumMax() {
		return numMax;
	}

	public void setNumMax(int numMax) {
		this.numMax = numMax;
	}

	public int getNumAct() {
		return numAct;
	}

	public void setNumAct(int numAct) {
		this.numAct = numAct;
	}
	
}
