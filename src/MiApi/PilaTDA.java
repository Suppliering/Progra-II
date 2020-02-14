package MiApi;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 * @TDA: Cola 
 * @Definicion: estructura destructiva en la cual el primer elemento en ingresar es el ultimo en salir.
 */
public interface PilaTDA {	
	
	/**
	 * @Tarea: inicializa la pila con sus valores por defecto
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: N/A
	 * @Postcondicion: N/A
	 */
	public void inicializarPila();
	
	/**
	 * @Tarea: coloca el valor x en el tope de la pila
	 * @Parametros: valor a apilar
	 * @Devuelve: N/A
	 * @Precondicion: debe estar inicializada
	 * @Postcondicion: N/A
	 */
	public void apilar(int x);
	
	/**
	 * @Tarea: saca el tope actual de la pila
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: no debe estar vacia
	 * @Postcondicion: N/A 
	 */
	public void desapilar(); 
	
	/**
	 * @Tarea: devuelve el tope de la pila
	 * @Parametros: N/A
	 * @Devuelve: tope de la pila
	 * @Precondicion: no debe estar vacia
	 * @Postcondicion: N/A
	 */
	public int tope(); 
	
	/**
	 * @Tarea: informa si la pila esta vacia o no
	 * @Parametros: n/A
	 * @Devuelve: si la pila esta vacia o no 
	 * @Precondicion: debe estar inicializada
	 * @Postcondicion:  n/A
	 */
	public boolean pilaVacia();
}
