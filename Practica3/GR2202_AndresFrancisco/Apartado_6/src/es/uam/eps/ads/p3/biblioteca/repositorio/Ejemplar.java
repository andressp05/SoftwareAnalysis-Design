/**
 * Este fichero Ejemplar.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 8/3/2017
 */
package es.uam.eps.ads.p3.biblioteca.repositorio;

import java.util.List;

import es.uam.eps.ads.p3.biblioteca.Biblioteca;
import es.uam.eps.ads.p3.biblioteca.Prestamo;
import es.uam.eps.ads.p3.biblioteca.repositorio.obras.Obra;
import es.uam.eps.ads.p3.biblioteca.usuarios.Usuario;

/**
 * La clase Ejemplar se encarga de representar los distintos ejemplares de cada
 * una de las obras existentes en una biblioteca.
 * @author Andres y Francisco
 */
public class Ejemplar {
	/** obra a la que corresponde el ejemplar */
	private Obra obra;
	/** contador usado para asignar los identificadores por orden de creacion */
	private static int cont;
	/** identificador del ejemplar */
	private int id;
	/** estado en el que se encuentra el ejemplar: disponible o prestado */
	private Estado estado;
	/**
	 * Usuario que tiene prestado el ejemplar actualmente en caso de no estar 
	 * disponible. En otro caso vale null 
	 */
	private Usuario usuario;
	
	/**
	 * Constructor de la clase 
	 * @param obra
	 */
	public Ejemplar(Obra obra) {
		this.obra = obra;
		cont++;
		this.id = cont;
		this.estado = Estado.DISPONIBLE;
		this.usuario = null;
		Biblioteca b = Biblioteca.getInstance();
		b.anyadirEjemplar(this);
	}
	
	@Override
	public String toString(){
		return "{"+ id + obra + "(" + estado + ")}"; 
	}

	public Obra getObra() {
		return obra;
	}

	public void setObra(Obra obra) {
		this.obra = obra;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	/**
	 * Este metodo se encargar de realizar las instrucciones necesarias
	 * a la hora de prestar un ejemplar
	 * @param u : usuario que presta
	 * @return p : Prestamo que se genera en el proceso
	 */
	public Prestamo prestar(Usuario u){
		if ( (this.estado.equals(Estado.PRESTADO) == true) || (u.getPrestamos().contains(this)) ||
				(recorreEjemplares(u) == false) || (u.getNumPrestamosSim() == u.getPrestamos().size()) ) {
			return null;
		}
		
		/* Modificacion apartado 6. Comprueba si el ejemplar esta retirado */
		if (Biblioteca.getInstance().getEjemplares().contains(this) == false) {
			return null;
		}
		
		Prestamo p = new Prestamo(this, u);
		
		if (u.anyadirPrestamo(p) == false) {
			return null;
		}
		
		p.prestamoAnyadido();
		this.usuario = u;
		this.estado = Estado.PRESTADO;
		return p;
	}
	
	/**
	 * Comprueba si un cierto usuario tiene prestado el ejemplar que nos ocupa
	 * @param u : usuario en cuestion
	 * @return boolean : true si no lo tiene prestado, false si lo tiene
	 */
	private boolean recorreEjemplares(Usuario u){
		Prestamo p;
		int i = 0;
		
		while (i < u.getPrestamos().size()) {
			p = u.getPrestamos().get(i);
			if (p.getEjemplar().getObra().equals(this.getObra())) {
				return false;
			}
			i++;
		}
		return true;
	}
	
	/**
	 * Este metodo se encarga de realizar las acciones precisas a la hora de que
	 * un usuario devuelva un ejemplar
	 * @return boolean : indica si la dovolucion se ha realizado correctamente o no
	 */
	public boolean devolver(){
		int i;
		Prestamo p;
		List<Prestamo> uprestamos = this.usuario.getPrestamos();
		
		for (i = 0; i < uprestamos.size(); i++) {
			p = uprestamos.get(i);
			if (p.getEjemplar().equals(this)) {
				p.prestamoDevuelto();
				
				if (this.usuario.eliminarPrestamo(p) == false) {
			    	return false;
			    }
				this.estado = Estado.DISPONIBLE;
				this.usuario = null;
				return true;
			}
		}
		return false;
	}
}
