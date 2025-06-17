package reto2;

import ejemplosRepo.Pedido;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Sucursal> sucursales = List.of(
                new Sucursal("Centro", List.of(
                        new Encuesta("Luis", null, 9),
                        new Encuesta("Sofía", "Excelente servicio", 10)
                )),
                new Sucursal("Malecón", List.of(
                        new Encuesta("Pamela", "Tiempo de espera demasiado largo", 4),
                        new Encuesta("Isabel", null, 7)
                )),
                new Sucursal("Juaréz", List.of(
                        new Encuesta("Karina", "La señora de recepción fue bastante grosera", 2),
                        new Encuesta("Martin", null, 8)
                )),
                new Sucursal("Marina", List.of(
                        new Encuesta("Ara", "La farmacia no tiene los medicamentos que recetan los doctores", 5),
                        new Encuesta("Alan", null, 9)
                ))
        );
        System.out.println("📋 Seguimiento a pacientes insatisfechos:");

        sucursales.stream()
                .flatMap(sucursal ->
                        sucursal.getEncuestas().stream()
                                .filter(e -> e.getCalificacion() <= 5)
                                .map(encuesta -> new Seguimiento(encuesta, sucursal.getNombre()))
                )
                .filter(seg -> seg.encuesta().getComentario().isPresent())
                .map(seg -> {
                    String comentario = seg.encuesta().getComentario().get();
                    return "Sucursal " + seg.sucursal() +
                            ": Seguimiento a paciente con comentario: \"" + comentario + "\"";
                })
                .forEach(System.out::println);
    }
    }
    record Seguimiento(Encuesta encuesta, String sucursal) {
    }

