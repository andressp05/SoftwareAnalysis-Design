package consola;

/**
 * Esta interfaz declara el metodo necesario para utilizar interfaces funcionales
 * @author Andres y Francisco
 */
@FunctionalInterface
public interface Function {
	/**
	 * Funcion tipo para ser pasado como argumento en forma de una expresion lambda
	 * @param args : argumentos de entrada (cantidad variable)
	 * @throws IllegalArgumentException : entrada no valida
	 */
	void execute(String ...args) throws IllegalArgumentException;
	
}
