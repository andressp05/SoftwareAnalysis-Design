package es.uam.eps.ads.p3.tester;

import es.uam.eps.ads.p3.biblioteca.*;
import static es.uam.eps.ads.p3.tester.DatosPruebas.*;
/**
 * Tester Apartado 1 de la práctica 3
 * @author Profesores ADS
 */
public class TesterApartado1 {
  public static void main(String[] args) {
		 
     // veamos el contenido de algunos objetos
	 System.out.println( u1 );    System.out.println( u4 );
	 System.out.println( obra1 ); System.out.println( obra2 ); 	 // con plazos de prestamo iniciales 

	// en el constructor Prestamo se debe usar  FechaSimulada.getHoy() para obtener fecha "simulada" de hoy
	 Prestamo pf = new Prestamo(e11, u1); // préstamo ficticio reutilizado para simular múltiples préstamos
	 // veamos cómo un usuario Publico gana privilegios según se le hace préstamos (ver enunciado)
    System.out.println(u1); 
    for (int i = 1; i <= 4; i++) { 
    	 u1.anyadirPrestamo(pf);  u1.eliminarPrestamo(pf);  System.out.println(u1);
    }
    

    // el plazo de prestamo de la obra 1 sigue siendo el inicial, pero BAJA tras 20 préstamos más
    System.out.println(obra1); 
    for (int i = 1; i <= 20; i++) { 
    	 u1.anyadirPrestamo(pf);  u1.eliminarPrestamo(pf); 
    }
    System.out.println(obra1);
    
    // sanciones por retraso a un usuario Publico
    u1.sancionarPorRetraso(2);  // pierde parte de los privilegios ganados arriba
    System.out.println(u1);
    
    // sanciones por retraso a un Empleado
    System.out.println(u4); 
    u4.sancionarPorRetraso(10);     System.out.println(u4); // suma 25
    u4.sancionarPorRetraso(3);      System.out.println(u4); // perdonado, menos de 4 días
    u4.sancionarPorRetraso(5);      System.out.println(u4); // suma 5 x 2.5 = 12.75
    u4.eliminarSancion();           System.out.println(u4); // paga sus sancion, a cero.                     	
  }
}
