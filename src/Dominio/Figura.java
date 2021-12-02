package Dominio;

import java.util.Objects;
import javax.swing.JLabel;

/**
 *
 * @author Equipo 5
 */
public class Figura extends JLabel {

    /**
     * Atributos de la clase Figura.
     */
    private Jugador jugador;
    private boolean uso = false;
    private TipoFigura tipo;

    /**
     * Constructor por defecto de la clase Cuadro.
     */
    public Figura() {
    }

    public Figura(Jugador jugador, boolean uso, TipoFigura tipo) {
        this.jugador = jugador;
        this.uso = uso;
        this.tipo = tipo;
    }

    /**
     * Gets y sets de la clase Figura.
     *
     * @return
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

    /**
     *
     * @param obj
     * @return
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Figura other = (Figura) obj;
        if (this.uso != other.uso) {
            return false;
        }
        if (!Objects.equals(this.jugador, other.jugador)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 83 * hash + Objects.hashCode(this.jugador);
        hash = 83 * hash + (this.uso ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.tipo);
        return hash;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        return jugador + ":" + uso + ":" + this.tipo + ":" + this.hashCode();
    }

}
