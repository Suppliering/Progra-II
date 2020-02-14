package MiApi;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 * @TDA: Cola 
 * @Definicion: estructura destructiva en el cual el primer elemento que entra es el primero en salir.
 */
public interface ColaTDA {
	
	/**
	 * @Tarea: Inicializa la cola con los valores por defecto
	 * @Parametros: n/a
	 * @Devuelve: n/a
	 * @Precondicion: n/a
	 * @Postcondicion: n/a
	 */
	public void inicializarCola();
	
	/**
	 * @Tarea: Acola el valor enviado por parametro
	 * @Parametros: valor a acolar
	 * @Devuelve: n/A
	 * @Precondicion: debe estar inicializada
	 * @Postcondicion:  N/A
	 */
	public void acolar(int x);
	
	/**
	 * @Tarea: Desacola el primer elemento de la cola
	 * @Parametros: n/A
	 * @Devuelve: N/A
	 * @Precondicion: no debe estar vacia
	 * @Postcondicion: n/A
	 */
	public void desacolar();
	
	/**
	 * @Tarea: Devuelve primer elemento de la cola
	 * @Parametros:  n/a
	 * @Devuelve: n/a
	 * @Precondicion: no debe estar vacia
	 * @Postcondicion:  n/A
	 */
	public int primero();
	
	/**
	 * @Tarea: Informa si la cola esta vacia o no con un booleano
	 * @Parametros:  N/A
	 * @Devuelve: si la cola esta vacia o no
	 * @Precondicion: debe estar inicializada
	 * @Postcondicion:  N/A
	 */
	public boolean colaVacia();
}
