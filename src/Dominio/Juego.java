/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Equipo 5
 */
public class Juego {

    /**
     * Atributos de la clase Juego.
     */
    private int numJugadores = 0;
    private List<Jugador> jugadores = new ArrayList<>();
    private String status;
    private Tablero tablero;
    private int turnoActual = 0;

    /**
     *
     * Constructor por defecto.
     */
    public Juego() {
    }

    public Juego(Tablero tablero) {
        this.tablero = tablero;
    }

    public Juego(List<Jugador> jugadores, String status) {
        this.jugadores = jugadores;
        this.status = status;
    }

    public Juego(int numJugadores, List<Jugador> jugadores, int puntajes, String status, Tablero tablero) {
        this.numJugadores = numJugadores;
        this.jugadores = jugadores;
        this.status = status;
        this.tablero = tablero;
    }

    /**
     * Gets y sets de la clase Juego.
     *
     * @return
     */
    public int getNumJugadores() {
        return numJugadores;
    }

    public void setNumJugadores() {
        this.numJugadores = 0;
        for (int i = 0; i < getJugadores().size(); i++) {
            this.numJugadores++;
        }
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
        setNumJugadores();
    }

    public void setJugador(int index, Jugador jugador) {
        if (this.jugadores.isEmpty()) {
            this.jugadores.add(jugador);
        } else {
            this.jugadores.set(index, jugador);
        }
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

    public void nuevoTurno() {
        this.turnoActual++;
        if (this.turnoActual >= this.jugadores.size()) {
            this.turnoActual = 0;
        } else {
            while (this.jugadores.get(turnoActual).getPuntaje() < 0) {
                this.turnoActual++;

                if (this.turnoActual >= this.jugadores.size()) {
                    this.turnoActual = 0;
                }
            }
        }
    }

    public int getTurnoActual() {
        return turnoActual;
    }

    @Override
    public String toString() {
        return "Juego{" + "jugador=" + jugadores + ", status=" + status + '}';
    }

}
