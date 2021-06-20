/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrocine;
import java.util.*;
/**
 *
 * @author Alberto
 */
public class Ticket {
    private int codigo;
    private int precio;
    private Pelicula pelicula;
    private NodoABB sucursal;
    private NodoDoble sala;
    //precio default de cada tipo de sala
    private int TDD = 100;
    private int TDDD = 200;
    private int TDX = 300;
    private Boolean pago;
    Random ran = new Random();
    
    //Los tickets obtienen la sucursal, la sala, la pelicula y el precio al momento segun el tipo de sala y su estatus de pago
    public Ticket(NodoABB sucursal, NodoDoble sala, int TDD, int TDDD, int TDX, Boolean pago) {
        this.sucursal = sucursal;
        this.sala = sala;
        this.pelicula = sala.getDato().getPeli().peek().getDato();
        if(null!= sala.getDato().getTipo())switch (sala.getDato().getTipo()) {
            case "2D":
                this.precio = TDD;
                break;
            case "3D":
                this.precio = TDDD;
                break;
            case "4DX":
                this.precio = TDX;
                break;
            default:
                break;
        }
        this.codigo = codigo();   
        this.pago = pago;
    }
    
    public Ticket(){ //constructor vacio auxiliar

    }

    public NodoABB getSucursal() {
        return sucursal;
    }

    public NodoDoble getSala() {
        return sala;
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public int getPrecio() {
        return precio;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getTDD() {
        return TDD;
    }

    public int getTDDD() {
        return TDDD;
    }

    public int getTDX() {
        return TDX;
    }

    public void setPelicula(Pelicula pelicula) {
        this.pelicula = pelicula;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public void setTDD(int TDD) {
        this.TDD = TDD;
    }

    public void setTDDD(int TDDD) {
        this.TDDD = TDDD;
    }

    public void setTDX(int TDX) {
        this.TDX = TDX;
    }

    private int codigo(){
        int code = ran.nextInt(1000000)+1;
        return code; 
    }

    public Boolean getPago() {
        return pago;
    }

    public void setPago(Boolean pago) {
        this.pago = pago;
    }
}
