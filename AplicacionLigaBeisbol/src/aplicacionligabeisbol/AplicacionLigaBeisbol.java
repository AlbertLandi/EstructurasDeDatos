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

/*
Alberto Landi C: 20151110119
*/
public class AplicacionLigaBeisbol {
    private Equipo[] vec_Equipos = new Equipo[10];
   
    public AplicacionLigaBeisbol(){
       vec_Equipos[0] = new Equipo("Leones");
       vec_Equipos[1] = new Equipo("Tiburones");
       vec_Equipos[2] = new Equipo("Cardenales");
       vec_Equipos[3] = new Equipo("Magallanes");
       vec_Equipos[4] = new Equipo("Tigres");
       vec_Equipos[5] = new Equipo("Caribes");
       vec_Equipos[6] = new Equipo("Aguilas");
       vec_Equipos[7] = new Equipo("Cachorros");
       vec_Equipos[8] = new Equipo("Orioles");
       vec_Equipos[9] = new Equipo("Panteras");
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        AplicacionLigaBeisbol app = new AplicacionLigaBeisbol();
        app.recorrerEquipos();
    } 
    
    public void recorrerEquipos(){
        for (int i = 0; i < vec_Equipos.length; i++) {
            System.out.println("Equipo: "+vec_Equipos[i].getNombre());
            //System.out.println("");
            System.out.println("Jugadores:");
            vec_Equipos[i].mostrarEquipo();
            System.out.println("");
            System.out.println("JUGANDO AHORA!");
            vec_Equipos[i].recorrerJugar();
            System.out.println("FIN DE JUEGO.");
            System.out.println("");
        }
    }
   
}
