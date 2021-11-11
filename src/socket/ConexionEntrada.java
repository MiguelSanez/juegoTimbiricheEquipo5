/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import control.InterpreteConexion;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author darkl
 */
public class ConexionEntrada extends Thread{
    private Socket socket;
    private ServerSocket servidor;
    private DataInputStream flujo_entrada;
    private DataOutputStream flujo_salida;
    
    public ConexionEntrada(int port,int port2,String ip){
        try {
            servidor=new ServerSocket(port, port2,InetAddress.getByName(ip));
        }
        catch(IOException ex ){
            System.out.println("puerto ocupado");
        }
    }
     @Override
    public void run(){
        String ej="";
        while(true){
            Object input=null;
            try{
                socket=servidor.accept();
                flujo_entrada = new DataInputStream(socket.getInputStream());
                flujo_salida = new DataOutputStream(socket.getOutputStream());
                
                input = flujo_entrada.readUTF();
                flujo_salida.writeUTF(ej);
                socket.close();
            }
            catch(IOException e){
                
            }
           InterpreteConexion.interpretar((String)input);
        }
    }
}
