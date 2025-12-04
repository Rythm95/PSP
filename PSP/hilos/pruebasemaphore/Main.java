package pruebasemaphore;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Main {

	private static Random rn = new Random();

	public static void main(String[] args) throws InterruptedException {
		final Main m = new Main();
		final Semaphore sem = new Semaphore(3);
		int numThreads = 99;
		final ExecutorService exe = Executors.newFixedThreadPool(numThreads + 1);
		for (int i = 0; i < numThreads; i++) {
			exe.submit(() -> m.tryAquire(sem));
		}
		
		while (true) {
			Thread.sleep(500);
			System.out.println("Cola: "+ sem.getQueueLength());
			if (sem.getQueueLength() == 0) {
				System.out.println("Sin más hilos");
				return;
			}
		}

//		sem.acquire();
//		sem.acquire();
//
//		System.out.println(sem.availablePermits());
//
//		sem.release(2);
//
//		System.out.println(sem.availablePermits());
	}
	
	private void tryAquire(Semaphore sem) {
		try {
			sem.acquire();
			Thread.sleep(rn.nextInt(1000));
			sem.release();
		} catch (InterruptedException e) {
			System.out.println(":(");
		}
		
	}

}
