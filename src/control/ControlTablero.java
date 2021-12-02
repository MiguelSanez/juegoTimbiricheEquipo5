package control;

import Dominio.Figura;
import Dominio.Juego;
import Dominio.Jugador;
import Dominio.TipoFigura;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import presentacion.FrmMenuPrincipal;
import socket.Cliente;

/**
 *
 * @author Equipo 5
 */
public class ControlTablero implements MouseListener {

    private JPanel panel;
    private Juego partida;
    private Control control = Control.getInstance();
    private JLabel[] puntuaciones;
    private Cliente cliente;

    /**
     *
     */
    public ControlTablero() {
        cliente = Cliente.getInstance();
    }

    /**
     *
     * @param panel
     * @param partida
     * @param puntuaciones
     */
    public ControlTablero(JPanel panel, Juego partida, JLabel[] puntuaciones) {
        this.panel = panel;
        this.partida = partida;
        this.puntuaciones = puntuaciones;
        this.cliente = Cliente.getInstance();
    }

    /**
     *
     * @param figuras
     * @param add
     */
    public void acomodar(Figura[][] figuras, boolean add) {
        int i = 0;
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (add) {
                    figuras[x][y] = new Figura();
                    figuras[x][y].addMouseListener(this);
                    i++;
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

    /**
     *
     * @param jugador
     * @param figuras
     */
    private void checar(Jugador jugador, Figura[][] figuras) {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (figuras[x][y].getTipo().equals(TipoFigura.CUADRO) && !figuras[x][y].getUso()) {
                    if (figuras[x - 1][y].getUso() && figuras[x + 1][y].getUso() && figuras[x][y - 1].getUso() && figuras[x][y + 1].getUso()) {
                        figuras[x][y].setJugador(jugador);
                        figuras[x][y].setUso(true);
                        figuras[x][y].setOpaque(true);
                        figuras[x][y].setBackground(new Color(jugador.getColor()[0], jugador.getColor()[1], jugador.getColor()[2]));

                        jugador.sumarPuntaje();
                        puntuaciones[0].setText("" + partida.getJugadores().get(0).getPuntaje());
                        puntuaciones[1].setText("" + partida.getJugadores().get(1).getPuntaje());
                        puntuaciones[2].setText("" + partida.getJugadores().get(2).getPuntaje());
                        puntuaciones[3].setText("" + partida.getJugadores().get(3).getPuntaje());
                        panel.repaint();
                    }
                }
            }
        }
        //cliente.sendJugada(jugada);
    }

    /**
     *
     * @param figuras
     * @return
     */
    private boolean paraGanar(Figura[][] figuras) {
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                if (figuras[x][y].getTipo().equals(TipoFigura.CUADRO) && !figuras[x][y].getUso()) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     *
     * @param figura
     */
    public void rayar(Figura[][] figura) {
        this.partida.getTablero().setFiguras(figura);
        panel.repaint();
    }

    /**
     *
     * @param evt
     */
    @Override
    public void mouseClicked(MouseEvent evt) {
        Figura figura = (Figura) evt.getSource();
        if (FrmMenuPrincipal.getInstance().getJugador().getUniqueID().equals(partida.getJugadores().get(partida.getTurnoActual()).getUniqueID())) {
            boolean encontrado = false;
            for (int x = 0; x < 19; x++) {
                for (int y = 0; y < 19; y++) {
                    if (partida.getTablero().getFiguras()[x][y] == figura) {
                        for (int i = 0; i < partida.getNumJugadores(); i++) {

                            figura.setBackground(new Color(partida.getJugadores().get(i).getColor()[0],
                                    partida.getJugadores().get(i).getColor()[1],
                                    partida.getJugadores().get(i).getColor()[2]));
                            figura.setUso(true);
                            figura.setJugador(partida.getJugadores().get(i));
                            figura.removeMouseListener(this);
                            figura.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                            checar(partida.getJugadores().get(i), partida.getTablero().getFiguras());
                            if (paraGanar(partida.getTablero().getFiguras())) {
                                control.finalizarPartida(partida);
                            }
                            break;

                        }
                        encontrado = true;
                    }
                }
                if (encontrado) {
                    break;
                }
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
