/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package server;

/**
 *
 * @author windiwitari
 */
public class ServerProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        Server server = new Server(5001);
        server.start();
    }
    
}
