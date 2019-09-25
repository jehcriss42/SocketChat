package Server;

import java.util.Scanner;

public class Receptor implements Runnable {
    private Scanner input;
    private Distributor distributor;

    public Receptor(Scanner input, Distributor distributor){
        this.input = input;
        this.distributor = distributor;
    }

    @Override
    public void run() {
        while(this.input.hasNextLine()){
            String message = this.input.nextLine();
            this.distributor.distribuiMensagem(message);
        }

    }

}
