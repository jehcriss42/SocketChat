package Client;

import java.util.Scanner;

public class MessageReceptor implements Runnable{
    private ChatScreen chatScreen;
    private Scanner input;

    public MessageReceptor(Scanner input, ChatScreen chatScreen){
        this.input = input;
        this.chatScreen = chatScreen;
    }


    @Override
    public void run() {
        while(this.input.hasNextLine()){
            String message = this.input.nextLine();
            this.chatScreen.addMessage(message);
        }
    }

}
