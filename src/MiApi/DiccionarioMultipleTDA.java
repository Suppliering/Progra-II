package MiApi;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 * @TDA: DiccionarioMultiple
 * @Definicion: estructura no destructiva la cual se asocia un valor llamado clave con un conjunto de valores que le pertenecen.
 * No puede haber claves duplicadas, pueden haber mismos valores para diferentes claves.
 * Una clave no puede existir sin al menos un valor.
 */
public interface DiccionarioMultipleTDA {
	
	/**
	 * @Tarea: inicializa el diccionario con los valores por defecto
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: N/A
	 * @Postcondicion: N/A
	 */
	public void inicializarDiccionario();
	
	/**
	 * @Tarea: Metodo que devuelve los elementos clave del diccionario multiple en forma de conjunto
	 * @Parametros: N/A
	 * @Devuelve: Conjunto que contiene todos los elementos clave del diccionario multiple
	 * @Precondicion: debe estar inicializado
	 * @Postcondicion:  N/A
	 */
	public ConjuntoTDA claves();
	
	/**
	 * @Tarea: Metodo que recupera el conjunto de valores que pertenecen a la clave enviada por parametro
	 * @Parametros: clave de la cual recuperar el conjunto de valores
	 * @Devuelve: conjunto de valores pertenecientes a la clave enviada por parametro
	 * @Precondicion: debe estar inicializado 
	 * @Postcondicion: N/A
	 */
	public ConjuntoTDA recuperar(int c);
	
	/**
	 * @Tarea: Metodo que agrega el elemento x enviado por parametro
	 *  al conjunto de valores perteneciente a la clave c enviada por parametro
	 * @Parametros: clave y elemento el cual agregar al conjunto de valores de la clave
	 * @Devuelve: N/A
	 * @Precondicion: debe estar inicializado
	 * @Postcondicion: N/A
	 */
	public void agregar(int c, int x);
	
	/**
	 * @Tarea: Metodo que elimina una clave del diccionario multiple, y con ella tambièn eliminar todos sus valores
	 * @Parametros: clave a eliminar
	 * @Devuelve: N/A
	 * @Precondicion: debe estar inicializado
	 * @Postcondicion: N/A
	 */
	public void eliminar(int c);
	
	/**
	 * @Tarea: metodo que elimina el valor x del conjunto de valores de la clave c enviada por parametro
	 * @Parametros: clave de la cual eliminar el valor x de su conjunto de valores
	 * @Devuelve: N/A
	 * @Precondicion: debe estar inicializado.
	 * @Postcondicion: 
	 */
	public void eliminarValor(int c, int x);
}
