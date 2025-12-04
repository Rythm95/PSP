package pruebasemaphore2;

import java.util.concurrent.Semaphore;

public class ServerPrueba {
	
	private static final Semaphore sp = new Semaphore(2);
	
	public static void main(String[] args) {
		Runnable tasks = () -> {
			try {
				sp.acquire();
				System.out.println(Thread.currentThread().getName()+ " Accediendo");
				Thread.sleep(2000);
				System.out.println(Thread.currentThread().getName()+" Terminado");
				sp.release();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				sp.release();
			}
			
		};
		
		for (int i = 1; i<=5; i++) {
			new Thread(tasks, "Hilo-"+i).start();
		}
		
	}
	
}
