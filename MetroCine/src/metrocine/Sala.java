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
public class Sala {
    private int numero;
    private String tipo;
    private Cola peli = new Cola(); //Cada sala cuenta con una cola de peliculas que se van a reproducir en ella
    private String peliculas[] = { "Black Panther", "The Commuter", "Dunkirk", "Tomb Raider"}; //Peliculas precargadas
    private String idioma[] = { "Espanol", "Ingles"}; //idiomas precargados
    Random ran = new Random();
    
    //constructor por default de cada sala
    public Sala(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        String sp = peliculas[ran.nextInt(peliculas.length)];
        peli.push(new Pelicula(sp, idioma[ran.nextInt(idioma.length)], genero(sp), "7:00 PM"));
    }
    
    //constructor de una nueva sala
     public Sala(int numero, String tipo, Pelicula pelicula, Cola cartelera) {
        this.numero = numero;
        this.tipo = tipo;
        peli.push(pelicula);
        cartelera.push(pelicula);
    }
     
    public Sala(){
        
    }
    
     //metodo auxiliar selector de genero segun pelicula precargada
    public String genero(String sp){
        String g = null;
        if(sp.equals("Black Panther") || sp.equals("Tomb Raider") ){
            g = "Accion";
        }else if(sp.equals("The Darkest Hour") || sp.equals("Dunkirk") || sp.equals("The Commuter")){
            g = "Suspenso";
        }
        return g;
    }

    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public Cola getPeli() {
        return peli;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setPeli(Cola peli) {
        this.peli = peli;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
