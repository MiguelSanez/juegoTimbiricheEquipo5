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
public class Cuadro extends Tablero{
    
    /**
     * Atributos de la clase Cuadro.
     */
    private Jugador jugador;
    private String posicionCuadro;
    private Linea linea;

    /**
     * Constructor por defecto de la clase Cuadro.
     */
    public Cuadro() {
    }

    public Cuadro(Jugador jugador, String posicion, Linea linea) {
        this.jugador = jugador;
        this.posicionCuadro = posicion;
        this.linea = linea;
    }

    /**
     * Gets y sets de la clase Cuadro.
     */
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public String getPosicionCuadro() {
        return posicionCuadro;
    }

    public void setPosicionCuadro(String posicionCuadro) {
        this.posicionCuadro = posicionCuadro;
    }

    public Linea getLinea() {
        return linea;
    }

    public void setLinea(Linea linea) {
        this.linea = linea;
    }

    @Override
    public String toString() {
        return "Cuadro{" + "jugador=" + jugador + ", posicion=" + posicionCuadro + ", linea=" + linea + '}';
    }
    
}
