package Clase.Scoket.Modificacion_serv_echo.V4.Server;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Recpetor implements Runnable {
    private Socket socket;
    private Almacen almacen;
    

    public Recpetor(Socket socket, Almacen almacen) {
        this.socket = socket;
        this.almacen = almacen;
    }

    @Override
    public void run() {
        try (Socket socket = this.socket ) {
            
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

}
