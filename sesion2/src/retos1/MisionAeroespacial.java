package retos1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class MisionAeroespacial {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        System.out.println("🚀 Simulación espacial iniciada...");
        //enviando tareas
        Future<String> navegacion = executor.submit(new SistemaNavegacion());
        Future<String> comunicaciones = executor.submit(new SistemaComunicaciones());
        Future<String> cTermico = executor.submit(new SistemaControlTermico());
        Future<String> sVital = executor.submit(new SistemaSoporteVital());
        //recuperando resultados
        System.out.println(navegacion.get());
        System.out.println(comunicaciones.get());
        System.out.println(cTermico.get());
        System.out.println(sVital.get());
        //cerrar executor
        executor.shutdown();
        //imprimir resultados
        System.out.println("✅ Todos los sistemas reportan estado operativo.\n");

    }
}
