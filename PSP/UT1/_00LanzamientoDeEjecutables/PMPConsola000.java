package _00LanzamientoDeEjecutables;

import java.io.IOException;

/**
 * En esta clase se muestra:
 *  1. Cómo lanzar un ejecutable de windows y continuar con el programa
 *  2. Cómo lanzar un ejecutable de windows y esperar a que termine
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMPConsola000 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        String comando1 = "notepad.exe";
        String comando2 = "mspaint.exe";
        String comando3 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe https://alojaweb.educastur.es/web/cifplalaboral/centro";
       
        Process proceso1 = null, proceso2 = null, proceso3 = null;
        try {
            System.out.println("Lanzando el comando1:" + comando1);
            proceso1 = r.exec(comando1);
            System.out.println("El nuevo programa "+comando1+" está corriendo pero el programa principal sigue.");

            System.out.println("Lanzando el comando2:" + comando2);
            proceso2 = r.exec(comando2);
            System.out.println("Esperando a que termine la ejecución de " + comando2);
            int resultado = proceso2.waitFor();
            if (resultado == 0) {
                System.out.println(comando2 + " ha finalizado correctamente");
            } else {
                System.out.println("ERROR en la ejecución de "+ comando2);
            }
            System.out.println("Lanzando el comando3: " + comando3);
            proceso3 = r.exec(comando3);
            
        } catch (IOException ex) {
            System.out.println("Error IOException: " + ex.getMessage());
        } catch (InterruptedException ex) {
            System.out.println("Error InterruptedException: " + ex.getMessage());
        }
        System.out.println("FIN");
    }
    
}
