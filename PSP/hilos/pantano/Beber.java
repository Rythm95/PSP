/**
* Clase Beber.java
*
* @author Simao Fernandez Gervasoni
* @version 1.0
*/
package pantano;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Beber extends Thread{
	
	int idCiudadano;
	int mes;
	String nombre;
	Semaphore semPantano;
	Pantano pantano;
	
	static int contador_sequias = 0; // variable igual para todas las instancias de la clase
	Random rn = new Random();
	
	public void run() {
		int cantidad; //cantidad aleatoria de agua
		try {
			semPantano.acquire();
			cantidad = rn.nextInt(1,6);
			if (cantidad <= pantano.valor()) {
				pantano.gastar(cantidad, mes, idCiudadano);
			}
			
		} catch(InterruptedException e) {
			
		}
	}
	
}
