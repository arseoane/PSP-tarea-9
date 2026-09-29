public class GestorDescargas {
    public static void main(String[] args) {
        Descarga d1 = new Descarga("meditacion.mp4");
        Descarga d2 = new Descarga("mantras.mp3");
        Descarga d3 = new Descarga("horoscopo.pdf");
        Descarga d4 = new Descarga("cuarzos.png");

        Thread t1 = new Thread(d1);
        Thread t2 = new Thread(d2);
        Thread t3 = new Thread(d3);
        Thread t4 = new Thread(d4);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
