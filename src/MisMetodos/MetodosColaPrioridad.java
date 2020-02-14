package MisMetodos;

import MiApi.ColaPrioridadTDA;
import MisImplementaciones.Estatica.ColaPrioridad;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 */
public class MetodosColaPrioridad {

	/**
	 * @Tarea: copia una cola con prioriodad en otra sin destruir el origen
	 * @Parametros: cola prioriodad origen y cola prioridad destino
	 * @Devuelve: N/A
	 * @Precondicion: las colas con prioridad deben estar inicializadas
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static void copiarCola(ColaPrioridadTDA orig, ColaPrioridadTDA dest) {
		
		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.inicializarCola();
		
		while(!orig.colaVacia()) {
			int val = orig.primero();
			int prior = orig.prioridad();
			aux.acolarPrioridad(val, prior);
			orig.desacolar();
		}
		
		reacolar(aux, orig, dest);
	}

	/**
	 * @Tarea: muestra la cola con prioridad sin destruirla en el proceso
	 * @Parametros: cola prioridad a mostrar
	 * @Devuelve:  N/A
	 * @Precondicion: la cola prioridad debe estar inicializada
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static void mostrarCola(ColaPrioridadTDA cola) {
		
		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.inicializarCola();
		while(!cola.colaVacia()) {
			int x = cola.primero();
			int prior = cola.prioridad();
			System.out.println("Valor: "+x+", Prioridad: "+prior);
			aux.acolarPrioridad(x, prior);
			cola.desacolar();
		}
		
		reacolar(aux, cola, null);
	}
	
	/**
	 * @Tarea: suma los valores de una cola prioridad sin destruirla en el proceso
	 * @Parametros: cola a la cual sumar los valores
	 * @Devuelve: N/A
	 * @Precondicion: la cola debe estar inicializada
	 * @Postcondicion:  N/A
	* @Costo: lineal
	 */
	public static int sumarValores(ColaPrioridadTDA cola) {

		ColaPrioridadTDA aux = new ColaPrioridad();
		aux.inicializarCola();
		
		int suma = 0;
		while(!cola.colaVacia()) {
			int x = cola.primero();
			int prior = cola.prioridad();
			aux.acolarPrioridad(x, prior);
			cola.desacolar();
			suma += x;
		}
		
		reacolar(aux, cola, null);
		
		return suma;
	}
	
	/**
	 * @Tarea: acola los valores de una cola origen en una cola destino y una opcional. destruyendo el origen en el proceso 
	 * @Parametros: cola prioridad oirgen, cola prioridad destino, cola prioridad opcional
	 * @Devuelve: N/A
	 * @Precondicion: las colas prioridad deben estar inicializadas
	 * @Postcondicion: N/A
	 */
	private static void reacolar(ColaPrioridadTDA orig, ColaPrioridadTDA dest, ColaPrioridadTDA opcional) {
		
		while(!orig.colaVacia()) {
			int x = orig.primero();
			int prior = orig.prioridad();
			dest.acolarPrioridad(x, prior);
			
			if(opcional != null)
				opcional.acolarPrioridad(x, prior);
			
			orig.desacolar();
		}
	}
}
