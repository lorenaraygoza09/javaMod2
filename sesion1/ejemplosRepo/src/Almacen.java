
public class Almacen<T>{
    private T producto;
    //guardar producto de cualquier tipo
    public void guardarProducto(T producto){
        this.producto = producto;
        System.out.println("Producto guardado: " + producto);
    }
    //devuelve el producto almacenado
    public T obtenerProducto(){
        return producto;
    }
    //verifica si el almacen esta vacio
    public boolean estaVacio(){
        return producto == null;
    }
    //muestra el tipo de producto almacenado
    public void mostrarTipoProducto(){
        if (producto != null){
            System.out.println("Tipo de producto almacenado: " + producto);
        } else {
            System.out.println("El almacén está vacío");
        }
    }
}


