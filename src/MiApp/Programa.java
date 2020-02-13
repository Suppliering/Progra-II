package MiApp;

import Herramientas.Entradas;
import Herramientas.MetodosColaPrioridad;
import Implementaciones.Estaticas.ColaPrioridad;
import MiApi.ColaPrioridadTDA;
import MiApi.ConjuntoTDA;

public class Programa {

	public static void main(String[] args) {

		Entradas.obtenerEstacionesPorLinea();
		ConjuntoTDA claves = Entradas.lineaEstaciones.claves();
		
		while(!claves.conjuntoVacio()) {
			
			int cl = claves.elegir();
			ConjuntoTDA estaciones = Entradas.lineaEstaciones.recuperar(cl);
			
			int tam = 0;
			while(!estaciones.conjuntoVacio()) {
				estaciones.sacar(estaciones.elegir());
				tam++;
			}
			
			String linea = Entradas.obtenerNombreLinea(cl);
			System.out.println("Linea " + linea + ": " + tam + " estaciones");
			
			claves.sacar(cl);
		}
		
		ColaPrioridadTDA colaPrioridad = new ColaPrioridad();
		colaPrioridad.inicializarCola();
		ConjuntoTDA estacionesTransferencias = Entradas.estacionesTransferencia.claves();
		System.out.println("Estacion - Linea - Cant. de posibilidades");
		while(!estacionesTransferencias.conjuntoVacio()) {
			
			int cl = estacionesTransferencias.elegir();
			ConjuntoTDA lineasTransferencias = Entradas.estacionesTransferencia.recuperar(cl);
			
			int tam = 0;
			while(!lineasTransferencias.conjuntoVacio()) {
				lineasTransferencias.sacar(lineasTransferencias.elegir());
				tam++;
			}
			
//			String linea = Entradas.obtenerNombreLinea((Entradas.obtenerLineaDeEstacion(cl)));
//			String estacionTransferencia = Entradas.obtenerNombreEstacion(cl);
			
			colaPrioridad.acolarPrioridad(cl, tam);
			
//			System.out.println(estacionTransferencia + " - " + linea + " - " + tam);
			
			estacionesTransferencias.sacar(cl);
		}
		
		ColaPrioridad aux = new ColaPrioridad();
		aux.inicializarCola();
		MetodosColaPrioridad.copiarCola(colaPrioridad, aux);
		
		while(!aux.colaVacia()) {
			
			String linea = Entradas.obtenerNombreLinea((Entradas.obtenerLineaDeEstacion(aux.primero())));
			String estacionTransferencia = Entradas.obtenerNombreEstacion(aux.primero());
		
			
			System.out.println(estacionTransferencia + " - " + linea + " - " + aux.prioridad());
			aux.desacolar();
		}
		
		System.out.println();
	}
}
