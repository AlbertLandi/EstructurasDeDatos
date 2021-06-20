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

/*La clase lista simple hace uso de tipo de dato generico. Los tipos de datos a utilizar son Cliente y Ticket*/
public class ListaSimple <T> {
    private Nodo<T> cabeza;
    private Nodo<T> cola;
    
    public ListaSimple() {
        this.cabeza = this.cola = null;
    }
    
    public ListaSimple(Nodo<T> n){
        this.cabeza = this.cola = n;
    }
    
    private boolean estaVacio() {
        return this.cabeza == null;
    }

    public Nodo<T> getCabeza() {
        return cabeza;
    }

    public Nodo<T> getCola() {
        return cola;
    }

    public void setCabeza(Nodo<T> cabeza) {
        this.cabeza = cabeza;
    }

    public void setCola(Nodo<T> cola) {
        this.cola = cola;
    }
    
    public void anadirPrimero(T dato) {
        Nodo<T> n = new Nodo<>(dato);
        if (estaVacio()) {
            this.cabeza = n;
            this.cola = n;
            this.cabeza.setNext(this.cola);
            this.cola.setNext(null);
        } else {
            n.setNext(this.cabeza);
            this.cabeza = n;
        }
    }
       
    public void anadirUltimo(T dato) {
        Nodo<T> n = new Nodo<>(dato);
        if (estaVacio()) {
            this.cabeza = n;
            this.cola = n;
            this.cabeza.setNext(this.cola);
            this.cola.setNext(null);
        } else {
            this.cola.setNext(n);
            this.cola = n;
        }
    }
    
    public void recorrerListaSimple(){
        if (estaVacio()) {  
            System.out.println("No hay elementos guardados.");
        } else {
            Nodo<T> aux = this.cabeza;
            while (aux != null) {
                if(aux.getDato() instanceof Cliente){
                    aux.presentar(aux.getDato());
                }else if(aux.getDato() instanceof Ticket){
                    aux.presentar(aux.getDato());
                }else if(aux.getDato() instanceof Pelicula){
                    aux.presentar(aux.getDato());
                }
                aux = aux.getNext();
            }
        }
    }
    
    public Nodo<Cliente> BuscarNodoCliente(Nodo<Cliente> aux, int cedula){
        if(estaVacio()){
            return null;
        }else{
            while(aux != null){
                if(cedula == aux.getDato().getCedula()){
                    break;
                }
                aux = aux.getNext();
            }
            return aux;
        }
    }
    
    public int tamano() {
        if (estaVacio()) {
            return 0;
        } else {
            Nodo<T> aux = this.cabeza;
            int i = 0;
            while (aux != null) {
                aux = aux.getNext();
                i++;
            }
            return i;
        }
    }

}
