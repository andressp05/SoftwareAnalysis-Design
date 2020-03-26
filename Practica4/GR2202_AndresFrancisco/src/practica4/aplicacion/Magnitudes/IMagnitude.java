/**
 * Este fichero IMagnitude.java declara la interfaz de la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/4/2017
 */
package practica4.aplicacion.Magnitudes;

import practica4.aplicacion.Excepciones.QuantityException;
import practica4.aplicacion.SistemasMetricos.IPhysicalUnit;

/**
 * Esta clase es la encargada de declarar la interfaz que presenta la clase Magnitude
 * para poder ser manejada de formma externa
 * @author Andres y Francisco
 */
public interface IMagnitude {
	/**
	 * Suma a esta magnitud la pasada como argumento, tras la previa conversion pertinente
	 * @param m : magnitud a sumar
	 * @return resultado de la operacion
	 * @throws QuantityException
	 */
	IMagnitude add(IMagnitude m) throws QuantityException;
	
	/**
	 * Resta a esta magnitud la pasada como argumento, tras la previa conversion pertinente
	 * @param m : magnitud a restar
	 * @return resultado de la operacion
	 * @throws QuantityException
	 */
	IMagnitude subs(IMagnitude m) throws QuantityException;
	
	/**
	 * Transforma una magnitud a otra unidad
	 * @param c : unidad a convertir
	 * @return magnitud tras la conversion
	 * @throws QuantityException
	 */
	IMagnitude transformTo(IPhysicalUnit c) throws QuantityException;
	
	/**
	 * Devuelve la unidad de la magnitud
	 * @return unidad de la magnitud
	 */
	IPhysicalUnit getUnidad();
	
	/**
	 * Devuelve el valor de la magnitud
	 * @return valor de la magnitud
	 */
	double getValor();
} 
