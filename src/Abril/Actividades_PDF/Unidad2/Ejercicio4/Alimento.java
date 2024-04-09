package Abril.Actividades_PDF.Unidad2.Ejercicio4;

public class Alimento extends Productos{
    public Alimento(int idP, int v, String ptipos) {
        super(idP, v, ptipos);

    }

    String ptipo="Alimento";

    public String getPtipo() {
        return ptipo;
    }
    
}
