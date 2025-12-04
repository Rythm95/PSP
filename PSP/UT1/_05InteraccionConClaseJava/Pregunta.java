package _05InteraccionConClaseJava;

import java.time.LocalDate;
import java.util.Scanner;

public class Pregunta {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        String nombre = teclado.nextLine();
        try {
            System.out.println("==================================");
            System.out.println("==== Hola " + nombre);
            System.out.println("==== Fecha de hoy:" + LocalDate.now());
            System.out.println("==== Seas bienvenido !!!");
            System.out.println("==================================");
        } catch (Exception e) {
            System.out.println("Se ha producido una excepcion:" + e.getLocalizedMessage());
            e.printStackTrace();
        }
    }

}
