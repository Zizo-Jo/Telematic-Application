package upf.dad.p1.chat.server;
...
public class ChatServer {
...
ServerSocket s = new ServerSocket(PORT);
InetAddress addrs = InetAddress.getByName("localhost");
System.out.println("Server started. Waiting for connections..." );
try {
Socket socket = s.accept();
try {
BufferedReader in = new BufferedReader(
new InputStreamReader(socket.getInputStream()));
PrintWriter out = new PrintWriter(
new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
out.println("Welcome! Enter your name please: ");
String username = in.readLine();
out.println("Welcome" + username + ". See you soon!");
} catch (IOException e) {
...
}
} finally {
s.close();
}
...
}