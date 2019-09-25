package Client;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        String ip = JOptionPane.showInputDialog("Server IP: ");
        Socket socket = new Socket(ip, 10000);
        PrintStream output = new PrintStream(socket.getOutputStream());
        Scanner input = new Scanner(socket.getInputStream());

        MessageEmitter messageEmitter = new MessageEmitter(output);
        ChatScreen chatScreen = new ChatScreen(messageEmitter);

        MessageReceptor receptor = new MessageReceptor(input, chatScreen);

        Thread stack = new Thread(receptor);
        stack.start();
    }
}
