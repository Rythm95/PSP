package _01LanzamientoDeComandos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;

/**
 * En esta clase se muestra:
 *  1. Cómo lanzar un comando interno de MSDOS
 * @author Ignacio Fontecha Hernández
 * @version 1.0
 * @since PSP 1.0
*/
public class PMPConsola001 {

    /**
     * Método principal de la clase
     * @param args No recibe parámetros de entrada
    */
    public static void main(String[] args) {
        //En primer lugar se imprimen por la salida estándar todas las propiedades del sistema
        Properties p = System.getProperties();
        p.list(System.out);
        
        //Obtenemos la instancia de Runtime
        Runtime r = Runtime.getRuntime();
        //Obtenemos la propiedad user.home para el directorio raiz del usuario
        String homeDirectory = System.getProperty("user.home");
        //Obtenemos la propiedad os.name para saber si es un SO windows
        boolean isWindows = System.getProperty("os.name").toLowerCase().startsWith("windows");
        
        //Para listar los archivos de un directorio el comando en windows es dir y en Unix es ls
        //Además, la shell de windows se lanza con cmd /c y la de Unix con sh -c
        String comando = (isWindows? "dir": "ls");
        if(isWindows)
            comando = String.format("cmd.exe /c "+comando+" %s", homeDirectory);
        else
            comando = String.format("sh -c "+comando+" %s", homeDirectory);
        Process proceso;
        try {
            System.out.println("Lanzando el comando..." );
            proceso = r.exec(comando);
            System.out.println("Esperando a que termine la ejecución del comando ...");
            int resultado = proceso.waitFor();
            InputStream is;
            InputStreamReader isr;
            BufferedReader br;
            if (resultado == 0) {
                System.out.println("DIR se lanzó con éxito");
                is = proceso.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            } else {
                System.out.println("ERROR en la ejecución del comando!!!");
                is = proceso.getErrorStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
            }
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
            isr.close();
            is.close();
        } catch (IOException | InterruptedException ex) {
            System.out.println("Error: "  + ex.getMessage());
        }
    }
    
}
