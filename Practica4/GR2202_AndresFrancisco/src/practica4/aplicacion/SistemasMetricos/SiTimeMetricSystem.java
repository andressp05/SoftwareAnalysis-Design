/**
 * Este fichero SiTimeMetricSystem.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 7/4/2017
 */
package practica4.aplicacion.SistemasMetricos;

import java.util.ArrayList;

import practica4.aplicacion.SistemasMetricos.IPhysicalUnit;
import practica4.aplicacion.SistemasMetricos.PhysicalUnit;
import practica4.aplicacion.SistemasMetricos.Quantity;

/**
 * Esta clase heredera de MetricSystem se encarga de representar el caso concreto de un
 * sistema metrico, conccretamente el internacional para unidades de tiempo
 * @author Andres y Francisco
 */
public class SiTimeMetricSystem extends MetricSystem {
	/** Unica instancia de la clase */
	static public final SiTimeMetricSystem SYSTEM = new SiTimeMetricSystem();
	/** Constante que representa los segundos */
	static public final PhysicalUnit SECOND = new PhysicalUnit(Quantity.TIME, "s", 1, SYSTEM);
	/** Constante que representa los minutos */
	static public final PhysicalUnit MINUTE = new PhysicalUnit(Quantity.TIME, "min", 60, SYSTEM);
	/** Constante que representa las horas */
	static public final PhysicalUnit HOUR = new PhysicalUnit(Quantity.TIME, "h", 3600, SYSTEM);
	/** Constante que representa los milisegundos */
	static public final PhysicalUnit MILISECOND = new PhysicalUnit(Quantity.TIME, "ms", 0.001, SYSTEM);
	/** Lista en la que se deben incluir las constantes deseadas */
	static private ArrayList<IPhysicalUnit> lista = null;
	
	/**
	 * Constructor vacio de la clase
	 */
	private SiTimeMetricSystem() {
		super();
	}
	
	@Override
	/**
	 * Implemetacion del metodo abstracto el cual devuelve la lista de unidades que forman este sistema
	 * @return lista de unidades que forman el sistema
	 */
	protected ArrayList<IPhysicalUnit> getLista() {
		if (lista == null) {
			lista = new ArrayList<IPhysicalUnit>();
			lista.add((IPhysicalUnit)HOUR);
			lista.add((IPhysicalUnit)SECOND);
			lista.add((IPhysicalUnit)MILISECOND);
		}
		return lista;
	}

	@Override
	/**
	 * Implementa el metodo abstrato que obtiene la base de un sistema
	 * @return unidad fisica que hace de base
	 */
	protected PhysicalUnit getBase() {
		return SECOND;
	}
}
