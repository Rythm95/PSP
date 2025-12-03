package filos;

import java.util.Random;

public class Filosofo implements Runnable {

	private static Random rn = new Random();
	private Tenedor izquierdo = new Tenedor();
	private Tenedor derecho = new Tenedor();

	String nombre;

	public Filosofo(String nombre, Tenedor izquierdo, Tenedor derecho) {
		this.nombre = nombre;
		this.izquierdo = izquierdo;
		this.derecho = derecho;

	}

	public void run() {
		while (true) {
			pensar();
			comer();
		}

	}

	private void pensar() {
		System.out.println(nombre + " está pensando...");
		esperar(rn.nextInt(2000, 3000));

	}

	private void esperar(int ms) {
		try {
			Thread.sleep(ms);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void comer() {
		System.out.println(nombre + " tiene hambre y agarra el tenedor izquierdo");
		esperar(rn.nextInt(400, 600));
		
		synchronized (izquierdo) {
			System.out.println(nombre + " agarra el tenedor derecho.");
			esperar(rn.nextInt(400, 600));
			
			synchronized (derecho) {
			System.out.println(nombre+" está comiendo...");
			esperar(rn.nextInt(2000, 3000));
			}
			System.out.println(nombre+" ha soltado el tenedor derecho.");
		}
		System.out.println(nombre+" ha soldato el tenedor izquierdo.");
	}

}
