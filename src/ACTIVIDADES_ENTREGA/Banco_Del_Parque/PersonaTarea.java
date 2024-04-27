package ACTIVIDADES_ENTREGA.Banco_Del_Parque;

public class PersonaTarea extends Thread {
    private Banco b;
    private long paseo;
    private long sentado;

    public PersonaTarea(String name, Banco b) {
        super(name);
        this.b = b;
        this.paseo = (long) ((Math.random() * 1000000) % 2001 + 100);
        this.sentado = (long) ((Math.random() * 1000000) % 6001 + 100);
    }

    @Override
    public void run() {
        try {
            Main.actualizar(getName() + " llego al banco");
            Thread.sleep(paseo);
            b.sentarse();
            Main.actualizar(getName() + " sento al banco");
            Thread.sleep(sentado);
            b.levantarse();
            Main.actualizar(getName() + " se ha ido del banco");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
