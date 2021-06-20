/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package almacen;
import java.util.*;

/**
 *
 * @author Alberto
 */
public class Administracion {
    Scanner sc = new Scanner(System.in);
    Alimento[] almacen = new Alimento[5000];
    String dia[] = { "lunes", "martes", "miercoles", "jueves", "viernes"};
    String nombreP[] = { "tomates", "lechugas", "cebollas", "pimentones", "pescado", "huevos", "lomito", "cochino"};
    String nombreNP[] = { "atun enlatado", "sardinas enlatadas", "galletas", "pastas", "arroz", "miel", "frijoles", "harina"};
    String proveedor[] = { "VenFoods", "Distribuidora Los Andes", "Importaciones del Llano"};
    private String d;
    private int ventaP=0, ventaNP=0, inDiario=0, ScantP=0, ScantNP=0, IcantP=0, IcantNP=0;
    Random ran = new Random();
    
    public void menu(){
        System.out.println("Bienvenido al almacen");
        int i=0;
        int respuesta=1;
        int regresar=1;
        d = dia[i];
        while(respuesta==1){
            regresar=1;
            while(regresar==1){
                System.out.println("Dia:"+ d);
                System.out.println("Seleccione una opcion:");
                System.out.println("[1] Ingresar alimento\n[2] Retirar alimento\n[3] Reporte diario\n[4] Inventario");
                int sele = sc.nextInt();
                switch(sele){
                    case 1:
                        ingreso();
                        System.out.println("Alimentos ingresados.");
                        break;
                    case 2:
                        salida();
                        System.out.println("Venta concretada");
                        break;
                    case 3:
                        reporte();
                        break;
                    case 4:
                        inventario();
                        break;
                }
                System.out.println("Continuar administrando mismo DIA? [1] para continuar, cualquier tecla para TERMINAR dia");
                regresar = sc.nextInt();
            }
            System.out.println("Terminar programa? Presione [1] para CONTINUAR al dia siguiente, cualquier tecla para terminar el programa");
            respuesta = sc.nextInt();
            d = dia[i+1];
            inDiario=0;
            ventaP=0;
            ventaNP=0;
            ScantP=0;
            ScantNP=0;
            IcantP=0;
            IcantNP=0;
        }  
    }
    
    
    public void ingreso(){
        int rango, precio, cant, aux=0;
        
        for (int i = 0; i < almacen.length; i++) { //Control del llenado del almacen
            if(almacen[i]!=null){
                aux++;
            }
            if(aux==almacen.length){
                System.out.println("Almacen lleno.");
                return;
            }  
        }
        if(inDiario==1000){
            System.out.println("Limite diario de ingreso de alimentos alcanzado");
            return;
        }
        if("lunes".equals(d)){//comida perecedera
            cant = ran.nextInt(1000);
            for (int i = 0; i < cant; i++) {
                if(almacen[i]==null){
                    rango = 75000-15000+1;
                    precio = ran.nextInt(rango)+15000;
                    almacen[i] = new Perecedero(nombreP[ran.nextInt(nombreP.length)], proveedor[ran.nextInt(proveedor.length)], precio, dia[ran.nextInt(dia.length)]);
                    inDiario++;
                    IcantP++;
                }
            }
        }
        else if("martes".equals(d) || "jueves".equals(d)){ //comida no perecedera
            cant = ran.nextInt(1000);
            for (int i = 0; i < cant; i++) {
                if(almacen[i]==null){
                    rango = 50000-10000+1;
                    precio = ran.nextInt(rango)+10000;
                    almacen[i] = new NoPerecedero(nombreNP[ran.nextInt(nombreNP.length)], proveedor[ran.nextInt(proveedor.length)], precio);
                    inDiario++;
                    IcantNP++;
                }
            }
        }
        else{
            System.out.println("Hoy no esta pautado el ingreso de ningun alimento.");
        }
    }
    
    public void salida(){
        int cantP=0, cantNP=0, cantVentaP, cantVentaNP;
        for (int i = 0; i < almacen.length; i++) { //Contador de items
            if(almacen[i] instanceof Perecedero){
                cantP++;
            }else if(almacen[i] instanceof NoPerecedero){
                cantNP++;
            }
        }
        if(cantP==0 && cantNP==0){ //No hay nada que vender
            System.out.println("No hay inventario que vender.");
        }
        if(cantP>0 && cantNP==0){ // No hay alimentos No perecederos que vender, pero si Perecederos
            cantVentaP = ran.nextInt(cantP);
            for (int i = 0; i < cantVentaP; i++) {
                if(almacen[i] instanceof Perecedero){
                    ventaP = ventaP + almacen[i].getPrecio();
                    ScantP++;
                    almacen[i] = null;
                }
            }
        }
        if(cantP==0 && cantNP>0){ // No hay alimentos perecederos que vender, pero si No Perecederos
            cantVentaNP = ran.nextInt(cantNP);
            for (int i = 0; i < cantVentaNP; i++) {
                if(almacen[i] instanceof NoPerecedero){
                    ventaNP = ventaNP + almacen[i].getPrecio();
                    ScantNP++;
                    almacen[i] = null;
                }
            }
        }
        else if(cantP>0 && cantNP>0){ //Caso general, Hay ambos tipos
            cantVentaP = ran.nextInt(cantP);
            for (int i = 0; i < cantVentaP; i++) {
                if(almacen[i] instanceof Perecedero){
                    ventaP = ventaP + almacen[i].getPrecio();
                    ScantP++;
                    almacen[i] = null;
                }
            }
            cantVentaNP = ran.nextInt(cantNP);
            for (int i = 0; i < cantVentaNP; i++) {
                if(almacen[i] instanceof NoPerecedero){
                    ventaNP = ventaNP + almacen[i].getPrecio();
                    ScantNP++;
                    almacen[i] = null;
                }
            }
        }
        if("viernes".equals(d) && cantP>0){ //Perecederos salen del almacen maximo el viernes
            for (int i = 0; i < cantP; i++) {
                if(almacen[i] instanceof Perecedero){
                    ventaP = ventaP + almacen[i].getPrecio();
                    ScantP++;
                    almacen[i] = null;
                }
            }
        }
    }
    
    public void reporte(){
        int cantP=0, cantNP=0;
        System.out.println("\tREPORTE DIARIO");
        System.out.println("Dia "+ d);
        for (int i = 0; i < almacen.length; i++) {
            if(almacen[i] instanceof Perecedero){
                cantP++;
            }
            else if(almacen[i] instanceof NoPerecedero){
                cantNP++;
            }
        }
        System.out.println(" Estatus almacen: ");
        System.out.println("Alimentos Perecederos: "+ cantP);
        System.out.println("Alimentos No Perecederos: " + cantNP);
        
        System.out.println("\tINGRESOS");
        System.out.println("Alimentos Perecederos: "+ IcantP);
        System.out.println("Alimentos No Perecederos: " + IcantNP);
        
        System.out.println("\tSALIDAS");
        System.out.print("Alimentos Perecederos: "+ ScantP);
        System.out.println(" Total venta: "+ ventaP +" Bolivares Fuertes");
        System.out.print("Alimentos No Perecederos: "+ ScantNP);
        System.out.println(" Total venta: "+ ventaNP +" Bolivares Fuertes");
        System.out.println("");
    }
    
    public void inventario(){ //Comprueba existencia de objetos con sus caracteristicas
        int cont=0;
        for (int i = 0; i < almacen.length; i++) {
            if(almacen[i]!=null){
                System.out.print("Producto: " + almacen[i].getNombre());
                if(almacen[i] instanceof Perecedero){
                    System.out.println(" (Perecedero)");
                }else if(almacen[i] instanceof NoPerecedero){
                    System.out.println(" (No Perecedero)");
                }
                System.out.println("Precio: "+ almacen[i].getPrecio());
                System.out.println("Proveedor: "+ almacen[i].getProveedor());
                if(almacen[i] instanceof Perecedero){
                    System.out.println("Fecha de vencimiento: "+ almacen[i].getFecha());
                }
                System.out.println("");
                cont++;
            } 
        }
        if(cont==0){
            System.out.println("Sin inventario.");
        }
    }
}
