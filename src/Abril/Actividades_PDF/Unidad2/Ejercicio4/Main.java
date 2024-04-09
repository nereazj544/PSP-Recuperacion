package Abril.Actividades_PDF.Unidad2.Ejercicio4;

import Abril.Actividades_PDF.Unidad2.Ejercicio4.Almacen;

public class Main {
    public static void main(String[] args) {
        int capacidad = 10;
        int numPro = 5;
        int numCon = 5;

        Almacen <Productos> almacen = new Almacen2<>(capacidad);

        for (int i = 0; i < numCon; i++) {
            new Consumidores(almacen, i).start();
            
        }
        for (int i = 0; i < numPro; i++) {
            new Probedores(almacen, i).start();
        }
    }
}
