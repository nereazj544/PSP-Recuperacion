package Abril.Actividades_PDF.Unidad2;

import java.io.BufferedReader;
import java.io.FileReader;

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

public class Ejercicio3_2 {

    private static class Tarea implements Runnable {

        // Definir la variable donde estara el archivo a mirar
        private final String f;

        public Tarea(String f) {
            this.f = f;
        }

        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new FileReader(f))) {
                //Contadores

                int Lines = 0;
                int Words = 0;
                int charas = 0;
                
                String line;
                while ((line = br.readLine()) != null) {
                    Lines++;
                    String [] m = line.split("\\p{Alpha}+");
                    Words += m.length -1;
                    charas += line.length();
                }
                System.out.println("- Nombre del fichero: "+ f + "\n"
                + "- Lineas: " + Lines + "\n" +
                "- Palabras: " + Words + "\n"
                + "- Caracteres: " + charas);
            } catch (Exception e) {
                
            }
        }

    }

    public static void main(String[] args) throws InterruptedException {

        if (args.length == 0) {
            System.err.println("ERROR, DATOS INTRODUCCIDOS DE MANERA ERRONIA");
        }

        long star = System.currentTimeMillis();
        
        Thread [] t = new Thread[args.length];

        for (int i = 0; i < args.length; i++) {
            Tarea tr = new Tarea(args[i]);
            t[i]=new Thread(tr);
            t[i].start();
        }

        for (Thread thread : t) {
            thread.join();
        }

        long end = System.currentTimeMillis();
        long tiempo = end - star;
        System.err.println("Tiempo Final: " + tiempo + " ms.");

    }

}
