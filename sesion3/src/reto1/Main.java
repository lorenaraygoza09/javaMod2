package reto1;

import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        List<Pedido> pedidos = List.of(
                new Pedido("Luis", "Domicilio", "6959500000"),
                new Pedido("Martin", "Local", null),
                new Pedido("Isabel", "Local", null),
                new Pedido("Jonhatan", "Domicilio", "6951160000")
        );

        List<String> mensajes = pedidos.stream()
                                .filter(p -> p.getTipoEntrega().equalsIgnoreCase("domicilio"))
                                .map(Pedido::getTelefono)
                                .filter(Optional::isPresent)
                                .map(Optional::get)
                                .map(tel -> "- Confirmación enviada al número: " + tel)
                                .toList();

        System.out.println("Confirmaciones de pedidos a domicilio: ");
        mensajes.forEach(System.out::println);
    }
}
