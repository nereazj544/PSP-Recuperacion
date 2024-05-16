package ACTIVIDADES_ENTREGA.Unidad3.VersionesEcho.v3B.Server;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Almacen {

	private LinkedList<String> almacen = new LinkedList<>();
	private static final int MAX = 1000;
	
	private final Lock lock = new ReentrantLock();
	private final Condition c = lock.newCondition();

	public synchronized void almacenar(String s) throws InterruptedException {
		lock.lock();
		try{
			while (almacen.size() == MAX)
				try {
					c.await();
				} catch (InterruptedException e) {}
			almacen.offer(s);
			c.signalAll();
		}finally{
			lock.unlock();
		}

	}
	
	public synchronized String retirar() {
		try {
			while (almacen.isEmpty())
				c.await();
			String s = almacen.poll();
			c.signalAll();
			return s;
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
			return null;
		}finally{
			lock.unlock();
		}
	}
}
