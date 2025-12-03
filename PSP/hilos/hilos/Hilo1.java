package hilos;

public class Hilo1 extends Thread {

	public void run() {
		Long i = 0L;
		Long e = 0L;
		for (;;) {
			boolean interrupted = isInterrupted();
			if (interrupted) {
				System.out.println("Me han cerrao el chiringo");
				System.out.println(e);
				return;
			}
			if (++i == 100000000L) {
				i = 0L;
				System.out.println("hallo!!");
			}
			++e;

		}
		
	}
}
