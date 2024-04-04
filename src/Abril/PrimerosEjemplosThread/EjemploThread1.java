package Abril.PrimerosEjemplosThread;

/**
 * EjemploThread1
 */
public class EjemploThread1 {
    public static void main(String[] args) throws InterruptedException {
        // Forma de crear un Hilo
        // Thread t = new Thread();
        // t.start();
        // ! No se ejecuta nada

        // ! Arrays de Hilos

        Thread[] t = new Thread[10]; // Indicamos el n de arrays.
        for (int i = 0; i < t.length; i++) {
            t[i] = new Hilo(); //! Se hace referencia al objeto Hilo.
        }
        for (int i = 0; i < t.length; i++) {
            t[i].start(); // Esto hara que el hilo empiece a carrular
        }
        for (int i = 0; i < t.length; i++) {
            t[i].join();
            // Hace que el hilo espere, el "Join" en este caso solo afecta al main.
        }
        // while(true);
        // Bucle infinito

    }

}

class Hilo extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Id del hilo: " + getId() +
                    "\nNombre del hilo: " + getName() + " - " + i);
            try {
                Thread.sleep(100);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

    }

}