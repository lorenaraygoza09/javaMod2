package Funcional;

import java.util.Arrays;
import java.util.List;

public class Ejemplo {
    public static void main(String[] args) {
        List<Integer> numeritos = Arrays.asList(9, 11, 8, 100, 3, 4);

        //imperativa
        //decir lo que quiero y como lo quiero obtener
        for (int i = 0; i < numeritos.size(); i++) {
            System.out.println("Imperativo: " + numeritos.get(i));
        }
        //declarativa
        //decir lo que quiero sin preocuparme del como
        numeritos.forEach(numero -> System.out.println("\nDeclarativo " + numero));
    //Lambda: funcion anonima que recibe parametros y hace algo, como la funcion de arriba⬆️
    }
}
