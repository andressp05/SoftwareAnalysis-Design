/**
 * Este fichero Magnitude.java implementa la clase homonima
 * @author Andres y Francisco
 * @version 1.0
 * @date 31/3/2017
 */
package practica4.aplicacion.Magnitudes;

import practica4.aplicacion.Excepciones.QuantityException;
import practica4.aplicacion.Excepciones.UnknownUnitException;
import practica4.aplicacion.SistemasMetricos.IPhysicalUnit;
import practica4.aplicacion.SistemasMetricos.PhysicalUnit;

/**
 * La clase Magnitude se encarga de manejar este tipo de datos los cuales simplemente
 * constan de un cierto valor numerico y una determinada unidad fisica.
 * @author Andres y Francisco
 */
public class Magnitude implements IMagnitude {
	/** Valor numerico que presenta la magnitud */
	private double valor;
	/** Unidades fisicas en la que se muestra el valor de la magnitud */
	private PhysicalUnit unidad;
	
	/**
	 * Constructor principal de la clase
	 * @param valor : valor numerico
	 * @param unidad : unidad fisica
	 */
	public Magnitude(double valor, PhysicalUnit unidad) {
		this.valor = valor;
		this.unidad = unidad;
	}
	
	/**
	 * Constructor alternativo para crear una magnitud vacia
	 */
	public Magnitude() {
		
	}

	@Override
	public IPhysicalUnit getUnidad() {
		return unidad;
	}

	@Override
	public double getValor() {
		return valor;
	}

	public void setValor(double d) {
		valor = d;
	}

	public void setUnidad(PhysicalUnit to) {
		unidad = to;
	}

	@Override
	/**
	 * Suma a esta magnitud la pasada como argumento, tras la previa conversion pertinente
	 * @param m : magnitud a sumar
	 * @return resultado de la operacion
	 * @throws QuantityException
	 */
	public IMagnitude add(IMagnitude m) throws QuantityException {
		Magnitude aux = getCopy(m);
		try {
			aux.transformTo(this.unidad);
		} catch (QuantityException e) {
			throw e;
		}
		this.valor += aux.getValor();
		return this;
	}

	@Override
	/**
	 * Resta a esta magnitud la pasada como argumento, tras la previa conversion pertinente
	 * @param m : magnitud a restar
	 * @return resultado de la operacion
	 * @throws QuantityException
	 */
	public IMagnitude subs(IMagnitude m) throws QuantityException {
		Magnitude aux = getCopy(m);
		try {
			aux.transformTo(this.unidad);
		} catch (QuantityException e) {
			throw e;
		}
		this.valor -= aux.getValor();
		return this;
	}

	@Override
	/**
	 * Transforma una magnitud a otra unidad
	 * @param c : unidad a convertir
	 * @return magnitud tras la conversion
	 * @throws QuantityException
	 */
	public IMagnitude transformTo(IPhysicalUnit u) throws QuantityException {
		IMagnitude aux = new Magnitude();
		if ( this.getUnidad().getMetricSystem().equals(u.getMetricSystem()) || this.getUnidad().getQuantity().equals(u.getQuantity()) == false) { /*Mismo sistema*/
			try {
				this.valor = this.unidad.transformTo(this.valor, u);
			} catch (QuantityException e) {
				throw e;
			}
			this.unidad = (PhysicalUnit)u;
			return  this;
		}
		else { /*Distinto sistema*/
			try {
				if (this.getUnidad().getMetricSystem().getConverter(u.getMetricSystem()) != null) {
					aux = this.getUnidad().getMetricSystem().getConverter(u.getMetricSystem()).transformTo(this, u);
				}
				else {
					throw new QuantityException(this.getUnidad(), u);
				}
			} catch (UnknownUnitException e) {
				System.out.println(e);
			}
			return aux;
		}
	}
	
	/**
	 * Metodo estatico que devuelve una copia de una determinada magnitud
	 * @param m : magnitud a copiar
	 * @return copia
	 */
	public static Magnitude getCopy(IMagnitude m) {
		Magnitude aux = new Magnitude();
		aux.valor = m.getValor();
		aux.unidad = (PhysicalUnit) m.getUnidad();
		return aux;
	}
	
	@Override
	public String toString() {
		return valor + " [" + unidad + "]";
	}
	
}
