package Abril.Unidad2.Ejemplos;

public class Ejemplo4 {
    public static void main(String[] args) throws InterruptedException{
        Thread thread = new Thread("Cuenta atras"){
            @Override
            public void run(){
                for (int i = 5; i >= 0; i--) {
                    System.out.println(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                    }
                }
                System.out.println("End Thread");
            }
        };
        thread.start();

        // ! Punto clave del programa
        // Con este metodo espera a que finalice el hilo, antes de continuar con la ejecucion del metodo main.
        thread.join();
        
        System.out.println("Main End");
    }
}
