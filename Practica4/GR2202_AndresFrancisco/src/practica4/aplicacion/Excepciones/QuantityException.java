/**
 * Este fichero QuantityException.java implementa el manejo de errrores de tipo Quantity
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/4/2017
 */
package practica4.aplicacion.Excepciones;

import practica4.aplicacion.SistemasMetricos.IPhysicalUnit;

/**
 * Esta clase es una heredera de Exception ya que sirve para crear nuestro propio manejo de errores
 * para un fallo que puede surgir al intentar tranformar unidades en otras incompatibles.
 * @author Anderes y Francisco
 */
public class QuantityException extends Exception {
	/** Unidades incompatibles */
	IPhysicalUnit err1, err2;
	/** Identificador */
	public static final long serialVersionUID = 1;
	
	/**
	 * Constructor de la clase
	 * @param pu1 : unidades fuente
	 * @param pu2 : unidad de destino
	 */
	public QuantityException(IPhysicalUnit pu1, IPhysicalUnit pu2) {
		err1 = pu1;
		err2 = pu2;
	}
	
	@Override
	public String toString() {
		return "La unidad fisica [" + err1 + "] no puede ser transformada a [" + err2 + "]";
	}
	
}
