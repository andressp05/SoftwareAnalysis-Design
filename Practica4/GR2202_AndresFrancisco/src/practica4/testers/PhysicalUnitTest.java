package practica4.testers;

import practica4.aplicacion.Excepciones.QuantityException;
import practica4.aplicacion.SistemasMetricos.IPhysicalUnit;
import practica4.aplicacion.SistemasMetricos.PhysicalUnit;
import practica4.aplicacion.SistemasMetricos.SiLengthMetricSystem;
import practica4.aplicacion.SistemasMetricos.SiTimeMetricSystem;

public class PhysicalUnitTest {
	public static void main(String[] args) throws QuantityException {
		
		PhysicalUnit metro = SiLengthMetricSystem.METER;
		PhysicalUnit kilometro = SiLengthMetricSystem.KILOMETER;
		PhysicalUnit milimetro = SiLengthMetricSystem.MILIMETER;
		PhysicalUnit segundo = SiTimeMetricSystem.SECOND;
		
		IPhysicalUnit meter = metro;
		System.out.println(meter);
		// This is how a meter is printed (abrev + Quantity)
		System.out.println(meter.canTransformTo(kilometro));
		// Yes, we can
		System.out.println(meter.canTransformTo(segundo));
		// No, we don't
		System.out.println("1000 m en km: " + meter.transformTo(1000, kilometro));
		System.out.println("1000 m en mm: " + meter.transformTo(1000, milimetro));
		try {
			System.out.println("1000 m en s: " + meter.transformTo(1000, segundo)); // Exception!
		} catch (QuantityException e) {
			System.out.println(e);
		}
	}
}