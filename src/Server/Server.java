package Server;

import java.io.IOException;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) throws IOException {
        Distributor distributor = new Distributor();

        ServerSocket serverSocket = new ServerSocket(10000);
        Registrator registrator = new Registrator(distributor, serverSocket);

        Thread stack = new Thread(registrator);

        stack.start();
    }
}
