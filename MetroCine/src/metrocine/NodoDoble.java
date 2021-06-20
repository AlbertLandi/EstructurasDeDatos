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
public class NodoDoble {
    private Sala dato;
    private NodoDoble next;
    private NodoDoble prev;

    public NodoDoble (Sala dato){
        this.dato = dato;
        this.next = null;
        this.prev = null;
    }
    
    public void presentar(Sala dato){
        System.out.println("Sala "+ ((Sala) dato).getNumero() + "("+ ((Sala) dato).getTipo() + ")");
    }
        

    public Sala getDato() {
        return dato;
    }

    public void setDato(Sala dato) {
        this.dato = dato;
    }

    public NodoDoble getNext() {
        return next;
    }

    public void setNext(NodoDoble next) {
        this.next = next;
    }

    public NodoDoble getPrev() {
        return prev;
    }

    public void setPrev(NodoDoble prev) {
        this.prev = prev;
    }
}
