package MiApi;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 * @TDA: Diccionario Simple
 * @Definicion: estructura no destructiva en la cual se asocia un elemento llamado valor a un elemento llamado clave, no puede haber claves duplicadas.
 * puede repetirse el mismo valor para diferentes claves.
 * Una clave no puede existir sin al menos un valor.
 */
public interface DiccionarioSimpleTDA {
	
	/**
	 * @Tarea: inicializa el diccionario con los valores por defecto
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: N/A
 	 * @Postcondicion:  N/A
	 */
	public void inicializarDiccionario();
	
	/**
	 * @Tarea: Agrega el elemento con su clave si no esta presente en el diccionario, actualiza el valor si la clave caso contrario.
	 * @Parametros: clave y valor
	 * @Devuelve: N/A
	 * @Precondicion: debe estar inicializada
	 * @Postcondicion: N/A
	 */
	public void agregar(int c, int x);
	
	/**
	 * @Tarea: elimina la clave y por lo tanto su valor del diccionario
	 * @Parametros: clave la cual eliminar del diccionario
	 * @Devuelve: N/A
	 * @Precondicion: debe estar inicializado
	 * @Postcondicion: N/A
	 */
	public void eliminar(int c);
	
	/**
	 * @Tarea: metodo que el valor asociado a la clave enviada por parametro
	 * @Parametros: clave de la cual recuperar el valor asociado
	 * @Devuelve: valor asociado a la clave enviada por parametro
	 * @Precondicion: debe existir la clave.
	 * @Postcondicion: N/A
	 */
	public int recuperar(int c); // debe existir la clave
	
	/**
	 * @Tarea: Recupera las claves del diccionario en forma de conjunto
	 * @Parametros:  N/A
	 * @Devuelve: conjunto de claves del diccionario
	 * @Precondicion: debe estar inicializado
	 * @Postcondicion: N/A
	 */
	public ConjuntoTDA claves();

}
