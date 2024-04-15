package Clase.Fumadores;

import java.util.HashSet;

public class Mesa {

    HashSet<Ingredientes> ingredientes = new HashSet<>();

    public synchronized void posarIng(Ingredientes i1, Ingredientes i2){
        ingredientes.add(i1);
        ingredientes.add(i2);
    }
    
    public synchronized void retirarIng (){
        ingredientes.clear();
    }


}
