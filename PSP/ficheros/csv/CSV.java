package csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CSV {

	public static void main(String[] args) {
		//writeCSV();
		readCSV();
	}

	public static void readCSV() {

		String val1;
		int val2;
		String val3;

		File file = new File("ficheros/recursos/prueba.csv");

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			br.readLine();
			while ((line = br.readLine()) != null) {
				String[] datos = line.split("\\|");
				val1 = datos[0];
				val2 = Integer.parseInt(datos[1]);
				val3 = datos[2];
				System.out.println(val1 + " " + val2 + " " + val3);
			}
		} catch (IOException e) {
			System.out.println("Error al leer los datos.");
		}

	}

	public static void writeCSV() {

		File creFile = new File("ficheros/recursos/prueba.csv");

		String val1 = "Val1";
		int val2 = 2;
		String val3 = "Val3";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(creFile, true))) { // true: Que se escriba debajo
																						// en vez de reescribir
																						// todo.
			if (!creFile.exists() || creFile.length() == 0) {
				creFile.createNewFile();

				// Encabezado
				bw.write("Val1" + "|" + "Val2" + "|" + "Val3");
				bw.newLine();
			}

			bw.write(val1 + "|" + val2 + "|" + val3);
			bw.newLine();

		} catch (IOException e) {
			System.out.println("Error al escribir el archivo." + e);
		}

	}

}
