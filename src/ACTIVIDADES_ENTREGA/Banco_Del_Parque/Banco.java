package ACTIVIDADES_ENTREGA.Banco_Del_Parque;

public class Banco {

    private int Disponible;
    

    public Banco(int disponible) {
        Disponible = disponible;
    }



    public synchronized boolean ocupar() {
        if (Disponible > 0) {
            Disponible--;
            return true;
        }
        return false;
    }

    public void liberar() {
        Disponible++;
    }

}
