package observer;

import java.util.ArrayList;

/**
 * Esta clase es la que se encarga de implementar el funcionamiento general de los 
 * objetos que son observables por otros.
 * @author Andres y Francisco
 */
public class DefaultObservableProperty<V> implements ObservableProperty<V> {

	/** Valor almacenado */
	protected V value;
	
	/** Lista de observadores sobre esta propiedad */
	protected ArrayList<PropertyObserver<V>> observadores;

	
	/**
	 * Constructor de la clase
	 * @param value : valor de la propiedad
	 */
	public DefaultObservableProperty(V value) {
		this.value = value;
		this.observadores = new ArrayList<PropertyObserver<V>>();
	}

	protected void setValue(V newValue) {
		V oldvalue = this.value;
		if( (oldvalue.equals(newValue) == false) && (newValue != null) ) {
			this.value = newValue;
			for(PropertyObserver<V> p: observadores){
				p.propertyChanged(this, oldvalue);
			}
		}
	}
	
	@Override
	public V getValue(){
		return this.value;
	}

	/**
	 * Anyade un nuevo observador a la clase
	 * @param o : observador a anyadir
	 */
	@Override
	public void addObserver(PropertyObserver<V> o) {
		if(this.observadores.contains(o) == false){
			this.observadores.add(o);
		}
	}

	/**
	 * Elimina un observador de la clase
	 * @param o : observador a eliminar
	 */
	@Override
	public void removeObserver(PropertyObserver<V> o) {
		this.observadores.remove(o);
	}
	
}
