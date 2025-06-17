package reto2;

public class Articulo extends MaterialCurso{
    private final int numPalabras;
    public Articulo(String titulo, String autor, int numPalabras) {
        super(titulo, autor);
        this.numPalabras = numPalabras;
    }


    @Override
    public void mostrarDetalle() {
        System.out.println("Artículo: " + getTitulo() + " - Autor: " + getAutor() + " - Cantidad de palabras: " + numPalabras);

    }
}
