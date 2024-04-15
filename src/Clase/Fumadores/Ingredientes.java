package Clase.Fumadores;

//No es obligatorio crear los emun
public enum Ingredientes {
    TABACO, PAPEL, CERILLAS;

    public Ingredientes get(){
        return values()[(int) ((Math.random() * 1000000) % values().length)];
    }

    //valores restringidos y ingredientes aleatorios
    //el metodo values esta dentro del metodo run
}


