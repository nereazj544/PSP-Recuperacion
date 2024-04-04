package Abril.Unidad2.Actividades;

public class Actividad1_1 extends Thread {
    //! Hilos con clase anonima
    public static void main(String[] args) {
        for (int i = 0; i <= 3; i++) {
            new Thread("hilo" + i){
                @Override
                public void run(){
                    for (int j = 0; j <=5; j++) {
                        try {
                            Thread.sleep(100);
        } catch (InterruptedException e) {}
            System.out.println(getName() + ", mensaje " + j);
                    }
                }
            }.start();
        
    }
    }
}
