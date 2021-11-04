
package control;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import juegotimbiriche.Figura;
import juegotimbiriche.Jugador;
import juegotimbiriche.TipoFigura;

/**
 *
 * @author Equipo 5
 */
public class ControlTablero implements MouseListener {
    
    private JPanel panel;

    public ControlTablero() {
    }
    
    public ControlTablero(JPanel panel) {
        this.panel = panel;
    }
    
    public void acomodar(Figura[][] figuras, boolean add){
        Control control= new Control();
        for(int x=0;x<19;x++){
            for(int y=0;y<19;y++){
                if(add){
                    figuras[x][y]=new Figura();
                    figuras[x][y].addMouseListener(this);
                }
                else{
                    figuras[x][y].setJugador(null);
                    figuras[x][y].setUso(false);
                }
                if(x%2==0){
                    if(y%2==0){
                        figuras[x][y].setTipo(TipoFigura.VERTICE);
                        figuras[x][y].setBounds(17+(25*(y/2)),12+(25*(x/2)),7,7);
                        figuras[x][y].setBackground(Color.black);
                        figuras[x][y].removeMouseListener(this);
                    }
                    else{
                        figuras[x][y].setTipo(TipoFigura.LINEA);
                        figuras[x][y].setBounds(24+(25*(y/2)),12+(25*(x/2)),18,7);
                        figuras[x][y].setBackground(Color.WHITE);
                    }
                }
                else{
                    if(y%2==0){
                        figuras[x][y].setTipo(TipoFigura.LINEA);
                        figuras[x][y].setBounds(17+(25*(y/2)),19+(25*(x/2)),7,18);
                        figuras[x][y].setBackground(Color.WHITE);
                    }
                    else{
                        figuras[x][y].setTipo(TipoFigura.CUADRO);
                        figuras[x][y].setBounds(24+(25*(y/2)),19+(25*(x/2)),18,18);
                        figuras[x][y].setBackground(Color.WHITE);
                        figuras[x][y].removeMouseListener(this);
                    }
                }
                if(add){
                    control.agregarBotones(figuras[x][y], panel);
                }
            }
        }
    }
    
    public void checar(Jugador jugador, Figura[][] figuras){
        for(int x=0;x<19;x++){
            for(int y=0;y<19;y++){
                if(!figuras[x][y].getUso()){
                    if(figuras[x-1][y].getUso() && figuras[x+1][y].getUso() 
                            && figuras[x][y-1].getUso() 
                            && figuras[x][y+1].getUso()){
                        figuras[x][y].setJugador(jugador);
                        figuras[x][y].setUso(true);
                        switch(jugador.getNumTurno()){
                            case 1:
                                jugador.sumarPuntaje();
                                jugador.setTurno(true);
                                break;
                            case 2: 
                                jugador.sumarPuntaje();
                                jugador.setTurno(true);
                                break;
                            case 3:
                                jugador.sumarPuntaje();
                                jugador.setTurno(true);
                                break;
                            case 4:
                                jugador.sumarPuntaje();
                                jugador.setTurno(true);
                                break;
                        }
                    }
                }
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        JOptionPane.showMessageDialog(panel, "Funciona", "Información", JOptionPane.INFORMATION_MESSAGE); 
//        for (int x = 0; x < 19; x++) {
//            for (int y = 0; y < 19; y++) {
//                me.getSource().
//                vistamaquina.getBoton(x, y).setBackground(Color.black);
//                vistamaquina.getBoton(x, y).setEnabled(false);
//                ban = true;
//                break;
//            }
//            if (ban) {
//                break;
//            }
//        }
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
