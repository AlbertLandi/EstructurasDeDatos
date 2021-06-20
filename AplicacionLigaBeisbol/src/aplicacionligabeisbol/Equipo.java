/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionligabeisbol;
import java.util.*;
/**
 *
 * @author Alberto
 */
public class Equipo {
    private String nombre;
    private Jugador[] vec_jugadores = new Jugador[15];
    private String nombres[] = {"Gerardo", "Luis", "Paulo", "Juan", "Pedro", "Jose", "Ricardo", "Fabio", "Mauricio", "Adrian"};
    private String apellidos[] = { "Gonzalez", "Perez", "Rodriguez", "Garcia", "Bolivar", "Miranda", "Martinez", "Ramos", "Alvarez", "Vazquez"}; 
    Random ran = new Random();
    Scanner sc = new Scanner(System.in);
    private String pos;

    public Equipo(String nombre) {
        this.nombre = nombre;
        llenarEquipo();
    }
    
    public void incorporarJugador(Jugador j){
        System.out.println("Inserte nombre");
        String name = sc.nextLine();
        for (int i = 0; i < vec_jugadores.length; i++) {
            //vec_jugadores[i] = new Jugador();
            
        }
    }
    
    public void llenarEquipo(){
        for (int i = 0; i < vec_jugadores.length; i++) {
            if(i%2==0){
                vec_jugadores[i] = new Lanzador(nombres[ran.nextInt(nombres.length)], apellidos[ran.nextInt(apellidos.length)], Integer.toString(ran.nextInt(9)+1), ran.nextBoolean(), 0);
            }else{
                vec_jugadores[i] = new Bateador(nombres[ran.nextInt(nombres.length)], apellidos[ran.nextInt(apellidos.length)], Integer.toString(ran.nextInt(9)+1), ran.nextBoolean(), 0, 0);
            }
        }
    }
    
    public void mostrarEquipo(){
        for (int i = 0; i < vec_jugadores.length; i++) {
            vec_jugadores[i].mostrarJugador();
        }
    }
    
    public void recorrerJugar(){
        for (int i = 0; i < vec_jugadores.length; i++) {
            if(vec_jugadores[i].getActivo()==true && vec_jugadores[i] instanceof Bateador){
                ((Bateador)vec_jugadores[i]).batearJonron();
            }
            else if(vec_jugadores[i].getActivo()==true && vec_jugadores[i] instanceof Lanzador){
                ((Lanzador)vec_jugadores[i]).ponchar();
            }
            else if(vec_jugadores[i].getActivo()==false){
                System.out.println("Jugador inactivo: ");
                vec_jugadores[i].mostrarJugador();
                System.out.println("");
            }
            
        }
    }

    public String getNombre() {
        return nombre;
    }

    public Jugador[] getVec_jugadores() {
        return vec_jugadores;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setVec_jugadores(Jugador[] vec_jugadores) {
        this.vec_jugadores = vec_jugadores;
    }
    
    
    
}
