
package juegotimbiriche;

import javax.swing.JLabel;

/**
 *
 * @author Equipo 5
 */
public class Figura extends JLabel{
    
    /**
     * Atributos de la clase Figura.
     */
    private Jugador jugador;
    private boolean uso;
    private TipoFigura tipo;

    /**
     * Constructor por defecto de la clase Cuadro.
     */
    public Figura(){
    }

    public Figura(Jugador jugador, boolean uso, TipoFigura tipo) {
        this.jugador = jugador;
        this.uso= uso;
        this.tipo= tipo;
    }

    /**
     * Gets y sets de la clase Figura.
     */
    public Jugador getJugador() {
        return jugador;
    }

    public void setJugador(Jugador jugador) {
        this.jugador = jugador;
    }

    public boolean getUso() {
        return uso;
    }

    public void setUso(boolean uso) {
        this.uso = uso;
    }

    public TipoFigura getTipo() {
        return tipo;
    }

    public void setTipo(TipoFigura tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Cuadro{" + "nombre=" + jugador.getNombre() + ", uso=" + uso +", tipoFigura="+this.tipo+'}';
    }
    
}
