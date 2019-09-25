package Client;

import java.io.PrintStream;

public class MessageEmitter {
    private PrintStream output;

    public MessageEmitter(PrintStream output){

        this.output = output;
    }

    public void sent(String message){

        this.output.println(message);
    }

}
