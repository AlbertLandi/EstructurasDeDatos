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
public class Bateador extends Jugador{
    private int hits;
    private int jonrones;

    public Bateador( String nombre, String apellido, String posicionCampo, Boolean activo, int hits, int jonrones) {
        super(nombre, apellido, posicionCampo, activo);
        this.hits = hits;
        this.jonrones = jonrones;
    }
    
    public void batearJonron(){
        System.out.println("HOME RUN!");
        this.jonrones++;
        this.hits++;
        System.out.println("");
    }

    @Override
    public void mostrarJugador() {
        System.out.print(this.nombre+ " "+ this.apellido);
        System.out.println(" Posicion: " + this.posicionCampo);
        //System.out.println("Hits: " + this.hits);
        //System.out.println("Home runs:" + this.jonrones);
    }
    
    
    
}
