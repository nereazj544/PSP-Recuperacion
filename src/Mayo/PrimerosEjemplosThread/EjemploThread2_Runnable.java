package Mayo.PrimerosEjemplosThread;

public class EjemploThread2_Runnable {
    public static void main(String[] args) {
        Thread[] t = new Thread[10]; // Indicamos el n de arrays.
        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(new Tarea(), "Hilo " + i);
            // Se instancia el Thread y despues se pone el objoto de la tarea.
            if (i < 5) {
                t[i].setPriority(7);
            }
        }
        for (int i = 0; i < t.length; i++) {
            t[i].start(); // Esto hara que el hilo empiece a carrular
        }

    }
}

class Tarea implements Runnable {
    //Esta clase no es un hilo, es una Tarea. 

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - Hola Mundo! - " + i + " - " + Thread.currentThread().getPriority());

            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }

}

/*
 * otras movidas (no hacerle caso)
 * Thread [] tArrays = new Thread[10];
 * for(int i = 0; i < tArrays.length; i++)
 * tArrays[i] = new Thread(new Runnable() {
 * 
 * @Override
 * public void run() {
 * for (int i = 0; i < 5;
 * i++) { System.out.println("Hola Mundo!");
 * System.out.println(Thread.currentThread().getName() + " - Hola Mundo - " +
 * i); //La consola es un recurso compartido por lo que esta compartida //
 * try { // Thread.sleep(1); //El hilo duerme un segundo // }catch
 * (InterruptedException e) { // e.printStackTrace();} // ); //Se insatacia el
 * thread y luego la tarea // for (int i = 0; i < tArrays.length; i++) //
 * tArrays[i].start();
 * 
 * // !Con referencia a metodos
 * void tarea(){ for (int i = 0; i < 5; i++)
 * { System.out.println("Hola Mundo!");
 * System.out.println(Thread.currentThread().getName() + " - Hola Mundo - " +
 * i);
 * //La consola es un recurso compartido por lo que esta compartida
  * try {
 * Thread.sleep(100); //El hilo duerme un segundo
 * }catch
 * (InterruptedException e) {}
 * }
 * 
 * 
 * 
 */