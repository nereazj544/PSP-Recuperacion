package ACTIVIDADES_ENTREGA.Unidad3.ServidorEco.ReaderWriter.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Clase.Socket.TareaRespuesta;

public class Server {
    public static void main(String[] args) throws IOException {
		ServerSocket serverSocket = new ServerSocket(5000);
		ExecutorService executor = Executors.newFixedThreadPool(100);
		System.out.println("Servidor escuchando en el puerto 5000");
		while (true) {
			Socket socket = serverSocket.accept();
			executor.execute(new TareaRespuesta(socket));
		}
        
    }
}
