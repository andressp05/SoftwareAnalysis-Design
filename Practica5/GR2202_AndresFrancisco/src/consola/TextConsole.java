package consola;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Esta clase es la encargada de implementar la funcionalidad basica para manejar tareas desde 
 * la consola que se exige en el apartado 3
 * @author Andres y Francisco
 */
public class TextConsole {
	/** Coleccion de los comandos soportados */
	private HashMap<String, Function> comandos = null;
	
	/**
	 * Constructor de la clase
	 */
	public TextConsole() {
		comandos = new HashMap<String, Function>();
	}

	/**
	 * Funcion principal de la clase que se encarga de leer la consola para llamar a los
	 * comandos pertinentes
	 */
	public void run(){
		 Scanner input = new Scanner(System.in);
		 
		 while (true) {
			 String line = input.nextLine(); //Leemos linea a linea
			 if (line.equals("")) {
				 input.close();
				 return;
			 }
			 String toks[] = line.split(" ");
			 
			 Function f = comandos.get(toks[0]); //Obtenemos la funcion correspondiente al nombre introducido
			 if (f == null) {
				 System.out.println("El comando introducido no existe, pruebe con: ");
				 //System.out.println(comandos.keySet());
				 for (String str: comandos.keySet()) {
					 System.out.println("\t" + str);
				 }
			 } else {
				 try {
					 f.execute(toks);
				 } catch(IllegalArgumentException e) {
					 System.out.println("Se ha producido un error al ejercutar el comando");
				 }
			 }
		 }
	}
	
	/**
	 * Este metodo anyade nuevos comandos a la clase
	 * @param name : nombre del comando a anyadir
	 * @param op : funcion asociada al comando a anyadir
	 */
	public void addComands(String name, Function op) {
		comandos.put(name, op);
	}

}
