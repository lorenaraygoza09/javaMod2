package introduccion;

//al añadir extends Thread se crea el hilo
public class PrimerHilo extends Thread{
    //lo que este dentro del metodo run
    // se ejecutara de manera concurrente
    @Override public void run(){
        for (int i = 0; i < 10; i++) {
            System.out.println("=> " + (i + 1));
        }
    }
}
