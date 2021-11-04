
package control;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import juegotimbiriche.Figura;
import juegotimbiriche.Jugador;

public class Control {

    public Control() {
    }
    
    public Jugador crearJugador(String nombre, String color){
       
        int[] colores= new int[3];
        
        switch(color){
            
            case "Rojo":
                colores[0]= 255;
                colores[1]= 87;
                colores[2]= 87;
                break;
            
            case "Naranja":
                colores[0]= 255;
                colores[1]= 145;
                colores[2]= 77;
                break;
            
            case "Amarillo":
                colores[0]= 255;
                colores[1]= 189;
                colores[2]= 89;
                break;
            
            case "Verde lima":
                colores[0]= 201;
                colores[1]= 226;
                colores[2]= 101;
                break;
            
            case "Verde":
                colores[0]= 0;
                colores[1]= 128;
                colores[2]= 55;
                break;
            
            case "Turquesa":
                colores[0]= 3;
                colores[1]= 152;
                colores[2]= 158;
                break;
            
            case "Celeste":
                colores[0]= 56;
                colores[1]= 182;
                colores[2]= 255;
                break;
            
            case "Azul":
                colores[0]= 67;
                colores[1]= 92;
                colores[2]= 207;
                break;
           
            case "Morado":
                colores[0]= 126;
                colores[1]= 79;
                colores[2]= 219;
                break;
           
            case "Rosa":
                colores[0]= 255;
                colores[1]= 102;
                colores[2]= 196;
                break;
           
            case "Rosa claro":
                colores[0]= 255;
                colores[1]= 203;
                colores[2]= 235;
                break;
        }
       
        Jugador jugador= new Jugador(colores, nombre);
        return jugador;
    }
    
<<<<<<< Updated upstream
=======
    public void agregarBotones(Figura figura, JPanel panel){
        figura.setOpaque(true);
        figura.setBorder(BorderFactory.createEmptyBorder(1,1,1,1));
        panel.add(figura);
        figura.setVisible(true);
    }
    
>>>>>>> Stashed changes
}
