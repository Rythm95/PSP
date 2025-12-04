package _08RedireccionamientoDeSalida;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * En esta clase se muestra: 1. Cómo modificar el dispositivo de por el que se
 * envían los mensajes de salida 2. Cómo modificar el dispositivo de por el que
 * se envían los mensajes de error 3. Todo ello utilizando ProcessBuilder Para
 * poder ejecutar este proyecto será necesario que existan las siguientes
 * variables de entorno: 1. El fichero saludo.bat debe alojarse en el directorio
 * c:\maniobra 2. La carpeta c:\scripts debe existir en el sistema
 *
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
 */
public class PMPConsola202 {

    /**
     * Método principal de la clase
     *
     * @param args No recibe parámetros de entrada
     */
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("cmd", "/c", "dir");
        File salida = new File(".\\maniobra\\salida.txt");
        File error = new File(".\\maniobra\\error.txt");
        pb.redirectError(error);
        pb.redirectOutput(salida);
        
        try {
            pb.start();
            
         //   https://runebook.dev/es/docs/openjdk/java.base/java/lang/processbuilder.redirect
           // pb = new ProcessBuilder("cmd", "/c", args[0]);
           // pb.start();
        } 
        catch (IOException ex) {
            System.out.println("Se ha producido una excepcion:" + ex.getLocalizedMessage());
            ex.printStackTrace();
        } 

    }

}
