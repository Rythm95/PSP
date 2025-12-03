package contador;

import java.util.Random;

public class MainTimbre {
	static Random rn = new Random();

	static class Timbre {

		public void timbre() {

			synchronized (this) {

				System.out.println("Ding... ");
				try {
					Thread.sleep(2000);
					int r = rn.nextInt(15) + 1;

					if (r == 7) {
						System.out.println("Quack!");
					} else {
						System.out.println("Dong.");
					}
				} catch (InterruptedException e) {
					System.out.println("... *Cough*");
				}
			}
		}
	}

	static class Visitante implements Runnable {
		Timbre t;

		public Visitante(Timbre t) {
			this.t = t;
		}

		@Override
		public void run() {
			t.timbre();
		}

	}

	public static void main(String[] args) {
		Timbre t = new Timbre();
		Thread v1 = new Thread(new Visitante(t));
		Thread v2 = new Thread(new Visitante(t));
		try {
			v1.start();
			v2.start();
			v1.join();
			v2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
