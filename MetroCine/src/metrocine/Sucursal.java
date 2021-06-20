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
public class Sucursal {
    private String ubicacion;
    private int codigo;
    private ListaDoble Salas = new ListaDoble(); //cada sucursal cuenta con una lista doble de salas
    private String tipo[] = { "2D", "3D", "4DX"};
    Random ran = new Random();
    
    //constructor default de una sucursal
    public Sucursal(String ubicacion, int codigo) {
        this.ubicacion = ubicacion;
        this.codigo = codigo;
        crearSalas();
    }
    
    //constructor de una nueva sucursal
    public Sucursal(String ubicacion, int codigo, int DD, int DDD, int DX) {
        this.ubicacion = ubicacion;
        this.codigo = codigo;
        crearSalas(DD, DDD, DX);
    }
    
    //se anaden tantas salas como se deseen a la lista doble de salas
    public void crearSalas(int DD, int DDD, int DX){
        for (int i = 1; i <= DD; i++) {
            Salas.anadirUltimo(new Sala(i, "2D"));
        }
        for (int i = DD+1; i <= DDD+DD; i++) {
            Salas.anadirUltimo(new Sala(i, "3D"));
        }
        for (int i = DDD+DD+1; i <= DX+DDD+DD; i++) {
            Salas.anadirUltimo(new Sala(i, "4DX"));
        }
    }
    
    //Salas precargadas
    public void crearSalas(){
        Salas.anadirUltimo(new Sala( 1, "2D"));
        Salas.anadirUltimo(new Sala( 2, "2D"));
        Salas.anadirUltimo(new Sala( 3, "3D"));
        Salas.anadirUltimo(new Sala( 4, "3D"));
        Salas.anadirUltimo(new Sala( 5, "4DX"));
        Salas.anadirUltimo(new Sala( 6, "4DX"));
    }    

    public String getUbicacion() {
        return ubicacion;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public ListaDoble getSalas() {
        return Salas;
    }

    public void setSalas(ListaDoble Salas) {
        this.Salas = Salas;
    }
    
    
    
    
}
