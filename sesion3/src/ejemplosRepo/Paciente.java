package ejemplosRepo;

import java.util.Optional;

public class Paciente {
    //variables
    private final String nombre;
    private final int edad;
    private final boolean enObservacion;
    private final String correo; //puede ser nulo

    public Paciente(String nombre, int edad, boolean enObservacion, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.enObservacion = enObservacion;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEdad() {
        return edad;
    }

    public boolean isEnObservacion() {
        return enObservacion;
    }
//metodo que duelveva optional para evitar NullPointerException
    public Optional<String> getCorreo() {
        return Optional.ofNullable(correo);
    }

    //metodo toString
    @Override
    public String toString(){
        return nombre + " (Edad: " + edad + ", Observación; " + enObservacion + ")";
    }
}
