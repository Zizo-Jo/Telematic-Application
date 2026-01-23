package s1.src.upf.at.s1;
...

public class ChatClient {
...
    Socket socket = new Socket(InetAddress.getByName("localhost"), Integer.parseInt("5000"));
    try {
        BufferedReader in = new BufferedReader(
            new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(
            new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        BufferedReader myinput = new BufferedReader(new InputStreamReader(System.in));
        try {
            System.out.println(in.readLine());
            String username = myinput.readLine();
            out.println(username);
            System.out.println(in.readLine());
        } catch (IOException e) {
        ...
        }
} finally {
    socket.close();
}
...
}