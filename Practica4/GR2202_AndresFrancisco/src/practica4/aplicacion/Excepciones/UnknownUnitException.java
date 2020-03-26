/**
 * Este fichero UnknownUnitException.java implementa el manejo de errrores de tipo UnknownUnit
 * @author Andres y Francisco
 * @version 1.0
 * @date 12/4/2017
 */
package practica4.aplicacion.Excepciones;

import practica4.aplicacion.Magnitudes.IMagnitude;
import practica4.aplicacion.Magnitudes.Magnitude;
import practica4.aplicacion.SistemasMetricos.IPhysicalUnit;
import practica4.aplicacion.SistemasMetricos.PhysicalUnit;

/**
 * Esta clase es una heredera de Exception ya que sirve para crear nuestro propio manejo de errores
 * para un fallo que puede surgir al intentar tranformar unidades pertenecientes a distintos sistemas,
 * ya que puede que no exista un conversor destinado a dicha transformacion.
 * @author Andres y Francisco
 */
public class UnknownUnitException extends Exception {
	/** Magnitud de partida */
	Magnitude mFrom;
	/** Unidad fisica de destino */
	PhysicalUnit uTo;
	/** Identificador */
	public static final long serialVersionUID = 2;
	
	/**
	 * Constructor de la clase
	 * @param from : magnitud que se intenta transformar
	 * @param to : Unidad a la que se intenta transformar
	 */
	public UnknownUnitException(IMagnitude from, IPhysicalUnit to) {
		mFrom = (Magnitude)from;
		uTo = (PhysicalUnit)to;
	}
	
	@Override
	public String toString() {
		return "No se puede realizar la conversion de [" + mFrom + "] a [" + uTo + "]";
	}

}
