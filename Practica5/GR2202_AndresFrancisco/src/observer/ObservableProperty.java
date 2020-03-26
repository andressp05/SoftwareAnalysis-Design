 package observer;

 /**
  * Esta interfaz declara los metodos propios de un objetos observable
  * @author Andres y Francisco
  */
public interface ObservableProperty<V> {
	/** 
	 * devuelve el valor almacenado
	 * @return V : valor de la propiedad
	 */
	V getValue();
	
	/**
	 * Anyade un nuevo observador a la clase
	 * @param o : observador a anyadir
	 */
	void addObserver(PropertyObserver<V> o);
	
	/**
	 * Elimina un observador de la clase
	 * @param o : observador a eliminar
	 */
	void removeObserver(PropertyObserver<V> o);
}
