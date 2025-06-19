package org.bedu.sesion5;

import reactor.core.publisher.Flux;

import java.time.Duration;

public class NotifFluxReactivo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Enviando notificaciones con FLUX:");
        Flux<String> usuariosFlux = Flux.just("Ana", "Luis", "Mario", "Carlos")
                .delayElements(Duration.ofSeconds(1));//SIMULA LLEGADA GRADUAL

        usuariosFlux.subscribe( usuario -> System.out.println("Notificacion enviada a: " + usuario));
        //esperar que terminen las notificaciones reactivas
        Thread.sleep(5000);
    }
}
