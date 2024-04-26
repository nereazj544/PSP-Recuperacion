package ACTIVIDADES_ENTREGA.Banco_Del_Parque;

public class Banco {
    private int plazaslibres;

    public Banco(int plazas) {
        plazaslibres = plazaslibres;
    }

    public synchronized void sentarse(){
        while (plazaslibres == 0) {
            try {
                System.out.println(Thread.currentThread().getName() + " esperando");
                wait();
            } catch (InterruptedException e) {}

            plazaslibres--;
        }
    }

    public synchronized void levantarse(){
        plazaslibres++;
        notify();
    }
}
