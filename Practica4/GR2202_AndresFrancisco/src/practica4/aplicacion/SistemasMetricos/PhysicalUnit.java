/**
 * Este fichero PhysicalUnit.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 31/3/2017
 */
package practica4.aplicacion.SistemasMetricos;

import practica4.aplicacion.Excepciones.QuantityException;
import practica4.aplicacion.SistemasMetricos.IMetricSystem;
import practica4.aplicacion.SistemasMetricos.MetricSystem;

/**
 * La clase PhysicalUnit es una de las mas basicas de este programa y es la encargada de implementar
 * la funcionalidad relitiva al uso de unidades fisicas, las cuales a parte de pertenecer a un sistema
 * metrico determinado y estar caracterizados por una Quantity, tienen una abreviatura y un coeficiente
 * de conversion a la base de su sistema.
 * @author Andres y Francisco
 */
public class PhysicalUnit implements IPhysicalUnit {
	/** Propiedad fisica que mide esta unidad */	
	private Quantity quantity;
	/** Abreviatura de esta unidad */
	private String abbrev;
	/** Coeficiente de conversion entre esta unidad y la base de su sistema (1 si se trata de la base) */
	private double equivBase;
	/** Sistema metrico al cual pertenece esta unidad fisica */
	private MetricSystem ms;
	
	/**
	 * Constructor de la clase
	 * @param quantity : propiedad a medir
	 * @param abbrev : abreviatura de la unidad
	 * @param equivBase : coeficiente de conversion a la base del sistema
	 * @param ms : sistema metrico al que pertenece
	 */
	protected PhysicalUnit(Quantity quantity, String abbrev, double equivBase, MetricSystem ms) {
		this.quantity = quantity;
		this.abbrev = abbrev;
		this.equivBase = equivBase;
		this.ms = ms;
	}

	public Quantity getQuantity() {
		return this.quantity;
	}
	
	public String abbrev() {
		return this.abbrev;
	}
	
	public double getBase() {
		return this.equivBase;
	}
	
	public IMetricSystem getMetricSystem() {
		return ms;
	}

	/**
	 * Comprueba si esta unidad fisica puede convertida a otra. Para ello deben pertenecer al mismo 
	 * sistema y medir la misma propiedad fisica
	 * @param u : unidad fisica a la que comprobamos si se puede transformar
	 * @return true en caso afirmativo, false en el negativo
	 */
	public boolean canTransformTo(IPhysicalUnit u) {
		if( this.getQuantity().equals(u.getQuantity()) && this.getMetricSystem().equals(u.getMetricSystem())) {
			return true;
		}
		return false;
	}
	
	/**
	 * Tranforma una cierta cantidad de esta unidad a otra unidad dando error si la conversion no
	 * fuera posible
	 * @param d : valor a convertir
	 * @param u : unidad a la que se desea convertir
	 * return valor numerico obtenido tras la conversion
	 */
	public double transformTo(double d, IPhysicalUnit u) throws QuantityException {
		double base;
		if ( this.canTransformTo(u) == false ) {
			//System.out.println(new QuantityException(this, u));
			throw new QuantityException(this, u);
		}	
		base = this.getBase();
		return d * base * (1 / ((PhysicalUnit)u).getBase());
	}
	
	@Override
	public String toString() {
		return abbrev + " " + quantity;
	}

	
	
}
