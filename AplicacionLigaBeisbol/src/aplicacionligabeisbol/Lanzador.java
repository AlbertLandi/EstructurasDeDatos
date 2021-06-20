/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionligabeisbol;

/**
 *
 * @author Alberto
 */
public class Lanzador extends Jugador{
    private int ponchesTotales;

    public Lanzador( String nombre, String apellido, String posicionCampo, Boolean activo, int ponchesTotales) {
        super(nombre, apellido, posicionCampo, activo);
        this.ponchesTotales = ponchesTotales;
    }
    
    public void ponchar(){
        System.out.println("Ponchado!");
        this.ponchesTotales++;
        System.out.println("");
    }
    
    @Override
    public void mostrarJugador(){
        System.out.print(this.nombre+ " "+ this.apellido);
        System.out.println(" Posicion: " + this.posicionCampo);
        //System.out.println("Ponches totales" + this.ponchesTotales);
        
    }
}
