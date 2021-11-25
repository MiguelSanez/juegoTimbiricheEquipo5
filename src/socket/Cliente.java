/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import control.InterpreteConexion;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Iterator;
import juegotimbiriche.Jugador;

/**
 *
 * @author darkl
 */
public class Cliente extends Thread {

    private static Cliente singleton = null;
    private static ArrayList<Jugador> usuarios = new ArrayList<Jugador>();
    private static InetAddress ip;
    private static final int PORT = 5000;
    private static DatagramSocket yo;
    private static String recibido;

    public static Cliente getCliente() {
        if (singleton == null) {
            singleton = new Cliente();
        }
        return singleton;
    }

    public void setIp(InetAddress ip) {
        Cliente.ip = ip;
        try {
            yo = new DatagramSocket();
        } catch (SocketException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }

    private Cliente() {
    }

    public void registrar(Jugador jugador) {
        String mensaje = ".registra@" + jugador.toString();
        byte[] registrarBuffer = new byte[100];
        registrarBuffer = mensaje.getBytes();
        DatagramPacket registrar = new DatagramPacket(registrarBuffer, registrarBuffer.length, ip, PORT);
        try {
            yo.send(registrar);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }
    public void sendJugada(String jugada){
        String mensaje = ".Jugada@" + jugada;
        byte[] registrarBuffer = new byte[100];
        registrarBuffer = mensaje.getBytes();
        DatagramPacket registrar = new DatagramPacket(registrarBuffer, registrarBuffer.length, ip, PORT);
        try {
            yo.send(registrar);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.exit(1);
        }
    }

    private void conecta() {
        //formato de registro ".conecta@color1,color2,color3,nombre"
        String[] info = recibido.split("@");
        String[] infoJ = info[1].split(",");

        Jugador c = new Jugador();
        c.setNombre(infoJ[3]);
        int[] color = new int[3];
        for (int i = 0; i < color.length; i++) {
            int j = Integer.parseInt(infoJ[i]);
            color[i] = j;
        }
        c.setColor(color);
        usuarios.add(c);
        InterpreteConexion.interpretar("JugadorConexion@" + c.toString());
    }

    @Override
    public void run() {
        byte[] bufferR;
        DatagramPacket paquete;
        while (true) {
            try {
                bufferR = new byte[100];
                paquete = new DatagramPacket(bufferR, bufferR.length);
                yo.receive(paquete);
                recibido = new String(paquete.getData());
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }//recibe mensaje entrante
            if (recibido.startsWith(".conecta")) {
                this.conecta();
            }//conecta
        }//while

    }//run

}
