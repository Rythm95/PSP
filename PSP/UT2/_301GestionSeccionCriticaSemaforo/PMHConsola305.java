package _301GestionSeccionCriticaSemaforo;

import java.util.concurrent.Semaphore;

/**
 *
 * @author ifhprof01
 */
public class PMHConsola305 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Hilo[] listaHilos = new Hilo[10];
        RecursoCompartido r = new RecursoCompartido();
        Semaphore s = new Semaphore(1);
        
        for (int cont = 1; cont < 10; cont ++) {
            listaHilos[cont] = new Hilo(cont, r, s);
            listaHilos[cont].start();
        }
       
    }
    
}
