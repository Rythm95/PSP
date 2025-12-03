package procesos;

import java.io.IOException;

public class proRuntime {

	public static void main(String[] args) {
		try {
			ProcessBuilder pb = new ProcessBuilder("\"C:\\Users\\usuario\\Downloads\\documentacion (8).pdf");
			
			Process proceso1 = pb.start();

			System.out.println("Abriendo notas");

			int result = proceso1.waitFor();

			if (result == 0) {
				System.out.println("Proceso cerrado.");
			} else {
				System.out.println("Error al ejecutar el programa.");
			}

		} catch (IOException e) {
			System.out.println("prob 1");
		} catch (InterruptedException e) {
			System.out.println("prob 2");
		}

	}
}
