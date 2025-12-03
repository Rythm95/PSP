package executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) {

		ExecutorService service = Executors.newSingleThreadExecutor();
		service.submit(new Executor("Tareita", 2, TimeUnit.SECONDS));
		System.out.println("Epa.");
		
		System.out.println("It is I: "+Thread.currentThread().threadId());
		
		service.shutdown();
	}

}
