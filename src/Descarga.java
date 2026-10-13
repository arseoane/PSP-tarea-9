import java.util.Random;

public class Descarga implements Runnable {
    private final String nombreArchivo;
    private Random aleatorio = new Random();

    public int getTardar = aleatorio.nextInt(401) + 100;

    public Descarga(String nombre){
        this.nombreArchivo = nombre;
    }

    public void run(){
        try {
            int i = 0;
            while (i++ < 10) {
                System.out.println("[" + this.nombreArchivo + "] " + i + "0%");
                Thread.sleep(getTardar);
            }

            System.out.println("[" + this.nombreArchivo + "] completada en " + (this.getTardar * 10) + " ms");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
