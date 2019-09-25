package Server;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Registrator implements Runnable {
    private Distributor distributor;
    private ServerSocket serverSocket;

    public Registrator(Distributor distributor, ServerSocket serverSocket) {
        this.distributor = distributor;
        this.serverSocket = serverSocket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket socket = this.serverSocket.accept();
                String ip = socket.getInetAddress().toString();

                Scanner input = new Scanner(socket.getInputStream());
                PrintStream output = new PrintStream(socket.getOutputStream());

                Receptor receptor = new Receptor(input, this.distributor);

                Thread pilha = new Thread(receptor);
                pilha.start();

                Emitter emissor = new Emitter(ip, output);

                this.distributor.adicionaEmissor(emissor);

            }catch (IOException e) {
                System.out.printf("ERRO : %s\n", e.getMessage());
            }
        }
    }
}