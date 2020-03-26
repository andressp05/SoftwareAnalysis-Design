/**
* Esta aplicacion y unica clase, calcula el triangulo de Tartaglia hasta una fila mas de la dada.
*
* @version 1.2 10 Feb 2017
* @author Andres Salas andres.salas@estudiante.uam.es
*	  	  Francisco Vicente francisco.vicentel@estudiante.uam.es
*
*/
public class Tartaglia{
	/* Solo necesario una unica clase llamada Tartaglia */

	/**
	* Punto de entrada a la aplicacion.
	*
	* Este metodo imprime el triangulo de Tartaglia hasta una fila mas de la pasada como entrada,
	* y comprueba que los parametros que se pasan por pantalla son los adecuados.
	*
	* @param args Los argumentos de la linea de comandos. Se espera un numero como parametro
	*/
	public static void main(String[] args){
		int rows = Integer.parseInt(args[0]);
		int i,j;
		int tartaglia[][] = new int[rows + 1][];

		/* Comprobacion de los parametros de entrada*/
		if (args.length < 1) {
			System.out.print("Se espera un numero como parametro. ");
			System.out.println("Introduce el numero de filas:");
			return;
		}

		else if (args.length > 1){
			System.out.print("Se espera un numero como parametro. ");
			System.out.println("Introduce el numero de filas:");
			return;
		}
		
		/* Se evitan numeros negativos y numeros que colapsen el tamanyo de un entero*/
		else if (rows < 0 || rows > 33){
			System.out.println("El valor introducido no pertenece al intervalo permitido [0, 33]");
			System.out.println("Introduce el numero de filas a introducir");
			return;
		}
	
		tartaglia[0] = new int[1];
		/* Caso Particular y Base*/
		tartaglia[0][0] = 1;
		System.out.println(tartaglia[0][0]);

		/* Realizacion del triangulo de Tartaglia mediante dos bucles*/
		for (i = 1; i <= rows; i++) {
		
			tartaglia[i] = new int [i+1];
			tartaglia[i][0] = 1;
			tartaglia[i][i] = 1;
			j=1;
			System.out.print(tartaglia[i][0]+" ");
		
			for(j=1; j<i; j++) {
				tartaglia[i][j] = tartaglia[i-1][j-1] + tartaglia[i-1][j];
				System.out.print(tartaglia[i][j]+" ");
			}
		
			System.out.println(tartaglia[i][i]);
		}
		
		return;
	}
}
