import java.util.Arrays;

public class GestorDescargas {
    public static void main(String[] args) throws InterruptedException {
        Descarga d1 = new Descarga("meditacion.mp4");
        Descarga d2 = new Descarga("mantras.mp3");
        Descarga d3 = new Descarga("horoscopo.pdf");
        Descarga d4 = new Descarga("cuarzos.png");

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
    }
}
