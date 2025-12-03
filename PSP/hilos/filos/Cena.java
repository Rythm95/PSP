package filos;

public class Cena {

	public static void main(String[] args) {
		String[] nombres = { "Aristoteles", "Platon", "Socrates", "Epicuro" };

		Tenedor[] tenedores = new Tenedor[nombres.length];
		for (int i = 0; i < tenedores.length; i++) {
			tenedores[i] = new Tenedor();
		}
		
		Filosofo[] filosofos = new Filosofo[nombres.length];
		for (int i = 0; i < filosofos.length; i++) {
			Tenedor izquierdo = tenedores[i % tenedores.length];
			Tenedor derecho = tenedores [(i+1) % tenedores.length];
			filosofos[i] = new Filosofo(nombres[i], izquierdo, derecho);
		}
		
		for (Filosofo f : filosofos) {
			new Thread(f).start();
		}
	}

}
