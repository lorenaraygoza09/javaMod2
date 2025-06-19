package org.bedu.sesion5;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class NotificacionesStreamTradicional {
    public static void main(String[] args) {
        List<String> usuarios = List.of("Ana", "Luis", "Mario", "Carlos");
        System.out.println("Enviando notificaiones con STREAM API");
    usuarios.forEach(NotificacionesStreamTradicional::enviarNotificacion);
    }

    private static void enviarNotificacion(String usuario){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e){
            Thread.currentThread().interrupt();
        }
        System.out.println("Notificacion enviada a: " + usuario);
    }
}
