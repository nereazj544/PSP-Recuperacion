package Abril.Actividades_PDF.Unidad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.PublicKey;

/**
 * Ejercicio3_secuencial_thread
 */
public class Ejercicio3_secuencial_thread {

    public static class Tarea implements Runnable {

        String file;

        public Tarea(String file) {
            this.file = file;
        }

        @Override
        public void run() {
            try (BufferedReader r = new BufferedReader(new FileReader(file))) {

                int l = 0;
                int p = 0;
                int c = 0;

                String linea;

                while ((linea = r.readLine()) != null) {
                    l++;
                    String[] parray = linea.split("\\p{Alpha}+");

                    p += parray.length - 1;
                    c += linea.length();

                }

                System.out.println("Nombre del fichero: " + file + "\n Lineas: " + l + ", Palabras: " + p
                        + ", Caracteres: " + c + "\n");

            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        // ! END TAREA
    }

    public static void main(String[] args) throws InterruptedException {
        if (args.length == 0) {
            System.out.println("DATOS NO CORRECTOS");
        }

        long start = System.currentTimeMillis();

        int LineasT = 0;
        int PalaT = 0;
        int CaraT = 0;

        Thread[] t = new Thread[args.length];

        for (int i = 0; i < args.length; i++) {
            Tarea tarea = new Tarea(args[i]);
            t[i] = new Thread(args[i]);
            t[i].start();
        }

        for (Thread thread : t) {
            thread.join();
        }

        long end = System.currentTimeMillis();
        long total = end-start;

        System.out.println("\n- Totales:");
    System.out.println("- Lineas: " + LineasT);
    System.out.println("- Palabras: " + PalaT);
    System.out.println("- Caracteres: " + CaraT);
    System.out.println("\nTiempo total: " + total + " ms.");
        // !END MAIN
    }
}