/**
 * Este fichero Biblioteca.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 20/3/2017
 */
package es.uam.eps.ads.p3.biblioteca;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.uam.eps.ads.p3.biblioteca.repositorio.Ejemplar;
import es.uam.eps.ads.p3.biblioteca.repositorio.Estado;
import es.uam.eps.ads.p3.biblioteca.repositorio.obras.Obra;
import es.uam.eps.ads.p3.biblioteca.usuarios.Usuario;

/**
 * La clase Biblioteca es una extra del apartado 6 que pide implementarla
 * segun singleton para habilitar un registro historico de los elementos de
 * una biblioteca
 * @author Andres y Francisco
 */
public class Biblioteca {
	/** instancia de la clase */
	private static Biblioteca INSTANCE;
	/** usuarios de una biblioteca */
	private ArrayList<Usuario> usuarios;
	/** ejemplares de una biblioteca */
	private ArrayList<Ejemplar> ejemplares;
	/** prestamos de una biblioteca */
	private ArrayList<Prestamo> prestamos;
	/** obras de una biblioteca */
	private ArrayList<Obra> obras;
	
	/**
	 * Constructor de la clase. Es privado para adecuarse al singleton
	 */
	private Biblioteca() {
		usuarios = new ArrayList<Usuario>();
		ejemplares = new ArrayList<Ejemplar>();
		prestamos = new ArrayList<Prestamo>();
		obras = new ArrayList<Obra>();
	}
	
	public List<Ejemplar> getEjemplares() {
		return Collections.unmodifiableList(this.ejemplares);
	}
	
	/**
	 * obtiene la instancia a biblioteca
	 * @return la biblioteca
	 */
	public static Biblioteca getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new Biblioteca();
		}
		return INSTANCE;
	}
	
	/**
	 * anyade un nuevo usuario a la biblioteca
	 * @param u usuario a anyadir
	 */
	public void anyadirUsuario(Usuario u) {
		usuarios.add(u);
	}
	
	/**
	 * anyade un nuevo ejemplar a la biblioteca
	 * @param e : ejemplar a anyadir
	 */
	public void anyadirEjemplar(Ejemplar e) {
		ejemplares.add(e);
	}
	
	/**
	 * anyade un nuevo prestamo a la biblioteca
	 * @param p : prestamo a anyadir
	 */
	public void anyadirPrestamo(Prestamo p) {
		prestamos.add(p);
	}
	
	/**
	 * anyade una nueva obra a la biblioteca
	 * @param o : obra a anyadir
	 */
	public void anyadirObra(Obra o) {
		obras.add(o);
	}
	
	/**
	 * elimina cierto ejemplar de una bilioteca realizando las
	 * comprobaciones pertinentes
	 * @param e : ejemplar a eliminar
	 * @return si se ha eliminado satisfactoriamente o no
	 */
	public boolean eliminarEjemplar(Ejemplar e) {
		for (Ejemplar ejem : ejemplares) {
			if (ejem.equals(e)) {
				if (e.getEstado().equals(Estado.DISPONIBLE)){ 
					return ejemplares.remove(e);
				}
				return false;
			}
		}
		return false;
	}
	
	/**
	 * elimina cierta obra de una bilioteca asi como los ejemplares
	 * de esta realizando las comprobaciones pertinentes
	 * @param o : obra a eliminar
	 * @return si se ha eliminado satisfactoriamente o no
	 */
	public boolean eliminarObra(Obra o) {
		for (Ejemplar ejem : ejemplares) {
			if (o.equals(ejem.getObra()) && ejem.getEstado().equals(Estado.PRESTADO)) {
				return false;
			}	
		}
		
		for (Ejemplar ejem : ejemplares) {
			if (o.equals(ejem.getObra())) {
				eliminarEjemplar(ejem);
			}	
		}
		return obras.remove(o);
	}
	
}




