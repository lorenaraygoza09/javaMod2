import java.util.List;

public class InspeccionComponentes {
    //metodo flexible: acepta cualquier tipo que sea Componente
    // o subclase de componente
    public static void imprimirComponentes(List<? extends Componente> componentes){
        for (Componente c : componentes){
            System.out.println("Inspeccionando componentes: " + c.getNombre());
        }
    }
    public static void main(String[] args) {
        List<Motor> motores = List.of(new Motor("Motor Falcon 9"), new Motor("Motor Raptor"));
        List<Ala> alas = List.of(new Ala("Ala Delta"), new Ala("Ala Supersónica"));

        //metodo acepta ambos tipos gracias a la wildcard con extends
        imprimirComponentes(motores);
        imprimirComponentes(alas);
    }
}
