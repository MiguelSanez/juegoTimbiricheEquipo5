/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/**
 *
 * @author Equipo 5
 */
public class Jugador extends Juego {

    /**
     * Atributos de la clase Jugador.
     */
    private UUID uniqueID;
    private int[] color;
    private int puntaje = 0;
    private String nombre;
    private InetAddress ip;
    private int port;

    /**
     * Constructor por default de la clase Jugador.
     */
    public Jugador() {
        this.uniqueID = UUID.randomUUID();
    }

    public Jugador(int[] color, String nombre) {
        this.uniqueID = UUID.randomUUID();
        this.color = color;
        this.nombre = nombre;
    }

    public Jugador(String datos) {
        String[] aux = datos.split(",");
        int[] color = new int[3];

        for (int i = 0; i < aux.length - 1; i++) {
            String string = aux[i];
            color[i] = Integer.parseInt(string);
        }

        this.color = color;
        this.nombre = aux[3].trim();
    }

    /**
     * 
     * @return 
     */
    public UUID getUniqueID() {
        return uniqueID;
    }

    /**
     * 
     * @param uniqueID 
     */
    public void setUniqueID(UUID uniqueID) {
        this.uniqueID = uniqueID;
    }

    /**
     * Gets y sets de la clase Jugador.
     *
     * @return
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

    public void sumarPuntaje() {
        this.puntaje++;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.uniqueID);
        hash = 79 * hash + Arrays.hashCode(this.color);
        hash = 79 * hash + this.puntaje;
        hash = 79 * hash + Objects.hashCode(this.nombre);
        hash = 79 * hash + Objects.hashCode(this.ip);
        hash = 79 * hash + this.port;
        return hash;
    }

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
        final Jugador other = (Jugador) obj;
        if (this.puntaje != other.puntaje) {
            return false;
        }
        if (this.port != other.port) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.uniqueID, other.uniqueID)) {
            return false;
        }
        if (!Arrays.equals(this.color, other.color)) {
            return false;
        }
        if (!Objects.equals(this.ip, other.ip)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Jugador{color=").append(color);
        sb.append(", puntaje=").append(puntaje);
        sb.append(", nombre=").append(nombre);
        sb.append(", ip=").append(ip);
        sb.append(", port=").append(port);
        sb.append('}');
        return sb.toString();
    }

}
