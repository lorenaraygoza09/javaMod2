package Funcional;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Funciones {
    public static void main(String[] args) {
        List<Integer> numeritos = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //stream API
        //permite utilizar programacion funcional sobre las listas
        //objetivo; tomar cada numero y multiplicarlo por 10
        // ==== PROGRAMACION ORIENTADA A OBJETOS ====

        for (int i = 0; i < numeritos.size(); i++) {
            int miNumero = numeritos.get(i); //obteniendo el i-esimo numero
            int nuevoNumero = miNumero * 10;
            numeritos.set(i, nuevoNumero);
        }

        for (int i = 0; i < numeritos.size(); i++) {
            System.out.println(numeritos.get(i));
        }
        // === PROGRAMACION FUNCIONAL ===
        // high order functions; las funciones pueden recibir como parametros
        // funciones o regresar funciones
        //Function<tipoDDatoDEntrada, tipoDDatoDSalida> nombre = argumento -> lo que hace con el argumento
        Function<Integer, Integer> multiplicarPor10 = x -> x * 10;
        numeritos
                .stream()//activando modo funcional
                .map(multiplicarPor10);//convierte la lista en otra lista segun el criterio
            //esto es lo mismo ⬇️
        numeritos
                .stream()//activando modo funcional
                .forEach((n) -> System.out.println(n + "Hola"));
            //que esto ⬇️
        numeritos
                .stream()//activando modo funcional
                .forEach(System.out::println);
    }
}
