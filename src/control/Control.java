package control;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import juegotimbiriche.Figura;
import juegotimbiriche.Juego;
import juegotimbiriche.Jugador;
import presentacion.SalaDeEspera;
import presentacion.juegoTimbiriche;

public class Control {

    private static ArrayList<Jugador> jugadores = new ArrayList<Jugador>();
    private static HashMap<String, InetAddress> map = new HashMap<String, InetAddress>();
    private int conectados = 0;
    private static Control singleton;
    private InterpreteConexion interprete;

    private Control() {
        interprete = new InterpreteConexion(this);
    }

    public static Control getControl() {
        if (singleton == null) {
            singleton = new Control();
        }
        return singleton;
    }

    public Jugador crearJugador(String nombre, String color) {

        int[] colores = new int[3];

        switch (color) {

            case "Rojo":
                colores[0] = 255;
                colores[1] = 87;
                colores[2] = 87;
                break;

            case "Naranja":
                colores[0] = 255;
                colores[1] = 145;
                colores[2] = 77;
                break;

            case "Amarillo":
                colores[0] = 255;
                colores[1] = 189;
                colores[2] = 89;
                break;

            case "Verde lima":
                colores[0] = 201;
                colores[1] = 226;
                colores[2] = 101;
                break;

            case "Verde":
                colores[0] = 0;
                colores[1] = 128;
                colores[2] = 55;
                break;

            case "Turquesa":
                colores[0] = 3;
                colores[1] = 152;
                colores[2] = 158;
                break;

            case "Celeste":
                colores[0] = 56;
                colores[1] = 182;
                colores[2] = 255;
                break;

            case "Azul":
                colores[0] = 67;
                colores[1] = 92;
                colores[2] = 207;
                break;

            case "Morado":
                colores[0] = 126;
                colores[1] = 79;
                colores[2] = 219;
                break;

            case "Rosa":
                colores[0] = 255;
                colores[1] = 102;
                colores[2] = 196;
                break;

            case "Rosa claro":
                colores[0] = 255;
                colores[1] = 203;
                colores[2] = 235;
                break;
        }

        Jugador jugador = new Jugador(colores, nombre);
        conectados++;
        return jugador;
    }

    public void agregarBotones(Figura figura, JPanel panel) {
        figura.setOpaque(true);
        figura.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panel.add(figura);
        figura.setVisible(true);
    }

    public Juego cambiarTurno(Juego partida, Jugador jugador) {
        int idx = 0;
        int turnoIdx = partida.getTurnoActual();
        System.out.println("Actual turn " + turnoIdx);
        if (!jugador.getTurno()) {
            for (Jugador j : partida.getJugadores()) {
                boolean turno = turnoIdx % partida.getNumJugadores() == idx++;
                j.setTurno(turno);
                if (turno) {
                    System.out.println("Turn given to " + j.getNombre() + " idx " + idx);
                    break;
                }
            }
            partida.nuevoTurno();
        }
        return partida;
    }

    public boolean checarTurnos(Juego partida) {
        for (int i = 0; i < partida.getNumJugadores(); i++) {
            if (partida.getJugadores()[i].getTurno()) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Jugador> getJugadores() {
        return jugadores;
    }
    public static void cambiaTurno(){
        int turn=0;
        for (int i = 0; i < jugadores.size(); i++) {
            Jugador jugador = jugadores.get(i);
            if (jugador.getTurno()) {
                jugador.setTurno(false);
                turn=i;
            }
        }
        if (turn>=jugadores.size()) {
            turn=0;
        }
        jugadores.get(turn).setTurno(true);
        
        Juego.setJugador(jugadores);
    }

    public static void finalizarPartida( juegoTimbiriche juego) {
        Jugador ganador = Juego.getJugadores()[0];
        for (int i = 1; i < Juego.getNumJugadores(); i++) {
            if (Juego.getJugadores()[i].getPuntaje() > ganador.getPuntaje()) {
                ganador = Juego.getJugadores()[i];
            }
        }
        JOptionPane.showMessageDialog(null, "El ganador es " + ganador.getNombre(), "Juego finalizado", JOptionPane.INFORMATION_MESSAGE);
        Juego.getJuego().dispose();
        SalaDeEspera sala = new SalaDeEspera((java.awt.Frame) juego.getParent(), true, juego, Juego.getJugadores());
        sala.setVisible(true);
    }

    public void conectaJugador(Jugador jugador) {
        if (jugadores.isEmpty()) {
            jugador.setTurno(true);
        }else{
            jugador.setTurno(false);
        }
        if (map.get(jugador.getNombre()) == null) {
            jugadores.add(jugador);
            try {
                map.put(jugador.getNombre(), InetAddress.getLocalHost());
            } catch (UnknownHostException ex) {
                Logger.getLogger(Control.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
        SalaDeEspera.Conecta(jugadores);
        conectados++;
    }
}
