package ACTIVIDADES_ENTREGA.Banco_Del_Parque;

import static ACTIVIDADES_ENTREGA.Fumadores.Fork.Main.actualizar;



public class PersonaTarea extends Thread {
    private Banco b;

    private long paseo;
    private long sentado;

    // private JTextArea textArea;

    public PersonaTarea(String name, Banco b) {
        super(name);
        this.b = b;
        // this.textArea = textArea;
        this.paseo = (long) ((Math.random() * 1000000) % 2001 + 100);
        this.sentado = (long) ((Math.random() * 1000000) % 6001 + 100);
    }

    @Override
    public void run() {
        try {
           actualizar(getName() + " llego al banco");
            Thread.sleep(paseo);
            b.sentarse();
            actualizar(getName() + " sento al banco");
            Thread.sleep(sentado);
            b.levantarse();
            actualizar(getName() + " se ha ido del banco");

        } catch (Exception e) {
        }
    }

}
