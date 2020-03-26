/**
 * Este fichero Libro.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 8/3/2017
 */
package es.uam.eps.ads.p3.biblioteca.repositorio.obras;

/**
 * Sobre esta clase, Libro, recae la tarea de almacenar y manejar la informacion
 * relativa a las obras (clase de la que hereda) de tipo libro.
 * @author Andres y Francisco
 */
public class Libro extends Obra {
	/** editorial del libro */
	private String editorial;
	/** edicion del libro */
	private int numEdicion;
	/** numero de ejemplares del libro que estan prestados */
	private int numPrestado;
	
	/**
	 * Constrcutor de la clase
	 * @param titulo
	 * @param autor
	 * @param anyo
	 * @param editorial
	 * @param numEdicion
	 */
	public Libro(String titulo, String autor, int anyo, String editorial, int numEdicion){
		super(titulo, autor, anyo);
		this.editorial = editorial;
		this.numEdicion = numEdicion;
		this.plazoPrestamo = 25;
		this.numPrestado = 0;
	}

	/**
	 * Constructor alternativo (faltan ciertos datos)
	 * @param titulo
	 * @param autor
	 * @param anyo
	 */
	public Libro(String titulo, String autor, int anyo){
		this(titulo, autor, anyo, null, 0);
	}

	@Override
	public String toString() {
		return "[L:" + titulo + ", de "+ autor + " (" + anyo + ") plazo:" + plazoPrestamo + "]";
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}

	public int getNumEdicion() {
		return numEdicion;
	}

	public void setNumEdicion(int numEdicion) {
		this.numEdicion = numEdicion;
	}
	
	@Override
	public int getPlazoPrestamo() {
		return this.plazoPrestamo;
	}
	
	/**
	 * se encarga de comprobar los plazos de prestamo para cada libro por
	 * si han de actualizarse
	 * @return plazo fijado tras la llamada.
	 */
	public int plazoPrestamo() {
		if (plazoPrestamo == 7) {
			numPrestado++;
			return this.plazoPrestamo;
		} else if ((numPrestado) == 10) {
			this.plazoPrestamo--;
			this.numPrestado = 0;
			return this.plazoPrestamo;
		}
		
		numPrestado++;
		return this.plazoPrestamo;
	}
	
}
