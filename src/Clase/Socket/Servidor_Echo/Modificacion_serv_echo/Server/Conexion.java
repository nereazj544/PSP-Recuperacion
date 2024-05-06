package Clase.Scoket.Modificacion_serv_echo.Server;

import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class Conexion {
    private Socket socket;
    private Almacen Almacen;
    private Emisor emisor;
    private Recpetor recpetor;

    public Conexion(Socket socket, ExecutorService service) {
        this.socket = socket;
    }

    public void Finalizar() {
        //! El repcetor es el que finalizara la conexion

        //TODO: EL RECPTROR TIENE QUE INVOCAR ESTE METODO

    }

}
