/**
 * Este fichero IPhysicalUnit.java declara la interfaz de la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 31/3/2017
 */
package practica4.aplicacion.SistemasMetricos;

import practica4.aplicacion.Excepciones.QuantityException;
import practica4.aplicacion.SistemasMetricos.IMetricSystem;

/**
 * Esta interfaz declara las funciones para el manejo de unidades fisicas que pueden s
 * er usadas externamente
 * @author Andres y Francisco
 */
public interface IPhysicalUnit {
	
	/**
	 * Comprueba si esta unidad fisica puede convertida a otra. Para ello deben pertenecer al mismo 
	 * sistema y medir la misma propiedad fisica
	 * @param u : unidad fisica a la que comprobamos si se puede transformar
	 * @return true en caso afirmativo, false en el negativo
	 */
	boolean canTransformTo(IPhysicalUnit u);
	
	/**
	 * Tranforma una cierta cantidad de esta unidad a otra unidad dando error si la conversion no
	 * fuera posible
	 * @param d : valor a convertir
	 * @param u : unidad a la que se desea convertir
	 * @return valor numerico obtenido tras la conversion
	 */
	double transformTo(double d, IPhysicalUnit u) throws QuantityException;
	
	Quantity getQuantity();
	
	String abbrev();
	
	IMetricSystem getMetricSystem();
	
}
