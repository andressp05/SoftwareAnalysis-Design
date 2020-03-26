package practica4.testers;

import practica4.aplicacion.SistemasMetricos.IMetricSystem;
import practica4.aplicacion.SistemasMetricos.ImperialLengthMetricSystem;
import practica4.aplicacion.SistemasMetricos.SiLengthMetricSystem;
import practica4.aplicacion.SistemasMetricos.SiTimeMetricSystem;

public class MetricSystemTest {
	public static void main(String[] args) {
		IMetricSystem ms = SiLengthMetricSystem.SYSTEM;
		//new SiLengthMetricSystem(); compilation error
		System.out.println(ms.units());
		System.out.println("Base = " + ms.base());
		
		IMetricSystem ms2 = SiTimeMetricSystem.SYSTEM;
		System.out.println(ms2.units());
		System.out.println("Base = " + ms2.base());
		
		IMetricSystem ms3 = ImperialLengthMetricSystem.SYSTEM;
		System.out.println(ms3.units());
		System.out.println("Base = " + ms3.base());
		
		System.out.println(SiLengthMetricSystem.METER.canTransformTo(ImperialLengthMetricSystem.FOOT));		
		// No: different metric systems
		System.out.println(SiLengthMetricSystem.METER.canTransformTo(SiTimeMetricSystem.HOUR));		
		// No: different quantities
		System.out.println(SiLengthMetricSystem.KILOMETER.canTransformTo(SiLengthMetricSystem.METER));
	}
}