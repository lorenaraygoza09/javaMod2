package retos1;

import java.util.concurrent.Callable;

public class SistemaControlTermico implements Callable<String> {
    @Override
    public String call() throws Exception {
        Thread.sleep(800);
        return "🌡️ Control termico: Temperatura interna 20°C | Temperatura externa -4°C";
    }
}
