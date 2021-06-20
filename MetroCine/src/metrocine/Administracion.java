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
public class Administracion {
    private ABB sucursales = new ABB();
    private ListaSimple cliente = new ListaSimple<Cliente>();
    private Ticket t = new Ticket(); //es un objeto auxiliar
    private Cola cartelera = new Cola();
    private Sala s = new Sala();
    private int ganancia = 0;
    Scanner sc = new Scanner(System.in);
    Random ran = new Random();
    
    
    public Administracion(){ //precarga de sucursales y cartelera
        Sucursal S1 = new Sucursal("Manzanares", 9999);
        Sucursal S2 = new Sucursal("Tolon", 9998);
        Sucursal S3 = new Sucursal("El Hatillo", 9997);
        sucursales.insertarNodoABB(sucursales.getRaiz(), new NodoABB (S1));
        sucursales.insertarNodoABB(sucursales.getRaiz(), new NodoABB(S2));
        sucursales.insertarNodoABB(sucursales.getRaiz(), new NodoABB(S3));
        Pelicula P1 = new Pelicula("Black Panther","Espanol", s.genero("Black Panther"), "7:00 PM");
        Pelicula P2 = new Pelicula("Black Panther","Ingles", s.genero("Black Panther"), "7:00 PM");
        Pelicula P3 = new Pelicula("Tomb Raider","Espanol", s.genero("Tomb Raider"), "7:00 PM");
        Pelicula P4 = new Pelicula("Tomb Raider","Ingles", s.genero("Tomb Raider"), "7:00 PM");
        Pelicula P5 = new Pelicula("The Darkest Hour","Espanol", s.genero("The Darkest Hour"), "7:00 PM");
        Pelicula P6 = new Pelicula("The Darkest Hour","Ingles", s.genero("The Darkest Hour"), "7:00 PM");
        Pelicula P7 = new Pelicula("Dunkirk","Espanol", s.genero("Dunkirk"), "7:00 PM");
        Pelicula P8 = new Pelicula("Dunkirk","Ingles", s.genero("Dunkirk"), "7:00 PM");
        Pelicula P9 = new Pelicula("The Commuter","Espanol", s.genero("The Commuter"), "7:00 PM");
        Pelicula P10 = new Pelicula("The Commuter","Ingles", s.genero("The Commuter"), "7:00 PM");
        cartelera.push(P1);
        cartelera.push(P2);
        cartelera.push(P3);
        cartelera.push(P4);
        cartelera.push(P5);
        cartelera.push(P6);
        cartelera.push(P7);
        cartelera.push(P8);
        cartelera.push(P9);
        cartelera.push(P10);       
    }
    
    public void menuInicio(){ //Menu inicial
        System.out.println("Sistema MetroCine V.1.0.0");
        System.out.println("Seleccione:\n[1]Carrito de compra de cliente\n[2]Opciones administrativas\n[3]Terminar programa"); 
        int s = sc.nextInt();
        while(s<1 || s>3){
            System.out.println("ERROR: Seleccione:\n[1]Carrito de compra de cliente\n[2]Opciones administrativas\n[3]Terminar programa"); 
            s = sc.nextInt();
        }
        switch(s){
            case 1:
                menuCliente();
                break;
            case 2:
                menuEmpleado();
                break;
            case 3:
                System.out.println("Programa concluido.");
                System.exit(0);
                break;
        }
    }
    
    public void menuEmpleado(){ //Menu de administracion del cine 
        int respuesta = 1;
        while(respuesta==1){
            System.out.println("Menu");
            System.out.println("Seleccione:\n[1]Agregar sucursales, salas y peliculas\n[2]Modificar sucursales, salas y peliculas existentes\n[3]Modificar Precios de ticket por sala\n[4]Ver listado de peliculas en una sucursal\n[5]Ver cartelera\n[6]Visualizar todo\n[7]Ver ingresos");
            int s = sc.nextInt();
            while(s<1 || s>7){
                System.out.println("ERROR: Seleccione:\n[1]Agregar sucursales, salas y peliculas\n[2]Modificar sucursales, salas y peliculas existentes\n[3]Modificar Precios de ticket por sala\n[4]Ver listado de peliculas en una sucursal\n[5]Ver cartelera\n[6]Visualizar todo\n[7]Ver ingresos");
                s = sc.nextInt();
            }
            switch(s){
                case 1: 
                    seleccion(true);
                    break;
                case 2:
                    seleccion(false);
                    break;
                case 3:
                    precioTicket();
                    break;
                case 4:
                    verSucursal();
                    break;
                case 5:
                    verCartelera();
                    break;
                case 6:
                    Visualizar();
                    break;
                case 7:
                    ingresos();
                    break;
            }
            System.out.println("Desea seguir en el menu de empleado? [1]Si [cualquier numero]No");
            respuesta = sc.nextInt();
        }
        menuInicio();
    }
    
    public void menuCliente(){ //Menu de acciones con respecto al cliente
        int respuesta = 1;
        while(respuesta==1){
            System.out.println("Seleccione:\n[1]Cliente regular\n[2]Cliente nuevo");
            int s = sc.nextInt();
            while(s<1 || s>2){
                System.out.println("Seleccione:\n[1]Cliente regular\n[2]Cliente nuevo");
                s = sc.nextInt();
            }
            Nodo<Cliente> c = null;
            switch(s){
                case 1:
                    if(cliente.getCabeza() == null){
                        System.out.println("Sin clientes registrados.");
                        registrarCliente();
                        c = cliente.getCola();
                    }else{
                        System.out.println("Ingrese el numero de cedula del cliente");
                        int cedula = sc.nextInt();
                        c = cliente.BuscarNodoCliente(cliente.getCabeza(), cedula);
                    }
                    break;
                case 2:
                    registrarCliente();
                    c = cliente.getCola();
                    break;
            }
            Boolean aux = true;
            while(aux){
                System.out.println("Seleccione:\n[1]Anadir al carrito\n[2]Pagar carrito\n[3]Ver Carrito\n[4]Eliminar carrito\n[5]Salir de carrito de " + c.getDato().getNombre());
                int sele = sc.nextInt();
                while(sele<1 || sele>5){
                    System.out.println("Seleccione:\n[1]Anadir al carrito\n[2]Pagar carrito\n[3]Ver Carrito\n[4]Eliminar carrito\n[5]Salir de carrito de "+ c.getDato().getNombre());
                    sele = sc.nextInt();
                }
                switch(sele){
                    case 1:
                        ponerCarrito(c);
                        break;
                    case 2:
                        pago(c.getDato().getCarrito().tamano(), c);
                        break;
                    case 3:
                        verCarrito(c);
                        break;
                    case 4:
                        eliminarCarrito(c);
                        break;
                    case 5:
                        aux = false;
                        break;
                }
            }
                
            System.out.println("Desea seguir en el menu de cliente? [1]Si [cualquier numero]No");
            respuesta = sc.nextInt();
        }
        menuInicio();
    }
    
    public void ponerCarrito(Nodo<Cliente> c){ //permite poner tickets al carrito
        NodoABB aux = buscarSucursal();
        sucursales.Cartelera(aux);
        NodoDoble sala = buscarSala(aux);
        System.out.println("Seleccione la cantidad de tickets a comprar.");
        int cantTickets = sc.nextInt();
        while(cantTickets<1){
            System.out.println("Seleccione la cantidad de tickets a comprar.");
            cantTickets = sc.nextInt();
        }
        for(int i = 0; i < cantTickets; i++) {
            Ticket T = new Ticket(aux, sala, t.getTDD(), t.getTDDD(), t.getTDX(), false);
            c.getDato().getCarrito().anadirUltimo(T);
        }
    }
    
    public void verCarrito(Nodo<Cliente> c){ //imprime carrito
        c.getDato().getCarrito().recorrerListaSimple();
    }
    
    public void eliminarCarrito(Nodo<Cliente> c){ //elimina contenidos del carrito
        c.getDato().setCarrito(null);
        System.out.println("Carrito eliminado.");
    }
    
    public void pago(int cantTickets, Nodo<Cliente> c){ //confirma pago de tickets sin pagar
        ganancia = cantTickets * c.getDato().getCarrito().getCabeza().getDato().getPrecio();
        Nodo<Ticket> aux = c.getDato().getCarrito().getCabeza();
        while(aux != null){ //se revisa el carrito
            if(!aux.getDato().getPago()){ //tickets sin pagar se confirman pagos
                aux.getDato().setPago(true);
            }
            aux = aux.getNext();
        }
        System.out.println("Transaccion autorizada.");
    }
    
    public void seleccion(Boolean aux){ //menu de seleccion
        System.out.println("Seleccione:\n[1]Sucursales\n[2]Salas\n[3]Peliculas");
        int s = sc.nextInt();
        switch(s){
            case 1:
                if(aux){
                    insertarSucursal();
                }else{
                    modSucursal();
                }
                break;
            case 2:
                if(aux){
                    insertarSala();
                }else{
                    modSala();
                }
                break;
            case 3:
                if(aux){
                    insertarPelicula();
                }else{
                    modPelicula();
                }
                break;
        }
    menuEmpleado();
    }
    
    public void insertarSucursal(){ //insertar una nueva sucursal
        sc.nextLine();
        System.out.println("Ingrese:\nUbicacion:");
        String ubicacion = sc.nextLine(); 
        System.out.println("Codigo:");
        int codigo = sc.nextInt();
        System.out.println("Cantidad de salas 2D: ");
        int DD = sc.nextInt();
        System.out.println("Cantidad de salas 3D: ");
        int DDD = sc.nextInt();
        System.out.println("Cantidad de salas 4DX: ");
        int DX = sc.nextInt();
        Sucursal ns = new Sucursal(ubicacion, codigo, DD, DDD, DX);
        sucursales.insertarNodoABB(sucursales.getRaiz(), new NodoABB(ns));
        System.out.println("Sucursal anadida.");
    }
    
    public void modSucursal(){ //modificar datos de una sucursal
        NodoABB aux = buscarSucursal();
        System.out.println("Inserte nuevo nombre de ubicacion");
        String ubi = sc.nextLine();
        aux.getDato().setUbicacion(ubi);
        System.out.println("Inserte nuevo codigo:");
        int code = sc.nextInt();
        aux.getDato().setCodigo(code);
        System.out.println("Sucursal modificada.");
    }
    
    public void insertarSala(){ //insertar una nueva sala a una sucursal
        NodoABB aux = buscarSucursal();
        System.out.println("DATOS DE SALA");
        System.out.println("Tipo:\n[1]2D\n[2]3D\n[3]4DX");
        int s = sc.nextInt();
        while(s<1 || s>3){
            System.out.println("ERROR: Ingrese Tipo:\n[1]2D\n[2]3D\n[3]4DX");
            s = sc.nextInt();
        }
        String tipo = null;
        switch(s){
            case 1:
                tipo = "2D";
                break;
            case 2:
                tipo = "3D";
                break;
            case 3:
                tipo = "4DX";
                break;
        }
        sc.nextLine();
        int numero = aux.getDato().getSalas().getCola().getDato().getNumero() + 1; //numero de sala nueva se obtiene automaticamente gracias a la actual cola
        aux.getDato().getSalas().anadirUltimo(new Sala( numero, tipo));
        System.out.println("Sala insertada.");
    }
    
    public void modSala(){ //modificar datos de una sala
        NodoABB aux = buscarSucursal();
        NodoDoble sala = buscarSala(aux);
        System.out.println("Ingrese el nuevo tipo de sala:");
        String tipo = sc.nextLine();
        /*while(tipo != "2D" || tipo != "3D" || tipo != "4DX"){
            System.out.println("ERROR: Tipo de sala invalida.\nIngrese el nuevo tipo de sala:");
            tipo = sc.nextLine();
        }*/
        sala.getDato().setTipo(tipo);
        System.out.println("Cambio guardadado:\nSala "+ sala.getDato().getNumero() +" reproducira peliculas en formato "+ sala.getDato().getTipo());
    }
    
    public void insertarPelicula(){ //insertar una nueva pelicula a una sala
        NodoABB aux = buscarSucursal();
        NodoDoble sala = buscarSala(aux);
        System.out.println("DATOS DE PELICULA");
        System.out.println("Nombre:");
        String nombre = sc.nextLine();
        System.out.println("Idioma:");
        String idioma = sc.nextLine();
        System.out.println("Genero:");
        String genero = sc.nextLine();
        System.out.println("Horario:");
        String horario = sc.nextLine();
        Pelicula pelicula = new Pelicula(nombre, idioma, genero, horario);
        sala.getDato().getPeli().push(pelicula);
        cartelera.push(pelicula);
        System.out.println("Pelicula anadida a grilla de la sala"+ sala.getDato().getNumero());
    }
    
    public void modPelicula(){ //se modifica una pelicula en cartelera
        NodoABB aux = buscarSucursal();
        NodoDoble sala = buscarSala(aux);
        System.out.println("Seleccione:\n[1]Eliminar pelicula\n[2]Modificar datos Pelicula");
        int s = sc.nextInt();
        while(s<1 || s>2){
            System.out.println("ERROR: Seleccione:\n[1]Eliminar pelicula\n[2]Modificar datos Pelicula");
            s = sc.nextInt();
        }
        if(s==1){
            sala.getDato().getPeli().pop();
            System.out.println("Pelicula eliminada de sala.");
        }else if(s==2){
            System.out.println("DATOS DE PELICULA");
            System.out.println("Nombre");
            String nombre = sc.nextLine();
            System.out.println("Idioma:");
            String idioma = sc.nextLine();
            System.out.println("Genero:");
            String genero = sc.nextLine();
            sala.getDato().getPeli().peek().getDato().setNombre(nombre);
            sala.getDato().getPeli().peek().getDato().setIdioma(idioma);
            sala.getDato().getPeli().peek().getDato().setGenero(genero);
        }
    }
    
    public void precioTicket(){ //cambia los presets de los precios de los tickets
        System.out.println("Inserte precio:\nTicket 2D: ");
        int TDD = sc.nextInt();
        System.out.println("Ticket 3D: ");
        int TDDD = sc.nextInt();
        System.out.println("Ticket 4DX: ");
        int TDX = sc.nextInt();
        t.setTDD(TDD);
        t.setTDDD(TDDD);
        t.setTDX(TDX);
    }
    
    public void registrarCliente(){ //registra cliente nuevo
        sc.nextLine();
        System.out.println("Registrar nuevo Cliente:\nNombre:");
        String nombre = sc.nextLine();
        System.out.println("Cedula:");
        int cedula = sc.nextInt();
        sc.nextLine();
        System.out.println("Telefono:");
        String tlf = sc.nextLine();
        Cliente c = new Cliente(nombre, cedula, tlf);
        cliente.anadirUltimo(c);
        System.out.println("Cliente Guardado");
    }
          
    public void Visualizar(){ //retorna todo el sistema
        sucursales.recorrerABB(sucursales.getRaiz());
    }
    
    public NodoABB buscarSucursal(){ //codigo reutilizable para buscar sucursal
        sc.nextLine();
        System.out.println("Inserte ubicacion de la sucursal");
        String ubicacion = sc.nextLine();
        NodoABB aux = sucursales.buscarNodo(sucursales.getRaiz(), ubicacion);
        if(aux == null){
            System.out.println("Ubicacion no existe.");
            buscarSucursal();
        }
        return aux;
    }
    
    public NodoDoble buscarSala(NodoABB aux){ //codigo reutilizable para buscar sala
        System.out.println("Inserte Numero de sala:");
        int numSala = sc.nextInt();
        while(numSala < 1 || numSala > aux.getDato().getSalas().tamano()){
            System.out.println("ERROR: Sala no existe. Inserte Numero de sala:");
            numSala = sc.nextInt();
        }
        NodoDoble sala = aux.getDato().getSalas().BuscarNodo(numSala);
        sc.nextLine();
        return sala;
    }
    
    public void verSucursal(){//ver una sucursal individual
        NodoABB aux = buscarSucursal();
        sucursales.Cartelera(aux);
    }
    
    public void verCartelera(){ //Ver cartelera con filtrada o en orden alfabetico o no.
        System.out.println("Desea filtrar su busqueda? [1]SI [2]NO");
        int sele = sc.nextInt();
        while(sele<1 || sele>2){
            System.out.println("ERROR: Desea filtrar su busqueda? [1]SI [2]NO");
            sele = sc.nextInt();
        }
        if(sele==1){
            System.out.println("Por:\n[1]Nombre\n[2]Idioma\n[3]Genero");
            int num = sc.nextInt();
            while(num<1 || num>3){
                System.out.println("Por:\n[1]Nombre\n[2]Idioma\n[3]Genero");
                num = sc.nextInt();
            }
            sc.nextLine();
            switch(num){
                case 1:
                    System.out.println("Inserte el nombre:");
                    String name = sc.nextLine();
                    cartelera.filtro(cartelera.peek(), name);
                    break;
                case 2:
                    System.out.println("Inserte idioma:");
                    String lang = sc.nextLine();
                    cartelera.filtro(cartelera.peek(), lang);
                    break;
                case 3:
                    System.out.println("Inserte genero:");
                    String genre = sc.nextLine();
                    cartelera.filtro(cartelera.peek(), genre);
                    break;
            }
        }else if(sele==2){
            System.out.println("Ordenar Alfabeticamente? [1]SI [2]NO");
            int num = sc.nextInt();
            while(num<1 || num>2){
                System.out.println("Ordenar Alfabeticamente? [1]SI [2]NO");
                num = sc.nextInt();
            }
            if(num==1){
                System.out.println("Inserte orden: [1]A-Z [2]Z-A");
                int selec = sc.nextInt();
                switch(selec){
                    case 1:
                        cartelera.ordenarAZ(cartelera, false);
                        break;
                    case 2:
                        cartelera.ordenarAZ(cartelera, true);
                        break;
                }
            }else if(num==2){
                cartelera.recorrerCola();
            }
        }

    }
    
    public void ingresos(){ //Ingresos del cine
        int cont = 0, mayor = 0;
        System.out.println("Ingresos Totales: Bs." + ganancia );
        Nodo<Cliente> aux = cliente.getCabeza(); 
        Nodo<Ticket> m = null; 
        while(aux != null){ //se revisa la lista de clientes
            Nodo<Ticket> auxt = aux.getDato().getCarrito().getCabeza(); 
            while(auxt != null){// por cada cliente, se revisa su carrito
                if(auxt.getDato().getPago()){ //si el ticket esta vendido
                    cont++; //se contabiliza el ticket para la frecuencia a la sala
                    if(cont>mayor){ //se compara con el contador con el dato mayor de frecuencia ya guardado
                        mayor = cont; 
                        m = auxt; //se guarda un ticket, para conocer la sucursal y la sala que corresponde
                    } 
                }
                auxt = auxt.getNext();
            }
            cont = 0;
            aux = aux.getNext();
        }
        if(m == null){
            System.out.println("Sin sala frecuentada.");
        }else{
            System.out.println("Sala mas frecuentada: " + m.getDato().getSala().getDato().getNumero() + " en " + m.getDato().getSucursal().getDato().getUbicacion());
        }
    }
    
    
}
