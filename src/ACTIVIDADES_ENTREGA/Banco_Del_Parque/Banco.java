package ACTIVIDADES_ENTREGA.Banco_Del_Parque;

public class Banco {
    private int plazaslibres;
    private boolean pausado;

    public Banco(int plazas) {
        plazaslibres = plazas;
    }

    public synchronized void pausar() {
        pausado = true;
    }

    public synchronized void reanudar() {
        pausado = false;
        notifyAll();
    }

    public synchronized void sentarse() {
        while (plazaslibres == 0 || pausado) {
            if (pausado) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            plazaslibres--;
        }
    }

    public synchronized void levantarse() {
        plazaslibres++;
        notify();
    }
}
