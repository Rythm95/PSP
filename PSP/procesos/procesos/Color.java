package procesos;

import java.io.IOException;
import java.util.Scanner;

public class Color {
	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		String color = "";

		System.out.println("Elige una opción.");
		System.out.println("2 - Lanzar el programa con Runtime");
		System.out.println("1 - Lanzar el programa con ProcessBuilder");
		System.out.println("0 - Salir");

		char menu = read.next().charAt(0);

		if (menu == 0) {
			System.out.println("Programa finalizado");
			return;
		}

		boolean colorValido = true;
		do {
			System.out.println("Elige el color de fondo del cmd:");
			colores();
			String fondo = read.next();

			switch (fondo) {
			case "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F":
				color.concat(fondo);
				break;
				
			default:
				System.out.println("Ha introducido un valor no válido");
				colorValido = false;

			}
		} while (colorValido);

		ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "start", "cmd.exe", "/k", "color", color);
		pb.inheritIO();
		try {
			Process p = pb.start();
		} catch (IOException e) {
			System.out.println("nuh-uh");
		}
	}

	public static void colores() {
		System.out.println("0=Negro\t\t8=Gris");
		System.out.println("1=Azul\t\t9=Azul claro");
		System.out.println("2=Verde\t\tA=Verde claro");
		System.out.println("3=Aguamarina\t\tB=Aguamarina claro");
		System.out.println("4=Rojo\t\tC=Rojo claro");
		System.out.println("5=Púrpura\t\tD=Púrpura claro");
		System.out.println("6=Amarillo\t\tE=Amarillo claro");
		System.out.println("7=Blanco\t\tF=Blanco brillante");

	}
}
