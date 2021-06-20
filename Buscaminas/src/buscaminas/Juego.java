/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package buscaminas;
import java.util.*;
/**
 *
 * @author Alberto
 */
public class Juego {
    private Casilla[][] tablero;
    private Jugador j;
    Scanner sc = new Scanner(System.in);
    Random ran = new Random();
    private int x, y, minas, fila, columna;
    private boolean gameOver, gameWin; 
    
    public void menu(){ //Menu inicial
        System.out.println("\tBuscaminas");
        System.out.println("Ingrese su nombre:");
        String name = sc.nextLine();
        j = new Jugador(name); //se genera objeto jugador, salvado por toda la partida
        int r=1;
        while(r==1){ //ciclo de reoeticion de partidas
            System.out.println("Seleccione una dificultad: \n[1] Facil\n[2] Media\n[3] Dificil\n[4] Personalizado");
            int s = sc.nextInt();
            while(s<1 || s>4){
                System.out.println("ERROR: Seleccion invalida.\nSeleccione una dificultad: \n[1] Facil\n[2] Media\n[3] Dificil\n[4] Personalizado");
                s = sc.nextInt();
            }
            switch(s){ //seleccion de dificultad
                case 1:
                    x=10;
                    y=10;
                    tablero = new Casilla[x][y];
                    minas=10;
                    break;
                case 2:
                    x=15;
                    y=15;
                    tablero = new Casilla[x][y];
                    minas=40;
                    break;
                case 3:
                    x=22;
                    y=22;
                    tablero = new Casilla[x][y];
                    minas=100;
                    break;
                case 4:
                    custom();
                    break;
            }
            partida();
            System.out.println("Desea hacer otra partida? [1] Reiniciar, cualquier numero para terminar el juego");
            r = sc.nextInt();
        }
        System.out.println("Gracias por jugar!"); //fin del juego
    }
    
    public void partida(){ //La partida es este conjunto de metodos
        gameOver=false;
        gameWin=false;
        inicializarTablero();
        while(!gameOver){ //ciclo de juego
            visualizarTablero();
            seleccion();
            checkWin();
        }
        if(!gameWin){ //si el jugador pierde
            visualizarTablero();
            System.out.println("BOOM! Has explotado " + j.getNombre());
        }
        if(gameWin){ //si el jugador gana
            visualizarTablero();
            System.out.println("Felicidades, "+ j.getNombre()+ ", Has ganado el Buscaminas!");
        }
    }
    
    public void custom(){ //tablero personalizado
        System.out.println("Seleccione cantidad de filas:");
        x = sc.nextInt();
        while(x<0){
            System.out.println("ERROR: Seleccione una cantidad valida de filas");
            x = sc.nextInt();
        }
        System.out.println("Seleccione cantidad de columnas:");
        y = sc.nextInt();
        while(y<0){
            System.out.println("ERROR: Seleccione una cantidad valida de columnas");
            y = sc.nextInt();
        }
        tablero = new Casilla[x][y];
        System.out.println("Seleccione cantidad de minas");
        minas = sc.nextInt();
        while(minas<1 || minas>x*y){
            System.out.println("ERROR: Seleccione una cantidad valida de minas ");
            minas = sc.nextInt();
        }  
    }
    
    public void inicializarTablero(){
        for (int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[i].length; j++){
                tablero[i][j] = new NoMina('+'); //Al inicio todas las casillas son NoMina (vacia)
                }
            }
        ponerMinas(); //Ingresa las minas
    }
    
    public void ponerMinas(){ //sobreescribe casillas NoMina del tablero, poniendo las minas
        int i, j;
        int k = minas;
        while(k>0){ //Mientras hayan minas que poner
            i = ran.nextInt(x)+0; //fila al azar
            j = ran.nextInt(y)+0; //columna al azar
            if(tablero[i][j] instanceof NoMina){ //Solo pondra mina si la casilla esta vacia
                tablero[i][j] = new Mina('+'); //ingresa la mina, con el simbolo oculto
                k--; //una mina menos que poner
            }
        }
    }
    
    public void visualizarTablero(){ //Imprime el tablero con guias
        int aux=1;
        System.out.println("");
        System.out.print("  ");
        do{ 
            if(aux>=10){
                System.out.print(" "+aux);
            }else{
                System.out.print(" "+aux+" ");
            }
            aux++;
        }while(aux<=y);
        System.out.println("");
        for (int i = 0; i < tablero.length; i++) {
            if(i+1<=9){
                System.out.print((i+1)+" ");
            }
            else if(i+1>9){
                System.out.print((i+1));
            }
            for(int j = 0; j < tablero[i].length; j++){
                System.out.print("["+tablero[i][j].getSimbolo()+"]");
            }
            System.out.println("");
        }
        System.out.println("Minas: " + minas);
        System.out.println("");
    }
    
    public void seleccion(){ //Escoje la casilla deseada y la accion a realizar
        System.out.println("Seleccione:\nFila: ");
        fila = sc.nextInt()-1;
        while(fila<0 || fila>x){
            System.out.println("Fila invalida. Ingrese nuevamente:");
            fila = sc.nextInt()-1;
        }
        System.out.println("Columna: ");
        columna = sc.nextInt()-1;
        while(columna<0 || columna>y){
            System.out.println("Columna invalida. Ingrese nuevamente:");
            columna = sc.nextInt()-1;
        }
        //Solo si la casilla esta cerrada podras realizar alguna accion 
        if(tablero[fila][columna].getSimbolo()=='+' || tablero[fila][columna].getSimbolo()=='P' || tablero[fila][columna].getSimbolo()=='?'){ 
            System.out.println("Como desea proceder:\n[1] Abrir casilla\n[2] Marcar Bandera (P)\n[3] Marcar indeterminado (?)");
            int s = sc.nextInt();
            while(s<1 || s>3){
                System.out.println("ERROR: Ingrese una opcion valida.\nComo desea proceder:\n[1] Abrir casilla\n[2] Marcar Bandera (P)\n[3] Marcar indeterminado (?)");
                s = sc.nextInt();
            }
            switch(s){
                case 1:
                    abrirCasilla();
                    break;
                case 2:
                    if(tablero[fila][columna].getSimbolo()=='P'){
                        System.out.println("Casilla ya marcada como bandera.");
                        return;
                    }
                    System.out.println("Pase");
                    tablero[fila][columna].setSimbolo('P');
                    break;
                case 3:
                    if(tablero[fila][columna].getSimbolo()=='?'){
                        System.out.println("Casilla ya marcada como indeterminada.");
                        return;
                    }
                    tablero[fila][columna].setSimbolo('?');
                    break;       
            }
        }else{ // y si ya esta abierta, se selecciona otra casilla
            System.out.println("ERROR: Casilla abierta.");
            seleccion();
        }
    }
    
    public void abrirCasilla(){
        if(tablero[fila][columna] instanceof Mina){ //Si abres una mina, es game over
            for (int i = 0; i < tablero.length; i++) {
                for (int j = 0; j < tablero[i].length; j++) {
                    if(tablero[i][j] instanceof Mina){
                        tablero[i][j].setSimbolo('*');
                    } 
                }
            }
            gameOver=true;
        }else if(tablero[fila][columna] instanceof NoMina){ //Si la casilla esta vacia, se verifica dicha casilla
            verificarCasilla(fila, columna);
        }
    }
    
    public void verificarCasilla(int fila, int columna) { //verificacion de casilla
        char num;
        if (fila < 0 || fila >= tablero.length || columna < 0 || columna >= tablero[0].length){ //chequeo de bordes del tablero
            return;
        }
        if(tablero[fila][columna] instanceof Mina){ //chequeo de tipo mina, si consigue alguna, se retorna
            return;
        }
        int contM = contarMinas(fila, columna); //cantidad de minas colindantes
        if(contM == 0 && (tablero[fila][columna].getSimbolo()=='+' || tablero[fila][columna].getSimbolo()=='?' || tablero[fila][columna].getSimbolo()=='P') ){ // si casilla sin minas alrededor y cerrada
            tablero[fila][columna].setSimbolo(' '); //cambia a simbolo vacio
            //recursividad de cada uno de los bordes de alrededor de dicha casilla
            verificarCasilla(fila-1,columna-1);
            verificarCasilla(fila-1,columna);
            verificarCasilla(fila-1,columna+1);
            verificarCasilla(fila,columna-1);
            verificarCasilla(fila,columna+1);
            verificarCasilla(fila+1,columna-1);
            verificarCasilla(fila+1,columna);
            verificarCasilla(fila+1,columna+1);
        }
        if(contM>0 && (tablero[fila][columna].getSimbolo()=='+' || tablero[fila][columna].getSimbolo()=='?' || tablero[fila][columna].getSimbolo()=='P') ){ // si casilla con minas alrededor y cerrada
            num = (char) (contM + '0'); //conversion de int a char
            tablero[fila][columna].setSimbolo(num); //set simbolo al numero obtenido de minas alrededor solo en esa casilla
        }
    }
    
    public int contarMinas(int fila, int columna){ //Cuenta las minas en las 8 casillas conlindantes, retornando la cantidad
        int aux=0;
        for (int i = Math.max(0, fila-1); i <= Math.min(fila+1, tablero.length-1); i++) {
            for (int j = Math.max(0, columna-1); j <= Math.min(columna+1, tablero[0].length-1); j++) {
                if(tablero[i][j] instanceof Mina){
                    aux++;
                }
            }
        }
        return aux;
    }
    
    public void checkWin(){ //cada vez que pasa un "turno", se revisa si el juego ha sido ganado 
        int cantNMA=0, cantNM=0;
        for (int i = 0; i < tablero.length; i++) {
            for(int j = 0; j < tablero[i].length; j++){
                if((tablero[i][j].getSimbolo()!='+' && tablero[i][j].getSimbolo()!='P' && tablero[i][j].getSimbolo()!='?') && tablero[i][j] instanceof NoMina){
                    cantNMA++; //cuenta las casillas abiertas (impresas como un espacio o un numero de minas alrededor)
                }
                if(tablero[i][j] instanceof NoMina){
                    cantNM++; //casillas vacias totales
                }
            }
        }
        //System.out.println("Abiertas: " + cantNMA);
        //System.out.println("totales: " + cantNM);
        if(cantNM==cantNMA){ //si las casillas abiertas igualan a las casillas vacias totales, el juego ha terminado y sido ganado
           gameOver=true;
           gameWin=true;
        }
    }
}
