import java.util.LinkedList;
import java.util.List;

public class CalculadoraPrimos{
    public static boolean esPrimo(long numero){
        if(numero <= 1) return false;
        if(numero <= 3) return true;
        if(numero % 2 == 0 || numero % 3 == 0) return false;

        //optimizacion: solo verificar divisores hasta sqrt(numero)
        // y solo divisores de la forma 6k +-    1
        for (long i = 5; i * i <= numero ; i+= 6) {
            if (numero % i == 0 || numero % (i + 2) == 0) {
                return false;
            }
        }
        return true;
}
    // Éste tipo de métodos se les conoce como "CPU Intensive"
    // dado que requiren mucho tiempo de procesamiento para poder terminar
    public static List<Long> calcularPrimerosPrimos(int cantidad) {
        List<Long> primos = new LinkedList<>();

        long pivote = 1;

        // No vamos a terminar hasta encontrar todos los primos solicitados
        while (primos.size() < cantidad) {

            // Reutilizamos el método de arriba
            if (esPrimo(pivote)) {
                primos.add(pivote);
            }

            pivote++;
        }

        return primos;
    }
}