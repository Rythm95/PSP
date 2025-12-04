package serversemaphor;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Server implements Runnable {

	private final Random rn = new Random();

	private final Semaphore sem;
	private static final int numUsers = 100;

	public Server() {
		sem = new Semaphore(numUsers);
		new Thread(this::status).start();
	}

	public void status() {
		while (true) {
			try {
				Thread.sleep(1000);
				System.out.println("Usuarios en el server: " + (numUsers - sem.availablePermits()));
			} catch (InterruptedException e) {

			}
		}
	}

	public boolean tryLogin() {
		return sem.tryAcquire();
	}

	public void logout() {
		sem.release();
	}

	@Override
	public void run() {
		try {
			while (!tryLogin()) {
				Thread.sleep(rn.nextInt(1000));
			}
			Thread.sleep(rn.nextInt(1000));
			logout();
		} catch (InterruptedException e) {
			System.out.println("Boowomp");
		}
	}
}
