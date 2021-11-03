
package juegotimbiriche;

/**
 *
 * @author Equipo 5
 */
public class Jugador extends Juego{
    
    /**
     * Atributos de la clase Jugador.
     */
    private int[] color;
    private int puntaje;
    private String nombre;
    private Boolean turno;

    /**
     * Constructor por default de la clase Jugador.
     */
    public Jugador() {
    }

    public Jugador(int[] color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }
    
    /**
     * Gets y sets de la clase Jugador.
     */
    public int[] getColor() {
        return color;
    }

    public void setColor(int[] color) {
        this.color = color;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getTurno() {
        return turno;
    }

    public void setTurno(Boolean turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Jugador{" + "color=" + color + ", puntaje=" + puntaje + ", nombre=" + nombre + ", turno=" + turno + '}';
    }
    
}
