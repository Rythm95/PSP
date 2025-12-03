package hilos;

public class Hilo2 implements Runnable{

	@Override
	public void run() {
		System.out.println("Hola desde "+this.getClass().getName());
		
	}

}
