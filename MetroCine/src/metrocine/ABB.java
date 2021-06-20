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

//El ABB es la estructura de datos principal del programa, cada nodo contiene una sucursal
public class ABB {  
    private NodoABB raiz;
    
    public NodoABB getRaiz() {
        return this.raiz;
    }

    public void setRaiz(NodoABB raiz) {
        this.raiz = raiz;
    }
    
    public boolean estaVacio() {
        return this.raiz == null;
    }
    
    public void insertarNodoABB(NodoABB aux, NodoABB nuevo) {
        if(estaVacio()){
            this.raiz = nuevo;
        }else if (nuevo.getDato().getCodigo() < aux.getDato().getCodigo()) {
            if (aux.getHI() == null) {
                aux.setHI(nuevo);      
            }else {
                this.insertarNodoABB(aux.getHI(), nuevo);
            }
        }else if(nuevo.getDato().getCodigo() > aux.getDato().getCodigo()) {
            if(aux.getHD() == null) {
                aux.setHD(nuevo);  
            }else {
                this.insertarNodoABB(aux.getHD(), nuevo);
            }
        }else{
            System.out.println("Dicha sucursal ya existe.");
        }
    }
    
    public void recorrerABB(NodoABB aux){
        if(estaVacio()){
            System.out.println("No hay sucursales guardadas.");
        }else{
            if(aux != null){
                this.recorrerABB(aux.getHI());
                aux.presentarABB();
                aux.getDato().getSalas().recorrerListaDoble();
                this.recorrerABB(aux.getHD());
            }
        }
    }
    
    public void Cartelera(NodoABB aux){
        if(aux != null){
            System.out.println("Cartelera de " + aux.getDato().getUbicacion());
            NodoDoble aux2 = aux.getDato().getSalas().getCabeza();
            while(aux2 != null){
                aux2.presentar(aux2.getDato());
                aux2.getDato().getPeli().recorrerCola();
                aux2 = aux2.getNext();
            }
        }
    }
    
    public NodoABB buscarNodo(NodoABB aux, String ubicacion) {
        if (aux != null) {
            int comp = ubicacion.compareTo(aux.getDato().getUbicacion());
            if (comp < 0) {
                return this.buscarNodo(aux.getHI(), ubicacion);
            }else if (comp > 0) {
                return this.buscarNodo(aux.getHD(), ubicacion);
            }else {
                return aux;   
            }
        }else{
            return null;
        }   
    }
}
