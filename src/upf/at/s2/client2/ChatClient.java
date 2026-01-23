package upf.at.s2.client2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ChatClient {
    public static void main(String[] args) {
        Socket socket = null;
        try {
            // 1. Connect to the Server
            // We use host.docker.internal for Docker compatibility
            socket = new Socket(InetAddress.getByName("host.docker.internal"), 5000);

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
            
            // Stream to read from the User's Console (Keyboard)
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));

            // 2. Handshake handling
            // Read "Welcome! Enter your name..."
            System.out.println(in.readLine()); 
            
            // User types name
            String username = stdIn.readLine();
            out.println(username);
            
            // Read "Welcome [User]..."
            System.out.println(in.readLine());

            // 3. Main Chat Loop
            while (true) {
                // Read from keyboard
                String messageToSend = stdIn.readLine();
                
                // Send to server
                if (messageToSend != null) {
                    out.println(messageToSend);
                }
            }
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection.");
            e.printStackTrace();
        } finally {
            try {
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}