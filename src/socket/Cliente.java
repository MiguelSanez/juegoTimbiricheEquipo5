/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author darkl
 */
public class Cliente extends Thread{
    private static InetAddress ip;
    private static final int PORT=5000;
    private static DatagramSocket yo;
    
    public Cliente(InetAddress ip){
        this.ip=ip;
         try{
      yo = new DatagramSocket();
    }catch(SocketException e){
      System.out.println(e.getMessage());
      System.exit(1);
    }
    }
    
    private void registrar(String nickname){
        String mensaje = ".registrar@" + nickname;
        byte[] registrarBuffer = new byte[100];
        registrarBuffer = mensaje.getBytes();
        DatagramPacket registrar = new DatagramPacket(registrarBuffer, registrarBuffer.length, ip, PORT);
        try{
          yo.send(registrar);
        }catch(IOException ex){
          System.out.println(ex.getMessage());
          System.exit(1);
        }
    }
    
    
    
    
}
