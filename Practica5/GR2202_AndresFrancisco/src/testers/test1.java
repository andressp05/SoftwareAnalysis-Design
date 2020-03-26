package testers;

import observer.Propiedad;

public class test1 {
	
	public static void main(String[] args) {
		
		Propiedad t1 = new Propiedad(10); //creacion de la tarea 1 
		Propiedad t11 = new Propiedad(0); //creacion de la subtarea 1.1  
		Propiedad t111 = new Propiedad(); //creacion de la subtarea 1.1.1
		
		System.out.println("Valor de la tarea 1: " + t1.getValue());
		System.out.println("Valor de la subtarea 1.1: " + t11.getValue());
		
		t1.addPropiedad(t11); //ahora t1 observa a su tarea hija, 1.1
		t11.addPropiedad(t111); 
		
		t11.incrementTime(5);
		
		System.out.println("\nValor de la tarea 1: " + t1.getValue()); //10 + 5
		System.out.println("Valor de la subtarea 1.1: " + t11.getValue());
		
		try { //Forzamos el error por incremento invalido
			t11.incrementTime(-50);
		} catch(IllegalArgumentException e) {
			System.out.println("\nERROR");
		}

		t111.incrementTime(15);
		
		System.out.println("\nValor de la tarea 1: " + t1.getValue()); //15 + 15
		System.out.println("Valor de la subtarea 1.1: " + t11.getValue()); // 5 + 15
		System.out.println("Valor de la subtarea 1.1.1: " + t111.getValue());
		
		t111.incrementTime(-1);
		
		System.out.println("\nValor de la tarea 1: " + t1.getValue()); //30 - 1
		System.out.println("Valor de la subtarea 1.1: " + t11.getValue()); //20 - 1
		System.out.println("Valor de la subtarea 1.1.1: " + t111.getValue()); //15 - 1
		
		t11.removePropiedad(t111);
		
		System.out.println("\nValor de la tarea 1: " + t1.getValue()); //29 - 14
		System.out.println("Valor de la subtarea 1.1: " + t11.getValue()); //19 - 14
		
		t1.removePropiedad(t11);
		
		System.out.println("\nValor de la tarea 1: " + t1.getValue()); //15 - 5
		
	}

}
