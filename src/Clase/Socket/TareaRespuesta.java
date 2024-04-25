package Clase.Scoket;

import java.net.Socket;

public class HiloRespuesta implements Runnable{

    private Socket socket;
    

    public HiloRespuesta(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        
    }
    
}
