package es.uam.eps.ads.p3.tester;

import es.uam.eps.ads.p3.fechasimulada.FechaSimulada;
import static es.uam.eps.ads.p3.tester.DatosPruebas.*;
import es.uam.eps.ads.p3.biblioteca.*;
/**
 * Tester Apartado3 de la practica 3
 * @author Profesores ADS
 */
public class TesterApartado3 {
	  public static void main(String[] args) {
		 System.out.println( e11 );   System.out.println( e14 );
		 
		 System.out.println( e11.prestar(u1) );     // OK, prestamo realizado         
		 System.out.println( e12.prestar(u1) );     // OK, prestamo realizado  
		 System.out.println( e13.prestar(u1) );     // rechazar por exceso de prestamos, ya tiene 2 prestados
		 
		 System.out.println( e13.prestar(u4) );     // OK, porque no se presto en linea anterior
		 System.out.println( e21.prestar(u4) );     // OK
		 System.out.println( e22.prestar(u4) );     // OK porque el limite de prestamos de empleados es superior a 2
		 
		 System.out.println( e13.prestar(u2) );     // rechazar por ya prestado (a cualquier usuario)
		 System.out.println( e23.prestar(u2) );     // OK ejemplar 2 de obra 3 esta disponible
		 System.out.println( e33.prestar(u2) );     // rechazar  u2 ya tiene otro ejemplar (el 2) de la "misma" obra (la 3)
 
		 System.out.println( e14.prestar(u2) );     // rechazar  u2 ya tiene otro ejemplar (el 2) de la "misma" obra (la 3 tiene mismo titulo y autor que la obra 4)	     
		 System.out.println( e33.prestar(u3) );     // OK, prestamo realizado  porque u3 NO ES  el mismo usuario que u2
		 
	     e22.devolver();  // sin sancion
	     e21.devolver();  // sin sancion
	     e12.devolver();  // sin sancion
	     
	     FechaSimulada.avanzar( 3 ); // adelantar la fecha simulada 3 dias
	     System.out.println( "\nFecha simulada: " + FechaSimulada.getHoy() );
	     
	     System.out.println( e22.prestar(u1) ); // OK, e22 se devolvio, y u1 no supera limite de prestamos simultaneos
	     System.out.println( "\nPrestamos actuales de " + u1 + "\n" + u1.getPrestamos() );
	     
	     System.out.println( "Num. prestamos realizados: " + Prestamo.numPrestamosHistoricos() );   // 8 segun mis cuentas
	     System.out.println( "Num. prestamos pendientes: " + Prestamo.numPrestamosPendientes() );  // 5 segun mis cuentas   
	  }
 }

