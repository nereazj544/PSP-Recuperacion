package Abril.Actividades_PDF.Unidad2.Ejercicio4;

import java.util.ArrayList;
import java.util.List;

public class Almacen2 <T> implements Almacen<T>{

    private List<T> almacen;
    int capacidad;
    int contador;

    public Almacen2(int capacidad){
        this.capacidad = capacidad;
        this.almacen = new ArrayList<>(capacidad);
        this.contador = 0;
        
    }

    @Override
    public synchronized void almacenar(T producto) {
        while (almacen.size() == capacidad) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        almacen.add(producto);

    }

    @Override
    public synchronized T retirar() {
        while (almacen.isEmpty()) {
            try {
                wait();
            } catch (Exception e) {
                // TODO: handle exception
            }
            
        }
        T producto = almacen.remove(almacen.size() -1);
        return producto;
    }
    
}
