package observer;

import java.util.ArrayList;

/**
 * Esta clase realiza la implementacion fundamental para las propiedades de tiempo necesarias para 
 * el primer apartado de la practica. Engloba todo lo creado hasta hora pues hereda de 
 * DefaultObserverProperty y ademas implementa AdjustableTime y PropertyObserver.
 * @author Andres y Francisco
 */
public class Propiedad extends DefaultObservableProperty<Integer> implements AdjustableTime, PropertyObserver<Integer> {
	
	/** Lista de propiedades cuyo padre es esta */
	private ArrayList<Propiedad> subpropiedades;
	
	/**
	 * Constructor vacio de la clase
	 */
	public Propiedad() {
		this(0);
	}
	
	/**
	 * Constructor de la clase
	 * @param inicial : valor inicial en minutos
	 */
	public Propiedad(int inicial) {
		super(inicial);
		this.subpropiedades = new ArrayList<Propiedad>();
	}
	
	/**
	 * Se encarga de realizar un incremento sobre las unidades de tiempo
	 * @param inc : incremento en minutos
	 */
	@Override
	public void incrementTime(int inc) throws IllegalArgumentException {
		if (this.getValue() + inc < 0) {
			throw new IllegalArgumentException();
		}
		this.setValue(this.getValue() + inc);
	}

	/**
	 * Anyade una propiedad a la lista de subpropiedades de esta
	 * @param o : propiedad a anyadir
	 */
	public void addPropiedad(ObservableProperty<Integer> o) {
		if (o != null) {
			this.subpropiedades.add((Propiedad) o);
			this.incrementTime(o.getValue());
			o.addObserver(this);
		}
	}
	
	/**
	 * Elimina una propiedad de la lista de subpropiedades de esta
	 * @param o : propiedad a eliminar
	 */
	public void removePropiedad(ObservableProperty<Integer> o) {
		if (o != null && subpropiedades.remove(o)) {
			this.incrementTime((-1) * o.getValue());
			o.removeObserver(this);
		}
	}

	/**
	 * Realiza las acciones pertinentes cuando se notifica a un observador de un cambio
	 * @param property : objeto observable que ha sufrido cambios
	 * @param oldValue : valor anterior
	 */
	@Override
	public void propertyChanged(ObservableProperty<Integer> property, Integer oldValue) {
		int incr = property.getValue() - oldValue;
		incrementTime(incr);
	}
}
