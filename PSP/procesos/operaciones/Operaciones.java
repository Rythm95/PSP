package operaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Operaciones {

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		Runtime rt = Runtime.getRuntime();
		String rutaPersonal = System.getProperty("user.home");
		System.out.println(rutaPersonal);
		String SO = System.getProperty("os.name");
		boolean isWin = SO.toLowerCase().startsWith("windows");
		System.out.println(SO);
		try {
			String comando = "mkdir " + rutaPersonal + "\\nuevoDirectorio";
			System.out.println(comando);
			Process pr = rt.exec("cmd /c " + comando);

			String listar = "";
			if (isWin)
				listar = "dir " + rutaPersonal;
			else
				listar = "ls -al " + rutaPersonal;
			Process pr2 = rt.exec("cmd /c " + listar);
			listarContenido(pr2);

			if (isWin)
				comando = "rd " + rutaPersonal + "\\nuevoDirectorio";
			else
				comando = "rmdir " + rutaPersonal + "\\nuevoDirectorio";
			Process pr3 = rt.exec("cmd /c " + comando);
			
			ProcessBuilder pb = new ProcessBuilder("cmd.exe","/c",listar);
			Process pr4 = pb.start();
			listarContenido(pr4);
			System.out.println("Introduzca el nombre del fichero de salida");
			String nombre = read.next();
			File file = new File(nombre);
			file.createNewFile();
			pb.redirectOutput(file);
			pb.start();

		} catch (IOException e) {
			System.out.println("Error 1: " + e);
		}

	}

	public static void listarContenido(Process p) {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			System.out.println("Error 2: " + e);
		}

	}

}
