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
public abstract class Jugador {
    protected String nombre;
    protected String apellido;
    protected String posicionCampo;
    protected Boolean activo;

    public Jugador(String nombre, String apellido, String posicionCampo, Boolean activo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.posicionCampo = posicionCampo;
        this.activo = activo;
    }
    
    public abstract void mostrarJugador();

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getPosicionCampo() {
        return posicionCampo;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setPosicionCampo(String posicionCampo) {
        this.posicionCampo = posicionCampo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
    
    
}
