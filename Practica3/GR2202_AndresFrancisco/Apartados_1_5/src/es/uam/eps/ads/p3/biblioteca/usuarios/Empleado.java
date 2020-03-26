/**
 * Este fichero Empleados.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 10/3/2017
 */
package es.uam.eps.ads.p3.biblioteca.usuarios;

import es.uam.eps.ads.p3.biblioteca.Prestamo;

/**
 * La clase Empleados se encarga de implementar la funcionalidad necesaria
 * para manejar a los usuarios de tipo empleado en una biblioteca.
 * @author Andres y Francisco
 */
public class Empleado extends Usuario {
	/** cantidad que supone una sancion para el empleado */
	private double sancion;
	
	/**
	 * constructor de la clase
	 * @param nombre
	 */
	public Empleado(String nombre) {
		super(nombre);
		sancion = 0.0;
		numPrestamosSim = 20;
	}

	@Override
	public String toString() {
		if (sancion != 0.0) {
			return "[E: " + nombre +" $"+ sancion +"]";
		}
		return "[E: " + nombre +"]";
	}

	@Override
	/**
	 * anyade un prestamo asociado al empleado comprobando si ha alcanzado
	 * su limite.
	 * @param pf : nuevo prestamo
	 * @return si se ha anyadido correctamente o no
	 */
	public boolean anyadirPrestamo(Prestamo pf) {
		if (prestamos.size() == 20) {
			return false;
		}
		prestamos.add(pf);
		return true;
	}

	@Override
	/**
	 * elimina un prestamo asociado al empleado que nos ocupa
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
	/**
	 * realiza las acciones necesarias para sancinar a un empleado
	 * @param numDias : numero de dias pasados desde el vencimiento
	 */
	public void sancionarPorRetraso(int numDias) {
		if (numDias <= 4) {
			return;
		}
		calculaRetraso(numDias);
		return;
	}
	
	/**
	 * actualiza la sancion a realizar sobre un empleado en funcion
	 * del numero de dias que se haya retrasado
	 * @param numDias
	 * @return sancion fijada tras la llamada
	 */
	public double calculaRetraso(int numDias) {
		sancion += 2.5*numDias; 
		return sancion;
	}
	
	@Override
	/** elimina la sancion de un usuario */
	public void eliminarSancion() {
		sancion = 0;
		return;
	}
}
