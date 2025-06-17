package executor;

import introduccion.PrimerHilo;
import introduccion.SegundoHilo;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

//la clase "main" funciona como el hilo prinicpal
public class Main {
    public static void main(String[] args) throws InterruptedException {
        // ==============  heredando Thread
    PrimerHilo primerHilo = new PrimerHilo();
    primerHilo.start();
    // ================ implementando runnable
    SegundoHilo segundoHilo = new SegundoHilo();
    segundoHilo.run();
    // =============== implementando Callable
        //creando gestor de hilos con soporte para N (en este caso 1) hilos simultaneos
        ExecutorService executor = Executors.newFixedThreadPool(1);
       //mandando un hilo a recoger su "pelotita" de las N disponibles
        executor.submit(new TercerHilo());
        //impedir que mas hilos entren a la "alberca" por su "pelota"
        executor.shutdown();
        //esperar hasta que los hilos terminen, si no un hilo nuevo no avanza
        //el hilo esperara 3 microsegundos, si termina el tiempo se lanza una excepcion
        try {
            executor.awaitTermination(3, TimeUnit.MICROSECONDS);
        } catch (InterruptedException e) {
            System.out.println("Terminó el tiempo de espera");
        }
        }
    }
