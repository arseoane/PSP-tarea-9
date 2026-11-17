import java.util.Arrays;

public class GestorDescargas {
    public static void main(String[] args) throws InterruptedException {
        Descarga d1 = new Descarga("meditacion.mp4");
        Descarga d2 = new Descarga("mantras.mp3");
        Descarga d3 = new Descarga("horoscopo.pdf");
        Descarga d4 = new Descarga("cuarzos.png");

        Descarga[] lista = Arrays.asList(d1, d2, d3, d4).toArray(new Descarga[0]);

        Thread t1 = new Thread(d1, "Descarga-meditacion.mp4");
        Thread t2 = new Thread(d2, "Descarga-mantras.mp3");
        Thread t3 = new Thread(d3, "Descarga-horoscopo.pdf");
        Thread t4 = new Thread(d4, "Descarga-cuarzos.png");

        Thread[] descargas = Arrays.asList(t1, t2, t3, t4).toArray(new Thread[0]);

        long inicio = System.currentTimeMillis();
        for (Thread descarga : descargas) {
            descarga.start();
        }
        for (Thread descarga : descargas) {
            descarga.join();
        }
        long tiempoReal = System.currentTimeMillis() - inicio;

        long totalTiempo = 0;
        long minTiempo = Long.MAX_VALUE;
        long maxTiempo = 0;
        for (Descarga descarga : lista) {
            long tiempo = descarga.getTiempoDescarga();
            totalTiempo += tiempo;
            minTiempo = Math.min(minTiempo, tiempo);
            maxTiempo = Math.max(maxTiempo, tiempo);
        }

        System.out.println("Todas las descargas han terminado.");
        System.out.println("Tiempo total de descargas: " + totalTiempo + " ms");
        System.out.println("Tiempo real de ejecución: " + tiempoReal + " ms");
        System.out.println("Descarga más rápida: " + minTiempo + " ms");
        System.out.println("Descarga más lenta: " + maxTiempo + " ms");

    }
}
