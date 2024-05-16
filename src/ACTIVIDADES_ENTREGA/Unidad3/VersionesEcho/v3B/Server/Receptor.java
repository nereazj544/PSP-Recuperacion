package ACTIVIDADES_ENTREGA.Unidad3.VersionesEcho.v3B.Server;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Receptor implements Runnable {

	private Socket socket;
	private Almacen almacen;
	private Future<?> emisor;

	private final Lock lock = new ReentrantLock();
	private final Condition c = lock.newCondition();
	public Receptor(Socket socket, Almacen almacen, ExecutorService executor, Lock lock, Condition c) {
		this.socket = socket;
		this.almacen = almacen;
		emisor = executor.submit(new Emisor(socket, lock, c, almacen));
	}

	@Override
	public void run() {
		try {
			socket.setSoTimeout(5);
			DataInputStream in = new DataInputStream(socket.getInputStream());
			String s;
			while (true) {
				s = in.readUTF();
				System.out.println(socket.getInetAddress() + " -> " + s);
				try {
					almacen.almacenar(s);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				lock.lock();
				try{
					c.signalAll();
				}finally{
					lock.unlock();
				}
			}
		} catch (EOFException e) {
			System.out.println(socket.getInetAddress() + ": EOF");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			emisor.cancel(true);
			if (!emisor.isDone())
				try {System.out.println(socket.getInetAddress() + ": CONEXIÓN FINALIZADA");
					emisor.get();
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println(socket.getInetAddress() + ": CONEXIÓN FINALIZADA");
		}
	}

}
