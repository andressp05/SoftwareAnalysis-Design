/**
 * Este fichero Prestamo.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 8/3/2017
 */
package es.uam.eps.ads.p3.biblioteca;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;

import es.uam.eps.ads.p3.fechasimulada.FechaSimulada;
import es.uam.eps.ads.p3.biblioteca.repositorio.Ejemplar;
import es.uam.eps.ads.p3.biblioteca.usuarios.Usuario;

/**
 * La clase Prestamo es la encargada de manejar lo relativo al prestamo de 
 * ejemplares por parte de los distintos usurarios de una biblioteca
 * @author Andres y Francisco
 */
public class Prestamo {
	/** ejemplar prestado */
	private Ejemplar ejemplar;
	/** usuario que presta */
	private Usuario usuario;
	/** fecha de vencimiento */
	private LocalDate fechaFin;
	/** fecha de devolucion */
	private LocalDate fechaDevuelto;
	/** cantidad de ejemplares prestados en total */
	private static int numHistorico = 0;
	/** cantidad de ejemplares prestados sin haber sido devueltos aun */
	private static int numPendientes = 0;
	/** conjunto de prestamos aun pendientes */
	private static ArrayList<Prestamo> pendientes = new ArrayList<Prestamo>();
	
	/**
	 * Constructor de la clase.
	 * @param ejemplar
	 * @param usuario
	 */
	public Prestamo (Ejemplar ejemplar, Usuario usuario) {
		this.ejemplar = ejemplar;
		this.usuario = usuario;
		this.fechaFin = FechaSimulada.getHoy();
		this.fechaFin = FechaSimulada.avanzar(ejemplar.getObra().getPlazoPrestamo());
		FechaSimulada.avanzar(-ejemplar.getObra().getPlazoPrestamo());
		this.fechaDevuelto = null;
	}
	
	@Override
	public String toString() {
		if (this.fechaDevuelto != null) {
			return ejemplar + " prestado a "+ usuario + " hasta " + fechaFin + " devuelto " + fechaDevuelto;
		} else {
			return ejemplar + " prestado a "+ usuario + " hasta " + fechaFin;
		}
	}
	
	public Ejemplar getEjemplar() {
		return ejemplar;
	}

	public static int numPrestamosHistoricos() {
		return numHistorico;
	}
	
	public static int numPrestamosPendientes() {
		return numPendientes;
	}
	
	/**
	 * Maneja adecuadamente los contadores de la clase al realizarse un nuevo prestamo
	 */
	public void prestamoAnyadido(){
		numPendientes++;
		numHistorico++;
		Prestamo.pendientes.add(this);
	}
	
	/**
	 * Maneja adecuadamente los contadores de la clase al devolverse un prestamo
	 */
	public void prestamoDevuelto(){
		numPendientes--;
		Prestamo.pendientes.remove(this);
	}
	
	/**
	 *  obtiene los dias que la obra de un prestamo esta retrasada 
	 */
	private int diasRetraso() {
		return Period.between(this.fechaFin, FechaSimulada.getHoy()).getDays();
	}

	/**
	 * devuelve los prestamos cuya fecha de devolucion ya ha vencido
	 * @return lista de aquellos prestamos atrasados
	 */
	public static ArrayList<Prestamo> pasadosDeVencimiento() {
		ArrayList<Prestamo> atrasados = new ArrayList<Prestamo>();
		
		for (Prestamo p : Prestamo.pendientes) {
			if (p.diasRetraso() > 0) {
				atrasados.add(p);
			}
		}
		return atrasados;
	}

	/**
	 * devuelve los prestamos cuya fecha de devolucion coincide con el dia actual
	 * @return lista de aquellos prestamos que vencen hoy
	 */
	public static ArrayList<Prestamo> conVencimientoHoy() {
		ArrayList<Prestamo> vencenHoy = new ArrayList<Prestamo>();
		
		for (Prestamo p : Prestamo.pendientes) {
			if (p.diasRetraso() == 0) {
				vencenHoy.add(p);
			}
		}
		return vencenHoy;
	}

	/**
	 * se encarga de devolver un prestamo, eliminandolo correctamente del resto de clases
	 * @return si se ha devuelto satisfactoriamente o no
	 */
	public boolean devolver() {
		int retraso = Period.between(fechaFin, FechaSimulada.getHoy()).getDays();
		
		if (retraso > 0) {
			usuario.sancionarPorRetraso(retraso);
		}
		this.fechaDevuelto = FechaSimulada.getHoy();
		
		return ejemplar.devolver();
	}
	
}
