package contador;

public class Contador {

	public static void main(String[] args) throws InterruptedException {
		for (;;) {
			iterar();
		}
	}

	public static class Contar {
		private int valor = 0;

		public synchronized void ping() {
			this.valor++;
		}

		public int getValor() {
			return valor;
		}
	}

	public static class Contable implements Runnable {
		private Contar cont;

		public Contable(Contar cont) {
			this.cont = cont;
		}

		@Override
		public void run() {
			cont.ping();
		}

	}

	public static int HILOS = 1000;

	public static void iterar() throws InterruptedException {
		Contar c = new Contar();

		Thread threads[] = new Thread[HILOS];
		for (int i = 0; i < HILOS; i++) {
			threads[i] = new Thread(new Contable(c));
		}
		
		for (int i = 0; i < HILOS; i++) {
			threads[i].start();
		}
		
		for (int i = 0; i < HILOS; i++) {
			threads[i].join();
		}
		
		int total = c.getValor();
			System.out.println(total);
	}

}
