package ACTIVIDADES_ENTREGA.Unidad3.VersionesEcho.v3B.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ServidorEcho {

	public static void main(String[] args) throws IOException {
		try (ServerSocket serverSocket = new ServerSocket(5000)) {
			Almacen almacen = new Almacen();
			ExecutorService executor = Executors.newFixedThreadPool(1000);
			Lock lock = new ReentrantLock();
			Condition c = lock.newCondition();

			System.out.println("Servidor ECHO escuchando en puerto 5000");
			while (true) {
				Socket socket = serverSocket.accept();
				executor.submit(new Receptor(socket, almacen, executor, lock, c));
			}
		}
	}
}
