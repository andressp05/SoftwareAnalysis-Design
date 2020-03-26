package tareas;

import java.util.ArrayList;

/**
 * Esta clase presenta el patron singleton y nos facilita el manejo de todas las tareas
 * que vayamos creando en nuestro sistema.
 * @author Andres y Francisco
 */
public class Tasks {

	/** Instancia de la clase */
	private static Tasks instance = null;
	
	/** Conjunto de todas las tareas */
	private ArrayList<Task> tareas = null;
	
	/**
	 * Constructor vacio de la clase
	 */
	private Tasks() {
		this.tareas = new ArrayList<Task>();
	}
	
	public ArrayList<Task> getTasks(){
		return tareas;
	}
	
	/**
	 * Obtiene la instancia de la clase dado que sigue un patron singleton
	 * @return instancia
	 */
	public static Tasks getInstance() {
		if (Tasks.instance == null) {
			Tasks.instance = new Tasks(); 
		}
		return Tasks.instance;
	}
	
	/**
	 * Crea una nueva tarea
	 * @param name : nombre de la tarea a crear
	 * @return tarea creada
	 * @throws IllegalArgumentException : entrada no valida
	 */
	public Task newTask(String name) throws IllegalArgumentException {
		Task t = new Task(name);
		
		//Comprobamos que no exista otra ya creada con el mismo nombre
		if (isTask(name)) {
			throw new IllegalArgumentException();
		} else {
			tareas.add(t);
			return t;
		}
	}
	
	/**
	 * Comprueba si dado un nombre existe una tarea que concida con este
	 * @param name : nombre a buscar
	 * @return true si la busqueda es exitosa, false en caso contrario
	 */
	public boolean isTask(String name) {
		for (Task t: tareas) {
			if (name.toLowerCase().trim().equals(t.getName().toLowerCase().trim())) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Obtiene una tarea a partir de su nombre si existe
	 * @param name : nombre de la tarea
	 * @return tarea buscada, null en caso de que no se encuentre
	 */
	public Task getTask(String name) {
		for (Task t: tareas) {
			if (name.toLowerCase().trim().equals(t.getName().toLowerCase().trim())) {
				return t;
			}
		}
		return null;
	}

}
