package practica4.testers;

import practica4.aplicacion.Conversores.SiLength2ImperialConverter;
import practica4.aplicacion.Excepciones.QuantityException;
import practica4.aplicacion.Magnitudes.IMagnitude;
import practica4.aplicacion.Magnitudes.Magnitude;
import practica4.aplicacion.SistemasMetricos.ImperialLengthMetricSystem;
import practica4.aplicacion.SistemasMetricos.SiLengthMetricSystem;

public class ConversionTest {
	public static void main(String[] args) throws QuantityException {	
		Magnitude m = new Magnitude(10, SiLengthMetricSystem.KILOMETER);
		IMagnitude enMillas = null;
		try {
			enMillas = m.transformTo(ImperialLengthMetricSystem.MILE);
		} catch (QuantityException e) {
			System.out.println(e);
		}
		SiLengthMetricSystem.registerConverter(new SiLength2ImperialConverter());
		// Registers the converter and the reverse
		enMillas = m.transformTo(ImperialLengthMetricSystem.MILE);
		System.out.println("En millas = " + enMillas);
		System.out.println("En m = " + enMillas.transformTo(SiLengthMetricSystem.METER));
	}
}