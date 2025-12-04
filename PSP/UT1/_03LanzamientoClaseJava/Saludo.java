package _03LanzamientoClaseJava;

import java.time.LocalDate;

public class Saludo{

    public static void main(String[] args) {
        System.out.println("==================================");
	System.out.println("==== Hola " + args[0]);
        System.out.println("==== Fecha de hoy:" + LocalDate.now());
        System.out.println("==== Seas bienvenido !!!");
        System.out.println("==================================");
    }
    
}
