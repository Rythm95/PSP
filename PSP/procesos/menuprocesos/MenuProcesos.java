package menuprocesos;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuProcesos {

	public static void main(String[] args) {

		int menu = -1;
		Runtime r = Runtime.getRuntime();
		Scanner read = new Scanner(System.in);
		String comando = "";
		do {
			System.out.println("Introduzca la operación que desea realizar:");
			System.out.println("3 - Abrir Panel de Control");
			System.out.println("2 - Crear Nuevo Proceso");
			System.out.println("1 - Buscar Cadena de Caracteres");
			System.out.println("0 - Salir");
			menu = read.nextInt();
			read.nextLine();
			switch (menu) {
			case 3:
				try {
					System.out.println("Abriendo Panel de Control");
					String comando2 = "C:\\Users\\usuario\\AppData\\Local\\Packages\\Microsoft.4297127D64EC6_8wekyb3d8bbwe\\LocalCache\\Local\\runtime\\jre-legacy\\windows-x64\\jre-legacy\\bin\\javacpl.exe";
					Process p3 = r.exec(comando2);
					p3.waitFor();
				} catch (IOException | InterruptedException e) {
					System.out.println("Error case 3: " + e);
				}

				break;
			case 2:
				if (comando.isEmpty()) {
					System.out.println("Comando no disponible. Seleccione la opción 1 primero.");
					break;
				}
				try {
					ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", comando);
					File sal = new File("salida.txt");
					sal.createNewFile();
					pb.redirectOutput(sal);
					Process p2 = pb.start();
					System.out.println("Se ha creado el proceso.");

				} catch (IOException e) {
					System.out.println("Error en case 2: " + e);
				}

				break;
			case 1:
				try {
					System.out.println("Introduce el término de búsqueda:");
					String tb = read.nextLine();
					String parametros = "";

					System.out.println("¿Desea buscar al principio de la línea? [S para aceptar]");
					if (read.next().toUpperCase().charAt(0) == 'S')
						parametros = parametros.concat(" /B");
					read.nextLine();

					System.out.println("¿Desea buscar al final de la línea? [S para aceptar]");
					if (read.next().toUpperCase().charAt(0) == 'S')
						parametros = parametros.concat(" /E");
					read.nextLine();

					System.out.println("¿Desea buscar líneas de entorno? [S para aceptar]");
					if (read.next().toUpperCase().charAt(0) == 'S') {
						read.nextLine();
						System.out.println("¿Cuantas líneas de entorno desea buscar?");
						int numL = read.nextInt();
						parametros = parametros.concat(" /A:" + numL);
					}
					read.nextLine();

					System.out.println("Introduce la ruta del archivo donde se realizará la búsqueda:");
					String archivo = read.nextLine();

					comando = "FINDSTR /C:\"" + tb + "\"" + parametros + " " + "\"" + archivo + "\"";
					System.out.println();
					Process p = r.exec("cmd /c " + comando);

					BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
					BufferedReader brErr = new BufferedReader(new InputStreamReader(p.getErrorStream()));
					String line;
					while ((line = br.readLine()) != null) {
						System.out.println(line);
					}

					while ((line = brErr.readLine()) != null) {
						System.out.println("Error: " + line);
					}

					int salida = p.waitFor();
					if (salida == 1) {
						System.out.println("No se encontró la cadena.");
					}

				} catch (IOException e) {
					System.out.println("Error en case 1: " + e);
				} catch (InputMismatchException e) {
					System.out.println("Ha introducido un valor no válido.");
				} catch (InterruptedException e) {
					System.out.println("Error en case 1: " + e);
				}
				break;
			case 0:
				System.out.println("Saliendo.");
				return;

			default:

			}

		} while (true);

	}

}
