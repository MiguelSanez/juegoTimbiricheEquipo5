package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import juegotimbiriche.Figura;
import juegotimbiriche.Juego;
import juegotimbiriche.Jugador;
import juegotimbiriche.TipoFigura;
import presentacion.juegoTimbiriche;

/**
 *
 * @author Equipo 5
 */
public class ControlTablero implements MouseListener {

    private JPanel panel;
    private Juego partida;
    private Control control = Control.getControl();
    private JLabel[] puntuaciones;
    private juegoTimbiriche juego;

    public ControlTablero() {
    }

    public ControlTablero(JPanel panel, Juego partida, JLabel[] puntuaciones, JDialog pantalla, juegoTimbiriche juego) {
        this.panel = panel;
        this.partida = partida;
        this.puntuaciones = puntuaciones;
        partida.setJuego(pantalla);
        this.juego = juego;
    }

    public void acomodar(Figura[][] figuras, boolean add) {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (add) {
                    figuras[x][y] = new Figura();
                    figuras[x][y].addMouseListener(this);
                } else {
                    figuras[x][y].setJugador(null);
                    figuras[x][y].setUso(false);
                }
                if (x % 2 == 0) {
                    if (y % 2 == 0) {
                        figuras[x][y].setTipo(TipoFigura.VERTICE);
                        figuras[x][y].setBounds(17 + (25 * (y / 2)), 12 + (25 * (x / 2)), 7, 7);
                        figuras[x][y].setBackground(Color.black);
                        figuras[x][y].removeMouseListener(this);
                    } else {
                        figuras[x][y].setTipo(TipoFigura.LINEA);
                        figuras[x][y].setBounds(24 + (25 * (y / 2)), 12 + (25 * (x / 2)), 18, 7);
                        figuras[x][y].setBackground(Color.WHITE);
                    }
                } else {
                    if (y % 2 == 0) {
                        figuras[x][y].setTipo(TipoFigura.LINEA);
                        figuras[x][y].setBounds(17 + (25 * (y / 2)), 19 + (25 * (x / 2)), 7, 18);
                        figuras[x][y].setBackground(Color.WHITE);
                    } else {
                        figuras[x][y].setTipo(TipoFigura.CUADRO);
                        figuras[x][y].setBounds(24 + (25 * (y / 2)), 19 + (25 * (x / 2)), 18, 18);
                        figuras[x][y].setBackground(Color.WHITE);
                        figuras[x][y].removeMouseListener(this);
                    }
                }
                if (add) {
                    control.agregarBotones(figuras[x][y], panel);
                }
            }
        }
        partida.getTablero().setFiguras(figuras);
    }

    public void checar(Jugador jugador, Figura[][] figuras) {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (figuras[x][y].getTipo().equals(TipoFigura.CUADRO) && !figuras[x][y].getUso()) {
                    try {
                        if (figuras[x - 1][y].getUso() && figuras[x + 1][y].getUso() && figuras[x][y - 1].getUso() && figuras[x][y + 1].getUso()) {
                            figuras[x][y].setJugador(jugador);
                            System.out.println("Player set to box: " + jugador);
                            figuras[x][y].setUso(true);
                            System.out.println("Box is now occupied");
                            figuras[x][y].setOpaque(true);
                            figuras[x][y].setBackground(new Color(jugador.getColor()[0], jugador.getColor()[1], jugador.getColor()[2]));
                            System.out.println("Color assigned to current box: " + figuras[x][y].getBackground());

                            jugador.sumarPuntaje();
                            jugador.setTurno(true);
                            puntuaciones[0].setText("" + partida.getJugadores()[0].getPuntaje());
                            puntuaciones[1].setText("" + partida.getJugadores()[1].getPuntaje());
                            puntuaciones[2].setText("" + partida.getJugadores()[2].getPuntaje());
                            puntuaciones[3].setText("" + partida.getJugadores()[3].getPuntaje());
                        }
                    } catch (Exception e) {
                        System.out.println("Error: " + e);
                    }
                    
                }
            }
        }
        partida = control.cambiarTurno(partida, jugador);
    }

    public boolean paraGanar(Figura[][] figuras) {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (figuras[x][y].getTipo().equals(TipoFigura.CUADRO) && !figuras[x][y].getUso()) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        Figura figura = (Figura) me.getSource();
        boolean encontrado = false;
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (partida.getTablero().getFiguras()[x][y] == figura) {
                    for (int i = 0; i < partida.getNumJugadores(); i++) {
                        if (partida.getJugadores()[i].getTurno()) {
                            figura.setBackground(new Color(partida.getJugadores()[i].getColor()[0],
                                    partida.getJugadores()[i].getColor()[1],
                                    partida.getJugadores()[i].getColor()[2]));
                            figura.setUso(true);
                            figura.setJugador(partida.getJugadores()[i]);
                            figura.removeMouseListener(this);
                            figura.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                            partida.getJugadores()[i].setTurno(false);
                            checar(partida.getJugadores()[i], partida.getTablero().getFiguras());
                            if (paraGanar(partida.getTablero().getFiguras())) {
                                control.finalizarPartida(partida, juego);
                            }
                            break;
                        }
                    }
                    encontrado = true;
                }
            }
            if (encontrado) {
                break;
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {

    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {

    }

    @Override
    public void mouseExited(MouseEvent me) {

    }

}
