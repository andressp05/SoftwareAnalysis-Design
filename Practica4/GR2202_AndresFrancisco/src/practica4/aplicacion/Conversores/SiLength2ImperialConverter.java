/**
 * Este fichero SiLength2ImperialConverter.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 12/4/2017
 */
package practica4.aplicacion.Conversores;

import practica4.aplicacion.SistemasMetricos.ImperialLengthMetricSystem;
import practica4.aplicacion.SistemasMetricos.SiLengthMetricSystem;

/**
 * Esta clase es el caso concreto de conversor (hereda de MetricSystemConverter) para pasar, en
 * unidades de longitud, del sistema internacinal al imperial. Cabe destacar que tan solo contiene
 * al constructor pues el resto de la funcionalidad reside en su superclase.
 * @author Andres y Francisco
 */
public class SiLength2ImperialConverter extends MetricSystemConverter {
	
	/**
	 * Constrcutor de la clase
	 */
	public SiLength2ImperialConverter() {
		super(SiLengthMetricSystem.SYSTEM, ImperialLengthMetricSystem.SYSTEM, 3.28);
	}

}
