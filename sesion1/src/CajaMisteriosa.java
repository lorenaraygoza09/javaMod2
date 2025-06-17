public class CajaMisteriosa <X> {
/*
la clase Object es el padre de todos los tipos de dato, cualquier tipo de dato surge
de esta clase
 */
    private X valor;
    public void guardar(X nuevoValor){
    this.valor = nuevoValor;
    }

    public X sacar(){
    return valor;
    }

    public boolean estaVacia(){
    return valor == null;
    }
}
