package Abril.Actividades_PDF.Unidad2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

/**
 * Ejercicio3_secuencial
 * 
 * No se crean hilos en un programa secuencial. No es necesita la clase Thread.
 * 
 */
public class Ejercicio3_secuencial {
    public static void main(String[] args) {
        
        long star = System.currentTimeMillis();

        if (args.length== 0) {
            System.out.println("DATOS INCORRECTOS");
        }

        int Lineas = 0;
        int Palabras = 0;
        int Caracteres = 0;

        for (String file : args) {
            try (BufferedReader r = new BufferedReader(new FileReader(file))) {

                int linea = 0;
                int palabras = 0;
                int caractere = 0;

                String l;

                while ((l = r.readLine()) != null) {
                    linea++;
                    String [] a= l.split("\\p{Alpha}+");
                    palabras += a.length - 1;

                    caractere += l.length();
                }

                Lineas += linea;
                Palabras += palabras;
                Caracteres += caractere;

                System.out.println("Nombre del fichero: " + file + "\n Lineas: " + linea + ", Palabras: " + palabras + ", Caracteres: " + caractere + "\n");
                
            } catch (Exception e) {
                // TODO: handle exception
            }
        }

        long end = System.currentTimeMillis();
        long time = end - star;

        System.out.println("TOTAL : " + time + " ms");

    }
    
}