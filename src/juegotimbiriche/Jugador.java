
package juegotimbiriche;

import java.net.InetAddress;

/**
 *
 * @author Equipo 5
 */
public class Jugador extends Juego{
    
    /**
     * Atributos de la clase Jugador.
     */
    private int[] color;
    private int puntaje=0;
    private String nombre;
    private Boolean turno= false;
    private int numTurno;
    private InetAddress ip;
    private int port;

    /**
     * Constructor por default de la clase Jugador.
     */
    public Jugador() {
    }

    public Jugador(int[] color, String nombre) {
        this.color = color;
        this.nombre = nombre;
    }
     public Jugador(String datos){
        String[] aux=datos.split(",");
        int[] color=new int[3];
        for (int i = 0; i < aux.length-1; i++) {
            String string = aux[i];
            color[i]=Integer.parseInt(string);
        }
        this.color=color;
        this.nombre=aux[3].trim();
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

    public InetAddress getIp() {
        return ip;
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
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

    public int getNumTurno() {
        return numTurno;
    }

    public void setNumTurno(int numTurno) {
        this.numTurno = numTurno;
    }
    
    public void sumarPuntaje(){
        this.puntaje++;
    }

    @Override
    public String toString() {
        return color[0]+","+color[1] +","+color[2] + ","+nombre;
    }
    
}
