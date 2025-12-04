package pools;

import java.time.Duration;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Pool {

	public static void main(String[] args) {

		ExecutorService service = Executors.newFixedThreadPool(6);
		for (int i = 0; i < 8; i++) {
			service.submit(new Tarea("Tarea " + i, 2, TimeUnit.SECONDS));
		}
		
		service.shutdown();

	}

	static class Tarea implements Runnable {
		long amount;
		TimeUnit unit;
		String id;

		public Tarea(String id, long duracion, TimeUnit unit) {
			this.id = id;
			this.amount = duracion;
			this.unit = unit;
		}

		@Override
		public void run() {
			System.out.println(id + " Iniciamos");
			try {
				Thread.sleep(Duration.of(amount, unit.toChronoUnit()));
				System.out.println(id + " Terminado");
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}

	}

}
