//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class AlmacenMain {
    public static void main(String[] args) {
        //almacen de ropa
        Almacen<String> almacenRopa = new Almacen<>();
        System.out.println("¿Almacén de ropa vacío? " + almacenRopa.estaVacio());
        almacenRopa.guardarProducto("Camisa");
        almacenRopa.mostrarTipoProducto();
        // Almacén de números
        Almacen<Integer> almacenNumeros = new Almacen<>();
        almacenNumeros.guardarProducto(42);
        almacenNumeros.mostrarTipoProducto();
        // Almacén de alimentos
        Almacen<String> almacenAlimentos = new Almacen<>();
        almacenAlimentos.guardarProducto("Manzana");
        almacenAlimentos.mostrarTipoProducto();
        // 🎯 Mostrar productos recuperados
        System.out.println("\n🎯 Productos recuperados:");
        System.out.println("🧺 Ropa: " + almacenRopa.obtenerProducto());
        System.out.println("🔢 Número: " + almacenNumeros.obtenerProducto());
        System.out.println("🍏 Alimento: " + almacenAlimentos.obtenerProducto());
    }
}
