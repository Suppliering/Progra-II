package MisMetodos;

import MisImplementaciones.Estatica.Cola;
import MiApi.ColaTDA;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 */
public class MetodosCola {
	/**
	 * @Tarea: Copia una cola a otra sin destruir el origen
	 * @Parametros: cola origen y cola destino
	 * @Devuelve: N/A
	 * @Precondicion: las colas deben estar inicializadas
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static void copiarCola(ColaTDA orig, ColaTDA dest) {
		
		ColaTDA aux = new Cola();
		aux.inicializarCola();
		
		while(!orig.colaVacia()) {
			int x = orig.primero();
			aux.acolar(x);
			orig.desacolar();
		}
		
		reacolar(aux, orig, dest);
	}

	/**
	 * @Tarea: Muestra los valores de una cola sin destruirla
	 * @Parametros: Cola a mostrar
	 * @Devuelve:  N/A
	 * @Precondicion: la cola debe estar inicializada
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static void mostrarCola(ColaTDA cola) {
		
		ColaTDA aux = new Cola();
		aux.inicializarCola();
		while(!cola.colaVacia()) {
			int x = cola.primero();
			System.out.println(x);
			aux.acolar(x);
			cola.desacolar();
		}
		
		reacolar(aux, cola, null);
	}
	
	/**
	 * @Tarea: suma los valores de una cola
	 * @Parametros:  cola a sumar sus valores
	 * @Devuelve: N/A
	 * @Precondicion: la cola debe estar inicializada
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static int sumarValores(ColaTDA cola) {

		ColaTDA aux = new Cola();
		aux.inicializarCola();
		
		int suma = 0;
		while(!cola.colaVacia()) {
			int x = cola.primero();
			aux.acolar(x);
			cola.desacolar();
			suma += x;
		}
		
		reacolar(aux, cola, null);
		
		return suma;
	}
	
	/**
	 * @Tarea: acola los elementos del origen en una cola destino y una opcional destruyendo el origen en el proceso
	 * @Parametros: cola origen, cola destino y cola opcional
	 * @Devuelve: N/A
	 * @Precondicion: la colas debe estar inicializadas
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	private static void reacolar(ColaTDA orig, ColaTDA dest, ColaTDA opcional) {
		
		while(!orig.colaVacia()) {
			int x = orig.primero();
			dest.acolar(x);
			
			if(opcional != null)
				opcional.acolar(x);
			
			orig.desacolar();
		}
	}
}
