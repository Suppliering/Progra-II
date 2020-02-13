package MisAplicaciones;

import Api_es.InputOutput;


/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 */
public class TPO {

	public static void main(String[] args) {

		//-- Se lee el archivo para generar los vectores de estaciones y linea, con su numero unico asociado 
		//-- y generar las estructuras de TDA con los datos necesarios.
		//-- Punto 1
		InputOutput.generarTDAsYEstructuras();
		
		//-- Punto 2.a
		InputOutput.mostrarCantidadEstacionesLineas();
		
		//-- Punto 2.b
		//InputOutput.punto2b();
		
		//-- Punto 3.c
		InputOutput.obtenerLineasRepetidas();
		
		//-- Punto 2.d
		InputOutput.listarTransferenciaLineas();
	}
}