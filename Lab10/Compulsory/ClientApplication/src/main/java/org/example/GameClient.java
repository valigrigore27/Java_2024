package org.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class GameClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "127.0.0.1";
        final int PORT = 8100;

        try (
                Socket socket = new Socket(SERVER_ADDRESS, PORT);
                PrintWriter iesire = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader intrare = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedReader stdin = new BufferedReader(new InputStreamReader(System.in))
        ) {
            System.out.println("Connected to server.");

            String userInput;
            while ((userInput = stdin.readLine()) != null) {
                iesire.println(userInput);
                if (userInput.equals("exit")) {
                    break;
                }
                System.out.println("Server response: " + intrare.readLine());
            }
        } catch (IOException e) {
            System.err.println("Error communicating with server: " + e.getMessage());
        }
    }
}
