package testers;

import consola.TextConsole;

public class test3 {
	
	public static void main(String[] args) {
		TextConsole console = new TextConsole(); //Creamos la consola
		
		console.addComands("incremento", (f1) -> { //Anyadimos un comando unitario
			if (f1.length != 2) {
				throw new IllegalArgumentException("Parametros de entrada erroneos");
			} else {
				System.out.println("Resultado de " + f1[0] + ": " + (Integer.parseInt(f1[1]) + 1));
			}
		});
		
		console.addComands("adicion", (f2) -> { //Anyadimos un comando binario
			if (f2.length != 3) {
				throw new IllegalArgumentException("Parametros de entrada erroneos");
			} else {
				System.out.println("Resultado de " + f2[0] + ": " + (Integer.parseInt(f2[1]) + Integer.parseInt(f2[2])));
			}
		});
		
		console.addComands("adicionModulo", (f3) -> { //Anyadimos un comando ternario
			if (f3.length != 4) {
				throw new IllegalArgumentException("Parametros de entrada erroneos");
			} else {
				System.out.println("Resultado de " + f3[0] + ": " + (Integer.parseInt(f3[1]) + Integer.parseInt(f3[2])) % Integer.parseInt(f3[3]));
			}
		});
		
		console.run(); //Probar por consola los distintos comandos
		
		return;
	}

}
