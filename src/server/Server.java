/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;


import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author windiwitari
 */


public class Server {
    private int port;

    public Server(int port) {
        this.port = port;
    }

    public void start() throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("[SERVER] Listening on port " + port);

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("[SERVER] Connected to " + socket.getInetAddress());
            new Worker(socket).start();
        }
    }
}