/**
 * Este fichero Obra.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 8/3/2017
 */
package es.uam.eps.ads.p3.biblioteca.repositorio.obras;

import java.util.ArrayList;

import es.uam.eps.ads.p3.biblioteca.Biblioteca;
import es.uam.eps.ads.p3.biblioteca.repositorio.Ejemplar;

/**
 * La clase Obra se trata de una clase abstracta la cual generaliza el
 * comportamiento comun de las clases Libro y Pelicula.
 * @author Andres y Francisco
 */
public abstract class Obra {
	/** titulo de la obra */
	protected final String titulo;
	/** autor de la obra */
	protected final String autor;
	/** anyo de publicacion de la obra */
	protected final int anyo;
	/** numero maximo de dias para tomar una obra prestada */
	protected int plazoPrestamo;
	/** ejemplares de la obra */
	protected ArrayList<Ejemplar> ejemplares = new ArrayList<>();
	
	/**
	 * Contructor de la clase
	 * @param titulo
	 * @param autor
	 * @param anyo
	 */
	public Obra(String titulo, String autor, int anyo) {
		this.titulo = titulo;
		this.autor = autor;
		this.anyo = anyo;
		Biblioteca b = Biblioteca.getInstance();
		b.anyadirObra(this);
	}

	
	@Override
	public String toString() {
		return "Obra [titulo=" + titulo + ", autor=" + autor + ", anyo=" + anyo + "]";
	}
	
	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public int getAnyo() {
		return anyo;
	}
	
	public abstract int getPlazoPrestamo();
	
	
	public abstract int plazoPrestamo();
	
	/**
	 * comprueba si dos obras son iguales, entendiendo que basta con que su
	 * titulo y autor coincidan para que lo sean
	 * @return si son iguales o no
	 */
	public boolean equals(Object o) {
		if(o == this) {
			return true;
		} else if(o instanceof Obra) {
			Obra obra = (Obra) o;
			return ((this.titulo == obra.titulo) && (this.autor == obra.autor));
		}
		return false;
	}
}
