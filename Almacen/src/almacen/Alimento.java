/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;

/**
 *
 * @author Alberto
 */
public class Alimento {
    protected String nombre;
    protected String proveedor;
    protected int precio;
    protected String fecha;

    public Alimento(String nombre, String proveedor, int precio) {
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
    }

    public Alimento(String nombre, String proveedor, int precio, String fecha) {
        this.nombre = nombre;
        this.proveedor = proveedor;
        this.precio = precio;
        this.fecha = fecha;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public String getProveedor() {
        return proveedor;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
    
        public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
}
