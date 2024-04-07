package Abril.Unidad2.Actividades;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Actividad5
 */
public class Actividad5 {
    private static final Pattern word = Pattern.compile("\\p{L}+");

    public static void main(String[] args) throws Exception {
        if (args.length != 2) {
            System.err.println("Error al meter los parametos");
            System.exit(1);
        }

        String ruta = args[0];
        String indicador = args[1];

        if (!ruta.endsWith("/")) {
            ruta += "/";
        }
        if (!indicador.equals("S") && !indicador.equals("C")) {
            System.err.println("NO VALIDO: " + indicador);
        }

        long star = System.currentTimeMillis(); // Se inicia el crono

        if (indicador.equals("S")) {
            Secu(ruta);
        } else {
            Con(ruta);
        }

        long end = System.currentTimeMillis(); // Detenemos el crono
        long timetotal = end - star; // Caculamos el tiempo total

        System.out.println("Tiempo empezado: " + star + "ms. \n" +
                "Tiempo acabado: " + end + "ms. \n" +
                "Tiempo total: " + timetotal);
    }

    private static void Secu(String ruta) throws Exception {
        File[] files = new File(ruta).listFiles(); // Se obtiene la lista de los archivos de la carpeta

        for (File file : files) {
            // Comprobamos que sea un fichero de texto, comprobando que termina con ".txt"
            if (file.isFile() && file.getName().endsWith(".txt")) {
                Path p = Paths.get(file.getPath()); // Se obtine la ruta

                long lineas = Files.lines(p).count(); // Contamos las lineas

                // Conteo de las palabras y caracteres
                long words = 0;
                long character = 0;

                // leer con Scanner
                try (Scanner sc = new Scanner((file))) {
                    // Se recorren las lineas
                    while (sc.hasNextLine()) {
                        String linea = sc.nextLine(); // Se lee la sieguetne liena

                        character += linea.length(); // Actualizamos el contador de los caracteres

                        Matcher m = word.matcher(linea); // Se crea el matcher para buscar palabras en la linea

                        // Se recorren las palabras de la linea
                        while (m.find()) {
                            // Se actualiza el contador de palabras
                            words++;
                        }

                    }
                    System.out.printf("%s: lineas=%d, palabras= %d, caracteres%d\n", file.getName(), lineas, words,
                            character);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }
    }

    private static void Con(String ruta) throws Exception {
        ExecutorService eService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        File[] files = new File(ruta).listFiles();
        for (File file : files) {
            if (file.isFile() && file.getName().endsWith(".txt")) {

                // Se envia una tarea al pool threas para procesar el fichero
                eService.submit(() -> {
                    try {
                        Path p = Paths.get(file.getPath()); // Obtenemos la ruta

                        long l = Files.lines(p).count();

                        long words = 0;
                        long character = 0;

                        try (Scanner sc = new Scanner(file)) {
                            while (sc.hasNextLine()) {
                                String linea = sc.nextLine();

                                character += linea.length();

                                Matcher m = word.matcher(linea);

                                while (m.find()) {
                                    words++;
                                }
                            }
                        }

                        System.out.printf("%s: lineas=%d, palabras= %d, caracteres%d\n", file.getName(), l, words,
                                character);

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
            }
        }

        //Finalizamos las tareas
        eService.shutdown();
        eService.awaitTermination(Long.MAX_VALUE, TimeUnit.MILLISECONDS);
    }

}