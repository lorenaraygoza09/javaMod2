package ejemplosRepo;

import java.sql.Time;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ProcesadorOrdenes {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Ejecución concurrente con ExecutorService");
        ExecutorService executor = Executors.newFixedThreadPool(4);
        //concurrencia
        executor.submit(() -> procesarOrden("Orden 1 (Pizza)", 3));
        executor.submit(() -> procesarOrden("Orden 2 (Pasta)", 2));
        executor.submit(() -> procesarOrden("Orden 3 (Hamburguesa)", 4));
        executor.submit(() -> procesarOrden("Orden 4 (Ensalada)", 1));
        executor.shutdown();
        executor.awaitTermination(10, TimeUnit.SECONDS);

        //asincronia
        CompletableFuture<Void> ordenAsync1 = CompletableFuture.runAsync(() -> procesarOrden("Orden 5 (Sopa)", 2));
        CompletableFuture<Void> ordenAsync2 = CompletableFuture.runAsync(() -> procesarOrden("Orden 6 (Tacos)", 3));
        CompletableFuture<Void> ordenAsync3 = CompletableFuture.runAsync(() -> procesarOrden("Orden 7 (Sandwich)", 2));
        //esperar que todas las ordenes asincronas terminen
        CompletableFuture.allOf(ordenAsync1, ordenAsync2, ordenAsync3).join();
    }
    public static void procesarOrden(String orden, int segundos){
        System.out.println("Procesando " + orden);
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println(orden + " completada");
    }
}
