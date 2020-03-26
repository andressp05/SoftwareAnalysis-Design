package tareas;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

import observer.AdjustableTime;
import observer.Propiedad;

/**
 * Esta clase es la encargada de implementar la funcionalidad necesaria para el manejo
 * de tareas que se exige en el apartado 2 de esta practica
 * @author Andres y Francisco
 */
public class Task implements Comparable<Object> {
	
	/** Nombre de esta tarea*/
	private String name;
	
	/** Tiempo dedicado a esta tarea */
	private Propiedad dedicado;
	
	/** Tiempo estimado de esta tarea */
	private Propiedad estimado;
	
	/** Conjunto de subtareas */
	private TreeSet<Task> subtareas;
	
	/** Tarea padre de esta tarea*/
	private Task padre;
	
	/**
	 * Constructor de la clase
	 * @param name : nombre de la tarea
	 */
	public Task(String name){
		this.name = name;
		this.estimado = new Propiedad(0);
		this.dedicado = new Propiedad(0);
		this.subtareas = new TreeSet<Task>();
		this.padre = null;
	}
	
	public String getName(){
		return this.name;
	}
	
	public AdjustableTime getEstimado(){
		return this.estimado;
	}
	
	public AdjustableTime getDedicado(){
		return this.dedicado;
	}
	
	public void setParent(Task p) throws IllegalArgumentException {
		if (p == null) {
			if (this.padre != null) {
				this.padre.removeTask(this);
				return;
			}
			throw new IllegalArgumentException();
		}
		
		if(this.containsTask(p)) { //Evitamos ciclos
			throw new IllegalArgumentException();
		}
		p.addTask(this);
	}

	public Task getParent() {
		return this.padre;
	}
	
	public Set<Task> getTasks() {
		return Collections.unmodifiableSet(this.subtareas);
	}
	
	/**
	 * Indica si la tarea t se encuentra - directa o indirectamente - en esta tarea
	 * @param t : tarea a buscar
	 * @return true si la busqueda recursiva es exitosa, false en caso contrario
	 */
	public boolean containsTask(Task t){
		if (t.equals(this) == true) {
			return true;
		} else {
			for (Task tarea: this.subtareas) {
				if (tarea.containsTask(t)) { 
					return true;
				}
			}
			return false;
		}
	}
	
	/**
	 * Anyade una nueva subtarea a esta tarea si corresponde
	 * @param t : tarea a anyadir
	 * @return true si se anyade correctamente, false en caso contrario
	 */
	public boolean addTask(Task t) throws IllegalArgumentException {
		if (this.containsTask(t) == true) {
			return false;
		}
		
		if (t.getParent() != null) { //Una misma tarea no puede tener mas de un padre
			throw new IllegalArgumentException();
		}
		
		this.dedicado.addPropiedad((Propiedad)t.getDedicado());
		this.estimado.addPropiedad((Propiedad)t.getEstimado());
		t.padre = this;
		
		return this.subtareas.add(t);
	}
	

	/**
	 * Elimina la subtarea t de esta tarea si corresponde
	 * @param t : tarea a eliminar 
	 * @return true si la eliminacion ha sido correcta, false en caso contrario
	 */
	public boolean removeTask(Task t) {
		if (this.containsTask(t)) {
			this.dedicado.removePropiedad((Propiedad)t.getDedicado());
			this.estimado.removePropiedad((Propiedad)t.getEstimado());
			
			this.subtareas.remove(t);
			t.padre = null;
			return true;
		} 
		return false;
	}


	@Override
	public boolean equals(Object obj){
		if (obj != null || obj instanceof Task) {
			Task t = (Task) obj;
			if (this.name.toLowerCase().trim().equals(t.getName().toLowerCase().trim()) == true) {
				return true;
			}
		}
		return false;
	}

	@Override
	public int compareTo(Object obj) {
		Task task = (Task) obj;
		return -(task.getName().compareTo(this.getName()));
	}
	
	@Override
	public String toString() {
		String aux = "Nombre: " + this.name + ", Estimado: " + this.getEstimado().getValue() + " min, Dedicado: " + this.getDedicado().getValue() + " min";
		if (this.getParent() != null) {
			aux = aux + ", Padre: " + this.getParent().getName();
		}
		return aux;
	}

}
