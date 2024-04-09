package Abril.Actividades_PDF.Unidad2.Ejercicio4;

public class Consumidores extends Thread{
    private final Almacen<Productos> almacen;
    private int id;

    public Consumidores(Almacen<Productos> almacen, int id){
        this.almacen = almacen;
        this.id = id;
    }

    @Override
    public void run(){
        try {
            Productos productos = almacen.retirar();
            consumirProducto(productos);
            System.out.println("Consumidor " + id + " ha consumido: " + productos);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    private void consumirProducto(Productos productos) {
    switch (productos.getPtipos()) {
        case "Alimentos":
            System.out.println("Consumidor: " + id + " ha consumido el alimento: " + productos);
            break;
            case "Bebidas":
            System.out.println("Consumidor: " + id + " ha consumido la bebida: " + productos);
            break;
        default:
            break;
    }
    }


}
