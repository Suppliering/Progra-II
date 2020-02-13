package MiApi;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 * @TDA: Cola con Prioridad
 * @Definicion: estructura en forma de cola la cual se ordena por valor de prioridad y no valor de elemento, 
 * el de mayor prioridad que entra primero es el primero en salir.
 */
public interface ColaPrioridadTDA {
	
	/**
	 * @Tarea: Inicializa la cola con prioridad con sus valores por defecto
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: N/A
	 * @Postcondicion: N/A
	 */
	public void inicializarCola();
	
	/**
	 * @Tarea: acola el valor enviado por parametro con la prioridad enviada por parametro.
	 * @Parametros: valor y prioridad
	 * @Devuelve: N/A
	 * @Precondicion: La cola con prioridad debe estar inicializada
	 * @Postcondicion: N/A
	 */
	public void acolarPrioridad(int valor, int prior); 
	
	/**
	 * @Tarea: desacola el primer valor con mas prioridad
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: La cola no debe estar vacia
	 * @Postcondicion: N/A
	 */
	public void desacolar(); 
	
	/**
	 * @Tarea: devuelve el primer valor en la cola
	 * @Parametros: N/A
	 * @Devuelve: primer valor en cola con mayor prioridad
	 * @Precondicion: La cola no debe estar vacia
	 * @Postcondicion: N/A
	 */
	public int primero(); 
	
	/**
	 * @Tarea: devuelve el la prioridad del primer valor en la cola
	 * @Parametros: N/A
	 * @Devuelve: prioridad del primer valor en la cola
	 * @Precondicion: La cola no debe estar vacia
	 * @Postcondicion: N/A
	 */
	public int prioridad();
	
	/**
	 * @Tarea: devuelve un booleano informando si la cola esta vacia o no
	 * @Parametros: N/A
	 * @Devuelve: devuelve booleano informando si la cola esta vacia o no
	 * @Precondicion: la cola debe estar inicializada
	 * @Postcondicion: N/A 
	 */
	public boolean colaVacia();
}
