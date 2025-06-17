package reto2;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

public class AeropuertoControl {
    private static final Random random = new Random();
    public static void main(String[] args) {
        System.out.println("🛬 Verificando condiciones para el aterrizaje...");
        CompletableFuture<Boolean> pistaFuture = verificarPista();
        CompletableFuture<Boolean> climaFuture = verificarClima();
        CompletableFuture<Boolean> traficoAereoFuture = verificarTraficoAereo();
        CompletableFuture<Boolean> personalFuture = verificarPersonalDisponible();

        CompletableFuture<Void> reporteCondiciones = CompletableFuture.allOf(pistaFuture, climaFuture, traficoAereoFuture, personalFuture)
                .thenAccept(v -> {
                    try {
                        boolean pista = pistaFuture.get();
                        boolean clima = climaFuture.get();
                        boolean trafico = traficoAereoFuture.get();
                        boolean personal = personalFuture.get();

                        if (pista && clima && trafico && personal) {
                            System.out.println("✅ Aterrizaje autorizado: condiciones adecuadas.");
                        } else {
                            System.out.println("❌ Aterrizaje denegado: condiciones no óptimas.");
                        }
                    } catch (InterruptedException | ExecutionException e) {
                        System.out.println("Error en la evaluación de condiciones: " + e.getMessage());
                    }
                })
                .exceptionally(ex -> {
                    System.out.println("Error en el proceso de aterrizaje: " + ex.getMessage());
                    return null;
                });
        reporteCondiciones.join();
    }


    public static CompletableFuture<Boolean> verificarPista(){
        return CompletableFuture.supplyAsync(() ->{
            System.out.println("🛣️ Verificando pista...");
            dormir(3);
            boolean disponible = random.nextInt(100) < 90;
            System.out.println("🛣️ Pista disponible: " + disponible);
            return disponible;
        });
    }
    public static CompletableFuture<Boolean> verificarClima(){
        return CompletableFuture.supplyAsync(() ->{
            System.out.println("🌤️️ Verificando clima...");
            dormir(2);
            boolean favorable = random.nextInt(100) < 90;
            System.out.println("🌤️️ Clima favorable: " + favorable);
            return favorable;
        });
    }

    public static CompletableFuture<Boolean> verificarTraficoAereo(){
        return CompletableFuture.supplyAsync(() ->{
            System.out.println("🚦 Verificando tráfico aéreo...");
            dormir(2);
            boolean despejado = random.nextInt(100) < 80;
            System.out.println("🚦 Tráfico aéreo despejado: " + despejado);
            return despejado;
        });
    }
    public static CompletableFuture<Boolean> verificarPersonalDisponible(){
        return CompletableFuture.supplyAsync(() ->{
            System.out.println("👷🏻‍♀️ Verificando disponibilidad de personal...");
            dormir(2);
            boolean disponible = random.nextInt(100) < 80;
            System.out.println("👷🏻‍♀️ Personal disponible: " + disponible);
            return disponible;
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
