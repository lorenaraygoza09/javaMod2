package ejemplosRepo;

import java.util.List;

public class Sucursal {
    private final String nombre;
    private final List<Pedido> pedidos;

    public Sucursal(String nombre, List<Pedido> pedidos) {
        this.nombre = nombre;
        this.pedidos = pedidos;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Pedido> getPedidos() {
        return pedidos;
    }
}
