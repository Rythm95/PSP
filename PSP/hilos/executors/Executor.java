package executors;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Executor implements Runnable {

	long amount;
	TimeUnit unit;
	String id;

	public Executor(String id, long amount, TimeUnit unit) {
		this.amount = amount;
		this.unit = unit;
		this.id = id;
	}

	@Override
	public void run() {
		System.out.println("It is I: "+Thread.currentThread().threadId());
		
		System.out.println(id + " Iniciado.");

		try {
			Thread.sleep(Duration.of(amount, unit.toChronoUnit()));
			System.out.println(id + " Finalizado.");
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
