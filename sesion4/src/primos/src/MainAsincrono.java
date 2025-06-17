import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class MainAsincrono {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while(true) {
            System.out.println("\n🤖 ¿Cuántos números primos quieres calcular?");

            int cantidad = sc.nextInt();
            sc.nextLine();
            //para crear un proceso asincrono se pueden utilizar
            // los metodos de abajo
            //supplyAsync: se usa cuando el proceso regresa un valor
            //runAsync: se usa cuando el proceso no regresa un valor

            //dividir el proceso asincrono en varios pasos(cadena de ejecucion)
            CompletableFuture
                    //1- calcular los N primos
                            .supplyAsync(() ->{
                                System.out.println("\n⌛ Calculando " + cantidad + " primos...");
                                return CalculadoraPrimos.calcularPrimerosPrimos(cantidad);
                            })
            //2- escribir en un archivo
                    .thenAccept((primos) -> ManejoArchivos.escribir(primos))
                    .thenAccept((x) -> System.out.println("\nCálculo de " + cantidad + " primos terminado"))
                    //si existe un error se ejecuta exceptionally
                    .exceptionally((err) -> {
                        System.out.println("Ocurrio un error inesperado");
                        return null;
                    });
            // .thenApply: el sig paso regresa un valor
            //.thenAccept: el sig paso no regresa un valor
            //.thenCombine: el sig paso regresa un futuro

            try {
            } catch (Exception ex) {
                System.out.println("\n❌ Ocurrió un error inesperado");
            }
            System.out.println("\n✅ Cálculo de " + cantidad + " primos terminado");
            System.out.println("\n🤖 ¿Quieres seguir calculando? (Y/N)");

            String continuar = sc.nextLine();

            if (!continuar.toLowerCase().equals("y")) {
                break;
            }
        }

        sc.close();
        System.out.println("\nTerminando programa...");
    }
    }

