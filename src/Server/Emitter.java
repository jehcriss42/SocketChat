package Server;

import java.io.PrintStream;

public class Emitter {
    private String ip;

    private PrintStream output;

    public Emitter(String ip,PrintStream output){
        this.ip = ip;
        this.output = output;
    }

    public void Sent(String message){

        this.output.println("IP : " + ip + message);
    }

    public String getIp() {

        return ip;
    }

    public void setIp(String ip) {

        this.ip = ip;
    }

}
