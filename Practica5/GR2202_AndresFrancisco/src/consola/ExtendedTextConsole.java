package consola;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;

import tareas.Task;
import tareas.Tasks;

/**
 * Esta clase se trata de la consola completa que se exige en el apartado 4
 * @author Andres y Francisco
 */
public class ExtendedTextConsole extends TextConsole {

	/** Tarea actual */
	private Task estado = null;
	
	/** Raiz de todas las tareas existentes */
	private Tasks instancia;
	
	/** Fecha inicial en la que da comienza la tarea actual */
	private Date fechaIni;
	
	/**
	 * Constructor de la clase
	 */
	public ExtendedTextConsole() {
		this.instancia = Tasks.getInstance();
		this.addComands("start", this::start);
		this.addComands("stop", this::stop);
		this.addComands("addEstimate", this::addEstimate);
		this.addComands("spend", this::spend);
		this.addComands("parent", this::parent);
		this.addComands("list", this::list);
		this.addComands("status", this::status);
	}
	
	/**
	 * El comando start creara la tarea con el nombre, taskName, indicado, si no existe. 
	 * Además fijará la tarea como tarea actual, y detendra la tarea anterior.
	 * @param input : entrada
	 */
	private void start(String input[]) {
		Task nuevaTarea = null;
		
		if (input.length != 2) {
			System.out.println("Error en los parametros de entrada");
			return;
		}
		String taskName = input[1];
		
		try {
			nuevaTarea = this.instancia.newTask(taskName);
		} catch(IllegalArgumentException e) {
			System.out.println("La tarea ya existe");
			//Asignamos a nuevaTarea la que se llama igual para continuarla
			nuevaTarea = instancia.getTask(taskName);
		}
		
		if (estado != null) {
			stop(Arrays.copyOf(input, 1)); //Detenemos la tarea actual si existe
		}
		estado = nuevaTarea;
		fechaIni = new Date();
		return;
	}
	
	/**
	 * Detiene la tarea actual, pasando a no tener ninguna tarea actual. Al detener la tarea, se añade a tiempo 
	 * dedicado los minutos (segundos en la simulacion) que han pasado desde el comando start.
	 * @param input : entrada
	 */
	private void stop(String input[]) {
		if (input.length != 1) {
			System.out.println("Error en los parametros de entrada");
			return;
		}
		
		if (this.estado != null) {
			Date fechaFin = new Date(); //calculamos el tiempo dedicado
			int secs = (int) (( fechaFin.getTime() - fechaIni.getTime() ) / 1000);
			
			estado.getDedicado().incrementTime(secs); //actualizamos los campos pertinentes
			estado = null;
			this.fechaIni = null;
			return;
		}
		System.out.println("No hay ninguna tarea actual");
	}
	
	/**
	 * Anyade los minutos indicados al tiempo estimado de la tarea actual. Minutos puede ser 
	 * negativo, en cuyo caso el tiempo se restara.
	 * @param input : entrada
	 */
	private void addEstimate(String a[]) {
		if (a.length != 2) {
			System.out.println("Error en los parametros de entrada");
			return;
		}
		if (estado != null) {
			try {
				estado.getEstimado().incrementTime(Integer.parseInt(a[1]));	
			} catch(IllegalArgumentException e) {
				System.out.println("Se ha obtenido un resultado negativo ejecutando el comando");
			}
			return;
		}
		System.out.println("No hay ninguna tarea actual");
	}
	
	/**
	 * Similar al comando anterior, para ajustar el tiempo dedicado. Al igual que con estimate, 
	 * se admitiran correcciones usando tiempos negativos.
	 * @param input : entrada
	 */
	private void spend(String input[]) {
		if(input.length != 2){
			System.out.println("Error en los parametros de entrada");
			return;
		}
		if (estado != null) {
			try {
				estado.getDedicado().incrementTime(Integer.parseInt(input[1]));
			} catch(IllegalArgumentException e){
				System.out.println("Se ha obtenido un resultado negativo ejecutando el comando");
			}
			return;
		}
		System.out.println("No hay ninguna tarea actual");
	}
	
	/**
	 * Cambia la tarea padre de la tarea actual. Si no se indica la tarea padre, equivaldra a eliminar 
	 * la tarea de su tarea padre, mediante setParent(null).
	 * @param input : entrada
	 */
	private void parent(String input[]) {
		if (input.length != 1 && input.length != 2) {
			System.out.println("Error en los parametros de entrada");
			return;
		}
		if(estado == null) {
			System.out.println("No hay ninguna tarea actual");
			return;
		}
		
		if (input.length == 1) { //eliminamos la tarea de su tarea padre
			try {
				estado.setParent(null);
			} catch(IllegalArgumentException e) {
				System.out.println("El padre a eliminar no existe");
				return;
			}
		} else { //modificamos la tarea padre de la actual
			Task nuevaTarea = instancia.getTask(input[1]);
			if (nuevaTarea == null) {
				System.out.println("La tarea indicada no existe");
				return;
			}
			
			try {
				estado.setParent(nuevaTarea);
			} catch(IllegalArgumentException e) {
				System.out.println("No se puede modificar el padre");
			}
		}
		return;
	}
	
	/**
	 * Lista en orden alfabetico todas las tareas.
	 * @param input : entrada
	 */
	private void list(String input[]) {
		HashSet<Task> ordenados = new HashSet<>();
		if (input.length != 1) {
			System.out.println("Error en los parametros de entrada");
			return;
		}
		
		System.out.println("Tareas activas: ");
		for(Task t: instancia.getTasks()){
			ordenados.add(t);
		}
		for(Task t: ordenados){
			System.out.println("\t" + t);
		}
	}
	
	/**
	 * Imprime la informacion de la tarea indicada, su nombre, tarea padre, y tiempos. 
	 * Si se omite el nombre, se mostrara la tarea actual.
	 * @param input : entrada
	 */
	private void status(String input[]) {
		if (input.length != 1 && input.length != 2) {
			System.out.println("Error en los parametros de entrada");
			return;
		}
		if (input.length == 1) { //Tarea actual
			if (estado == null){
				System.out.println("No hay ninguna tarea actual");
				return;
			}
			System.out.println(estado);
		}
		else { //Tarea indicada
			Task nuevaTarea = instancia.getTask(input[1]);
			if (nuevaTarea == null) {
				System.out.println("La tarea indicada no existe");
				return;
			}
			System.out.println(nuevaTarea);
		}
	}
	
}
