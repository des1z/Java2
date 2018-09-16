import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;


public class Server {
    private static final long DELAY_BEFORE_TIMEOUT = 120;
    private final List<ClientHandler> clients = Collections.synchronizedList(new ArrayList<>());
    private AuthService authService;

    public static void main(String[] args) {
        new Server(new BaseAuthService());
    }

    public Server(AuthService authService) {
        this.authService = authService;

        Socket s = null;
        ServerSocket server = null;
        try {
            server = new ServerSocket(8888);
            System.out.println("Server created. Waiting for client...");
            startKiller();
            while (true) {
                s = server.accept();
                ClientHandler client = new ClientHandler(this, s);
                new Thread(client).start();
                clients.add(client);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (server != null) server.close();
                System.out.println("Server closed");
                if (s != null) s.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void startKiller() {
        new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(100);
                    LocalDateTime now = LocalDateTime.now();

                    Iterator<ClientHandler> i = clients.iterator();
                    while (i.hasNext()) {
                        ClientHandler client = i.next();
                        if (!client.isActive()
                                && Duration.between(client.getConnectTime(), now).getSeconds() > DELAY_BEFORE_TIMEOUT) {
                            System.out.println("close unauthorized user");
                            client.close();
                            i.remove();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }


    public AuthService getAuthService() {
        return authService;
    }

    public void sendBroadcastMessage(String msg) {
        for (ClientHandler c : clients) {
            if (c.isActive()) c.sendMessage(msg);
        }
    }

    void sendPrivateMessage(String from, String userName, String message) {
        for (ClientHandler c : clients) {
            String name = c.getHandlerName();
            if (name.equals(userName) && c.isActive())
                c.sendMessage(from + " wisp " + userName + ": " + message);
        }
    }
}

