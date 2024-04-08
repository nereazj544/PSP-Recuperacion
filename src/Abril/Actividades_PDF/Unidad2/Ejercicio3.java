package Abril.Actividades_PDF.Unidad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Ejercicio3
 * 
 * Crear un programa que reciba a través de sus argumentos una lista de ficheros
 * de texto y cuente cuántas líneas, palabras y caracteres hay en cada fichero,
 * así como en el total entre todos los ficheros.
 * El programa recibirá un argumento adicional que indique si los ficheros se
 * procesarán de forma secuencial o en paralelo usando hilos.
 * 
 * Se considera como palabra cualquier cadena descrita por la expresión
 * \p{Alpha}+.
 * El programa medirá el tiempo que emplea en procesar los ficheros. Usar esa
 * información para comparar la velocidad de proceso de la versión secuencial
 * con la velocidad de proceso de la versión concurrente.
 */
public class Ejercicio3 {
    public static void main(String[] args) throws InterruptedException{
        long start = System.currentTimeMillis();

        if (args.length == 0) {
            System.out.println("DATOS MAL INTRODUCIDOS");
        }

        Thread []  t = new Thread[args.length];

        for (int i = 0; i < args.length; i++) {
            Tarea tr = new Tarea(args[i]);
            t[i]=new Thread(tr);
            t[i].start();
        }

        for (Thread thread : t) {
            thread.join();
        }

        long end = System.currentTimeMillis();

        long time = end - start;
        System.out.println("TOTAL : " + time + " ms");
    }

    public static class Tarea implements Runnable {

        private final String file;

        public Tarea(String file) {
            this.file = file;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(file))) {

                // Contadores
                int L = 0;
                int P = 0;
                int C = 0;

                String linea;

                while ((linea = br.readLine()) != null) {
                    L++;

                    String[] ArrayWords = linea.split("\\p{Alpha}+");
                    P += ArrayWords.length - 1;
                    C += linea.length();
                }
                System.out.println("Nombre del fichero: " + file + "\n Lineas: " + L + ", Palabras: " + P + ", Caracteres: " + C + "\n");
            } catch (Exception e) {}
        }

    }


}