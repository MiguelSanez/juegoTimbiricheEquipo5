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
    private String dimension;
    private Figura[][] figuras;

    /**
     * Constructor por default de la clase Tablero.
     */
    public Tablero() {
    }
    
    public Tablero(String dimension){
        this.dimension = dimension;
        figuras= new Figura[19][19];
    }

    public Tablero(String dimension, Figura[][] figuras) {
        this.dimension = dimension;
        this.figuras = figuras;
    }

    /**
     * Gets y sets de la clase Tablero.
     * @return 
     */
    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public Figura[][] getFiguras() {
        return figuras;
    }

    public void setFiguras(Figura[][] figuras) {
        this.figuras = figuras;
    }

    @Override
    public String toString() {
        return "Tablero{" + "dimension=" + dimension + '}';
    }
    
}
