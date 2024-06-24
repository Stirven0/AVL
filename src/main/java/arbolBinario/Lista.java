package arbolBinario;

public class Lista {

	private Nodo actual;
	private Nodo primero;
	private Nodo ultimo;

	public Lista() {
		this.primero = null;
		this.ultimo = null;
	}

	public Arbol siguiente() {
		if (actual.getSiguiente() != null) {
			actual = actual.getSiguiente();
			return actual.getValue();
		}
		System.out.println("No existe un sigiente estado");
		return null;

	}

	public Arbol anterior() {

		if (actual.getAnterior() != null) {
			actual = actual.getAnterior();
			return actual.getValue();
		}
		System.out.println("No existe un estado anteriro");
		return null;

	}

	public boolean addToLasd(Arbol arbol) {
		ultimo = actual;
		Nodo nodo = new Nodo(arbol);
		if (isEmpy()) {
			primero = nodo;
			ultimo = nodo;
		} else {
			nodo.setAnterior(ultimo);
			ultimo.setSiguiente(nodo);
			ultimo = nodo;
		}
		actual = ultimo;
		return true;
	}

	public boolean isEmpy() {
		if (primero == null && ultimo == null) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * NodoLista
	 */
	private class Nodo {
		Arbol arbol;
		private Nodo siguiente;
		private Nodo anterior;

		public Nodo(Arbol arbol) {
			this.arbol = arbol;
			this.anterior = null;
			this.siguiente = null;
		}

		public Nodo getSiguiente() {
			return siguiente;
		}

		public void setSiguiente(Nodo siguiente) {
			this.siguiente = siguiente;
		}

		public Nodo getAnterior() {
			return anterior;
		}

		public void setAnterior(Nodo anterior) {
			this.anterior = anterior;
		}

		public Arbol getValue() {
			return arbol;
		}
	}
}
