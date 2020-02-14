package MisImplementaciones.Estatica;

import MiApi.ConjuntoTDA;
import MiApi.DiccionarioSimpleTDA;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 */
public class DiccionarioSimple implements DiccionarioSimpleTDA {
	
	class Dato {
		int cl, d;
	}
	Dato[] vector;
	int tam;
	
	public void inicializarDiccionario() {
		vector = new Dato[100];
		tam = 0;
	}
	
	public ConjuntoTDA claves() {
		ConjuntoTDA r = new Conjunto();
		r.inicializarConjunto();
		for(int i = 0; i <tam; i++)
			r.agregar(vector[i].cl);
		return r;
	}
	
	public int recuperar(int c) {
		int i;
		for(i=0; vector[i].cl != c; i++);
		
		return vector[i].d;
	}
	
	public void eliminar(int c) { // igual a conjunto
		int i = 0;
		for(i=0; i<tam && vector[i].cl != c; i++);
		
		if(i<tam) { // lo encontro
			vector[i] = vector[tam-1];
			tam--;
			
		}
	}
	
	public void agregar(int c, int x) {
		int i;
		for(i=0; i < tam && vector[i].cl != c; i++);
		
		if(i == tam) { // no existe
			vector[i] = new Dato();
			vector[i].cl = c;
			tam++;
		}
		
		vector[i].d = x;
	}
}