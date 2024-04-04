package Abril.Unidad2.Actividades;

import java.util.Scanner;

/**
 * Actividad1_2
 * Lectura por teclado
 */
public class Actividad1_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Numero de hilos: ");
        int numthread = sc.nextInt();

        System.out.println("Mensaje por hilo: ");
        int send = sc.nextInt();

        System.out.println("Tiempo de espera: ");
        int time = sc.nextInt();

        for (int i = 0; i < numthread; i++) {
            new lectura(i, send, time).start();
        }
        sc.close();
    }

}

class lectura extends Thread {
    int numthread;
    int time;

    public lectura(int id, int numthread, int time) {
        super("Hilo " + id);
        this.numthread = numthread;
        this.time = time;
    }

    @Override
    public void run() {
        for (int i = 0; i <= numthread; i++) {
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + ", mensaje " + i);
        }
    }

}