package _300SincronizacionConSemaforos;

import static java.lang.Thread.sleep;
import java.util.concurrent.Semaphore;

/**
 * En esta clase se muestra cómo llevar a cabo la sincronización entre hilos
 * con un semáforo
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 3.0
*/
public class PMHConsola300 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Semaphore s = new Semaphore(1);
        
        Hilo h1 = new Hilo(s);
        h1.setName("Uno");

        Hilo h2 = new Hilo(s);
        h2.setName("Dos");

        Hilo h3 = new Hilo(s);
        h3.setName("Tres");

        Hilo h4 = new Hilo(s);
        h4.setName("Cuatro");

        Hilo h5 = new Hilo(s);
        h5.setName("Cinco");

        Hilo h6 = new Hilo(s);
        h6.setName("Seis");
        
        System.out.println("* Cantidad de hilos concurrentes adicionales permitidos: " + s.availablePermits() + " - Cantidad de hilos bloqueados: " + s.getQueueLength() + " - ¿Hay hilos bloqueados?: " + s.hasQueuedThreads());
        h6.start();
        h1.start();
        h2.start();
        h3.start();
        h4.start();
        h5.start();
        

        try {
            sleep(10000);
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("* Cantidad de hilos concurrentes adicionales permitidos: " + s.availablePermits() + " - Cantidad de hilos bloqueados: " + s.getQueueLength() + " - ¿Hay hilos bloqueados?: " + s.hasQueuedThreads());
    }
    
}
