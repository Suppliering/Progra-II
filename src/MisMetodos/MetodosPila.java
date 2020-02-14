package MisMetodos;

import MiApi.PilaTDA;
import MisImplementaciones.Estatica.Pila;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 */
public class MetodosPila {
	
	/**
	 * @Tarea: copia una pila a otra sin destruirse en el proceso
	 * @Parametros: pila origen pila destino
	 * @Devuelve: N/A
	 * @Precondicion: deben estar inicializadas
	 * @Postcondicion:  N/A
	 * @Costo: lineal
	 */
	public static void copiarPila(PilaTDA orig, PilaTDA dest) {
		
		Pila aux = new Pila();
		aux.inicializarPila();
		
		reapilar(orig, aux, null);
		reapilar(aux, orig, dest);
	}

	/**
	 * @Tarea: muestra la pila sin destruirse en el proceso
	 * @Parametros: pila a mostrar
	 * @Devuelve: N/A
	 * @Precondicion: debe estar inicializada
	 * @Postcondicion:  N/A
	 * @Costo: lineal
	 */
	public static void mostrarPila(PilaTDA pila) {
	
		PilaTDA aux = new Pila();
		aux.inicializarPila();
		
		while(!pila.pilaVacia()) {
			
			int x = pila.tope();
			aux.apilar(x);
			System.out.println(x);
			pila.desapilar();
		}
		
		reapilar(aux, pila, null);
	}

	/**
	 * @Tarea: suma los valores de una pila sin destruirla en el proceso
	 * @Parametros: pila a sumar sus valores
	 * @Devuelve: suma de sus valores
	 * @Precondicion: la pila debe estar inicializada
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static int sumaValores(PilaTDA pila) {
		
		PilaTDA aux = new Pila();
		aux.inicializarPila();
		
		int suma = 0;
		while(!pila.pilaVacia()) {
			int x = pila.tope();
			suma += x;
			aux.apilar(pila.tope());
			pila.desapilar();
		}
		
		return suma;
	}
	
	/**
	 * @Tarea: apila los los elementos de la pila origen en el destino y en una pila opcional destruyendose en el proceso.
	 * @Parametros: pila origen, pila destino y pila opcional
	 * @Devuelve: N/A
	 * @Precondicion: las pilas deben estar inicializadas
	 * @Postcondicion:  N/A
	 * @Costo: lineal
	 */
	private static void reapilar(PilaTDA orig, PilaTDA dest, PilaTDA opcional) {
		
		while(!orig.pilaVacia()) {
			int x = orig.tope();
			
			if(opcional != null)
				opcional.apilar(x);
			
			dest.apilar(x);
			orig.desapilar();
		}
	}
}
