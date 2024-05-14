package org.example;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private GameServer server;
    private PrintWriter iesire;
    private BufferedReader intrare;

    public ClientThread(Socket socket, GameServer server) {
        this.socket = socket;
        this.server = server;
        try {
            iesire = new PrintWriter(socket.getOutputStream(), true);
            intrare = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        } catch (IOException e) {
            System.err.println("Error creating client thread: " + e.getMessage());
        }
    }

    @Override
    public void run() {
        try {
            String command;
            while ((command = intrare.readLine()) != null) {
                System.out.println("Received command from client: " + command);
                if (command.equals("stop")) {
                    server.stop();
                    break;
                } else {
                    iesire.println("Server received command: " + command);
                }
            }
        } catch (IOException e) {
            System.err.println("Error communicating with client: " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Error closing socket: " + e.getMessage());
            }
        }
    }

    public void stopClient() {
        try {
            socket.close();
        } catch (IOException e) {
            System.err.println("Error closing socket: " + e.getMessage());
        }
    }
}
