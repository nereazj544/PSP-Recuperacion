package ACTIVIDADES_ENTREGA.Unidad3.VersionesEcho.v3B.Server;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Emisor implements Runnable {

	private Socket socket;
	private Almacen almacen;
	private final Lock lock;
	private final Condition c;

	public Emisor(Socket socket, Lock lock, Condition c, Almacen almacen) {
		this.socket = socket;
		this.almacen = almacen;
		this.lock = lock;
		this.c = c;
	}

	@Override
	public void run() {
		try {
			DataOutputStream out = new DataOutputStream(socket.getOutputStream());
			while (!Thread.currentThread().isInterrupted()) {
				lock.lock();
				try{

					String s = almacen.retirar();
					if (s != null)
					out.writeUTF(s);
				}finally{
					lock.unlock();
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(socket.getInetAddress() + ": FIN EMISOR");
	}

}
