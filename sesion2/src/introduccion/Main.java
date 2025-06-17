package introduccion;

// En este caso, la clase "Main" funciona como el hilo principal

public class Main {

    public static void main(String[] args) {

        // Si heredamos de Thread
        PrimerHilo primerHilo = new PrimerHilo();

        // Si usamos Runnable
        SegundoHilo segundoHiloRunnable = new SegundoHilo();
        Thread segundoHilo = new Thread(segundoHiloRunnable);

        // Nota: Ejecutar .start() y no .run()
        primerHilo.start();
        segundoHilo.start();
    }
}

/*
 * run() -> Escribir código
 * start() -> Ejecutar
 */
