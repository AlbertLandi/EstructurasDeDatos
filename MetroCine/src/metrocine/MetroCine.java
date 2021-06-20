/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package metrocine;

/**
 *
 * @author Alberto
 */
public class MetroCine {

    /**
     * @param args the command line arguments
     */
    
     /* 
    AUTOR: Alberto Landi Cortinas
    Prof. Alejandro Koury
    Preparador: Jose Quevedo
    Estructuras de Datos
    */
    
    /*Breve explicacion del proyecto:
    
    ABB con nodos que contienen objetos sucursales.
    
    cada sucursal cuenta con una lista doble de salas.
    
    cada sala cuenta con una cola de peliculas a reproducir.
    
    Se guarda un registro de clientes con sus datos(lista simple), cada uno cuenta con un carrito de compras (Lista simple) 
    donde se almacenan sus tickets a comprar/ya comprados.
    
    Background:
    Usted es un empleado de MetroCine a cargo de su administracion, sus tareas son desde registrar clientes y confirmar ventas
    hasta hacer cambios a las instalaciones y abrir nuevas sucursales.
    
    */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Administracion app = new Administracion();
        app.menuInicio();
    }  
}
