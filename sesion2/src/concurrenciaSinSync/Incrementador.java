package concurrenciaSinSync;

import java.util.concurrent.Callable;

public class Incrementador implements Callable<Void> {
    @Override
    public Void call() {

        for (int i = 0; i < 10000; i++) {
            // Bloqueamos el recurso para cualquier otro hilo
            MemoriaCompartida.candado.lock();

            try {
                // Aquí adentro va lo 'protegido'
                MemoriaCompartida.valor++;
            } finally {
                // Liberamos el recurso
                MemoriaCompartida.candado.unlock();
            }
        }

        return null;
    }
}
