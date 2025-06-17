package introduccion;

//interfaz runnable
public class SegundoHilo implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Hola => " + (i + 1));
        }
    }
}
