/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package arbolBinario;

/**
 *
 * @author julio
 */
public class Nodo {
    
    int valor;  //este es el objeto que sera contenido dentro del nodo
    Nodo hijoIzquierdo;
    Nodo hijoDerecho;
    

    public Nodo(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }
}
