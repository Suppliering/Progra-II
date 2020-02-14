package MiApi;

/**
 * @Autores: glacuesta, jsegovia, mculen, skomlev
 * @Grupo: 1
 * @TDA: Arbol
 * @Definicion: estructura jerarquica no destructiva 
 * sobre una coleccion de nodos los cuales comparten relacion de parentesco (nodo padre y nodos hijos).
 */
public interface ArbolTDA {
	
	public void inicializarArbol();
	public int raiz();
	public ArbolTDA hijoIzq();
	public ArbolTDA hijoDer();
	public boolean arbolVacio();
	public void agregarElem();
	public void eliminarElem();
}
