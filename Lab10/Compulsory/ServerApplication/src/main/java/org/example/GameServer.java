package org.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameServer {
    private static final int PORT = 8100;
    private ServerSocket serverSocket;
    private List<ClientThread> clients = new ArrayList<>();

    public GameServer() {
        try {
            serverSocket = new ServerSocket(PORT);
        } catch (IOException e) {
            System.err.println("Error creating server socket: " + e.getMessage());
        }
    }

    public void start() {
        System.out.println("Server started on port " + PORT);
        try {
            while (true) {
                System.out.println("Waiting for a client...");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected: " + socket.getInetAddress().getHostAddress());
                ClientThread clientThread = new ClientThread(socket, this);
                clients.add(clientThread);
                clientThread.start();
            }
        } catch (IOException e) {
            System.err.println("Error accepting client connection: " + e.getMessage());
        }
    }

    public void stop() {
        try {
            serverSocket.close();
            for (ClientThread client : clients) {
                client.stopClient();
            }
        } catch (IOException e) {
            System.err.println("Error stopping server: " + e.getMessage());
        }
    }


}
