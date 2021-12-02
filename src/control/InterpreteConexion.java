/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import Dominio.Figura;
import Dominio.Jugador;
import presentacion.FrmSalaEspera;

/**
 *
 * @author Equipo 5
 */
public class InterpreteConexion {

    private Control control;
    private static InterpreteConexion instance;

    /**
     *
     * @return
     */
    public static InterpreteConexion getInstance() {
        if (instance == null) {
            instance = new InterpreteConexion();
        }
        return instance;
    }

    private InterpreteConexion() {

    }

    /**
     *
     * @param accion
     * @param objeto
     */
    public void interpretar(int accion, Object objeto) {
//        String mando = mensaje.split("@")[0];
//        if (mando.equalsIgnoreCase("JugadorConexion")) {
//            Jugador jugador = new Jugador(mensaje.split("@")[1]);
//            getJugador().conectaJugador(jugador);
//        } else if (mando.equalsIgnoreCase("Jugada")) {
//            String jugada = mensaje.split("@")[1].trim();
//            Figura figura = Figura.toFigura(jugada.split(" ")[0]);
//            ControlTablero.rayar(figura);
//        } else if(mensaje.startsWith("Inicia")){
//            sala.inicia();
//        }
        if (objeto instanceof Jugador) {
            switch (accion) {
                case 0:
                    control.conectaJugador((Jugador) objeto);
                    break;
                case 1:

                    break;
                case 2:
                    break;
            }
            control.conectaJugador((Jugador) objeto);
        } else if (objeto instanceof Figura) {

        } else if (objeto instanceof String) {
            if (((String) objeto).startsWith("Inicia")) {
                FrmSalaEspera.getInstance().inicia();
            }
        }
    }

    /**
     *
     * @param control
     */
    public void setControl(Control control) {
        this.control = control;
    }

    /**
     *
     * @return
     */
    public Control getControl() {
        return control;
    }

}
