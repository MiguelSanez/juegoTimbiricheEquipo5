/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juegotimbiriche;

/**
 *
 * @author Equipo 5
 */
public class Tablero extends Juego{
    
    /**
     * Atributos de la clase Tablero.
     */
    private int alturaTablero;
    private int anchuraTablero;
    boolean marcaArriba;
    boolean marcaAbajo;
    boolean marcaIzquierda;
    boolean marcaDerecha;
    boolean cuadroCerrado;

    /**
     * Constructor por default de la clase Tablero.
     */
    public Tablero() {
    }

    /**
     * Constructor con los atributos de la clase Tablero.
     * @param marcaArribaN
     * @param marcaAbajoN
     * @param marcaIzquierdaN
     * @param marcaDerechaN
     * @param cuadroCerradoN 
     */
    public Tablero (boolean marcaArribaN, boolean marcaAbajoN, boolean marcaIzquierdaN, boolean marcaDerechaN, boolean cuadroCerradoN){
        this.marcaArriba = marcaArribaN;
        this.marcaAbajo = marcaAbajoN;
        this.marcaIzquierda = marcaIzquierdaN;
        this.marcaDerecha = marcaDerechaN;
        this.cuadroCerrado = cuadroCerradoN;
    }

    /**
     * Gets y sets de la clase Tablero.
     * @return 
     */
    public int getAlturaTablero() {
        return alturaTablero;
    }

    public void setAlturaTablero(int alturaTablero) {
        this.alturaTablero = alturaTablero;
    }

    public int getAnchuraTablero() {
        return anchuraTablero;
    }

    public void setAnchuraTablero(int anchuraTablero) {
        this.anchuraTablero = anchuraTablero;
    }

    public boolean isMarcaArriba() {
        return marcaArriba;
    }

    public void setMarcaArriba(boolean marcaArriba) {
        this.marcaArriba = marcaArriba;
    }

    public boolean isMarcaAbajo() {
        return marcaAbajo;
    }

    public void setMarcaAbajo(boolean marcaAbajo) {
        this.marcaAbajo = marcaAbajo;
    }

    public boolean isMarcaIzquierda() {
        return marcaIzquierda;
    }

    public void setMarcaIzquierda(boolean marcaIzquierda) {
        this.marcaIzquierda = marcaIzquierda;
    }

    public boolean isMarcaDerecha() {
        return marcaDerecha;
    }

    public void setMarcaDerecha(boolean marcaDerecha) {
        this.marcaDerecha = marcaDerecha;
    }

    public boolean isCuadroCerrado() {
        return cuadroCerrado;
    }

    public void setCuadroCerrado(boolean cuadroCerrado) {
        this.cuadroCerrado = cuadroCerrado;
    }

    
    @Override
    public String toString() {
        return "Tablero{" + "alturaTablero=" + alturaTablero + ", anchuraTablero=" + anchuraTablero + ", marcaArriba=" + marcaArriba + ", marcaAbajo=" + marcaAbajo + ", marcaIzquierda=" + marcaIzquierda + ", marcaDerecha=" + marcaDerecha + ", cuadroCerrado=" + cuadroCerrado + '}';
    }
    
}
