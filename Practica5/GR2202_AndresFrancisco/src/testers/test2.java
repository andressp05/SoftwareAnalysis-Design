package testers;


import tareas.Task;
import tareas.Tasks;

public class test2 {
	
	public static void main(String[] args) {
		Tasks instancia = Tasks.getInstance();
		
		//Creamos la primera tarea con sus tiempos correspondientes
		Task t1 = instancia.newTask("Hacer ejercicio");
		t1.getEstimado().incrementTime(60);
		t1.getDedicado().incrementTime(0);
		
		//Creamos la tarea 1.1 que es hija de la anterior
		Task t11 = instancia.newTask("100 flexiones");
		t11.getEstimado().incrementTime(25);
		t11.getDedicado().incrementTime(10);
		if (t1.addTask(t11) == false) {
			System.out.println("no es posible anyadir t1.1 a t1");
		}
		
		//Creamos una subtarea de "100 flexiones", la tarea 1.1.1
		Task t111 = instancia.newTask("descansar");
		t111.getEstimado().incrementTime(5);
		t111.getDedicado().incrementTime(1);
		if (t11.addTask(t111) == false) {
			System.out.println("no es posible anyadir t1.1.1 a t1.1");
		}
		
		//Creamos otra tarea hija de la primera, la tarea 1.2
		Task t12 = instancia.newTask("120 abdominales");
		t12.getEstimado().incrementTime(12);
		t12.getDedicado().incrementTime(5);
		if (t1.addTask(t12) == false) {
			System.out.println("no es posible anyadir t1.2 a t1");
		}
		
		//Valores finales
		System.out.println("tiempo estimado para t1: " + t1.getEstimado().getValue()); //60 + 25 + 5 + 12
		System.out.println("tiempo dedicado a t1: " + t1.getDedicado().getValue()); //0 + 10 + 1 + 5
		
		
		if (t1.containsTask(t111)) { //Comprobamos que la busqueda recursiva es correcta
			System.out.println("\nt1.1.1 está contenida en t1");
		}
		
		if (t11.containsTask(t1) == false) { //Comprobamos que la busqueda resulta en fracaso
			System.out.println("t1 no se encuentra contenido en t1.1");
		}
		
		if (t11.addTask(t111) == false) { //Comrpobamos que no se pueden anyadir elementos ya existentes
			System.out.println("no es posible anyadir t1.1.1 a t1.1");
		}
		
		if (t12.removeTask(t1) == false) { //Comprobamos que la tarea 1 no puede ser eliminada al no estar ser descendiente de t1.2
			System.out.println("no es posible eliminar la tarea 1 de t1.2");
		}
		
		if (t11.removeTask(t111)) { //Comprobamos que la eliminacion es correcta
			System.out.println("eliminamos t1.1.1 de su tarea padre, t1.1");
		}
		
		//Al haber eliminado t1.1.1 reducimos el tiempo estimado en 5 y el dedicado en 1
		System.out.println("\ntiempo estimado para t1: " + t1.getEstimado().getValue()); //102 - 5
		System.out.println("tiempo dedicado a t1: " + t1.getDedicado().getValue()); //16 - 1
				
		
		try { //Comprobamos que se lanza un error si anyadimos una tarea que ya tiene una tarea padre asignada
			t11.addTask(t12);
		} catch(IllegalArgumentException e) {
			System.out.println("\nno es posible anyadir t1.2 a t1.1");
		}
		
		try { //Comprobamos que es sistema no permite crear tareas con el mismo nombre (no sensitive)
			instancia.newTask("hacer EJERCICIO");
		} catch(IllegalArgumentException e) {
			System.out.println("\nno es posible crear una nueva tarea");
		}
		
		try { //Comprobamos la imposibilidad de cambiar el padre de la tarea 1.1
			t1.setParent(t11);
		} catch(IllegalArgumentException e) {
			System.out.println("no es posible asignar a t1.1 como padre de t1\n");
		}
		
		//Mostramos todas las tareas registradas. t1.1.1 aparece pese a que no tiene padre asignado
		//debido a que las tareas no son eliminadas de Tasks al retirarse de cierta tarea
		for (Task t: Tasks.getInstance().getTasks()) {
			System.out.println(t);
		}
		
	}

}
