package hilos;

import java.time.Duration;

public class PruebaHilo1 {

	public static void main(String[] args) {
		Hilo1 h1 = new Hilo1();
		Thread h2 = new Thread(new Hilo2());
		
		System.out.println(h1.getState().name());
		
		// No h1.run()!!!!
		h1.start();
		h2.start();
		
		
		try {
			Thread.sleep(Duration.ofSeconds(4));
		} catch (InterruptedException e) {
			System.out.println("Me han chapao.");
			e.printStackTrace();
		}
		h1.interrupt();
		
		
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.print("- ");
			
		}
		
		
		System.out.println(h1.getState().name());
		
		System.out.println("Hii!");
		
	}
	
}
