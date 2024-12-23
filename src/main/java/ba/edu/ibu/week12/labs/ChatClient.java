package ba.edu.ibu.week12.labs;

import java.io.*;
import java.net.*;

public class ChatClient {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java ChatClient <username> <server_ip>");
            return;
        }

        String username = args[0];
        String serverIp = args[1];
        int port = 12345;

        try (Socket socket = new Socket(serverIp, port);
             BufferedReader serverReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter serverWriter = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in))) {

            serverWriter.println(username);

            new Thread(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = serverReader.readLine()) != null) {
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }).start();

            String clientMessage;
            while ((clientMessage = consoleReader.readLine()) != null) {
                serverWriter.println(clientMessage);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

