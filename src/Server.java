import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private ClientHandler client;

    public static void main(String[] args) {
        new Server();
    }

    public Server() {
        Socket socket = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(8888);
            System.out.println("Server created. Waiting for client...");
            socket = server.accept();
            System.out.println("Client connected");
            client = new ClientHandler(socket);
            new Thread(client).start();
            consoleChecker();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                System.out.println("Server closed");
                if (socket != null) socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void consoleChecker() {
        Scanner s = new Scanner(System.in);

        while (true) {
            try {
                if (s.hasNext()) {
                    String message = s.nextLine();
                    String msg = "Server: " + message;
                    client.sendMessage(msg);
                    System.out.println(msg);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
