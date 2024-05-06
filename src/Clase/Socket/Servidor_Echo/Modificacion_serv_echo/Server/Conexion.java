package Clase.Scoket.Modificacion_serv_echo.Server;

import java.net.Socket;
import java.util.concurrent.ExecutorService;

public class Conexion{
    private Socket socket;
    private Almacen Almacen;


    public Conexion(Socket socket, ExecutorService service) {
        this.socket = socket;
    }



}
