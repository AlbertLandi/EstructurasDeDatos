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
public class Loteria {
    
    private Ticket[] tickets;
    
    private int cantidadRegular;
    
    private int cantidadEspecial;
    
    private float monto;
    
    public Loteria(int cantidadRegular, int cantidadEspecial) {
        
        this.cantidadRegular = cantidadRegular;
        
        this.cantidadEspecial = cantidadEspecial;
        
        this.crearTickets();
        
        this.determinarMonto();
        
        this.mostrarTickets();
        
        this.elegirTicketGanador();
        
    }
    
    private void crearTickets() {
        
        this.tickets = new Ticket[this.cantidadRegular + this.cantidadEspecial];
        
        for(int i = 0;i < this.cantidadRegular; i++){
            tickets[i] = new Regular();
        }
        
        for(int i = this.cantidadRegular; i< this.cantidadRegular + this.cantidadEspecial; i++) {
            tickets[i] = new Especial();
        }
    }
    
    private void determinarMonto() {
        
        this.monto = (this.calcularIngresos() * 30)/100;
        
    }
    
    private float calcularIngresos() {
        
        float ingresos = 0;
        
        for(Ticket ticket:tickets){
            
            ingresos += ticket.getCosto();
            
        }
        
        return ingresos;
    }
    
    private void mostrarTickets() {
        
        System.out.println("Estos son los tickets de la loteria");
        
        for(Ticket ticket:tickets){
            
            ticket.presentarTicket();
            
        }
        
    }
    
    private void elegirTicketGanador() {
        
        Random random = new Random();
        
        int ganador = random.nextInt(this.cantidadRegular + this.cantidadEspecial);

        tickets[ganador].setGanador(true);
        
        if(tickets[ganador].especial()) {
            
            this.setMonto(this.getMonto() * 2);
            
        }
        
    }
    
    public void comprarTicket(int numero) {
        
        for(int i = 0; i < tickets.length; i ++) {
            
            if(this.tickets[i].getNumero() == numero) {
                
                System.out.println("El ticket seleccionado tiene un costo de " + tickets[i].getCosto() + " Bs.");
                
                if(this.tickets[i].getGanador()){

                    System.out.println("Felicitaciones, ha ganado!");

                }else {

                    System.out.println("Lo sentimos, no ha ganado");

                }
            
            }
        
        }
        
    }
    
    public void mostrarTicketGanador() {
        
        for(Ticket ticket:tickets){
            
            if(ticket.getGanador()){
                
                System.out.println("El ticket ganador es el #" + ticket.getNumero() + " y se lleva " + this.monto + " Bs.");
            
            }
            
        }
        
    }
    
    public void mostrarGanancias() {
        
        float ingresos = this.calcularIngresos();
        
        System.out.println("\n---GANANCIAS---");
        System.out.println("Se vendieron " + tickets.length + " boletos lo cual generó un ingreso de " + ingresos + " Bs.");
        System.out.println("Se entregó un monto de " + this.monto + " Bs. en premios");
        System.out.println("La ganancia final para LotoUnimet es de " + (ingresos - this.monto) + " Bs.");
        
    }
    
    private float getMonto() {
        
        return this.monto;
        
    }
    
    private void setMonto(float monto) {
        
        this.monto = monto;
        
    }
}
