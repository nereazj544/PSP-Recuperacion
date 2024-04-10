package Abril.Actividades_PDF.Unidad2;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Ejercicio3_Secuencial_2
 */
public class Ejercicio3_Secuencial_2 {

    private static class Tarea {
        String file;

        public Tarea(String file) {
            this.file = file;
        }

        public void run(){
            try (BufferedReader r = new BufferedReader(new FileReader(file))) {
                
                int L = 0; //Lineas
                int W = 0; //Palabras
                int C = 0; //Caracteres

                String linea;

                while ((linea = r.readLine()) != null) {
                    L++;

                    String [] s = linea.split("\\p{Alpha}+");

                    W += s.length - 1;
                    C += linea.length();
                }
                System.out.println("Nombre del fichero: " + file + "\n Lineas: " + L + ", Palabras: " + W
                + ", Caracteres: " + C + "\n");
            } catch (Exception e) {
            
            }
        }

        // End Tarea
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("DATOS NO AÑADIDOS CORRECTAMENTE");
        }

        long e = System.currentTimeMillis(); //Empezar tiempo

        for (String arg : args) {
            Tarea t = new Tarea(arg);
            t.run();
        }

        long tr = System.currentTimeMillis(); //Terminar
        long T = tr - e; //Total = Terminado - empezado

        System.out.println("Tiempo total: " + T + " ms.");
    }

    // End program
}
