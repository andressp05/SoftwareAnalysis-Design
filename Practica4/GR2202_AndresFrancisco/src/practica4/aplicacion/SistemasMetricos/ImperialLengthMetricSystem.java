/**
 * Este fichero ImperialLengthMetricSystem.java implementa la clase homonima
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
 * sistema metrico, conccretamente el imperial para unidades de longitud
 * @author Andres y Francisco
 */
public class ImperialLengthMetricSystem extends MetricSystem {
	
	/** Unica instancia de la clase */
	static public final ImperialLengthMetricSystem SYSTEM = new ImperialLengthMetricSystem();
	/** Constante que representa las millas */
	static public final PhysicalUnit MILE = new PhysicalUnit(Quantity.LEN, "mi", 5280, SYSTEM);
	/** Constante que representa las yardas */
	static public final PhysicalUnit YARD = new PhysicalUnit(Quantity.LEN, "yd", 3, SYSTEM);
	/** Constante que representa las pulgadas */
	static public final PhysicalUnit INCH = new PhysicalUnit(Quantity.LEN, "in", 0.0833333, SYSTEM);
	/** Constante que representa los pies */
	static public final PhysicalUnit FOOT = new PhysicalUnit(Quantity.LEN, "ft", 1, SYSTEM);
	/** Lista en la que se deben incluir las constantes deseadas */
	static private ArrayList<IPhysicalUnit> lista = null;
	
	/**
	 * Constructor vacio de la clase
	 */
	private ImperialLengthMetricSystem() {
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
			lista.add((IPhysicalUnit)FOOT);
			lista.add((IPhysicalUnit)YARD);
			lista.add((IPhysicalUnit)MILE);
		}
		return lista;
	}
	
	@Override
	/**
	 * Implementa el metodo abstrato que obtiene la base de un sistema
	 * @return unidad fisica que hace de base
	 */
	protected PhysicalUnit getBase() {
		return FOOT;
	}
	
}
