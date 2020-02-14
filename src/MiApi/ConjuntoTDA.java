package MiApi;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 * @TDA: Conjunto
 * @Definicion: estructura destructiva la cual no tiene un orden y en la cual no se pueden repetir sus elementos.
 */
public interface ConjuntoTDA {
	
	/**
	 * @Tarea: Inicializa el conjunto con sus valores por defecto
	 * @Parametros: n/A
	 * @Devuelve: n/A
	 * @Precondicion: N/A
	 * @Postcondicion:  N/A
	 */
	public void inicializarConjunto();
	
	/**
	 * @Tarea: Agrega un valor al conjunto si no existe, caso contrario no hace nada.
	 * @Parametros: valor a agregar al conjunto
	 * @Devuelve: N/A
	 * @Precondicion: debe estar inicializado
	 * @Postcondicion: n/A
	 */
	public void agregar(int x); //-- (*)
	
	/**
	 * @Tarea: Saca el elemento si existe en el conjunto, caso contrario no hace nada
	 * @Parametros: valor a sacar del conjunto
	 * @Devuelve: N/A
	 * @Precondicion: debe estar inicializado
	 * @Postcondicion: N/A
	 */
	public void sacar(int x); //-- (*)
	
	/**
	 * @Tarea: Elige un elemento al azar del conjunto
	 * @Parametros: N/A
	 * @Devuelve: un elemento al azar del conjunto
	 * @Precondicion: el conjunto no debe estar vacio
	 * @Postcondicion:  N/A
	 */
	public int elegir(); //-- (**)
	
	/**
	 * @Tarea: Informa si el conjunto esta vacio o no
	 * @Parametros: N/A
	 * @Devuelve: si el conjunto esta vacio o no
	 * @Precondicion: debe estar inicializado
	 * @Postcondicion:  N/A
	 */
	public boolean conjuntoVacio(); //-- (*)
	
	/**
	 * @Tarea: Metodo que informa si el elemento enviado por parametro esta presente en el conjunto o no.
	 * @Parametros: elemento a verificar si esta presente en el conjunto o no
	 * @Devuelve: si el elemento enviado por parametro pertenece en el conjunto o no
	 * @Precondicion: debe estar inicializado
	 * @Postcondicion: N/A
	 */
	public boolean pertenece(int x); //-- (*)
}
