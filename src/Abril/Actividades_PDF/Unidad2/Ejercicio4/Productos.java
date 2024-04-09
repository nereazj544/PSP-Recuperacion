package Abril.Actividades_PDF.Unidad2.Ejercicio4;

public class Productos {
    int idP;
    int v;
    String ptipos;

    public String getPtipos() {
        return ptipos;
    }

    public Productos(int idP, int v, String ptipos ){
        this.idP = idP;
        this.v = v;
        this.ptipos = ptipos;
    }

    public int getIdP() {
        return idP;
    }

    public int getV() {
        return v;
    }

    @Override
    public String toString() {
        return "Productos [idP=" + idP + ", v=" + v + "]";
    }
    

}
