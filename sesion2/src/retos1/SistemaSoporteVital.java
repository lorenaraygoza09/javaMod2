package retos1;

import java.util.concurrent.Callable;

public class SistemaSoporteVital implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(2500);
        return "🧪 Condiciones internas: adecuadas para el humano";
    }
}
