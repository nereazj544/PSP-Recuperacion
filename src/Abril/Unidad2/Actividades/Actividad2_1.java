package Abril.Unidad2.Actividades;

import java.util.Scanner;

public class Actividad2_1 implements Runnable {
int numMe;
int time;

    public Actividad2_1(int numMe, int time) {
        this.numMe = numMe;
        this.time = time;
    }

    public void run() { 
        try{
            for (int i = 0; i <= numMe; i++) {
                System.out.printf("Hilo %s, mensaje %d\n", Thread.currentThread().getName(), i);
                Thread.sleep(time);
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Numero de hilos: ");
        int numthread = sc.nextInt();

        System.out.println("Mensaje por hilo: ");
        int send = sc.nextInt();

        System.out.println("Tiempo de espera: ");
        int time = sc.nextInt();
        for (int i = 0; i < numthread; i++) {
            Thread t = new Thread(new Actividad2_1(numthread, time));
            t.setName("hilo " + (i +1));
            t.start();
        }
        sc.close();
    }
}
