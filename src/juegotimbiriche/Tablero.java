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
    private double dimension;
    private double ancho;
    private double largo;
    private Figura cuadro;

    /**
     * Constructor por default de la clase Tablero.
     */
    public Tablero() {
    }

    public Tablero(double dimension, double ancho, double largo, Figura cuadro) {
        this.dimension = dimension;
        this.ancho = ancho;
        this.largo = largo;
        this.cuadro = cuadro;
    }

    /**
     * Gets y sets de la clase Tablero.
     * @return 
     */
    public double getDimension() {
        return dimension;
    }

    public void setDimension(double dimension) {
        this.dimension = dimension;
    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        this.ancho = ancho;
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        this.largo = largo;
    }

    public Figura getCuadro() {
        return cuadro;
    }

    public void setCuadro(Figura cuadro) {
        this.cuadro = cuadro;
    }

    @Override
    public String toString() {
        return "Tablero{" + "dimension=" + dimension + ", ancho=" + ancho + ", largo=" + largo + '}';
    }
    
}
