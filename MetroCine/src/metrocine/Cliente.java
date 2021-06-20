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
public class Cliente{
    private String nombre;
    private int cedula;
    private String telefono;
    private ListaSimple<Ticket> carrito;

    public Cliente(String nombre, int cedula, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.carrito = new ListaSimple<Ticket> ();
    }

    public String getNombre() {
        return nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public ListaSimple<Ticket> getCarrito() {
        return carrito;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCarrito(ListaSimple<Ticket> carrito) {
        this.carrito = carrito;
    }
    
    
    
}
