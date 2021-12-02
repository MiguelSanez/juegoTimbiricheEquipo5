/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Dominio.Figura;
import Dominio.Juego;
import Dominio.Jugador;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import presentacion.FrmSalaEspera;

public class Control {

    private Juego partida;
    private HashMap<Object, InetAddress> map = new HashMap<>();
    private InterpreteConexion interprete = InterpreteConexion.getInstance();

    private static Control instance;

    /**
     *
     * @return
     */
    public static Control getInstance() {
        if (instance == null) {
            instance = new Control();
        }
        return instance;
    }

    /**
     *
     */
    private Control() {
        interprete.setControl(instance);
    }

    /**
     *
     * @param nombre
     * @param color
     * @return
     */
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
        return jugador;
    }

    /**
     *
     * @param figura
     * @param panel
     */
    public void agregarBotones(Figura figura, JPanel panel) {
        figura.setOpaque(true);
        figura.setBorder(BorderFactory.createEmptyBorder(1, 1, 1, 1));
        panel.add(figura);
        figura.setVisible(true);
    }

    /**
     *
     * @return
     */
    public List<Jugador> getJugadores() {
        return partida.getJugadores();
    }

    /**
     *
     * @param juego
     */
    public void finalizarPartida(Juego juego) {
        Jugador ganador = juego.getJugadores().get(0);
        for (int i = 1; i < juego.getNumJugadores(); i++) {
            if (juego.getJugadores().get(i).getPuntaje() > ganador.getPuntaje()) {
                ganador = juego.getJugadores().get(i);
            }
        }

        JOptionPane.showMessageDialog(null, "El ganador es " + ganador.getNombre(), "Juego finalizado", JOptionPane.INFORMATION_MESSAGE);

        FrmSalaEspera sala = FrmSalaEspera.getInstance();
        sala.setVisible(true);
    }

    /**
     *
     * @param jugador
     */
    public void conectaJugador(Jugador jugador) {
        if (map.get(jugador.getNombre()) == null) {
            try {
                getJugadores().add(jugador);
                map.put(jugador.getNombre(), InetAddress.getLocalHost());
            } catch (UnknownHostException ex) {
                System.out.println(ex.getMessage());
            }
        }

        FrmSalaEspera.getInstance().conectar(getJugadores());
    }

    /**
     *
     */
    public void actualizarTablero() {

    }
}
