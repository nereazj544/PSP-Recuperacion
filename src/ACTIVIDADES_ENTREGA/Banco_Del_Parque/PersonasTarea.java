package ACTIVIDADES_ENTREGA.Banco_Del_Parque;

import static ACTIVIDADES_ENTREGA.Fumadores.Fork.Main.actualizar;

import java.util.concurrent.Semaphore;

public class PersonasTarea extends Thread {
    private Banco banco;
    private Semaphore semaphore;
    private boolean p = false;

    public PersonasTarea(String name, Banco banco, Semaphore semaphore) {
        super(name);
        this.banco = banco;
        this.semaphore = semaphore;
    }

    public synchronized void pausar() {
        p = true;
    }

    public synchronized void reanudar() {
        p = false;
        notify();
    }

    @Override
    public void run() {
        while (!isInterrupted()) {
            synchronized (this) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    return;
                }
            }
        }

        try {
            semaphore.acquire();

            if (banco.ocupar()) {
                actualizar(getName() + " ocupo");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    return;
                }

                banco.liberar();
                actualizar(getName() + " ha liberado");
            } else {
                actualizar(getName() + " no pudo ocupar una plaza");
            }
        } catch (Exception e) {
            return;
        }
        semaphore.release();
    }
}
