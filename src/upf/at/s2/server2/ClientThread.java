package upf.at.s2.server2;

import java.io.*;
import java.net.Socket;

public class ClientThread extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        // Initialize streams immediately in the constructor
        this.in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        
        // Start the thread (this calls the run() method)
        start();
    }

    @Override
    public void run() {
        try {
            // 1. Handshake: Ask for name
            out.println("Welcome! Enter your name please: ");
            String username = in.readLine();
            
            System.out.println(username + " has connected");
            out.println("Welcome " + username + ". Now, you can chat...");

            // 2. Message Loop: Keep reading until client disconnects
            while (true) {
                String messageReceived = in.readLine();
                
                // If message is null, client disconnected abruptly
                if (messageReceived == null) {
                    break; 
                }
                
                // Display message on Server Console as requested
                System.out.println(username + " says: " + messageReceived);
            }
        } catch (IOException e) {
            System.err.println("Client disconnected or error occurred.");
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}