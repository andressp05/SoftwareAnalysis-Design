package eps.uam.ads.p2.autoescuela.tester;

import eps.uam.ads.p2.autoescuela.alumnos.Alumno;

/**
 * Tester cel primer apartado de la P2
 * @author Profesores ADS
 */ 

public class TesterAlumnos {

	public static void main(String[] args) {

		Alumno a1 = new Alumno(12345678, "Pedro", "García Gómez", "C/ Delicias 34",
644444243, 10, 2, 2016);
		Alumno a2 = new Alumno(22233444, "Lucía", "Pérez Rodríguez", "Avda. Mediterraneo 67", 655777372, 32, 5, 2016);
		Alumno a3 = new Alumno(33344666, "Beatríz", "Sánchez Ríos", "Paseo de los Olivos 54", 688990011, 4, 13, 2015);
		
		System.out.println("Datos del alumno " + a1);
		System.out.println();
		System.out.println("Datos del alumno " + a2);
		System.out.println();
		System.out.println("Datos del alumno " + a3);
		System.out.println();

		System.out.println("isValida <" + a1.getFechaMatricula().getFecha() + "> ? " +
a1.isFechaValida(a1.getFechaMatricula()));
		System.out.println("isValida <" + a2.getFechaMatricula().getFecha() + "> ? " +
a2.isFechaValida(a2.getFechaMatricula()));
		System.out.println("isValida <" + a3.getFechaMatricula().getFecha() + "> ? " +
a3.isFechaValida(a3.getFechaMatricula()));
		
		a1.setFechaSupTeorico(15, 3, 2016);
		a1.setFechaSupPractico(13, 5, 2016);
		
		System.out.println();
		System.out.println("El alumno " + a1.getNombreYApellidos() + " aprobó el examen teórico el día " + a1.getFechaSupTeorico().getFecha());
		System.out.println("El alumno " + a1.getNombreYApellidos() + " aprobó el examen práctico el día "+ a1.getFechaSupPractico().getFecha());

	}

}