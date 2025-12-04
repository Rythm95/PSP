package _300SincronizacionConSemaforos;

import java.util.concurrent.Semaphore;

/**
 * Esta clase implementa un hilo que muestra su nombre y el estado del semáforo
 * que permite o bloquea su ejecución
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 3.0
*/
public class Hilo extends Thread {

    Semaphore s;

    /**
     * Constructor que pèrmite inicializar el hilo con el semáforo que le 
     * permite o bloquea su ejecución
     * @param s Semáforo que permite o bloquea la ejecución del hilo 
    */
    public Hilo(Semaphore s) {
        this.s = s;
    }
    
    
    /**
     * Método que implementa el comportamiento del hilo
    */
    @Override
    public void run() {
        wait_sem();
        System.out.println("Hilo " + this.getName() + ": estoy dentro");
        System.out.println("* Cantidad de hilos concurrentes adicionales permitidos: " + s.availablePermits() + " - Cantidad de hilos bloqueados: " + s.getQueueLength() + " - ¿Hay hilos bloqueados?: " + s.hasQueuedThreads());
        signal_sem();
    }
    
    /**
     * Método que implementa el método wait del hilo
    */
    public void wait_sem() {
        try {
            s.acquire();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    /**
     * Método que implementa el método signal del hilo
    */
    public void signal_sem() {
        s.release();
    }
}
