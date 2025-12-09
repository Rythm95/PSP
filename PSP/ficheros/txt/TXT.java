package txt;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TXT {

	public static void main(String[] args) {

		//writeTxt();
		
		readTxt();

	}

	public static void readTxt() {

		String val1 = "";
		int val2 = 0;
		String val3 = "";

		File file = new File("ficheros/recursos/prueba.txt");

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] data = line.split("\\|");
				if (!data[0].isEmpty()) {
					val1 = data[0];
					val2 = Integer.parseInt(data[1]);
					val3 = data[2];
				}
				System.out.println("Val1: "+val1+" Val2: "+val2+" Val3: "+val3);
			}
			
			
		} catch (IOException e) {
		}

	}

	public static void writeTxt() {

		File creFile = new File("ficheros/recursos/prueba.txt");

		String val1 = "Val1";
		int val2 = 2;
		String val3 = "Val3";

		try (BufferedWriter bw = new BufferedWriter(new FileWriter(creFile, true))) { // true: Que se escriba debajo en
																						// vez de reescribir todo.
			creFile.createNewFile();
			bw.write(val1 + "|" + val2 + "|" + val3);
			bw.newLine();

		} catch (IOException e) {
			System.out.println("Error al escribir el archivo.");
		}

	}

}
