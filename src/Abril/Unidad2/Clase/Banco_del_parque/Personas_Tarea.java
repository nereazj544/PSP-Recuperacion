package Abril.Unidad2.Clase.Banco_del_parque;

public class Personas_Tarea extends Thread {
    private Banco banco;
    //Estos valores tienen que ser aleatorios
    private long tpaseo;
    private long tsentado;

    public Personas_Tarea(Banco banco){
        this.banco = banco;
        //Hay más probabilidad de que salgan los numeros (Segun Julio).
        this.tpaseo = (long) ((Math.random() * 1000000) % 2001 + 100); 
        this.tpaseo = (long) ((Math.random() * 1000000) % 601 + 100); 
        
        // this.tpaseo = (int) (Math.random() * 2000 + 100);
        //Hay un metodo más facil que es con la clase random
    }

    @Override
    public void run() {
        try {
            Thread.sleep(tpaseo);
            banco.sentarse();
            
            Thread.sleep(tsentado);
            banco.levantarse();
        } catch (InterruptedException e) {
            
        }
    }
}
