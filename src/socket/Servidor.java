/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import Dominio.Jugador;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author darkl
 */
public class Servidor extends Thread {

    private List<Jugador> usuarios = new ArrayList<>();
    private HashMap<Object, InetAddress> map = new HashMap<>();
    private DatagramSocket serverTunnel;
    private InetAddress clientAddress;
    private int puertoCliente;
    private Object recibido;
    private Object aMandar;

    public Servidor() {
    }

    private void sendMessage(DatagramSocket serverTunnel, Object aMandar, String niki) {
        DatagramPacket paquete;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out;

        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(aMandar);
            out.flush();
            byte[] buffer = bos.toByteArray();

            for (int i = 0; i < usuarios.size(); i++) {
                Jugador userARecibir = usuarios.get(i);
                if (!userARecibir.getNombre().equalsIgnoreCase(niki)) {
                    paquete = new DatagramPacket(buffer, buffer.length, userARecibir.getIp(), userARecibir.getPort());
                    try {
                        serverTunnel.send(paquete);
                        System.out.println("Sending message: " + aMandar + " a " + userARecibir.getNombre());
                    } catch (IOException e) {
                        System.out.println(e.getMessage());
                        System.exit(1);
                    }
                }
            }
        } catch (IOException ex) {
            System.out.println("Fallo al leer los bytes del mensaje. a");
        }

    }

    private void registra() {
        //formato de registro ".registra@color1,color2,color3,nombre"

        if (map.size() < 4) {
            map.put(recibido, clientAddress);
            Jugador clienteJugador = new Jugador();
            clienteJugador.setIp(clientAddress);
            clienteJugador.setPort(puertoCliente);
            clienteJugador.setNombre(((Jugador) recibido).getNombre());
            clienteJugador.setColor(((Jugador) recibido).getColor());
            usuarios.add(clienteJugador);
            System.out.println("Se agrego al usuario " + clienteJugador.getNombre() + " " + clienteJugador.getIp().toString());
            for (Iterator<Jugador> iterator = usuarios.iterator(); iterator.hasNext();) {
                Jugador next = iterator.next();
                sendMessage(serverTunnel, ".conecta@" + next.toString(), "@System@");
            }
        } else {
            System.out.println("Servidor lleno. a");
        }
    }

    @Override
    public void run() {

        DatagramPacket paquete;

        byte[] buffer;
        try {
            serverTunnel = new DatagramSocket(5000);

            while (true) {

                buffer = new byte[100];
                paquete = new DatagramPacket(buffer, buffer.length);

                try {
                    serverTunnel.receive(paquete);
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                    System.exit(1);
                }

                recibido = new String(paquete.getData()).trim(); // Extraer los datos recibidos y transformalos a String
                clientAddress = paquete.getAddress();// Obtener la direcciÃ³n del cliente
                puertoCliente = paquete.getPort();

            }//while
        } catch (SocketException e) {
            System.out.println(e.getMessage());
        }

    }//run

}
