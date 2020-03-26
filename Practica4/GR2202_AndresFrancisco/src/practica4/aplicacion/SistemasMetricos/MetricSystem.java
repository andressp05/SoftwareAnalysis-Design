/**
 * Este fichero MetricSystem.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 31/3/2017
 */
package practica4.aplicacion.SistemasMetricos;

import java.util.ArrayList;
import java.util.Collection;

import practica4.aplicacion.Conversores.IMetricSystemConverter;
import practica4.aplicacion.Conversores.MetricSystemConverter;
import practica4.aplicacion.SistemasMetricos.IPhysicalUnit;
import practica4.aplicacion.SistemasMetricos.PhysicalUnit;

/**
 * La clase MetricSystem es la encargada de generalizar el comportamiento de los distintos
 * sistemas metricos de los que consta nuestro programa
 * @author Andres y Francisco
 */
public abstract class MetricSystem implements IMetricSystem {
	
	/** Lista en la que se deben incluir las constantes deseadas */
	static protected ArrayList<IPhysicalUnit> lista = null;
	
	/** Lista de los conversores cuyo sistema fuente es este mismo */
	private static ArrayList<MetricSystemConverter> conversores =  new ArrayList<MetricSystemConverter>();
	
	/**
	 * Obteniene la unidad fisica que hace de base en este sistema metrico
	 * @return unidad base
	 */
	public IPhysicalUnit base() {
		return (IPhysicalUnit)getBase();
	}
	
	/**
	 * Obtiene la coleccion de unidades fisicas que forman este sistema metrico
	 * @return coleccion de unidades
	 */
	public Collection<IPhysicalUnit> units() {
		return getLista();
	}
	
	/**
	 * Obtiene el conversor para realizar conversiones desde este sistema al indicado,
	 * siempre que este exita
	 * @param to : Sistema metrico de destino
	 * @return conversor pertinente; null si este no exitste
	 */
	public IMetricSystemConverter getConverter(IMetricSystem to) {
		for(MetricSystemConverter msc: conversores) {
			if (msc.targetSystem().equals(to)) {
				return msc;
			}
		}
		return null;
	}
	
	/**
	 * Resgistra un nuevo conversor en el sistema siempre que ya estuviera anyadido
	 * @param conv : conversor a anyadir
	 */
	public static void registerConverter(MetricSystemConverter conv) {
		if (conversores.contains(conv) == false) {
			conversores.add(conv);
			conversores.add((MetricSystemConverter)conv.reverse());
		}
	}
	
	/**
	 * Comprueba si una determinada unidad pertenece a este sistema metrico
	 * @param u : unidad fisica a buscar
	 * @return true si ha sido encontrado, false en caso contrario
	 */
	public boolean isInMetricSystem(PhysicalUnit u) {
		return getLista().contains(u);
	}
	
	/**
	 * Declaracion del metodo abstracto que obtiene la base de cada sistema
	 * @return unidad base
	 */
	abstract protected PhysicalUnit getBase();
	
	/**
	 * Declaracion del metodo abstracto que obtiene la lista de unidades de un sistema
	 * @return serie de unidades que forman el sistema
	 */
	abstract protected ArrayList<IPhysicalUnit> getLista();
	
}
