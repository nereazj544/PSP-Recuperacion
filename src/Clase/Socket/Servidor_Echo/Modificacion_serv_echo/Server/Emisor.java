package Clase.Socket.Servidor_Echo.Modificacion_serv_echo.Server;

import java.net.Socket;

public class Emisor implements Runnable {
    private Socket socket;

    public Emisor(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}
