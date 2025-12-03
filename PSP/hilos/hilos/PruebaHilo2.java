package hilos;

import java.time.Duration;

public class PruebaHilo2 {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(() -> {
			try{
				System.out.println("Inicio");
				Thread.sleep(Duration.ofSeconds(2));
				System.out.println("Fin");
			} catch (InterruptedException e) {
				System.out.println("Error");
			}
		});
		
		t.start();
		
		boolean status = false;
		status = t.join(Duration.ofSeconds(1));
		System.out.println(status);
		while (t.isAlive()) {
			System.out.println("El hilo sigue en ejecución.");
			t.join(500);
		}
		
		
		System.out.println("Listo");
		
	}
	
	
}
