/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import socket.ConexionEntrada;
import socket.ConexionSalida;

/**
 *
 * @author darkl
 */
public class Conexion {
    private int port1, port2;
    private String nombre, ip;
    private ConexionEntrada entrada;
    private ConexionSalida salida;
    private static Conexion singleton;
            
    private Conexion(String nombre, String ip, int port1, int port2){
       
        entrada=new ConexionEntrada(port1,port2,ip);
        entrada.start();
        salida=new ConexionSalida(ip, port2);
        
        
    }        
    public static void conecta(String nombre, String ip, int port1, int port2){
        Conexion.singleton=new Conexion(nombre,ip,port1,port2);
    }
    public static Conexion getConexion(){
        
            return singleton;
        
    }
            
    public void enviar(String obj){
        salida.mensaje_Saliente(obj);
    }
}
