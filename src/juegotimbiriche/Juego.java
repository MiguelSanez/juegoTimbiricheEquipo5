/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotimbiriche;

import javax.swing.JDialog;

/**
 *
 * @author Equipo 5
 */
public class Juego {
    
    /**
     * Atributos de la clase Juego.
     */
    private int numJugadores;
    private Jugador[] jugadores;
    private String status;
    private Tablero tablero;
    private JDialog juego;
    private int turnoActual=0;

    /***
     * Constructor por defecto.
     */
    public Juego() {
    }

    public Juego(Tablero tablero){
        this.tablero=tablero;
        this.jugadores= new Jugador[4];
    }
    
    public Juego(Jugador[] jugadores, int puntajes, String status) {
        this.jugadores = jugadores;
        this.status = status;
    }

    
    public Juego(int numJugadores, Jugador[] jugadores, int puntajes, String status, Tablero tablero) {
        this.numJugadores = numJugadores;
        this.jugadores = new Jugador[numJugadores];
        this.status = status;
        this.tablero = tablero;
    }
    
    /**
     * Gets y sets de la clase Juego.
     * @return 
     */
    public int getNumJugadores() {
        System.out.println(numJugadores);
        return numJugadores;
    }

    public void setNumJugadores(int numJugadores) {
        this.numJugadores = numJugadores;
    }

    public Jugador[] getJugadores() {
        return jugadores;
    }

    public void setJugador(Jugador[] jugadores) {
        this.jugadores = jugadores;
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

    public JDialog getJuego() {
        return juego;
    }

    public void setJuego(JDialog juego) {
        this.juego = juego;
    }

    public int nuevoTurno(){
        turnoActual++;
        return turnoActual;
    }

    public int getTurnoActual() {
        return turnoActual;
    }
    
    @Override
    public String toString() {
        return "Juego{" + "jugador=" + jugadores + ", status=" + status + '}';
    }
    
}
