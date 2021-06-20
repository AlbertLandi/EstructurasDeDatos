/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lotounimet;

/**
 *
 * @author Profesores
 */
public class Especial extends Ticket {
    
    public Especial() {
        
        super();
        
        this.costo = 2000;
    
    }
    
    public void presentarTicket() {
        
        System.out.println("Ticket Especial #" + this.numero);
        
    }
    
    public boolean especial(){
        
        return true;
        
    }
    
}
