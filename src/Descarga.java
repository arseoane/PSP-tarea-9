import java.util.Random;

public class Descarga implements Runnable {
    private final int tardar;
    private final String nombreArchivo;

    public Descarga(String nombre){
        this.nombreArchivo = nombre;
        Random aleatorio = new Random();
        this.tardar = aleatorio.nextInt(100,500);
    }

    public void run(){
        try {
            int i = 0;
            while (i++ < 10) {
                System.out.println("[" + this.nombreArchivo + "] " + i + "0%");
                Thread.sleep(tardar);

            }

            System.out.println("[" + this.nombreArchivo + "] completada en " + (this.tardar * 10) + " ms");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
