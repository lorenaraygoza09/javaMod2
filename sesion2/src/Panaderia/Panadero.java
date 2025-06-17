package Panaderia;

import java.util.concurrent.Callable;

public class Panadero implements Callable<Void> {

    @Override
    public Void call() {
        try {
        //cada panadero calcula cuantos panes puede hacer
        int cantidad = (int) (Math.random() * 5) + 1;
        System.out.println("👨🏻‍🍳 puede hacer " + cantidad + " panes");
        for (int i = 1; i <= cantidad; i++) {
            int indice = (int) (Math.random() * Panaderia.catalogo.length);
            String pan = Panaderia.catalogo[indice]; //cocinando un pan
            //duerme X milisegundos al hilo de ejecucion
            Thread.sleep(500);
            //bloqueamos la canasta
            Panaderia.candado.lock();
            try {
                //depositamos el pan en la canasta
                //zona de riesgo☢️
                // todos quieren acceder al msimo tiempo y causa perdidas
                Panaderia.canasta.add(pan);
            } finally {
                Panaderia.candado.unlock();
            }
        }
    } catch (InterruptedException ex){}
        return null;
    }
}
