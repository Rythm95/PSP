package _301GestionSeccionCriticaSemaforo;

/**
 * Esta clase contiene un vector de 10 posiciones y las operaciones permitidas 
 * que se pueden realizar sobre dicho vector
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 3.0
*/
public class RecursoCompartido {
    private int[] lista;
    
    /**
     * Constructor de la clase. Inicializa todas las posiciones del vector a 0 
    */
    public RecursoCompartido() {
        lista = new int[10];
        for (int i = 0; i<10; i++) lista[i] = 0;
    }
    
    /**
     * Incrementa todas las posiciones del vector con un mismo valor
     * @param valor Valor con el que incrementar todas las posiciones del vector
    */
    public void incrementar(int valor) {
        for (int i = 0; i<10; i++) {
            lista[i] = lista[i] + valor;
        }
    }
    
    /**
     * Decrementa todas las posiciones del vector con un mismo valor
     * @param valor Valor con el que decrementar todas las posiciones del vector
    */
    public void decrementar(int valor) {
        for (int i = 0; i<10; i++) {
            lista[i] = lista[i] - valor;
        }
    }
    
    /**
     * Muestra todas las posiciones del vector
    */
    public void mostrar() {
        for (int i = 0; i<10; i++) System.out.print(lista[i] + "-");
        // Probar con esta sentencia para comprobar que no siempre se incrementa
        // y decrementa hilo a hilo
        // for (int i = 0; i<10; i++) if (lista[i] > 9) System.out.print(lista[i] + "-");
        System.out.println("Fin");
    }
}
