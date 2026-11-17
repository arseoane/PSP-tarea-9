import java.util.Random;

public class Descarga implements Runnable {
    private final String nombreArchivo;
    private final int tiempoBloque;
    private long tiempoDescarga;

    public Descarga(String nombre) {
        this.nombreArchivo = nombre;
        this.tiempoBloque = new Random().nextInt(401) + 100;
    }

    public long getTiempoDescarga() {
        return tiempoDescarga;
    }

    @Override
    public void run() {
        long inicio = System.currentTimeMillis();
        try {
            int i = 0;
            while (i++ < 10) {
                Thread.sleep(tiempoBloque);
                System.out.println("[" + nombreArchivo + "] " + i + "0%");
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        tiempoDescarga = System.currentTimeMillis() - inicio;
        System.out.println("[" + nombreArchivo + "] completada en " + tiempoDescarga + " ms");
    }
}
