package Clase.Fumadores;



public class Agente extends Thread{
    Mesa mesa;

    public Agente(Mesa mesa){
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while (true) {
            Ingrediente i1 = Ingrediente.get();
            Ingrediente i2 = Ingrediente.get();
            while (i1 == i2) {
                i2 = Ingrediente.get();
                mesa.posarIng(Ingrediente.get(), Ingrediente.get());
                
            }
        }
    }
    
}
