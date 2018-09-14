package Server;

import java.io.IOException;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        Socket socket = null;

        try(ServerSocket server = new ServerSocket(9000);) {

            System.out.println("Server created. Waiting for client...");
            while (true) {
                socket = server.accept();
                System.out.println("Client connected");
                new Thread(new ClientHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
