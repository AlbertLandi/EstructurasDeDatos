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
public class Cola{
    private Nodo<Pelicula> cabeza;
    private Nodo<Pelicula> cola;
    
     private boolean estaVacia(){
        return this.cabeza == null;
    }
     
    public void push(Pelicula dato) {
        Nodo<Pelicula> aux = new Nodo(dato); 
        if (estaVacia()) {
            this.cabeza = this.cola = aux;
        } else {
            this.cola.setNext(aux);
            this.cola = aux;
        }
    }

    public void pop() {
        if (estaVacia()){
            System.out.println("Sin peliculas");
        } else {
            Nodo<Pelicula> temp = this.cabeza;
            this.cabeza = temp.getNext();
            temp.setNext(null);
        }
    }

    public Nodo<Pelicula> peek() {
        if (estaVacia()){
            return null;
        } else {
            Nodo temp = this.cabeza;
            return temp;
        }
    }
    
    public void recorrerCola(){
        if(estaVacia()){
            System.out.println("No hay peliculas asignadas en esta sala.");
        }else{
            Nodo<Pelicula> aux = this.cabeza;
            while(aux != null){
                aux.presentar(aux.getDato());
                aux = aux.getNext();
            }
        }
    }

    public void filtro(Nodo<Pelicula> aux, String s){
        if(aux != null){
            if(s.equals(aux.getDato().getNombre())){
                aux.presentar(aux.getDato());
            }else if(s.equals(aux.getDato().getIdioma())){
                aux.presentar(aux.getDato());
            }else if(s.equals(aux.getDato().getGenero())){
                aux.presentar(aux.getDato());
            }
            this.filtro(aux.getNext(), s);
        }
    }
    
    public void ordenarAZ(Cola cartelera, Boolean invertir) {
        ListaSimple<Pelicula> lp1 = new ListaSimple<>();
        Cola p1 = cartelera;
        Nodo<Pelicula> auxc = p1.peek();
        //de cola a lista simple
        while(auxc != null){
            lp1.anadirUltimo(auxc.getDato());
            auxc = auxc.getNext();
        }
        //metodo burbuja
        if (lp1.tamano() > 1) {
            boolean cambio;
            do {
                Nodo<Pelicula> actual = lp1.getCabeza();
                Nodo<Pelicula> anterior = null;
                Nodo<Pelicula> siguiente = lp1.getCabeza().getNext();
                cambio = false;
                while ( siguiente != null ) {
                    if (actual.getDato().getNombre().compareTo(siguiente.getDato().getNombre())>0) {
                        cambio = true;
                        if ( anterior != null ) {
                            Nodo<Pelicula> sig = siguiente.getNext();
                            anterior.setNext(siguiente);
                            siguiente.setNext(actual);
                            actual.setNext(sig);
                        } else {
                            Nodo<Pelicula> sig = siguiente.getNext();
                            lp1.setCabeza(siguiente);
                            siguiente.setNext(actual);
                            actual.setNext(sig);
                        }
                        anterior = siguiente;
                        siguiente = actual.getNext();
                    } else { 
                        anterior = actual;
                        actual = siguiente;
                        siguiente = siguiente.getNext();
                    }
                } 
            } while( cambio );
        }
        if(!invertir){ //Orden AZ, solo imprimir
           lp1.recorrerListaSimple(); 
        }else if(invertir){ //Orden ZA, usando la burbuja, se convierte en AZ y luego se ingresa en una pila que se imprime en ZA
            Pila P = new Pila();
            Nodo<Pelicula> aux = lp1.getCabeza();
            while(aux != null){
                P.push(aux.getDato());
                aux = aux.getNext();
            }
            P.recorrerPila(P.peek());
        }
    }
}
