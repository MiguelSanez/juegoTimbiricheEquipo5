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
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Melissa Arreola
 */
public class Servidor {

    /**
     * @param args the command line arguments
     */
    public void main(String[] args) {
        
        Socket socket = null;
        ServerSocket ss2 = null;
        System.out.println("Server Listening......");
       
        try {
            ss2 = new ServerSocket(0000);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Server error");
        }

        while (true) {
            try {
                socket = ss2.accept();
                System.out.println("connection Established");
                ServerThread st = new ServerThread(socket);
                st.start();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Connection Error");

            }
        }
    }
    
    
    class ServerThread extends Thread {

    String line = null;
    BufferedReader is = null;
    PrintWriter os = null;
    Socket socket = null;

    public ServerThread(Socket s) {
        this.socket = s;
    }

    public void run() {
        try {
            is = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            os = new PrintWriter(socket.getOutputStream());

        } catch (IOException e) {
            System.out.println("IO error in server thread");
        }

        try {
            line = is.readLine();
            while (line.compareTo("QUIT") != 0) {

                os.println(line);
                os.flush();
                System.out.println("Response to Client  :  " + line);
                line = is.readLine();
            }
        } catch (IOException e) {

            line = this.getName();
            System.out.println("IO Error/ Client " + line + " terminated abruptly");
        } catch (NullPointerException e) {
            line = this.getName();
            System.out.println("Client " + line + " Closed");
        } finally {
            try {
                System.out.println("Connection Closing..");
                if (is != null) {
                    is.close();
                    System.out.println(" Socket Input Stream Closed");
                }

                if (os != null) {
                    os.close();
                    System.out.println("Socket Out Closed");
                }
                if (socket != null) {
                    socket.close();
                    System.out.println("Socket Closed");
                }

            } catch (IOException ie) {
                System.out.println("Socket Close Error");
            }
        }
    }
    }
}
