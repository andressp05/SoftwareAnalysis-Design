/**
 * Este fichero Publico.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 8/3/2017
 */
package es.uam.eps.ads.p3.biblioteca.usuarios;

import es.uam.eps.ads.p3.biblioteca.Prestamo;

/**
 * La clase Publico se encarga de implementar la funcionalidad necesaria
 * para manejar a los usuarios publicos de una biblioteca.
 * @author Andres y Francisco
 */
public class Publico extends Usuario {
	/**
	 * cuenta las series de ejemplares que un usuario de este tipo
	 * ha devuelto existosamente
	 */
	int numPrestamosTot;
	
	/**
	 * Constrcutor de la clase
	 * @param nombre
	 */
	public Publico(String nombre) {
		super(nombre);
		numPrestamosSim = 2;
		numPrestamosTot = 0;
	}
	
	@Override
	public String toString() {
		return "[P: " + nombre + ",ppb:" + numPrestamosTot + ",ps:"+ numPrestamosSim +"]";
	}

	public int getNumPrestamosTot() {
		return numPrestamosTot;
	}

	public void setNumPrestamosTot(int numPrestamosTot) {
		this.numPrestamosTot = numPrestamosTot;
	}

	@Override
	/**
	 * anyade un prestamo asociado al usuario publico comprobando si ha alcanzado
	 * su limite.
	 * @param pf : nuevo prestamo
	 * @return si se ha anyadido correctamente o no
	 */
	public boolean anyadirPrestamo(Prestamo pf) {
		if (prestamos.size() == getNumPrestamosSim()) {
			return false;
		}
		prestamos.add(pf);
		numPrestamosTot++;
		pf.getEjemplar().getObra().plazoPrestamo();
		if (numPrestamosTot > numPrestamosSim) {
			numPrestamosTot = 1;
			numPrestamosSim++;
		}
		return true;
	}
	
	@Override
	/**
	 * realiza las acciones necesarias para sancinar a un usuario publico
	 * @param numDias : numero de dias pasados desde el vencimiento
	 */
	public void sancionarPorRetraso(int numDias) {
		numPrestamosTot -= numDias;
		if (numPrestamosTot < 0) {
			numPrestamosTot = 0;
		}
		numPrestamosSim = 2;
	}
	
	@Override
	/**
	 * elimina un prestamo asociado al usuario publico que nos ocupa
	 * @param pf : prestamo a eliminar
	 * @return si se ha eliminado correctamente o no
	 */
	public boolean eliminarPrestamo(Prestamo pf) {
		if (prestamos.size() == 0 || prestamos.contains(pf) == false) {
			return false;
		}
		
		prestamos.remove(pf);
		return true;
	}

	@Override
	/** elimina la sancion de un usuario */
	public void eliminarSancion() {
		return;
	}

}
