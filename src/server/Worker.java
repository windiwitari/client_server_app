/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.*;
import java.net.Socket;

public class Worker extends Thread {
    private Socket socket;

    public Worker(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            String fileName = dis.readUTF();
            long fileSize = dis.readLong();

            FileOutputStream fos = new FileOutputStream("received_" + fileName);

            byte[] buffer = new byte[4096];
            int read = 0;
            long remaining = fileSize;

            while ((read = dis.read(buffer, 0, (int)Math.min(buffer.length, remaining))) > 0) {
                fos.write(buffer, 0, read);
                remaining -= read;
            }

            System.out.println("[SERVER] File received: " + fileName);

            fos.close();
            dis.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}