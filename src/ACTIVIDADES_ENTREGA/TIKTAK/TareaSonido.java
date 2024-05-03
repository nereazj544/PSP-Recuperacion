package ACTIVIDADES_ENTREGA.TIKTAK;

import java.util.concurrent.Semaphore;

public class TareaSonido implements Runnable{
    private String sonido;
    private Semaphore semaphore;
    private Semaphore semaphore2;

    public TareaSonido(String sonido, Semaphore semaphore, Semaphore semaphore2) {
        this.sonido = sonido;
        this.semaphore = semaphore;
        this.semaphore2 = semaphore2;
    }

    @Override
    public void run() {
       try {
           semaphore.acquire();
           System.out.println(sonido + " ");
           Thread.sleep(1000);
    } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }finally{
        semaphore2.release();
    }
    }

    
}
