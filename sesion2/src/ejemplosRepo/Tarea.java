package ejemplosRepo;

public class Tarea implements Runnable{
    private String nombre;
    public Tarea(String nombre) {
        this.nombre = nombre;
    }
    @Override
    public void run() {
        for (int i = 1; i < 3; i++) {
            System.out.println("Ejecutando " + nombre + " - Iteración "
            + i + " - Hilo: " + Thread.currentThread().getName());
            try {
                Thread.sleep(500); //simula una operacion que toma tiempo
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt(); //interrumpe el hilo
                System.out.println(nombre + " fue interrumpido");
            }
        }
    }
}
