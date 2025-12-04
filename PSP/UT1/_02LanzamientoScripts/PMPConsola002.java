package _02LanzamientoScripts;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * En esta clase se muestra:
 *  1. Cómo lanzar un script de MSDOS
 * Para poder ejecutar este proyecto será necesario que:
 *  1. El fichero saludo.bat debe alojarse en el directorio c:\maniobra
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMPConsola002 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();
        System.out.println("Dime tu nombre:");
        Scanner in = new Scanner(System.in);
        String nombre = in.nextLine();
        String comando = "cmd /c .\\maniobra\\saludo "+ nombre;
        Process proceso;
        try {
            System.out.println("Lanzando el script SALUDO.BAT de la carpeta maniobra.");
            proceso = r.exec(comando);
            System.out.println("Esperando a que termine la ejecución del Script ...");
            int resultado = proceso.waitFor();
            InputStream is;
            InputStreamReader isr;
            BufferedReader br;
            if (resultado == 0) {
                System.out.println("El Script se lanzó con éxito");
                is = proceso.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            } else {
                System.out.println("ERROR en la ejecución del Script !!!");
                is = proceso.getErrorStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            }
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
            isr.close();
            is.close();
        } catch (IOException ex) {
            System.out.println("Error: " + ex.getMessage());
        } catch (InterruptedException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }
    
}
