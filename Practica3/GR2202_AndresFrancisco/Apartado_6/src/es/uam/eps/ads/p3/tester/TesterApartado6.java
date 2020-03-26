package es.uam.eps.ads.p3.tester;

import static es.uam.eps.ads.p3.tester.DatosPruebas.*;
import es.uam.eps.ads.p3.biblioteca.*;

/**
 * Tester del apartado opcional
 * @author Andres y Francisco
 */
public class TesterApartado6 {
	
	public static void main(String[] args) {
		 
		 System.out.println( e11.prestar(u1) );     // OK, prestamo realizado         
		 System.out.println( e12.prestar(u1) );     // OK, prestamo realizado
		 e12.devolver();
		 
		 Biblioteca.getInstance().eliminarEjemplar(e11);  //No hace nada porque se encuentra prestado
		 Biblioteca.getInstance().eliminarEjemplar(e12);  //Retiramos el ejemplar e12
		 	
		 System.out.println( e12.prestar(u2) );     // ERROR, ejemplar retirado
		 System.out.println( e22.prestar(u3) );	    // OK, Reserva correcta de otro ejemplar de obra 2 que no ha sido retirado
		 
	  }

}
