package Abril.Unidad2.Ejemplos_Julio;

public class UnHilo_Ej1 extends Thread {
    public UnHilo_Ej1(int id) {
        super("hilo " + id);
    }

    @Override
    public void run() {
        for (int i = 1; i <= 5; i++) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
            }
            System.out.println(getName() + ", mensaje " + i);
        }
    }
}
