package Clase.Fumadores;

import java.util.HashSet;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Mesa {
    // Monitor ⤴️

    // Recurso compartido ⬇️
    HashSet<Ingrediente> ingredientes = new HashSet<>();

    // Anulamos la recurrencia a los metodos.
    public synchronized void posarIng(Ingrediente i1, Ingrediente i2) {
        while (!ingredientes.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        ingredientes.add(i1);
        ingredientes.add(i2);
        System.out.println("Se ha colocado: " + i1 + " y " + i2);
        notifyAll();
    }
    
    public synchronized void retirarIng(Ingrediente i) {
        System.out.println("FUMADOR RETIRA");
        while (ingredientes.isEmpty() || ingredientes.contains(i)) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        System.out.println("El fumador a retirado " + 
        ingredientes.stream().map(j -> j.toString()).collect(Collectors.joining(" y ")));
        ingredientes.clear();
        notifyAll();
    }
}
