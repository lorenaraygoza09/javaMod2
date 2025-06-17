import java.util.List;

public class Banco {

    //el ? significa cualquier tipo (similar a poner T, X, etc)
    //se utiliza cuando el codigo no usa nada especifico de la clase objetivo
    public static void verCuentas(List <?> cuentas){
        for(Object o : cuentas){
            System.out.println(o);
        }
    }
    //Upper Bounded Wildcard
//List<CuentaBanco> != List<CuentaDebito>
// extends: se utiliza solo para lectura
    //extends: la lista puede ser de CuentaBanco y sus hijos(CuentaDebito, CuentaCredito)

    public static void verTitulares(List <? extends CuentaBanco> cuentas){
        for (CuentaBanco o : cuentas){
            System.out.println(o.getTitular());
        }
    }
    //Lower Bounded Wildcard
    //super se utiliza unicamente para escritura y admite las clases de cuentaDebito hacia arriba
    // admite las clases de CuentaDebito hacia arriba, o sea los padres (CuentaBanco)
    public static void depositar(List <? super CuentaDebito> cuentas){
        for (Object o :cuentas){
            if(o instanceof CuentaBanco){
                ((CuentaBanco)o).setSaldo(100);
            }
        }
    }
}
