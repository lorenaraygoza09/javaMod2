package ejemplosClase;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Futuro {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        //creamos hilo con Function
        Future<String> futuro = executor.submit(() -> {
            Thread.sleep(5000); //dormimos el hilo nuevo
            return "Hola, en el futuro!";
        });

        executor.shutdown();

        //esperamos a recibir un valor
        String resultadoEnElFuturo = futuro.get(); //bloquea el hilo principal
        System.out.println(resultadoEnElFuturo);
    }
}
