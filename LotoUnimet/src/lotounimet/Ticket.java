/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lotounimet;

import java.util.Random;

/**
 *
 * @author Profesores
 */
public class Ticket {
    
    protected int numero;
    
    protected boolean ganador;
    
    protected float costo;
    
    protected Ticket() {

        Random random = new Random();

        this.numero = random.nextInt(10000) + 1;
        
        this.ganador = false;
        
    }
    
    public boolean getGanador() {
        
        return this.ganador;
        
    }
    
    public void setGanador(boolean ganador) {
        
        this.ganador = ganador;
        
    }
    
    public int getNumero() {
        
        return this.numero;
        
    }
    
    public float getCosto() {
        
        return this.costo;
        
    }
    
    public void presentarTicket() {
        
        System.out.println("Ticket #" + this.numero);
        
    }
    
    public boolean especial(){
        
        return false;
        
    }
}
