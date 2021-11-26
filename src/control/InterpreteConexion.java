/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import control.Control;
import juegotimbiriche.Figura;
import juegotimbiriche.Jugador;

/**
 *
 * @author Equipo 5
 */
public class InterpreteConexion {
    private static Control control;
    public InterpreteConexion(Control control){
        this.control=control;
    }
    
    public static void interpretar(String mensaje){
        String mando=mensaje.split("@")[0];
        if (mando.equalsIgnoreCase("JugadorConexion")) {
            Jugador jugador=new Jugador(mensaje.split("@")[1]);
            InterpreteConexion.control.conectaJugador(jugador);
        }else if(mando.equalsIgnoreCase("Jugada")){
            String jugada=mensaje.split("@")[1].trim();
            Figura figura=Figura.toFigura(jugada.split(" ")[0]);
            ControlTablero.rayar(figura);
        }
    }
    
    
    
}
