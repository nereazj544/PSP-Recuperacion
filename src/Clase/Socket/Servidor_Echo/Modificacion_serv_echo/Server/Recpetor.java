package Clase.Scoket.Modificacion_serv_echo.Server;

import java.net.Socket;

public class Recpetor implements Runnable {
    private Socket socket;

    public Recpetor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}
