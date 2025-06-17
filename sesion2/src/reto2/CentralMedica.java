package reto2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CentralMedica {
    public static void main(String[] args) {
        System.out.println("Iniciando el acceso al recurso...");

        RecursoMedico quirofano = new RecursoMedico("Quirofano");
        ExecutorService executor = Executors.newFixedThreadPool(4);

        executor.submit(new Profesional("Dra Barrón", quirofano));
        executor.submit(new Profesional("Dr Sanchez", quirofano));
        executor.submit(new Profesional("Dr Olivares", quirofano));
        executor.submit(new Profesional("Dra Salas", quirofano));

        executor.shutdown();
    }
}
