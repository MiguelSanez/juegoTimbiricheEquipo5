/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotimbiriche;

/**
 *
 * @author Equipo 5
 */
public class Linea {
    
    private String posicion;
    private String colorLinea;

    public Linea() {
    }

    public Linea(String posicion, String colorLinea) {
        this.posicion = posicion;
        this.colorLinea = colorLinea;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }

    @Override
    public String toString() {
        return "Linea{" + "posicion=" + posicion + ", colorLinea=" + colorLinea + '}';
    }
    
}
