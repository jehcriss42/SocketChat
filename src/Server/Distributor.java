package Server;

import java.util.ArrayList;

public class Distributor {
    private ArrayList<Emitter> emiters = new ArrayList<>();

    public void adicionaEmissor(Emitter emissor){

        this.emiters.add(emissor);
    }

    public void distribuiMensagem(String message){
        for(Emitter emissor : this.emiters){
            emissor.Sent("IP : " + emissor.getIp() + message);
        }
    }


}
