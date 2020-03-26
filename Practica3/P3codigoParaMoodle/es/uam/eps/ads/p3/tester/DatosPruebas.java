package es.uam.eps.ads.p3.tester;
import static es.uam.eps.ads.p3.tester.DatosPruebas.e11;
import static es.uam.eps.ads.p3.tester.DatosPruebas.u1;

import es.uam.eps.ads.p3.biblioteca.*;

/**
 * Datos comunes para testers de la práctica 3
 * @author Profesores ADS
 */
public abstract class DatosPruebas {	  
    public static final Obra obra1 = new Libro("La Caverna", "Saramago", 2000, "Alfaguara", 9);			
    public static final Obra obra2 = new Pelicula("Atame", "Almodóvar", 1990, Genero.DRAMA);
    public static final Obra obra3 = new Libro("Crepúsculo", "Meyer", 2008, "Alfaguara", 1);
    public static final Obra obra4 = new Libro("Crepúsculo", "Meyer", 2011); // otro construtor menos parametros, 
                                                         // pero es la misma obra  con equals() aunque sea otro objeto en el catalogo
    public static final Usuario u1 = new Publico("Ramón");
    public static final Usuario u2 = new Publico("Ana"); 
    public static final Usuario u3 = new Publico("Ana");  // no es el mismo usuario que u2
    public static final Usuario u4 = new Empleado("Marta");
    public static final Usuario u5 = u4;
    
    public static final Ejemplar e11 = new Ejemplar(obra1); 
    public static final Ejemplar e21 = new Ejemplar(obra1); // e21, ejemplar 2 de la obra 1
    public static final Ejemplar e31 = new Ejemplar(obra1);
    public static final Ejemplar e12 = new Ejemplar(obra2);    
    public static final Ejemplar e22 = new Ejemplar(obra2);
    public static final Ejemplar e32 = new Ejemplar(obra2);
    public static final Ejemplar e13 = new Ejemplar(obra3);    
    public static final Ejemplar e23 = new Ejemplar(obra3);
    public static final Ejemplar e33 = new Ejemplar(obra3);
    public static final Ejemplar e14 = new Ejemplar(obra4); 
   
}
