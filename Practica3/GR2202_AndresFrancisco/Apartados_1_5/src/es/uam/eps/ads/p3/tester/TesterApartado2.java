package es.uam.eps.ads.p3.tester;

import static es.uam.eps.ads.p3.tester.DatosPruebas.*;
/**
 * Tester Apartado 2 de la práctica 3
 * @author Profesores ADS
 */
public class TesterApartado2 {
  public static void main(String[] args) { 
     // u2 y u3 son estudiantes, ambas de nombre "Ana" pero debe considerarse distintas
     System.out.println("u2.equals(u3): " + u2.equals(u3) ); // debe imprimir false
     // u4 y u5 son el mismo objeto, comparten estructura de datos y contenido
     System.out.println("u4.equals(u5): " + u4.equals(u5) ); // debe imprimir true
     // obra3 y obra4 deben considerarse como la misma obra (mismo título y autor)
     System.out.println("obra3.equals(obra4): " + obra3.equals(obra4) ); // debe imprimir true
     // pero sus ejemplares no son iguales
     System.out.println("e23.equals(e14): " + e23.equals(e14) ); // debe imprimir false                       	
  }
}
