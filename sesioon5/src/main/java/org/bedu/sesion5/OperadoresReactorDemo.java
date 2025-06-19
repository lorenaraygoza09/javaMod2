package org.bedu.sesion5;

import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

public class OperadoresReactorDemo {
    public static void main(String[] args) throws InterruptedException {
        //notif en universidad
        List<Usuario> usuarios = List.of(
                new Usuario("Ana", "Estudiante", "ana@uni.edu"),
                new Usuario("Carlos", "Profesor", "carlos@uni.edu"),
                new Usuario("Luisa", "Estudiante", "luisa@uni.edu"),
                new Usuario("Sofía", "Administrativo", "sofia@uni.edu")
        );

        Flux.fromIterable(usuarios)
                .filter(u -> u.getRol().equalsIgnoreCase("Estudiante")) //filtra estudiantes
                .map(u -> "Notificación para: " + u.getNombre())//transforma en mensaje
                .delayElements(Duration.ofMillis(500))
                .subscribe(m -> System.out.println("Universidad: " + m));

        //confirmacion de entregas
        Flux.just("Pedido 1", "Pedido 2", "Pedido 3")
                .flatMap(pedido -> simularEntrega(pedido))
                .subscribe(m -> System.out.println("Logística: " + m));

        //alerta de sensores
        Flux.just(18, 22, 35, 45)
                .filter(temp -> temp > 30)
                .map(temp -> "Alerta: temperatura alta: " + temp + "°C" )
                .subscribe(System.out::println);

        Thread.sleep(4000);
    }

    //proceso asincrono para confirmacion de entrega
    private static Flux<String> simularEntrega(String pedido){
        return Flux.just(pedido + " confirmado")
                .delayElements(Duration.ofMillis(700));
    }

    //CLASE AUXILIAR

    static class Usuario {
        private final String nombre;
        private final String rol;
        private final String correo;

        public Usuario(String nombre, String rol, String correo) {
            this.nombre = nombre;
            this.rol = rol;
            this.correo = correo;
        }

        public String getNombre() {
            return nombre;
        }

        public String getRol() {
            return rol;
        }
    }
}
