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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import juegotimbiriche.Jugador;

/**
 *
 * @author darkl
 */
public class Servidor extends Thread {

    private static ArrayList<Jugador> usuarios = new ArrayList<Jugador>();
    private static HashMap<String, InetAddress> map = new HashMap<String, InetAddress>();
    private static DatagramSocket yo = null;
    private static InetAddress dirCliente = null;
    private static int puertoCliente;
    private static String recibido;
    private static String aMandar;
    private static Servidor singleton = null;

    public static Servidor getServidor() {
        if (singleton == null) {
            singleton = new Servidor();
        }
        return singleton;
    }

    private Servidor() {

    }

    public static void sendMessage(DatagramSocket yo, String aMandar, String niki) {
        DatagramPacket paquete;
        byte[] buffer;
        buffer = new byte[100];
        buffer = aMandar.getBytes();
        for (int i = 0; i < usuarios.size(); i++) {
            Jugador userARecibir = usuarios.get(i);
            if (!userARecibir.getNombre().equalsIgnoreCase(niki)) {
                paquete = new DatagramPacket(buffer, buffer.length, userARecibir.getIp(), userARecibir.getPort());
                try {
                    yo.send(paquete);
                    System.out.println("sending message: " + aMandar + " a " + userARecibir.getNombre());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    System.exit(1);
                }
            }
        }
    }

    private void registra() {
        //formato de registro ".registra@color1,color2,color3,nombre"
        String[] info = recibido.split("@");
        String[] infoJ = info[1].split(",");

        map.put(info[1], dirCliente);
        Jugador c = new Jugador();
        c.setIp(dirCliente);
        c.setPort(puertoCliente);
        c.setNombre(infoJ[3]);
        int[] color = new int[3];
        for (int i = 0; i < color.length; i++) {
            int j = Integer.parseInt(infoJ[i]);
            color[i] = j;
        }
        c.setColor(color);
        usuarios.add(c);
        System.out.println("Se agrego al usuario " + info[1] + " " + c.getIp().toString());
        for (Iterator<Jugador> iterator = usuarios.iterator(); iterator.hasNext();) {
            Jugador next = iterator.next();
            sendMessage(yo, ".conecta@" + next.toString(), "@System@");
        }

    }

    @Override
    public void run() {

        DatagramPacket paquete;

        final int PUERTO = 5000;
        byte[] buffer = new byte[100];
        try {
            yo = new DatagramSocket(PUERTO);
        } catch (SocketException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        while (true) {

            buffer = new byte[100];
            paquete = new DatagramPacket(buffer, buffer.length);

            try {
                yo.receive(paquete);
            } catch (IOException e) {
                System.out.println(e.getMessage());
                System.exit(1);
            }

            recibido = new String(paquete.getData()).trim(); // Extraer los datos recibidos y transformalos a String
            dirCliente = paquete.getAddress();// Obtener la direcciÃ³n del cliente
            puertoCliente = paquete.getPort();

            if (recibido.startsWith(".registra")) {
                this.registra();
            }//registrar
            
            if (recibido.startsWith(".Jugada")) {
                sendMessage(yo, recibido, "@System@");
            }//Jugada
            
        }//while

    }//run

}
