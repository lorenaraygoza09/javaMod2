package org.bedu.sesion5.reto2;

import reactor.core.publisher.Flux;
import java.time.Duration;
import java.util.Random;

public class UCI {

    public static void main(String[] args) throws InterruptedException {
        Random random = new Random();

        // flujo de pacientes
        Flux<signosVitales> px1 = generarSignosVitales(1, random);
        Flux<signosVitales> px2 = generarSignosVitales(2, random);
        Flux<signosVitales> px3 = generarSignosVitales(3, random);

        // fusionar flujos de pacientes
        Flux.merge(px1, px2, px3)
                .filter(signosVitales::esCritico) // Filtrar  eventos críticos
                .sort((e1, e2) -> e1.prioridad() - e2.prioridad()) //Priorizar FC
                .delayElements(Duration.ofSeconds(1))
                .subscribe(System.out::println);

        Thread.sleep(15000);
    }

    // generar flujo de signos vitales por paciente
    private static Flux<signosVitales> generarSignosVitales(int pxId, Random random) {
        return Flux.interval(Duration.ofMillis(300))
                .map(tick -> {
                    // Generar datos aleatorios
                    int fC = 40 + random.nextInt(100); // 40-140
                    int paSist = 80 + random.nextInt(80); // 80-160 sistólica
                    int paDiast = 50 + random.nextInt(50); // 50-100 diastólica
                    int spO2 = 85 + random.nextInt(15); // 85-100%

                    return new signosVitales(pxId, fC, paSist, paDiast, spO2);
                })
                .take(10); // Limitar cantidad de eventos
    }

    // 📄 Clase auxiliar para los eventos de signos vitales
    static class signosVitales {
        private final int pxId;
        private final int fC;
        private final int paSist;
        private final int paDiast;
        private final int spO2;

        public signosVitales(int pxId, int fc, int paSist, int paDiast, int spo2) {
            this.pxId = pxId;
            this.fC = fc;
            this.paSist = paSist;
            this.paDiast = paDiast;
            this.spO2 = spo2;
        }

        // 🩺 Detectar si el evento es crítico
        public boolean esCritico() {
            return fC < 50 || fC > 120 || paSist < 90 || paSist > 140 || paDiast < 60 || paDiast > 90 || spO2 < 90;
        }

        // 🔝 Prioridad para ordenar eventos (FC=1, SpO2=2, PA=3)
        public int prioridad() {
            if (fC < 50 || fC > 120) return 1;
            if (spO2 < 90) return 2;
            return 3;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            if (fC < 50 || fC > 120) sb.append("⚠️ Paciente ").append(pxId).append(" - FC crítica: ").append(fC).append(" bpm\n");
            if (spO2 < 90) sb.append("⚠️ Paciente ").append(pxId).append(" - SpO2 baja: ").append(spO2).append("%\n");
            if (paSist < 90 || paSist > 140 || paDiast < 60 || paDiast > 90)
                sb.append("⚠️ Paciente ").append(pxId).append(" - PA crítica: ").append(paSist).append("/").append(paDiast).append(" mmHg\n");
            return sb.toString().trim();
        }
    }
}