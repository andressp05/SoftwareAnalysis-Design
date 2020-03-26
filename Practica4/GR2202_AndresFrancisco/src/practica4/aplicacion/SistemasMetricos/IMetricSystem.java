/**
 * Este fichero IMetricSystem.java declara la interfaz de la clase homonima
 * @author Andres y Francisco
 * @version 2.0 (listo para conversores entre sistemas)
 * @date 12/4/2017
 */
package practica4.aplicacion.SistemasMetricos;

import java.util.Collection;

import practica4.aplicacion.Conversores.IMetricSystemConverter;
import practica4.aplicacion.SistemasMetricos.IPhysicalUnit;


/**
 * Esta clase hace el papael de la interfaz que presenta la clase MetricSystem
 * para poder utilizada externamente
 * @author Andres y Francisco
 */
public interface IMetricSystem {
	
	/**
	 * Obteniene la unidad fisica que hace de base en este sistema metrico
	 * @return unidad base
	 */
	IPhysicalUnit base(); 
	
	/**
	 * Obtiene la coleccion de unidades fisicas que forman este sistema metrico
	 * @return coleccion de unidades
	 */
	Collection<IPhysicalUnit> units();
	
	/**
	 * Obtiene el conversor para realizar conversiones desde este sistema al indicado,
	 * siempre que este exita
	 * @param to : Sistema metrico de destino
	 * @return conversor pertinente; null si este no exitste
	 */
	IMetricSystemConverter getConverter(IMetricSystem to);
}