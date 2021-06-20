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
public class NodoABB {
    private Sucursal dato;
    private NodoABB HI; 
    private NodoABB HD;
    
    public NodoABB() {
        
    }
    
    public NodoABB(Sucursal dato) {  
        this.dato = dato;
        this.HI = null;
        this.HD = null;
    }
    
    public void presentarABB(){
        System.out.println("");
        System.out.println("Ubicacion: "+ this.getDato().getUbicacion());
        System.out.println("Codigo: "+ this.getDato().getCodigo());
    }
    
    public Sucursal getDato() {    
        return this.dato;
    }

    public void setDato(Sucursal dato) {
        this.dato = dato;
    }

    public NodoABB getHI() {
        return this.HI;
    }

    public void setHI(NodoABB HI) {
        this.HI = HI;
    }
    
     public NodoABB getHD() { 
        return this.HD;
    }

    public void setHD(NodoABB HD) {
        this.HD = HD;
        
    }
}
