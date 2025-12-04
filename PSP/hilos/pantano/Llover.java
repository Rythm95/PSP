/**
* Clase Llover.java
*
* @author Simao Fernandez Gervasoni
* @version 1.0
*/
package pantano;

import java.util.concurrent.Semaphore;

public class Llover extends Thread {

	Semaphore semPantano;
	Semaphore semFin = new Semaphore(0);
	Pantano pantano;
	static int contador_llover = 0;
	boolean parar = false;

	public Llover(Semaphore s, Pantano pantano, Semaphore semFin) {
		this.semPantano = s;
	}

	public void parar() {
		this.parar = true;
		
	}
}
