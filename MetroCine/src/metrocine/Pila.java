/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrocine;

/**
 *
 * @author Alberto
 */
public class Pila {
    private Nodo<Pelicula> cabeza;
  
     private boolean estaVacia(){
        return this.cabeza == null;
    }
     
    public void push(Pelicula dato) {
        Nodo<Pelicula> aux = new Nodo(dato); 
        if (estaVacia()) {
            this.cabeza = aux;
        } else {
            aux.setNext(this.cabeza);
            this.cabeza = aux;
        }
    }

    public void pop() {
        if (estaVacia()){
            System.out.println("Sin peliculas");
        } else {
            Nodo<Pelicula> aux = this.cabeza;
            this.cabeza = aux.getNext();
            aux.setNext(null);
        }
    }

    public Nodo<Pelicula> peek() {
        if (estaVacia()){
            return null;
        } else {
            Nodo aux = this.cabeza;
            return aux;
        }
    }
    
    public void recorrerPila(Nodo aux){
        if(aux != null){
            aux.presentar(aux.getDato());
            this.recorrerPila(aux.getNext());
        }
    }
}
