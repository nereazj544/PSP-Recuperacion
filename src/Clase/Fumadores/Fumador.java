package Clase.Fumadores;

public class Fumador extends Thread{
    Ingrediente ingrediente;
    Mesa mesa;

    // String ingredientes;

    // Constructor:
    public Fumador(Ingrediente ingrediente, Mesa mesa) {
        this.ingrediente = ingrediente;
        this.mesa = mesa;
    }

    @Override
    public void run() {
        //Dentro de este metodo ponemos las tareas
        //Esta simulacin se ejecutara de forma indefinida

        while (true) {
            mesa.retirarIng(ingrediente); //va a retirar los dos que le faltan
            try {
                sleep(1000);
            } catch (InterruptedException e) {}
        }

    }
    

}
