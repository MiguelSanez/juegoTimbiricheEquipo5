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
public class Juego {
    
    /**
     * Atributos de la clase Juego.
     */
    private int numJugadores;
    private Jugador jugador;
    private int puntajes;
    private String status;
    private Tablero tablero;

    /***
     * Constructor por defecto.
     */
    public Juego() {
    }

    
    public Juego(Jugador jugador, int puntajes, String status) {
        this.jugador = jugador;
        this.puntajes = puntajes;
        this.status = status;
    }

    
    public Juego(int numJugadores, Jugador jugador, int puntajes, String status, Tablero tablero) {
        this.numJugadores = numJugadores;
        this.jugador = jugador;
        this.puntajes = puntajes;
        this.status = status;
        this.tablero = tablero;
    }
    
    /**
     * Gets y sets de la clase Juego.
     * @return 
     */
    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public int getPuntajes() {
        return puntajes;
    }

    public void setPuntajes(int puntajes) {
        this.puntajes = puntajes;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Tablero getTablero() {
        return tablero;
    }

    public void setTablero(Tablero tablero) {
        this.tablero = tablero;
    }

    @Override
    public String toString() {
        return "Juego{" + "jugador=" + jugador + ", puntajes=" + puntajes + ", status=" + status + '}';
    }
    
}
