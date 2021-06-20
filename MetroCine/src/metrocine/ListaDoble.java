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
public class ListaDoble{
    private NodoDoble cabeza;
    private NodoDoble cola;
    
    public ListaDoble() {
    
    }

    public NodoDoble getCabeza() {
        return cabeza;
    }

    public NodoDoble getCola() {
        return cola;
    }

    public void setCabeza(NodoDoble cabeza) {
        this.cabeza = cabeza;
    }

    public void setCola(NodoDoble cola) {
        this.cola = cola;
    }
    
    
    public ListaDoble(NodoDoble aux) {
        this.cabeza = this.cola = aux;
        this.cabeza.setNext(this.cola);
        this.cola.setPrev(this.cabeza);
    }
    
    private boolean estaVacio() {
        return this.cabeza == null;
    }

    public int tamano() {
        if (estaVacio()) {
            return 0;
        } else {
            NodoDoble aux = this.cabeza;
            int i = 0;
            while (aux != null) {
                aux = aux.getNext();
                i++;
            }
            return i;
        }
    }

    public void anadirPrimero(Sala dato){
        NodoDoble aux = new NodoDoble(dato);
        if (estaVacio()) {
            this.cabeza = this.cola = aux;
            this.cabeza.setNext(this.cola);
            this.cola.setPrev(this.cabeza);
        } else {
            aux.setNext(this.cabeza);
            this.cabeza.setPrev(aux);
            this.cabeza = aux;
        }
    }
    
    public void anadirUltimo(Sala dato){
        NodoDoble aux = new NodoDoble(dato);
        if (estaVacio()) {
            this.cabeza = this.cola = aux;
            this.cabeza.setNext(this.cola);
            this.cola.setPrev(this.cabeza);
        } else {
            aux.setPrev(this.cola);
            this.cola.setNext(aux);
            this.cola = aux;
        }
    }
    
    public void recorrerListaDoble(){
        if(estaVacio()){
            System.out.println("No hay salas guardada.");
        }else{
            NodoDoble aux = this.cabeza;
            while(aux != null){
                aux.presentar(aux.getDato());
                aux.getDato().getPeli().recorrerCola();
                aux = aux.getNext();
            }
        }
    }
    
    public NodoDoble BuscarNodo(int numeroSala){
        NodoDoble aux = this.cabeza;
        if(estaVacio()){
            return null;
        }else{
            while(aux != null){
                if(aux.getDato().getNumero() == numeroSala){
                    break;
                }else{
                    aux = aux.getNext();
                }
            }
            return aux;
        }
    }
}
