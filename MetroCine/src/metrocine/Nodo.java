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

/*La clase Nodo utiliza tipo de dato generico, ya que es utilizada tanto para colas como listas simples.
Los tipos de dato que utilizan esta clase son pelicula, cliente y ticket*/
public class Nodo <T>{
    private T dato ;
    private Nodo<T> next;

    public Nodo (T dato){
        this.dato = dato;
        this.next = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo getNext() {
        return next;
    }

    public void setNext(Nodo next) {
        this.next = next;
    }
    
    //mismo metodo sirve para todos los tipos de datos a utilizar
    public void presentar(T dato){
        if(dato instanceof Pelicula){
            System.out.println("Nombre: " + ((Pelicula) dato).getNombre());
            System.out.println("Idioma: " + ((Pelicula) dato).getIdioma());
            System.out.println("Genero: " + ((Pelicula) dato).getGenero());
            System.out.println("Horario: " + ((Pelicula) dato).getHorario());
        }else if(dato instanceof Cliente){
            System.out.println("Nombre: " + ((Cliente) dato).getNombre());
            System.out.println("Cedula: " + ((Cliente) dato).getCedula());
            System.out.println("Telefono: " + ((Cliente) dato).getTelefono());
        }else if(dato instanceof Ticket){
            System.out.println("Sucursal: " + ((Ticket) dato).getSucursal().getDato().getUbicacion());
            System.out.println("Sala: " + ((Ticket) dato).getSala().getDato().getNumero() + " (" +((Ticket) dato).getSala().getDato().getTipo() + ")");
            System.out.println("Pelicula: " + ((Ticket) dato).getPelicula().getNombre());
            System.out.println("Precio: " + ((Ticket) dato).getPrecio());
            System.out.println("Codigo: " + ((Ticket) dato).getCodigo());
        }
          
    }

}
