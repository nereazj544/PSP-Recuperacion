package Abril.Unidad2.Ejemplos;

public class Mianej2 {
        public static void main(String[] args) {
            Runnable r = new Ejemplo2();
            for (int i = 0; i < args.length; i++) {
                new Thread(r, "Hilo " + i).start();
            }
        }
    }
    

