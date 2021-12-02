/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import Dominio.Jugador;
import control.InterpreteConexion;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author darkl
 */
public class Cliente extends Thread {

    private static Cliente instance;
    private List<Jugador> usuarios = new ArrayList<>();
    private InetAddress ip;
    private static final int PORT = 5000;
    private DatagramSocket clientTunnel;
    private Object recibido;

    private InterpreteConexion interpreteConexion = InterpreteConexion.getInstance();

    /**
     *
     * @return
     */
    public static Cliente getInstance() {
        if (instance == null) {
            instance = new Cliente();
        }
        return instance;
    }

    private Cliente() {
    }

    public void setIp(InetAddress ip) {
        this.ip = ip;
        try {
            clientTunnel = new DatagramSocket();
        } catch (SocketException e) {
            System.out.println(e.getMessage());
        }
    }

    public void registrar(Jugador jugador) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream out;

        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(jugador);
            out.flush();
            byte[] registrarBuffer = bos.toByteArray();
            
            System.out.println("Registrando datos: " + jugador);

            DatagramPacket registrar = new DatagramPacket(registrarBuffer, registrarBuffer.length, ip, PORT);
            clientTunnel.send(registrar);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void sendJugada(Object jugada) {
        //formato de la jugada: ".Jugada@"
        String mensaje = ".Jugada@" + jugada;
        byte[] registrarBuffer = mensaje.getBytes();
        DatagramPacket registrar = new DatagramPacket(registrarBuffer, registrarBuffer.length, ip, PORT);
        try {
            clientTunnel.send(registrar);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void inicia() {
        String mensaje = ".Inicia";
        byte[] registrarBuffer = mensaje.getBytes();
        DatagramPacket registrar = new DatagramPacket(registrarBuffer, registrarBuffer.length, ip, PORT);
        try {
            clientTunnel.send(registrar);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void conecta() {
        usuarios.add((Jugador) recibido);
        interpreteConexion.interpretar(0, recibido);
    }

    @Override
    public void run() {
        byte[] bufferR;
        DatagramPacket paquete;
        while (true) {
            try {
                bufferR = new byte[100];
                paquete = new DatagramPacket(bufferR, bufferR.length);
                clientTunnel.receive(paquete);
                recibido = paquete.getData();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }//recibe mensaje entrante
        }//while

    }//run

}
