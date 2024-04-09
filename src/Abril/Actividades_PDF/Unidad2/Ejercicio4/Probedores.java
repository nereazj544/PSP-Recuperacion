package Abril.Actividades_PDF.Unidad2.Ejercicio4;

public class Probedores extends Thread {
    private final Almacen<Productos> almacen;
    int id;

    public Probedores(Almacen<Productos> almacen, int id) {
        this.almacen = almacen;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Productos productos = producir(); // Produce
                almacen.almacenar(productos); // Almacena
                System.out.println("Proveedor " + id + " ha almacenado: " + productos);
            } catch (Exception e) {

            }
        }
    }

    private Productos producir() {
        String [] ptipos ={"Alimentos", "Bebidas"};
        int TipoRandom = (int) (Math.random() * ptipos.length);
        return new Productos(id, (int) (Math.random() * 100), ptipos[TipoRandom]);
    }

}
