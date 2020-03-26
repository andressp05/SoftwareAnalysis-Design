/**
 * Este fichero IMetricSystemConverter.java declara la interfaz de la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 12/4/2017
 */
package practica4.aplicacion.Conversores;

import practica4.aplicacion.Excepciones.QuantityException;
import practica4.aplicacion.Excepciones.UnknownUnitException;
import practica4.aplicacion.Magnitudes.IMagnitude;
import practica4.aplicacion.SistemasMetricos.IMetricSystem;
import practica4.aplicacion.SistemasMetricos.IPhysicalUnit;

/**
 * Esta interfaz se encarga de declarar la funcionalidad publica asociada a la clase
 * MetricSystemConverter
 * @author Andres y Francisco
 */
public interface IMetricSystemConverter {
	
	/**
	 * Obtiene el sistema fuente del conversor
	 * @return sistema fuente
	 */
	IMetricSystem sourceSystem();  
	
	/**
	 * Obtiene el sistema de destino del conversor
	 * @return sistema destino
	 */
	IMetricSystem targetSystem();
	
	/**
	 * Se encarga de transformar magnitudes entre distintos sistemas
	 * @param from : magnitud a transformar
	 * @param to : unidad de destino
	 * @return magnitud que resulta de la transformacion
	 * @throws UnknownUnitException
	 * @throws QuantityException
	 */
	IMagnitude transformTo(IMagnitude from, IPhysicalUnit to) throws UnknownUnitException, QuantityException;  
	
	/**
	 * Obtiene el conversor inverso al actual
	 * @return conversor inverso
	 */
	IMetricSystemConverter reverse(); 
} 