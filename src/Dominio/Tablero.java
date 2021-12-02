/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dominio;

/**
 *
 * @author Equipo 5
 */
public class Tablero extends Juego {

    /**
     * Atributos de la clase Tablero.
     */
    private String dimension;
    private Figura[][] figuras;

    /**
     * Constructor por default de la clase Tablero.
     */
    public Tablero() {
    }

    /**
     *
     * @param dimension
     */
    public Tablero(String dimension) {
        this.dimension = dimension;
        figuras = new Figura[19][19];
    }

    /**
     *
     * @param dimension
     * @param figuras
     */
    public Tablero(String dimension, Figura[][] figuras) {
        this.dimension = dimension;
        this.figuras = figuras;
    }

    /**
     * Gets y sets de la clase Tablero.
     *
     * @return
     */
    public String getDimension() {
        return dimension;
    }

    /**
     *
     * @param dimension
     */
    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    /**
     *
     * @return
     */
    public Figura[][] getFiguras() {
        return figuras;
    }

    /**
     *
     * @param figuras
     */
    public void setFiguras(Figura[][] figuras) {
        this.figuras = figuras;
    }

    /**
     *
     * @return
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Tablero{dimension=").append(dimension);
        sb.append(", figuras=").append(figuras);
        sb.append('}');
        return sb.toString();
    }

}
