package upf.at.s2.server2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {
    // Port to listen on
    private static final int PORT = 5000;

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;
        
        try {
            // 1. Create the listening socket
            serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT + ". Waiting for connections...");

            // 2. Infinite loop to accept multiple clients
            while (true) {
                // This blocks until a client connects
                Socket clientSocket = serverSocket.accept();
                
                // 3. Instead of handling the client here, we pass it to a new Thread
                // This allows the main loop to go back and wait for the NEXT client immediately
                new ClientThread(clientSocket);
            }
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }
}