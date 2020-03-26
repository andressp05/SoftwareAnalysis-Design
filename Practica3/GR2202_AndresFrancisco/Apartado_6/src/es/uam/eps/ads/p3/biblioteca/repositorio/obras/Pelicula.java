/**
 * Este fichero Pelicula.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 8/3/2017
 */
package es.uam.eps.ads.p3.biblioteca.repositorio.obras;

/**
 * La clase Pelicula es la encargada de almacenar y manejar la informacion
 * referente a las obras de tipo pelicula de una biblioteca. Es una clase 
 * heredera de Obra.
 * @author Andres y Francisco
 */
public class Pelicula extends Obra {
	/** genero al que pertenece la pelicula */
	private Genero genero;
	
	/**
	 * Constructor de la clase
	 * @param titulo
	 * @param autor
	 * @param anyo
	 * @param genero
	 */
	public Pelicula(String titulo, String autor, int anyo, Genero genero){
		super(titulo,autor,anyo);
		this.genero = genero;
		this.plazoPrestamo = 2;
	}

	@Override
	public String toString() {
		return "[P: "+ titulo + ", de "+ autor + "(" + anyo + ") plazo:" + plazoPrestamo + "]";
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	@Override
	public int getPlazoPrestamo() {
		return this.plazoPrestamo;
	}

	@Override
	/**
	 * se encarga de comprobar los plazos de prestamo para cada pelicula
	 * @return plazo fijado tras la llamada.
	 */
	public int plazoPrestamo() {
		this.plazoPrestamo = 2;
		return this.plazoPrestamo;
	}

	
	
}
