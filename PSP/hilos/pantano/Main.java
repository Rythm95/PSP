/**
* Clase Main.java
*
* @author Simao Fernandez Gervasoni
* @version 1.0
*/
package pantano;

import java.util.concurrent.Semaphore;

public class Main {

	public static void main(String[] args) {

		Semaphore semPantano;
		Semaphore semFin;
		semPantano = new Semaphore(1);
		semFin = new Semaphore(0);
		
		Pantano pantano = new Pantano(50);
		Llover lluvia = new Llover(semPantano, pantano, semFin);
		
		lluvia.start();
		for (int i = 1; i<=12; i++) {
			Beber ciudadano1; //= new...
		}
	}

}
