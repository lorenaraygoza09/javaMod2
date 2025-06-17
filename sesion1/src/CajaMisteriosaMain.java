public class CajaMisteriosaMain {
    public static void main(String[] args) {
        CajaMisteriosa<String> cajita = new CajaMisteriosa<>();

        cajita.guardar("Hola Mundo");

        String valor = (String) cajita.sacar();

        System.out.println("El valor de la caja es: " + valor);

        CajaMisteriosa<Integer> cajitaNumeros = new CajaMisteriosa<>();
        cajitaNumeros.guardar(1);
        System.out.println("El número guardado en la cajita es: " + cajitaNumeros.sacar());

        CajaMisteriosa<Boolean> cajitaBool = new CajaMisteriosa<>();
        cajitaBool.guardar(true);
        System.out.println("Valor en boolean: " + cajitaBool.sacar());
    }
}

/*
Tipos de datos primitivos son aquellos que nacieron con el lenguaje de programacion:
int, float, double, byte, boolean, short, char

String no es un dato primitivo
 */
