package ejemplosRepo;

import java.util.concurrent.*;

public class ProcesadorPedidos {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
       //gestiona un conjunto de hilos reutilizables
        ExecutorService executor = Executors.newFixedThreadPool(2);
        //callable puede devolver un resultado y lanzar excepciones
        Callable<String> pedido1 = () -> {
            Thread.sleep(1200); //simula procesamiento
            return "Pedido #1 entregado en 1.2 seg"; };
        Callable<String> pedido2 = () -> {
            Thread.sleep(800); //simula procesamiento
            return "Pedido #2 entregado en 0.8 seg"; };
        System.out.println("Procesando pedidos...");
        //Future: representa el estado futuro de una tarea
        //submit: envia la tarea al pool de hilos
        Future<String> r1 = executor.submit(pedido1);
        Future<String> r2 = executor.submit(pedido2);
        //get: espera y obtiene el resultado de una tarea
        System.out.println(r1.get());
        System.out.println(r2.get());
        //detiene el pool de hilos tras finalizar las tareas
        executor.shutdown();
        System.out.println("Todos los pedidos fueron procesados");
    }
}
