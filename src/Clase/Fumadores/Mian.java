package Clase.Fumadores;

public class Mian {
    public static void main(String[] args) {
        Mesa mesa = new Mesa();
        Agente agente = new Agente(mesa);
        Fumador f1 = new Fumador(Ingrediente.TABACO, mesa);
        Fumador f2 = new Fumador(Ingrediente.CERILLAS, mesa);
        Fumador f3 = new Fumador(Ingrediente.PAPEL, mesa);
        f1.start();
        f2.start();
        f3.start();
        agente.start();
        
    }
}
