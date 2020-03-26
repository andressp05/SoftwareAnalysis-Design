/**
*  Implementación de la clase Fecha
*
*  @file Fecha.java
*  @author Andres Salas andres.salas@estudiante.uam.es
*		   Francisco Vicente francisco.vicentel@estudiante.uam.es
*  @version 1.0
*  @date 15-02-2017
*/
package eps.uam.ads.p2.autoescuela.fechas;

/**
 * La clase Fecha proporciona la funcionalidad asociada al manejo de fechas
 * para que pueda ser utilizado por distintos elementos de la autoescuala
 */
public class Fecha {
	/*Atributos*/
	private int dia;
	private int mes;
	private int anyo;
	
	/**
	*  se trata del constructor de la clase
	*  @param dia : dia que se indica (entre 1 y 31)
	*  @param mes : mes que se indica (entre 1 y 12)
	*  @param anyo : anyo introducido
	*/
	public Fecha(int dia, int mes, int anyo){
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}

	/*Redefinicion de la funcion toString para que imprima esta clase como nos interesa*/
	@Override
	public String toString() {
		return dia + "/" + mes + "/" + anyo;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAnyo() {
		return anyo;
	}

	public void setAnyo(int anyo) {
		this.anyo = anyo;
	}
	
	public String getFecha(){
		return getDia() + "/" + getMes() + "/" + getAnyo();
	}
	
	public void setFecha(int dia, int mes, int anyo){
		setDia(dia);
		setMes(mes);
		setAnyo(anyo);
	}
	
	/**
	*  Esta funcion comprueba la validez de una determinada fecha
	*
	*  @return boolean : indica si es valida (true) o no (false)
	*/
	public boolean isFechaValida(){
		if(dia < 1 || dia > 31)
			return false;
		else if(mes < 1 || mes > 12)
			return false;
		return true;
	}
	
}
