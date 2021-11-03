/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

/**
 *
 * @author Melissa Arreola
 */
public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        /**
         * Atributos de la clase Cliente.
         */
        InetAddress address = InetAddress.getLocalHost();
        Socket socket = null;
        String line = null;
        BufferedReader br = null;
        BufferedReader is = null;
        PrintWriter os = null;

        
        try {
            //
            //Falta la direccion del socket.
            //
            socket = new Socket(address, 0000);
            br = new BufferedReader(new InputStreamReader(System.in));
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = new PrintWriter(socket.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.err.print("IO Exception");
        }

        System.out.println("Client Address : " + address);
        System.out.println("Enter Data to echo Server ( Enter QUIT to end):");
        String response = null;
        
        try {
            line = br.readLine();
            while (line.compareTo("QUIT") != 0) {
                os.println(line);
                os.flush();
                response = is.readLine();
                System.out.println("Server Response : " + response);
                line = br.readLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Socket read Error");
        } finally {
            is.close();
            os.close();
            br.close();
            socket.close();
            System.out.println("Connection Closed");
        }
    }
}
