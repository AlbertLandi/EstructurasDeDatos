/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;

/**
 *
 * @author Alberto
 */
public abstract class Casilla { //no se genera objeto casilla directamente, por lo que le trato de manera abstracta.
    protected char simbolo;

    public Casilla(char simbolo) { //el unico atributo de las casillas es su simbolo, debido al mismo se sabe si esta abierta o no
        this.simbolo = simbolo;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }
    
    
}
