package ejemplosRepo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class ConsultaServiciosExternos {
    public static void main(String[] args) {
        System.out.println("Iniciando consultas a servicios externos");
        CompletableFuture<String> climaFuture = obtenerClima();
        CompletableFuture<String> traficoFuture = obtenerTrafico();

        CompletableFuture<Void> reporteFinal = climaFuture.thenCombine(traficoFuture,(clima, trafico) -> {
            return "Reporte del día:\n- Clima: " + clima + "\n- Tráfico: " + trafico;
        })
                .thenAccept(System.out::println)
                .exceptionally(ex -> {
                    System.out.println("Error al generar el reporte: " + ex.getMessage());
                    return null;
                });
        reporteFinal.join();
    }
    public static CompletableFuture<String> obtenerClima(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🌡️ Consultando el clima...");
            dormir(2);
            return "Soleado, 25°C";
        });
    }

    public static CompletableFuture<String> obtenerTrafico(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("🚦 Consultando tráfico...");
            dormir(3);
            return "Moderado en el centro";
        });
    }

    public static void dormir(int segundos){
        try {
            TimeUnit.SECONDS.sleep(segundos);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
}