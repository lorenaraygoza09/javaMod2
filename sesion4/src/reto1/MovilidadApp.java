package reto1;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class MovilidadApp {
    public static void main(String[] args) {
        System.out.println("🚕 Calculando viaje");
        //operaciones en paralelo
        CompletableFuture<String> rutaF = calcularRuta();
        CompletableFuture<Double> tarifaF = estimarTarifa();
        //combinadas
        CompletableFuture<Void> viaje = rutaF.thenCombine(tarifaF, (ruta, tarifa) -> {
            return "🚕 Ruta calculada: " + ruta + " | 💵 Tarifa estimada: $" + tarifa;
        })
                .thenAccept(System.out::println)
                .exceptionally(ex -> {
                    System.out.println("Error al procesar el viaje: " + ex.getMessage());
                    return null;
                });
        viaje.join();
    }

    public static CompletableFuture<String> calcularRuta(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦Calculando ruta...");
            dormir(3);
            return "Centro -> Norte";
    });
}
   public static CompletableFuture<Double> estimarTarifa(){
        return CompletableFuture.supplyAsync(() ->{
            System.out.println("💵Estimando tarifa...");
            dormir(2);
            return 75.50;
        });
   }
    //simulador de latencia
    public static void dormir(int segundos){
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}
