package s1.src.upf.at.s1;

import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;

public class ChatServer {
    public static final int PORT = 5000;
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println("Server started on port " + PORT + ". Waiting for connections..." );

            while(true){
                Socket socket = serverSocket.accept();
                
                new ClientThread(socket);
            } 
        }catch (IOException e) {
                e.printStackTrace();
        } finally {
            if (serverSocket != null) serverSocket.close();
    }
    }
}