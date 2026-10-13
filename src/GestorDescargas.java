import java.util.Arrays;
import java.util.Collections;

public class GestorDescargas {
    public static void main(String[] args) throws InterruptedException {
        Descarga d1 = new Descarga("meditacion.mp4");
        Descarga d2 = new Descarga("mantras.mp3");
        Descarga d3 = new Descarga("horoscopo.pdf");
        Descarga d4 = new Descarga("cuarzos.png");

        Descarga[] lista = Arrays.asList(d1, d2, d3, d4).toArray(new Descarga[0]);

        int totalTiempo = 0;
        int minTiempo = 0;
        int maxTiempo = 0;

        for (int i = 1; i < lista.length; i++) {
            if (lista[i].getTardar < minTiempo) {
                minTiempo = lista[i].getTardar;
            }
        }

        for (int i = 1; i < lista.length; i++) {
            if (lista[i].getTardar > maxTiempo) {
                maxTiempo = lista[i].getTardar;
            }
        }

        for (Descarga d : lista){
            totalTiempo += d.getTardar;
        }

        Thread t1 = new Thread(d1);
        t1.setName("Descarga-meditacion.mp4");
        Thread t2 = new Thread(d2);
        t2.setName("Descarga-meditacion.mp4");
        Thread t3 = new Thread(d3);
        t3.setName("Descarga-meditacion.mp4");
        Thread t4 = new Thread(d4);
        t4.setName("Descarga-meditacion.mp4");

        Thread[] descargas = Arrays.asList(t1, t2, t3, t4).toArray(new Thread[0]);

        for (Thread descarga : descargas){
            descarga.start();
            descarga.join();
        }
        System.out.println("Tiempo total de descargas: " + totalTiempo);
        System.out.println("Descarga más rápida: " + minTiempo);
        System.out.println("Descarga más lenta: " + maxTiempo);

    }
}
