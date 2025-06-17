package Panaderia;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        //creamos el "pool" de hilos
        ExecutorService executor = Executors.newFixedThreadPool(5);
        //agregamos los hilos al pool
        //si agregamos mas de 5, solo esos 5 pueden hacerlo simultaneo, los demas tienen que esperar
        executor.submit(new Panadero());
        executor.submit(new Panadero());
        executor.submit(new Panadero());
        executor.submit(new Panadero());
        executor.submit(new Panadero());

        // ya no agregamos
        executor.shutdown();

        //esperamos a que terminen
        try {
            executor.awaitTermination(30, TimeUnit.SECONDS);
            System.out.println("La panadería ha terminado la producción del día");
        } catch (InterruptedException ex) {
        }
        System.out.println("Cantidad de panes horneados: " + Panaderia.canasta.size());
    }
}
