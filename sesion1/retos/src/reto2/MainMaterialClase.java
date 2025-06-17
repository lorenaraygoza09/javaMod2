package reto2;

import java.util.*;
import java.util.function.Predicate;

public class MainMaterialClase {
    public static void mostrarMateriales(List<? extends MaterialCurso> lista){
        System.out.println("\n Material registrado: ");
        for (MaterialCurso material : lista) {
            material.mostrarDetalle();
        }
    }
    public static void contarDuracionVideos(List<? extends Video> lista){
        int total = 0;
        for (Video v : lista){
            total += v.getDuracion();
        }
        System.out.println("\n Duración total de los videos: " + total + " minutos");
    }
    public static void marcarEjerciciosRevisados(List<? super Ejercicio> lista){
        System.out.println();
        for (Object obj : lista){
            if (obj instanceof Ejercicio){
                Ejercicio e = (Ejercicio) obj;
                e.setRevisado(true);
                System.out.println("Ejercicio '" + e.getTitulo() + "' esta revisado.");
            }
        }
    }
    // Filtrar materiales por autor
    public static void filtrarPorAutor(List<? extends MaterialCurso> lista, Predicate<MaterialCurso> filtro) {
        System.out.println("\nFiltrando materiales por autor:");
        for (MaterialCurso material : lista) {
            if (filtro.test(material)) {
                material.mostrarDetalle();
            }
        }
    }

    public static void main(String[] args) {
        // Crear materiales
        List<MaterialCurso> materiales = Arrays.asList(
                new Video("Inteligencia artificial", "Martín", 15),
                new Video("Internet de las cosas", "Monica", 20),
                new Articulo("Fundamentos de programación", "Lorena", 1200),
                new Articulo("Variables contadoras y acumuladoras", "Martín", 800),
                new Ejercicio("Variables contadoras y acumuladoras", "Martín"),
                new Ejercicio("Subneteo de redes", "Lorena")
        );

        // Filtrar tipo (videos y ejercicios)
        List<Video> videos = new ArrayList<>();
        List<Ejercicio> ejercicios = new ArrayList<>();
        for (MaterialCurso m : materiales) {
            if (m instanceof Video) {
                videos.add((Video) m);
            } else if (m instanceof Ejercicio) {
                ejercicios.add((Ejercicio) m);
            }
        }

        // Mostrar todos los materiales
        mostrarMateriales(materiales);

        // Contar duración total de videos
        contarDuracionVideos(videos);

        // Marcar ejercicios como revisados
        marcarEjerciciosRevisados(ejercicios);

        // Desafío opcional: Filtrar materiales por autor (Martin)
        filtrarPorAutor(materiales, m -> m.getAutor().equals("Martín"));
    }
}

