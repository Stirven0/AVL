/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolBinario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Esta clase contiene los metodos vasicos necesarios para
 * crear una estructura de datos de tipo Arbol Binario (AVL)
 * 
 * <pre>
getName()
clonnar()
eliminar()
insertar(int dato)
inorden()
postorden()
preoden()
exist(int dato)
numeroNodos()
clear()
 * </pre>
 * 
 * e incluye otros metodos internos para su funcionamiento
 * 
 * @author julio
 */

public class Arbol {

	Nodo raiz;
	// private ArbolPanel arbolPanel;
	public Nodo getRaiz() {
		return raiz;
	}

	private String name;
	private List<Integer> valores = new ArrayList<>();

	// public Arbol( ArbolPanel arbolPanel) {
	// 	this.raiz = null;
	// 	this.arbolPanel = arbolPanel;
	// }

	/**
	 * Crea un arvol vacio (arvol = null)
	 */
	public Arbol() {
		this.raiz = null;
	}

	public Arbol(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Este metodo primero valida si un valor existe dentor del
	 * arbol, luego crea un nodo donde se contien el valor que se
	 * desea agregar al arbol, por ultimo lo ubica el la posicion
	 * correcta y valancea el arbol en caso de ser necesario
	 * 
	 * @param dato para el caso un entero
	 */
	public void insertar(int dato) {
		if (!exist(dato)) {
			raiz = insertarRec(raiz, dato);
			// arbolPanel.show(raiz);
		} else {
			System.out.println("el valor {" + dato + "} exite dentro del alrbol");
		}
	}

	private Nodo insertarRec(Nodo raiz, int dato) {
		if (raiz == null) {
			raiz = new Nodo(dato);
			return raiz;
		}

		if (dato < raiz.valor) {
			raiz.hijoIzquierdo = insertarRec(raiz.hijoIzquierdo, dato);
		} else if (dato > raiz.valor) {
			raiz.hijoDerecho = insertarRec(raiz.hijoDerecho, dato);
		}

		raiz = balancearArbol(raiz);
		return raiz;
	}

	/**
	 * Este metodo imprime una cadena de texto con los valores
	 * contenidos en cada uno de los nodos del arbol respetando
	 * la regla (Izquierda-Raiz-Derecha)
	 */
	public List<Integer> inorden() {
		valores.clear();
		if (raiz != null) {
			inorden(raiz);
		}
		return valores;
	}

	private void inorden(Nodo nodo) {
		if (nodo != null) {
			inorden(nodo.hijoIzquierdo);
			valores.add(nodo.valor);
			inorden(nodo.hijoDerecho);

		}
	}

	/**
	 * Este metodo imprime una cadena de texto con los valores
	 * contenidos en cada uno de los nodos del arbol respetando
	 * la regla (Raiz-Izquierda-Derecha)
	 */
	public List<Integer> preorden() {
		valores.clear();
		if (raiz != null) {
			preorden(raiz);
		}
		return valores;
	}

	private void preorden(Nodo nodo) {
		if (nodo != null) {
			valores.add(nodo.valor);
			preorden(nodo.hijoIzquierdo);
			preorden(nodo.hijoDerecho);

		}
	}

	/**
	 * Este metodo imprime una cadena de texto con los valores
	 * contenidos en cada uno de los nodos del arbol respetando
	 * la regla (Izquierda-Derecha-Raiz)
	 */
	public List<Integer> postorden() {
		valores.clear();
		if (raiz != null) {
			postorden(raiz);
		}
		return valores;
	}

	void postorden(Nodo nodo) {
		if (nodo != null) {
			postorden(nodo.hijoIzquierdo);
			postorden(nodo.hijoDerecho);
			valores.add(nodo.valor);

		}
	}

	/**
	 * Este metodo es para comprobar la existencia
	 * de un dato dentro del arbol
	 * retorna verdadero o faso encaso de que
	 * exista o no exista el dato solicitado
	 * dentro del arbol respectivamente
	 * 
	 * @param dato
	 * @return true o false
	 */
	public boolean exist(int dato) {
		Nodo aux = raiz;
		aux = buscarRec(raiz, dato);
		return aux != null;
	}

	private Nodo buscarRec(Nodo raiz, int dato) {
		if (raiz == null || raiz.valor == dato)
			return raiz;

		if (dato < raiz.valor)
			return buscarRec(raiz.hijoIzquierdo, dato);

		return buscarRec(raiz.hijoDerecho, dato);
	}

	/**
	 * se usa para contar los nodos dentro de un arbol
	 * 
	 * @return un entero con el total de los nodos
	 *         dentro del arbol y en caso de arbol = null
	 *         retona 0
	 */
	public int numeroNodos() {
		if (raiz != null) {
			return numeroNodos(raiz) ;
		} else {
			return 0;
		}
	}

	private int numeroNodos(Nodo nodo) {
		if (nodo != null) {
			return 1 + numeroNodos(nodo.hijoIzquierdo) + numeroNodos(nodo.hijoDerecho);
		} else {
			return 0;
		}
	}

	// valansear el arbol
	private Nodo balancearArbol(Nodo nodo) {
		if (nodo == null) {
			return null;
		} else {
			int alturaIzquierda = calcularAltura(nodo.hijoIzquierdo);
			int alturaDerecha = calcularAltura(nodo.hijoDerecho);
			if (alturaIzquierda - alturaDerecha > 1) {
				// Rotacion a la izquierda
				if (calcularAltura(nodo.hijoIzquierdo.hijoIzquierdo) > calcularAltura(nodo.hijoIzquierdo.hijoDerecho)) {
					return rotacionIzquierda(nodo);
				} else {
					// Rotacion doble izquierda-derecha
					return rotacionDerecha(rotacionIzquierda(nodo));
				}
			} else if (alturaDerecha - alturaIzquierda > 1) {
				// Rotacion a la derecha
				if (calcularAltura(nodo.hijoDerecho.hijoDerecho) > calcularAltura(nodo.hijoDerecho.hijoIzquierdo)) {
					return rotacionDerecha(nodo);
				} else {
					// Rotacion doble derecha-izquierda
					return rotacionIzquierda(rotacionDerecha(nodo));
				}
			} else {
				// El árbol ya está balanceado
				return nodo;
			}
		}
	}

	private int calcularAltura(Nodo nodo) {
		if (nodo == null) {
			return 0;
		} else {
			return Math.max(calcularAltura(nodo.hijoIzquierdo), calcularAltura(nodo.hijoDerecho)) + 1;
		}
	}

	private Nodo rotacionIzquierda(Nodo nodo) {
		Nodo hijoIzquierdo = nodo.hijoIzquierdo;
		nodo.hijoIzquierdo = hijoIzquierdo.hijoDerecho;
		hijoIzquierdo.hijoDerecho = nodo;
		// arbolPanel.show(raiz);
		return hijoIzquierdo;
	}

	private Nodo rotacionDerecha(Nodo nodo) {
		Nodo hijoDerecho = nodo.hijoDerecho;
		nodo.hijoDerecho = hijoDerecho.hijoIzquierdo;
		hijoDerecho.hijoIzquierdo = nodo;
		// arbolPanel.show(raiz);
		return hijoDerecho;
	}

	/////////////////////////////////////////////////
	// Método para imprimir el árbol por niveles
	/**
	 * Este metodo debuelve por consola la vista del arbol
	 */
	public void show() {
		if (raiz != null) {
			int maxNivel = calcularAltura(raiz);
			imprimirNodoRecursivo(Collections.singletonList(raiz), 1, maxNivel);
		} else {
			System.out.println("No hay arvol para mostrar");
		}
	}

	private void imprimirNodoRecursivo(List<Nodo> nodos, int nivel, int maxNivel) {
		if (nodos.isEmpty() || esListaDeNodosVacia(nodos)) {
			return;
		}

		int piso = maxNivel - nivel;
		int bordeIzquierdo = (int) Math.pow(2, (piso)) - 1;
		int espacioEntreNodos = (int) Math.pow(2, (piso + 1)) - 1;

		imprimirEspacios(bordeIzquierdo);

		List<Nodo> nuevosNodos = new ArrayList<>();
		for (Nodo nodo : nodos) {
			if (nodo != null) {
				System.out.print(nodo.valor);
				nuevosNodos.add(nodo.hijoIzquierdo);
				nuevosNodos.add(nodo.hijoDerecho);
			} else {
				nuevosNodos.add(null);
				nuevosNodos.add(null);
				System.out.print(" ");
			}

			imprimirEspacios(espacioEntreNodos);
		}
		System.out.println("");

		imprimirNodoRecursivo(nuevosNodos, nivel + 1, maxNivel);
	}

	private void imprimirEspacios(int count) {
		for (int i = 0; i < count; i++) {
			System.out.print(" ");
		}
	}

	private boolean esListaDeNodosVacia(List<Nodo> lista) {
		for (Nodo nodo : lista) {
			if (nodo != null) {
				return false;
			}
		}
		return true;
	}
	/////////////////////////////////////////////////

	public void eliminar(int valor) {
		if (exist(valor)) {
			raiz = eliminarRec(raiz, valor);
			// arbolPanel.show(raiz);
		} else {
			System.out.println("el valor {" + valor + "} no exite dentro del alrbol");
		}
	}

	private Nodo eliminarRec(Nodo nodo, int valor) {
		if (nodo == null) {
			return nodo;
		}

		// Buscar el nodo a eliminar
		if (valor < nodo.valor) {
			nodo.hijoIzquierdo = eliminarRec(nodo.hijoIzquierdo, valor);
		} else if (valor > nodo.valor) {
			nodo.hijoDerecho = eliminarRec(nodo.hijoDerecho, valor);
		} else {
			// Nodo encontrado, manejar los casos de eliminación
			if (nodo.hijoIzquierdo == null) {
				return nodo.hijoDerecho;
			} else if (nodo.hijoDerecho == null) {
				return nodo.hijoIzquierdo;
			}

			// Nodo con dos hijos: encontrar sucesor inorden
			// nodo.valor = encontrarMinimo(nodo.hijoDerecho);
			nodo.valor = encontrarMaximo(nodo.hijoIzquierdo);
			nodo.hijoIzquierdo = eliminarRec(nodo.hijoIzquierdo, nodo.valor);
		}
		nodo = balancearArbol(nodo);
		return nodo;
	}

	private int encontrarMinimo(Nodo nodo) {
		int minimo = nodo.valor;
		while (nodo.hijoIzquierdo != null) {
			minimo = nodo.hijoIzquierdo.valor;
			nodo = nodo.hijoIzquierdo;
		}
		return minimo;
	}

	private int encontrarMaximo(Nodo nodo) {
		int maximo = nodo.valor;
		while (nodo.hijoDerecho != null) {
			maximo = nodo.hijoDerecho.valor;
			nodo = nodo.hijoDerecho;
		}
		return maximo;
	}

	public void clear() {
		for (Integer integer : inorden()) {
			eliminar(integer);
		}
	}
	
	public void clonarTo(Arbol arbol) {

		name = arbol.getName();

		raiz = clonar(arbol.raiz);
	}
	private Nodo clonar(Nodo nodo) {
		if (nodo == null) {
			return null;
		}
		Nodo clon = new Nodo(nodo.valor);
		clon.hijoIzquierdo = clonar(nodo.hijoIzquierdo);
		clon.hijoDerecho = clonar(nodo.hijoDerecho);

		return clon;
	}

	@Override
	public String toString() {
		return name;
	}

}
