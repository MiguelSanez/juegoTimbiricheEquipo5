package socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;

/**
 *
 * @author darkl
 */
public class ConexionSalida {
    private int port2;
    private Socket cliente;
    private DataOutputStream flujo_de_salida;
    private DataInputStream flujo_de_entrada;
    private String ip;
    
      public ConexionSalida(String ip, int port2){
        this.port2=port2;
        this.ip=ip;
        
    }
      
     public void mensaje_Saliente(String mensaje){
        try{
            cliente = new Socket(ip, port2);
            flujo_de_entrada = new DataInputStream(cliente.getInputStream());
            flujo_de_salida = new DataOutputStream(cliente.getOutputStream());
            flujo_de_salida.writeUTF((String)mensaje);
            flujo_de_entrada.readUTF();
            cliente.close();
        }
        catch(Exception ex){}
    }
    
}
