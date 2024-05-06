package Clase.Socket.Servidor_Echo.Modificacion_serv_echo.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.LinkedList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;



/**
 * Server
 */

 public class Server {

	public static LinkedList<Conexion> conexions = new LinkedList<>();
public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(5000);
		ExecutorService executor = Executors.newFixedThreadPool(100);
		while (true) {
			Socket socket = serverSocket.accept();
			conexions.add (new Conexion(socket, executor));
			// c.add(new Conexion(socket, executor));
			
		}
	}
}