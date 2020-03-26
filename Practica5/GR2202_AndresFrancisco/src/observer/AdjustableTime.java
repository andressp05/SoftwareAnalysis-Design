package observer;

/**
 * Esta interfaz declara el metodo asociado a los observadores
 * @author Andres y Francisco
 */
public interface AdjustableTime extends ObservableProperty<Integer> {
	
	/**
	 * Se encarga de realizar un incremento sobre las unidades de tiempo
	 * @param inc : incremento en minutos
	 */
	void incrementTime(int inc);
	
}
