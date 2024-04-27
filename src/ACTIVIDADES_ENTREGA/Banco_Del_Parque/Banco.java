package ACTIVIDADES_ENTREGA.Banco_Del_Parque;
import static ACTIVIDADES_ENTREGA.Fumadores.Fork.Main.actualizar;

public class Banco {
    private int plazaslibres;
    private boolean pausado;

    public Banco(int plazas) {
        plazaslibres = plazaslibres;
    }

    public synchronized void pausar(){
        pausado=true;
    }

    public synchronized void reanudar(){
        pausado=false;
        notifyAll();
    }



    public synchronized void sentarse(){
        while (plazaslibres == 0) {
            try {
                actualizar(Thread.currentThread().getName() + " esperando");
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
