package executor;

import java.util.concurrent.Callable;
/*
Callable permite regresar un valor (o no) al hilo principal
el tipo generico es el tipo de lo que voy a regresar.

por ejemplo:
- si regreso un numero, entonces seria Callable<Integer>
- si regreso un objeto de tipo persona, entonces seria Callable<Persona>
- si No regreso nada, entonces seria Callable<Void>

**Void con mayuscula es el wrapper class
**void con minuscula es el tipo primitivo
** void == nada/vacio

 */
public class TercerHilo implements Callable<Void> {
    //con Callable<T> se sobreescribe el metodo "call"
    //el tipo de retorno es el mismo que el generico
    @Override
    public Void call() {
        for (int i = 0; i < 10; i++) {
            System.out.println("Adios " + i);
        }
        //como este ejemplo usa Void, se retorna un null
        // o sea NADA == Void
        return null; //return es obligatorio aunque no regrese "nada"
    }
}
