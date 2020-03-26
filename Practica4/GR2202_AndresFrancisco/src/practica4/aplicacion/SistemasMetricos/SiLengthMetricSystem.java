/**
 * Este fichero SiLengthLengthMetricSystem.java implementa la clase homonima
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
 * sistema metrico, conccretamente el internacional para unidades de longitud
 * @author Andres y Francisco
 */
public class SiLengthMetricSystem extends MetricSystem {
	/** Unica instancia de la clase */
	static public final SiLengthMetricSystem SYSTEM = new SiLengthMetricSystem();
	/** Constante que representa los metros */
	static public final PhysicalUnit METER = new PhysicalUnit(Quantity.LEN, "m", 1, SYSTEM);
	/** Constante que representa los kilometros */
	static public final PhysicalUnit KILOMETER = new PhysicalUnit(Quantity.LEN, "km", 1000, SYSTEM);
	/** Constante que representa los milimetros */
	static public final PhysicalUnit MILIMETER = new PhysicalUnit(Quantity.LEN, "mm", 0.001, SYSTEM);
	
	/**
	 * Constructor vacio de la clase
	 */
	private SiLengthMetricSystem() {
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
			lista.add((IPhysicalUnit)KILOMETER);
			lista.add((IPhysicalUnit)METER);
			lista.add((IPhysicalUnit)MILIMETER);
		}
		return lista;
	}

	@Override
	/**
	 * Implementa el metodo abstrato que obtiene la base de un sistema
	 * @return unidad fisica que hace de base
	 */
	protected PhysicalUnit getBase() {
		return METER;
	}

}
