package MisImplementaciones.Dinamica;

import MiApi.PilaTDA;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 */
public class Pila implements PilaTDA {
	
	class nodo {
		int d;
		nodo sig;
	}
	
	nodo inicio;

	@Override
	public void inicializarPila() {
		inicio = null;
	}

	@Override
	public void apilar(int x) { // vinculo al inicio
		nodo nuevo = new nodo(); //-- Creo nodo
		nuevo.d = x;			//-- Copio datos
		inicio = nuevo;			//-- Vinculo
	}

	@Override
	public void desapilar() { // elimina inicio
		inicio = inicio.sig;
	}

	@Override
	public int tope() {
		return inicio.d;
	}

	@Override
	public boolean pilaVacia() {
		return (inicio==null);
	}

}
