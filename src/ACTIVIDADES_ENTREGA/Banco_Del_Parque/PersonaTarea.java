package ACTIVIDADES_ENTREGA.Banco_Del_Parque;

import javax.swing.JTextArea;

public class PersonaTarea extends Thread {
    private Banco b;

    private long paseo;
    private long sentado;

    private JTextArea textArea;

    public PersonaTarea(String name, Banco b, JTextArea textArea) {
        super(name);
        this.b = b;
        this.textArea = textArea;
        this.paseo = (long) ((Math.random() * 1000000) % 2001 + 100);
        this.sentado = (long) ((Math.random() * 1000000) % 6001 + 100);
    }

    @Override
    public void run() {
        try {
           textArea.append(getName() + " llego al banco");
            Thread.sleep(paseo);
            b.sentarse();
            textArea.append(getName() + " sento al banco");
            Thread.sleep(sentado);
            b.levantarse();
            textArea.append(getName() + " se ha ido del banco");

        } catch (Exception e) {
        }
    }

}
