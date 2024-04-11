package Abril.Unidad2.Clase.Banco_del_parque;

public class Parque {

    public static void main(String[] args) {
        Banco banco;
        Personas_Tarea[] personas;
        

    }

}

/*
 * Los metodos "wait", "sleep" los deja en modo de espera
 * Hay dos:
 * wait()
 * wait(ms) (despues de el tiempo de espera, no hace falta usar notify)
 * relacionados con estos dos metodos: notify (notifica a otro) y notifyAll
 * (notifica a todos) (comunicacion entre hilos).
 * Notifican el estado en el que tienen que estar. Esta es la unica comunicacion
 * que exite entre hilos.
 * ! Solo se pueden ejecutar el monitor.
 * Pueden invocarlo cual quierer objeto, solo se pueden invocar en una sececion
 * critica y con el monitor.
 */