/**
* Esta aplicacion y unica clase, devuelve los numeros que son primos de los pasados por pantalla.
*
* @version 1.1 12 Feb 2017
* @author Andres Salas andres.salas@estudiante.uam.es
*		  Francisco Vicente francisco.vicentel@estudiante.uam.es
*
*/
public class Primo{
	/* Solo necesario una unica clase llamada Primo */

	/**
	* Punto de entrada a la aplicacion.
	*
	* Este metodo imprime los numeros que son primos de los que el usuario pasa por pantalla,
	* y comprueba que los parametros que se pasan por pantalla son los adecuados.
	*
	* @param args Los argumentos de la linea de comandos. Se esperan un conjunto de numeros.
	*/    
    public static void main(String[] args) {
		int i;
		int[] num = new int[args.length-1];
    
		if (args.length < 1) {
			System.out.println("Se espera un conjunto de numeros como parametro.");
			System.out.println("Introduce el conjunto de numeros");
			return;
		}
	
		for(i = 0; i < args.length; i++){
			int j = Integer.parseInt(args[i]);		
			if(is_prime(j)){
				System.out.println("El número "+ j +" es primo");
			}
		}
	}		
	
	/**
	* Punto de entrada al metodo auxiliar.
	*
	* Este metodo comprueba por cada numero que se le pasa si es primo o no, devolviendo para
	* ello un valor booleano (true si es primo y false si no lo es)
	*
	* @param n El numero a calcular si es primo o no
	*/
    public static boolean is_prime(int n){
		int i;		
	
		if (n == 2) return true; // Se usa el 2 como caso particular para evitar un bucle mayor
		if (n == 1 || n%2 == 0) return false; //El ejercicio pide que el 1 no sea primo
	
		for (i=3; i*i<=n; i+=2){ // inicia desde  3, saltando 2 números para considerar solo los impares
			if (n%i == 0) return false;
			return true;
		}

	return true;
	}
}
