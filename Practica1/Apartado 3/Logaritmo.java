/**
* Esta aplicacion calcula el logaritmo neperiano de su primer parametro.
*
* @author Andres Salas andres.salas@estudiante.uam.es
*
*/
public class Logaritmo {

/**
* Punto de entrada a la aplicacion.
*
* Este metodo imprime el logaritmo neperiano del numero que se le pasa como entrada
*
* @param args Los argumentos de la linea de comando. Se espera un numero como primer parametro
*/
	public static void main(String[] args){
	if (args.length<1) {
		System.out.println("Se espera un numero como parametro.");
		return;
	}
	
	String arg = args[0]; //una variable String que obtiene el primer parametro
	double x = Double.parseDouble(arg); //una variable double, que convierte arg a numerico
	
	System.out.println("El logaritmo de " + arg + " es: " + Math.log(x));
	}
}
