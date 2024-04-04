package Abril.Unidad2.Ejemplos;

public class Ejemplo2 implements Runnable {

    public void run() {
        for (int i = 0; i <= 5; i++) {
            try {
                Thread.sleep(100);
                // Se duerme el hilo durante 100 milisegundos
            } catch (InterruptedException e) {
            }
            // Se imprime un mensaje con el nombre del hilo y nº del mensaje.
            System.out.printf("%s, mensaje %d\n", Thread.currentThread().getName(), i);
        }
    }

    public static void main(String[] args) {
        //Objeto runnable a partir de la clase ejemplo 2
        Runnable r = new Ejemplo2();
        for (int i = 0; i <= 3; i++) {
            new Thread(r, "Hilo " + i).start();
        }
    }
}
