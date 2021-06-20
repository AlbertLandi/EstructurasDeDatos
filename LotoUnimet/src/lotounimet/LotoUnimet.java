/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package lotounimet;

import java.util.Scanner;

/**
 *
 * @author Profesores
 */
public class LotoUnimet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Bienvenido a LotoUnimet\nCuantos tickets regulares desea emitir?");
        
        int cantidadRegulares = sc.nextInt();
        
        System.out.println("Cuantos tickets especiales desea emitir?");
        
        int cantidadEspeciales = sc.nextInt();
        
        Loteria loteria = new Loteria(cantidadRegulares, cantidadEspeciales);
        
        System.out.println("Ingrese el código del ticket que desea comprar");
        
        loteria.comprarTicket(sc.nextInt());
        
        loteria.mostrarTicketGanador();
        
        loteria.mostrarGanancias();
    }
}
