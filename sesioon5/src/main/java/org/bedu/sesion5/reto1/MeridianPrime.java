package org.bedu.sesion5.reto1;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.Random;

public class MeridianPrime {
    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        //🚗Sensores de tráfico
        Flux<Integer> trafico = Flux.interval(Duration.ofMillis(500))
                .map(i -> random.nextInt(101))//congestion 0-100%
                .filter(congestion -> congestion > 70)//filtra congestion critica
                .doOnNext(congestion -> System.out.println("🚗 Alerta: Congestión del " + congestion + "% en Avenida de la Marina"))
                .onBackpressureBuffer(5);//simula backpressure

        //️️☁️Contaminacion del aire
        Flux<Integer> contaminacion = Flux.interval(Duration.ofMillis(600))
                .map(i -> random.nextInt(80))
                .filter(pm -> pm > 50)
                .doOnNext(pm -> System.out.println("☁️ Alerta: Contaminación alta (PM2.5: " + pm + "ug/m3)"));

        //👮🏻 Accidentes viales
        Flux<String> accidentes = Flux.interval(Duration.ofMillis(800))
                .map(i -> {
                    String[] prioridades = {"Baja", "Media", "Alta"};
                    return prioridades[random.nextInt(prioridades.length)];
                })
                .filter(prioridad -> prioridad.equalsIgnoreCase("alta"))
                .doOnNext(prioridad -> System.out.println("👮🏻 Emergencia vial: Accidente con prioridad " + prioridad));

        //🚄trenes maglev
        Flux<Integer> trenes = Flux.interval(Duration.ofMillis(700))
                .map(i -> random.nextInt(10))
                .filter(retraso -> retraso > 5)
                .doOnNext(retraso -> System.out.println("🚄 Alerta: el tren tiene un retraso de " + retraso + " minutos."));

        //🚦Semaforos inteligentes
        Flux<String> semaforos = Flux.interval(Duration.ofMillis(400))
                .map(i -> {
                    String[] estado = {"Verde", "Amarillo", "Rojo"};
                    return estado[random.nextInt(estado.length)];
                })
                .transform(MeridianPrime::controlarSemaforos);

        //Merge de todos los flujos
        Flux.merge(trafico, contaminacion, accidentes, trenes, semaforos)
                .bufferTimeout(5, Duration.ofSeconds(2))
                .filter(lista -> lista.size() >= 3)//3 eventos juntos
                .doOnNext(lista -> System.out.println("☢️ Alerta global: Múltiples eventos detectados en Meridian Prime\n"))
                .subscribe();
        Thread.sleep(15000);
    }

        // Controlador de semáforos: detecta 3 rojos seguidos
        private static Flux<String> controlarSemaforos (Flux < String > flujo) {
            final int[] contador = {0};
            return flujo
                    .filter(estado -> {
                        if (estado.equals("Rojo")) {
                            contador[0]++;
                            if (contador[0] >= 3) {
                                contador[0] = 0; // Reiniciar contador
                                return true; // Emitir alerta
                            }
                        } else {
                            contador[0] = 0; // Reiniciar si cambia de estado
                        }
                        return false; // No emitir alerta aún
                    })
                    .doOnNext(estado -> System.out.println("🚦 Semáforo rojo detectado 3 veces seguidas en cruce Norte"));
        }
}