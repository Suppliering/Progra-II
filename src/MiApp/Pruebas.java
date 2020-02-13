package MiApp;

import Herramientas.MetodosCola;
import Herramientas.MetodosColaPrioridad;
import Herramientas.MetodosPila;
import Implementaciones.Estaticas.Cola;
import Implementaciones.Estaticas.ColaPrioridad;
import Implementaciones.Estaticas.Conjunto;
import Implementaciones.Estaticas.Pila;
import MiApi.ColaPrioridadTDA;
import MiApi.ColaTDA;
import MiApi.ConjuntoTDA;
import MiApi.PilaTDA;

public class Pruebas {

	public static void main(String[] args) {	
	  //pruebaPila();
	  //pruebaCola();
	  //pruebaColaPrioridad();
	  //pruebaConjunto();
	}
	
	public static void pruebaConjunto() {
		
		ConjuntoTDA conjunto = new Conjunto();
		conjunto.inicializarConjunto();
		
		conjunto.agregar(1);
		conjunto.agregar(2);
		conjunto.sacar(1);
		conjunto.agregar(1);
		
		System.out.println(conjunto.pertenece(1));
	}

	public static void pruebaColaPrioridad() {
		
		ColaPrioridadTDA cola = new ColaPrioridad();
		cola.inicializarCola();
		cola.acolarPrioridad(1, 1);
		cola.acolarPrioridad(1, 2);
		cola.acolarPrioridad(2, 3);
		
		ColaPrioridadTDA dest = new ColaPrioridad();
		dest.inicializarCola(); 
		
		MetodosColaPrioridad.copiarCola(cola, dest);
		MetodosColaPrioridad.mostrarCola(cola);
		MetodosColaPrioridad.mostrarCola(dest);
		
		
		System.out.println("");
	}

	public static void pruebaCola() {
		ColaTDA orig = new Cola();
		orig.inicializarCola();
		
		orig.acolar(1);
		orig.acolar(2);
		orig.acolar(3);
		
		while(!orig.colaVacia()) {
			System.out.println("Valor que sale: ".concat(String.valueOf(orig.primero())));
			orig.desacolar();
		}
		System.out.println("Cola vacia: " + orig.colaVacia());
		
		orig.acolar(1);
		orig.acolar(2);
		orig.acolar(3);
		
		ColaTDA dest = new Cola();
		dest.inicializarCola();
		
		MetodosCola.copiarCola(orig, dest);
		MetodosCola.mostrarCola(orig);
		MetodosCola.mostrarCola(dest);
		System.out.println("Suma Origen: ".concat(String.valueOf(MetodosCola.sumarValores(orig))));
		System.out.println("Suma Destino: ".concat(String.valueOf(MetodosCola.sumarValores(dest))));
		
		System.out.println("fin");
	}
	
	
	public static void pruebaPila() {
		
		PilaTDA orig = new Pila();
		orig.inicializarPila();
		
		orig.apilar(1);
		orig.apilar(2);
		orig.apilar(3);
		
		PilaTDA dest = new Pila();
		dest.inicializarPila();
		

		MetodosPila.copiarPila(orig, dest);
		MetodosPila.mostrarPila(orig);
		MetodosPila.mostrarPila(dest);
		System.out.println("Suma Origen: ".concat(String.valueOf(MetodosPila.sumaValores(orig))));
		System.out.println("Suma Destino: ".concat(String.valueOf(MetodosPila.sumaValores(dest))));
	}
}
