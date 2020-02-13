package Api_es;

import java.io.BufferedReader;
import java.io.FileReader;

import MiApi.ColaPrioridadTDA;
import MiApi.ConjuntoTDA;
import MiApi.DiccionarioMultipleTDA;
import MisImplementaciones.Estatica.ColaPrioridad;
import MisImplementaciones.Estatica.DiccionarioMultiple;
import MisMetodos.MetodosColaPrioridad;
import MisMetodos.MetodosConjunto;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 */
public class InputOutput {

	//-- Estructura que contiene la linea con su numero unico asociado
	private static class InfoLineas {
		public int nroLinea;
		public String linea;
	}

	//-- Estructura que contiene la estacion con su numero unico asociado
	private static class InfoEstaciones {
		public int nroEstacion;
		public String estacion;
	}
	
	private static InfoLineas[] infoLineas;
	private static InfoEstaciones[] infoEstaciones;

	public static DiccionarioMultipleTDA lineaEstaciones;
	public static DiccionarioMultipleTDA estacionesTransferencia;
	public static DiccionarioMultipleTDA estacionesIguales;

	/**
	 * @Tarea: metodo que lee el archivo y genera las estructuras y TDAs con la informacion que se necesita
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: N/A
	 * @Postcondicion: N/A
	 * @Costo: cuadratico
	 */
	public static void generarTDAsYEstructuras() {

		infoLineas = new InfoLineas[20];
		infoEstaciones = new InfoEstaciones[250];
		
		setearInfoLineas();
		setearInfoEstaciones();

		lineaEstaciones = new DiccionarioMultiple();
		estacionesTransferencia = new DiccionarioMultiple();
		estacionesIguales = new DiccionarioMultiple();
		estacionesTransferencia.inicializarDiccionario();
		lineaEstaciones.inicializarDiccionario();
		estacionesIguales.inicializarDiccionario();
		try {

			String register;
			FileReader arch = new FileReader("@datos.csv");
			BufferedReader buffer = new BufferedReader(arch);

			while((register = buffer.readLine()) != null) {
				String [] campos = register.split(";", 10);

				//-- Si no es taller o deposito, esta habilitada, etc.
				if(!"".equals(campos[2])) {

					int linea = obtenerNumeroLinea(campos[0]);
					int estacion = obtenerNumeroEstacion(campos[3]);

					lineaEstaciones.agregar(linea, estacion);
					estacionesIguales.agregar(estacion, linea);

					//-- Si es estacion de transferencia
					if(!"".equals(campos[4])) {
						int lineaTransferencia = obtenerNumeroLinea(campos[4]);
						estacionesTransferencia.agregar(estacion, lineaTransferencia);
					}
				}
			}
			arch.close();		
			System.out.print("");
		} catch(Exception e) {
			System.out.println("Excepcion leyendo archivo " + "@datos.csv" + ": " + e);
		}	
	}

	/**
	 * @Tarea: Metodo que muestra por pantalla la cantidad de estaciones que posee cada linea, ignorando los talleres, depositos
	 * y estaciones no habilitadas.
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: Se deben haber generado las estructuras y TDAs
	 * @Postcondicion: N/A
	 * @Costo: cuadratico
	 */
	public static void mostrarCantidadEstacionesLineas() {

		System.out.println("Cant. de estaciones");
		ConjuntoTDA claves = lineaEstaciones.claves();
		while(!claves.conjuntoVacio()) {

			int tam = 0;
			int cl = claves.elegir();
			ConjuntoTDA estaciones = lineaEstaciones.recuperar(cl);
			while(!estaciones.conjuntoVacio()) {
				estaciones.sacar(estaciones.elegir());
				tam++;
			}

			String linea = obtenerNombreLinea(cl);
			System.out.println("Linea " + linea + ": " + tam + " estaciones");
			claves.sacar(cl);
		}
		System.out.println();
	}

	/**
	 * @Tarea: Metodo que lista las estaciones de transferencia, con su linea de origen (primera encontrada segun orden) 
	 * junto a la cantidad de posibilidades de transferencias tiene con otras lineas.
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: Se deben haber generado las estructuras y TDAs
	 * @Postcondicion: N/A
	 * @Costo: cuadratico
	 */
	public static void listarTransferenciaLineas() {

		ColaPrioridadTDA colaPrioridad = new ColaPrioridad();
		colaPrioridad.inicializarCola();

		ConjuntoTDA estacionesTransferencias = estacionesTransferencia.claves();

		System.out.println("Estacion - Linea - Cant. de posibilidades");
		while(!estacionesTransferencias.conjuntoVacio()) {

			int tam = 0;
			int cl = estacionesTransferencias.elegir();
			ConjuntoTDA lineasTransferencias = estacionesTransferencia.recuperar(cl);
			while(!lineasTransferencias.conjuntoVacio()) {
				lineasTransferencias.sacar(lineasTransferencias.elegir());
				tam++;
			}

			colaPrioridad.acolarPrioridad(cl, tam);		

			estacionesTransferencias.sacar(cl);
		}

		ColaPrioridad aux = new ColaPrioridad();
		aux.inicializarCola();
		MetodosColaPrioridad.copiarCola(colaPrioridad, aux);

		while(!aux.colaVacia()) {

			int lineaDeEstacion = obtenerLineaDeEstacion(aux.primero());
			String linea = obtenerNombreLinea(lineaDeEstacion);
			String estacionTransferencia = obtenerNombreEstacion(aux.primero());

			System.out.println(estacionTransferencia + " - " + linea + " - " + aux.prioridad());
			aux.desacolar();
		}
		System.out.println();
	}
	
	/**
	 * @Tarea: Obtiene y muestra el listado de estaciones de igual nombre junto a las lineas en las cuales se repite.
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: deben estar generado los TDAs y estructuras
	 * @Postcondicion: N/A
	 * @Costo: cubico
	 */
	public static void obtenerLineasRepetidas() {
		
		System.out.println("Estaciones de igual nombre");
		ConjuntoTDA claves = estacionesIguales.claves();
		while(!claves.conjuntoVacio()) {
			
			int cl = claves.elegir();
			String lineas = "";
			ConjuntoTDA cjtoLineas = estacionesIguales.recuperar(cl);
			int cantLineas = MetodosConjunto.contarValores(cjtoLineas);
			while(!cjtoLineas.conjuntoVacio()) {
				
				int nroLinea = cjtoLineas.elegir();
				cjtoLineas.sacar(nroLinea);
				lineas = lineas.concat((obtenerNombreLinea(nroLinea)).concat(cjtoLineas.conjuntoVacio() ? "." : ", "));
			}
			
			if(cantLineas > 1)
				System.out.println(obtenerNombreEstacion(cl) + ": " + lineas);
			
			claves.sacar(cl);
		}
		System.out.println();
	}
	
	/**
	 * @Tarea: obtiene el numero de linea con el numero unico de una estacion segun orden
	 * @Parametros: numero unico de estacion de la cual obtener el numero unico de linea a la que pertenece segun el orden 
	 * @Devuelve: numero unico de linea de la estacion enviada por parametro
	 * @Precondicion: se deben haber generado la estructura y TDAs
	 * @Postcondicion: N/A
	 * @Costo: cuadratico
	 */
	public static int obtenerLineaDeEstacion(int estacion) {

		int linea = -1;
		ConjuntoTDA claves = lineaEstaciones.claves();

		while(!claves.conjuntoVacio() 
				&& linea == -1) {

			int cl = claves.elegir();
			ConjuntoTDA estaciones = InputOutput.lineaEstaciones.recuperar(cl);

			if(estaciones.pertenece(estacion)) {
				linea = cl;
			}

			claves.sacar(cl);
		}

		return linea;
	}

	/**
	 * @Tarea: genera vector de estructura InfoLinea para asociar un numero unico a un nombre de linea el cual es almacenado en la clase
	 * para luego ser utilizado.
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: debe existir el archivo
	 * @Postcondicion: si se ejecuta nuevamente en una misma ejecucion devolvera el mismo resultado que se genero la primera vez
	 * @Costo: cuadratico
	 */
	private static void setearInfoLineas() {

		if(infoLineas[0] != null)
			return;

		int tam = 0;
		try {
			String reg;
			FileReader arch = new FileReader("@datos.csv");
			BufferedReader buffer = new BufferedReader(arch);

			while((reg = buffer.readLine()) != null) {
				String [] campos = reg.split(";", 10);

				//-- Si es taller, deposito, o la estacion no esta habilitada no proceso
				boolean process = true;
				if("".equals(campos[2])) {
					process = false;
				}
				
				int i = 0;
				while (i < tam && infoLineas[i].linea.compareTo(campos[0]) != 0)
					i++;

				if (process && i == tam) {
					infoLineas[tam] = new InfoLineas();
					infoLineas[tam].nroLinea = tam + 1;
					infoLineas[tam].linea = campos[0];
					tam++;
				}
			}
			arch.close();		      
		} catch(Exception e) {
			System.out.println("Excepcion leyendo archivo " + "@datos.csv" + ": " + e);
		}	
	}

	/**
	 * @Tarea: genera vector de estructura InfoEstacion para asociar un numero unico a un nombre de estacion el cual es almacenado en la clase
	 * para luego ser utilizado.
	 * @Parametros: N/A
	 * @Devuelve: N/A
	 * @Precondicion: debe existir el archivo
	 * @Postcondicion: si se ejecuta nuevamente en una misma ejecucion devolvera el mismo resultado que se genero la primera vez
	 * @Costo: cuadratico
	 */
	private static void setearInfoEstaciones() {

		if(infoEstaciones[0] != null)
			return;

		int tam = 0;
		try {
			String reg;
			FileReader arch = new FileReader("@datos.csv");
			BufferedReader buffer = new BufferedReader(arch);

			while((reg = buffer.readLine()) != null) {
				String [] campos = reg.split(";", 10);
				
				//-- Si es taller, deposito, o la estacion no esta habilitada no proceso
				boolean process = true;
				if("".equals(campos[2])) {
					process = false;
				}
				
				int i = 0;
				while (i < tam && infoEstaciones[i].estacion.compareTo(campos[3]) != 0)
					i++;

				if (process && i == tam) {
					infoEstaciones[tam] = new InfoEstaciones();
					infoEstaciones[tam].nroEstacion = tam + 1;
					infoEstaciones[tam].estacion = campos[3];
					tam++;
				}
			}
			arch.close();		      
		} catch(Exception e) {
			System.out.println("Excepcion leyendo archivo " + "@datos.csv" + ": " + e);
		}	
	}

	/**
	 * @Tarea: obtiene el nombre de la linea con el numero unico asociado a la misma
	 * @Parametros: numero unico asociado a una linea
	 * @Devuelve: nombre de la linea
	 * @Precondicion: se deben haber generado la estructura y TDAs
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static String obtenerNombreLinea(int nroLinea) {

		int i = 0;
		while(infoLineas[i] != null 
				&& infoLineas[i].nroLinea != nroLinea) {
			i++;
		}

		return infoLineas[i].linea;
	}

	/**
	 * @Tarea: obtiene el nombre de la estacion con el numero unico asociado a la misma
	 * @Parametros: numero unico asociado a una estacion
	 * @Devuelve: nombre de la estacion
	 * @Precondicion: se deben haber generado la estructura y TDAs
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static String obtenerNombreEstacion(int nroEstacion) {

		int i = 0;
		while(infoEstaciones[i] != null 
				&& infoEstaciones[i].nroEstacion != nroEstacion) {
			i++;
		}

		return infoEstaciones[i].estacion;
	}

	/**
	 * @Tarea: obtiene el numero unico asociado a la linea enviada por parametro
	 * @Parametros: linea a obtener su numero unico
	 * @Devuelve: numero unico asociado a la linea enviada por parametro
	 * @Precondicion: se deben haber generado la estructura y TDAs
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static int obtenerNumeroLinea(String linea) {

		int i = 0;
		while(infoLineas[i] != null 
				&& !infoLineas[i].linea.equals(linea)) {
			i++;
		}

		return infoLineas[i].nroLinea;
	}

	/**
	 * @Tarea: obtiene el numero unico asociado a la estacion enviada por parametro
	 * @Parametros: estacion a obtener su numero unico
	 * @Devuelve: numero unico asociado a la estacion enviada por parametro
	 * @Precondicion: se deben haber generado la estructura y TDAs
	 * @Postcondicion: N/A
	 * @Costo: lineal
	 */
	public static int obtenerNumeroEstacion(String estacion) {

		int i = 0;
		while(infoEstaciones[i] != null 
				&& !infoEstaciones[i].estacion.equals(estacion)) {
			i++;
		}

		return infoEstaciones[i].nroEstacion;
	}
}