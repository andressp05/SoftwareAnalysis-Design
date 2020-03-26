package es.uam.eps.ads.p3.tester;

import es.uam.eps.ads.p3.fechasimulada.FechaSimulada;
import static es.uam.eps.ads.p3.tester.DatosPruebas.*;
import es.uam.eps.ads.p3.biblioteca.*;
/**
 * Tester Apartado4 de la práctica 3
 * @author Profesores ADS
 */
public class TesterApartado4 {
	  public static void main(String[] args) {	 
		 e11.prestar(u1);      e12.prestar(u4);    e13.prestar(u1);    

		 FechaSimulada.avanzar( obra2.plazoPrestamo() );  // forzamos el vencimiento de la obra2 pelicula
		 System.out.println( "Vencen hoy " + FechaSimulada.getHoy()  + "\n" + Prestamo.conVencimientoHoy() +"\n");
		 
		 e21.prestar(u4); 
		 
		 FechaSimulada.avanzar(  obra1.plazoPrestamo() - obra2.plazoPrestamo() );  // forzamos el vencimiento de libros e11 y e13
		 System.out.println( "Vencen hoy " + FechaSimulada.getHoy()  + "\n" + Prestamo.conVencimientoHoy());
		 
		 // De momento solo hay uno pasado de vencimiento
		 System.out.println( "\nPasados de vencimiento " + FechaSimulada.getHoy()  + "\n" + Prestamo.pasadosDeVencimiento());
		 
		 // Avanzamos un día más, los dos de vencimiento ayer, también estan vencidos hoy, total 3
		 FechaSimulada.avanzar( 1 );  
		 System.out.println( "\nPasados de vencimiento " + FechaSimulada.getHoy()  );
	     for (Prestamo p :  Prestamo.pasadosDeVencimiento() ) {  
	    	 System.out.println( p );   	    
	     } 
	     System.out.println( "-----");
	     
	    // Avanzamos unos días más, y los 4 préstamos estarán vencidos, y se van devolviendo
  		 FechaSimulada.avanzar( 3 );  
  		 System.out.println( "\nPasados de vencimiento " + FechaSimulada.getHoy()  );
  	     for (Prestamo p :  Prestamo.pasadosDeVencimiento() ) {  
  	    	 if ( p.devolver() ) System.out.println( p  );   	    
  	     } 
  		 System.out.println( "\nYa no debe haber préstamos pasados de vencimiento " ); 
  	     System.out.println( Prestamo.pasadosDeVencimiento()  );   	    
	  }
	}

