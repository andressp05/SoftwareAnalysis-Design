package observer;

/**
 * Esta interfaz declara el metodo asociado a los objetos observadores
 * @author Andres y Francisco
 */
public interface PropertyObserver<V> {
	/**
	 * Realiza las acciones pertinentes cuando se notifica a un observador de un cambio
	 * @param property : objeto observable que ha sufrido cambios
	 * @param oldValue : valor anterior
	 */
	void propertyChanged(ObservableProperty<V> property, V oldValue);

}
