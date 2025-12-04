package _03LanzamientoClaseJava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * En esta clase se muestra:
 *  1. Cómo lanzar una clase Java
 * Para poder ejecutar este proyecto será necesario que existan las siguientes variables de entorno:
 *  1. PATH con la ubicación del programa java.exe
 *  2. CLASSPATH con la ubicación del fichero Saludo.class
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMPConsola003 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        Runtime r = Runtime.getRuntime();

        String comando = "javac .\\maniobra\\Saludo.java ";
        Process proceso;
        try {
            System.out.println("Compilando el programa Saludo.java");
            proceso = r.exec(comando);
            System.out.println("Esperando a que termine la compilación del programa Java ...");
            int resultado = proceso.waitFor();
            InputStream is;
            InputStreamReader isr;
            BufferedReader br;
            if (resultado == 0) {
                System.out.println("El programa Javac se ejecutó con éxito.");
                System.out.println("Dime tu nombre:");
                Scanner in = new Scanner(System.in);
                String nombre = in.nextLine();
                comando = "java .\\maniobra\\Saludo.java " + nombre;
                System.out.println("Lanzando ahora el programa Java");
                proceso = r.exec(comando);
                is = proceso.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            } else {
                System.out.println("ERROR en la compilación del programa con javac !!!");
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
        System.out.println("FIN");
    }
    
}
