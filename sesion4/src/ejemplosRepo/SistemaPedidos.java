package ejemplosRepo;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class SistemaPedidos {
    public static void main(String[] args) {
        System.out.println("Procesando pedidos asincronos");
        CompletableFuture<Void> pedido = procesarPago()
                .thenApply(pago -> generarFactura(pago))
                .thenAccept(factura -> notificacion(factura))
                .exceptionally(ex -> {
                    System.out.println("Error en el proceso: " + ex.getMessage());
                    return null;
                });
        pedido.join();
    }
public static  CompletableFuture<String> procesarPago(){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Procesando pago...");
            dormir(2);
            System.out.println("Pago confirmado");
            return "Pago #123";
        });
}
    public static String generarFactura(String pago) {
        System.out.println("Generando factura para " + pago + "...");
    dormir(1);
    String factura = "Factura #456";
        System.out.println("Factura generada: " + factura);
        return factura;
    }
    public static void notificacion(String factura){
        System.out.println("Enviando notificación por " + factura + "...");
        dormir(1);
        System.out.println("Notificación enviada");
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
