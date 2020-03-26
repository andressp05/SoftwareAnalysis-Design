/**
*  Implementación del tester
*
*  @file Fecha.java
*  @author Andres Salas andres.salas@estudiante.uam.es
*		   Francisco Vicente francisco.vicentel@estudiante.uam.es
*  @version 1.0
*  @date 25-02-2017
*/
package eps.uam.ads.p2.autoescuela.tester;

import eps.uam.ads.p2.autoescuela.personas.Alumno;
import eps.uam.ads.p2.autoescuela.personas.Profesor;
import eps.uam.ads.p2.autoescuela.Autoescuela;

/**
 * La clase TesterOpcional se encarga de comprobar que la implementacion del 
 * ejercicio 4 funciona correctamente
 */
public class TesterOpcional {

	public static void main(String[] args) {

		Alumno a1 = new Alumno(12345678, "Pedro", "García Gómez", "C/ Delicias 34",
644444243, 10, 2, 2016);
		Alumno a2 = new Alumno(22233444, "Lucía", "Pérez Rodríguez", "Avda. Mediterraneo 67", 655777372, 32, 5, 2016);
		Alumno a3 = new Alumno(33344666, "Beatríz", "Sánchez Ríos", "Paseo de los Olivos 54", 688990011, 4, 13, 2015);
		/* Creacion de profesores y autoescuelas */
		Profesor p1 = new Profesor(99887766, "Gema", "Bello Orgaz", "e336069",3,67896788);
		Profesor p2 = new Profesor(2824562, "Esther", "Guerra", "e336070",5,62395832);	
		Autoescuela ae1 = new Autoescuela(693,"c/ Paraiso 10","Maravillas",30);
		Autoescuela ae2 = new Autoescuela(323, "c/ Londres 10","Chaparral",10);
		
		System.out.println("Datos del alumno " + a1);
		System.out.println();
		System.out.println("Datos del alumno " + a2);
		System.out.println();
		System.out.println("Datos del alumno " + a3);
		System.out.println();
		/* Comprobacion de los metodos toString */
		System.out.println("Datos del profesor " + p1);
		System.out.println();
		System.out.println("Datos de la autoescuela " + ae1);
		System.out.println();
	
		/* contratacion y despido de profesores */
		ae1.addContrato(p1,5, 6, 2000, 3500.32);
		System.out.println("Autoescuela: " + ae1);
		ae1.addContrato(p2,6, 7, 2001, 1800.32);
		ae1.deleteContrato(28, 2, 2017,99887766);
		ae1.deleteContrato(1, 3, 2017,2824562);
		ae2.addContrato(p1, 1, 3, 2017, 1900.87);
		System.out.println("Autoescuela: " + ae2);
		
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
		System.out.println();
		/* Salida pedida para el apartado */
		System.out.println("El profesor " + p1.getNombre() + " " + p1.getApellidos() + " trabaja en " + ae1.getNombre() + " desde " + (ae1.getContrato())[0].getFechaIni() + " hasta " + (ae1.getContrato())[0].getFechaFin());
		System.out.println("El profesor " + p1.getNombre() + " " + p1.getApellidos() + " trabaja en " + ae2.getNombre() + " desde " + (ae2.getContrato())[0].getFechaIni() + " hasta " + (ae2.getContrato())[0].getFechaFin());
		System.out.println("El profesor " + p2.getNombre() + " " + p2.getApellidos() + " trabaja en " + ae1.getNombre() + " desde " + (ae1.getContrato())[1].getFechaIni() + " hasta " + (ae1.getContrato())[1].getFechaFin());
		}
}
	