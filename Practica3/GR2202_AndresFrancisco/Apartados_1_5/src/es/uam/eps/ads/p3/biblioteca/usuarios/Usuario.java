/**
 * Este fichero Usuario.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 10/3/2017
 */
package es.uam.eps.ads.p3.biblioteca.usuarios;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import es.uam.eps.ads.p3.biblioteca.Prestamo;

/**
 * La clase Usuario se trata de una clase abstracta la cual generaliza el
 * comportamiento comun de las clases Publico y Empleado.
 * @author Andres y Francisco
 */
public abstract class Usuario {
	/** nombre del usuario */
	protected final String nombre;
	/** limite de prestamos del usuario */
	protected int numPrestamosSim;
	/** listado de prestamos asociados al usuario */
	protected ArrayList<Prestamo> prestamos = new ArrayList<>();
	
	/**
	 * constructor de la clase
	 * @param nombre
	 */
	public Usuario(String nombre) {
		super();
		this.nombre = nombre;
	}
	
	public int getNumPrestamosSim() {
		return numPrestamosSim;
	}

	public void setNumPrestamosSim(int numPrestamosSim) {
		this.numPrestamosSim = numPrestamosSim;
	}
	
	/**
	 * Este no es un getter normal pues para asegurar la hermeticidad de esta clase
	 * debemos devolver un arrayList que no se pueda modificar desde el exterior
	 * @return lista de prestamos inmodificable
	 */
	public List<Prestamo> getPrestamos() {
		return Collections.unmodifiableList(this.prestamos);
	}

	public void setPrestamos(ArrayList<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}

	public String getNombre() {
		return nombre;
	}

	/**
	 * anyade un prestamo asociado al usuario comprobando si ha alcanzado
	 * su limite.
	 * @param pf : nuevo prestamo
	 * @return si se ha anyadido correctamente o no
	 */
	public abstract boolean anyadirPrestamo(Prestamo pf);

	/**
	 * elimina un prestamo asociado al usuario que nos ocupa
	 * @param pf : prestamo a eliminar
	 * @return si se ha eliminado correctamente o no
	 */
	public abstract boolean eliminarPrestamo(Prestamo pf);
	
	/**
	 * realiza las acciones necesarias para sancinar a un usuario
	 * @param numDias : numero de dias pasados desde el vencimiento
	 */
	public abstract void sancionarPorRetraso(int numDias);
	
	/** elimina la sancion de un usuario */
	public abstract void eliminarSancion();
}
