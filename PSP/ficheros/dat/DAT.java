package dat;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DAT {
	
	public static void main(String[] args) {
		DataClass dc = new DataClass("Nombre", 2, false);
		writeDAT(dc);
		readDAT();
	}
	
	public static void readDAT() {
		
		File file = new File("ficheros/recursos/prueba.dat");
		DataClass dc;
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			dc = (DataClass) ois.readObject();
			
			System.out.println(dc.toString());
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("Error al leer el archivo");
		}
		
	}
	
	public static void writeDAT(DataClass objeto) {
		
		File file = new File("ficheros/recursos/prueba.dat");
		
		try {
			file.createNewFile();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			oos.writeObject(objeto);
			
		} catch (IOException e) {
			System.out.println("Error al crear el archivo");
		}
	}
	
}
