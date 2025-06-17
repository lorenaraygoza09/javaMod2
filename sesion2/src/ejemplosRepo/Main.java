package ejemplosRepo;

public class Main {
    public static void main(String[] args) {
        Thread hilo1  =new Thread(new Tarea("Tarea 1"));
        Thread hilo2 = new Thread(new Tarea("Tarea 2"));

        hilo1.start();//inicia la ejecucion del hilo
        hilo2.start();//inicia la ejecucion del hilo

        System.out.println("Hilos iniciados desde el hilo prinicipal: "
                + Thread.currentThread().getName());
    }
}
