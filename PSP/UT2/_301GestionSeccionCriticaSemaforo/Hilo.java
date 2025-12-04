package _301GestionSeccionCriticaSemaforo;

import java.util.concurrent.Semaphore;

/**
 * Esta clase implementa un hilo que maneja un recurso compartido consistente en
 * un vector de 10 posiciones, incrementando todas las posiciones de dicho 
 * vector con un número que dicho hilo tiene asignado y decrementando después
 * todas las posiciones de dicho vector con ese mismo número. El hilo atomiza
 * el acceso al vector para incrementarlo o decrementarlo, impidiendo de esa
 * forma que una instancia del hilo pueda incrementar o decrementar el vector 
 * mientras otra instancia del propio hilo está incrementando o decrementando
 * dicho vector
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 3.0
*/
public class Hilo extends Thread {
    int valor;
    RecursoCompartido r;
    Semaphore s;

    /**
     * Constructor que pèrmite inicializar el hilo con el valor asignado al
     * hilo, el recurso compartido (que contiene el vector de 10 posiciones) y 
     * el semáforo que va a permitir o bloquear el acceso al recurso compartido     * 
     * @param valor Valor asignado al hilo
     * @param r Recurso compartdo que contiene el vector de 10 posiciones
     * @param s Semáforo que permite o bloquea el acceso al recurso compartido 
    */
    public Hilo(int valor, RecursoCompartido r, Semaphore s) {
        this.valor = valor;
        this.r = r;
        this.s = s;
    }

    /**
     * Método que implementa el comportamiento del hilo
    */
    @Override
    public void run() {
        wait_sem();
        System.out.println("Incrementando con el Hilo " + valor);
        // Inicio de Sección Crítica");
        r.incrementar(valor);
        r.mostrar();
        // Fin de Sección Crítica");
        signal_sem();
        wait_sem();
        System.out.println("Decrementando con el Hilo " + valor);
        // Inicio de Sección Crítica");
        r.decrementar(valor);
        r.mostrar();
        // Fin de Sección Crítica");
        signal_sem();
    }
    
    /**
     * Método que implementa el método wait del hilo
    */
    public void wait_sem() {
        try {
            s.acquire();
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());;
        }
    }
    
    /**
     * Método que implementa el método signal del hilo
    */
    public void signal_sem() {
        s.release();
    }
    
}
