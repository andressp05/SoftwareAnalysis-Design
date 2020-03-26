package es.uam.eps.ads.p3.tester;

import es.uam.eps.ads.p3.biblioteca.repositorio.*;
import es.uam.eps.ads.p3.biblioteca.repositorio.obras.*;
import es.uam.eps.ads.p3.biblioteca.usuarios.*;

/**
 * Datos comunes para testers de la practica 3
 * @author Profesores ADS
 */
public abstract class DatosPruebas {	  
    public static final Obra obra1 = new Libro("La Caverna", "Saramago", 2000, "Alfaguara", 9);			
    public static final Obra obra2 = new Pelicula("Atame", "Almodovar", 1990, Genero.DRAMA);
    public static final Obra obra3 = new Libro("Crepusculo", "Meyer", 2008, "Alfaguara", 1);
    public static final Obra obra4 = new Libro("Crepusculo", "Meyer", 2011); // otro construtor menos parametros, 
                                                         // pero es la misma obra  con equals() aunque sea otro objeto en el catalogo
    public static final Usuario u1 = new Publico("Ramon");
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
