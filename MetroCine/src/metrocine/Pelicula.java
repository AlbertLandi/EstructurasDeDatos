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
public class Pelicula{
    private String nombre;
    private String idioma;
    private String genero;
    private String horario;

    public Pelicula(String nombre, String idioma, String genero, String horario) {
        this.nombre = nombre;
        this.idioma = idioma;
        this.genero = genero;
        this.horario = horario;
    }

    public String getNombre() {
        return nombre;
    }

    public String getIdioma() {
        return idioma;
    }

    public String getGenero() {
        return genero;
    }

    public String getHorario() {
        return horario;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    
    
    
    
}
