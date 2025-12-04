package serversemaphor;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

	public static final int numRequests = 1000;

	public static void main(String[] args) {

		final Server server = new Server();
		final Random rn = new Random();
		ExecutorService es = Executors.newFixedThreadPool(numRequests);

		for (int i = 0; i < numRequests; i++) {
			es.submit(server);
		}

	}

}
