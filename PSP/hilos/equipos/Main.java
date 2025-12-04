package equipos;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {

	private static List<Boolean> circulo = new ArrayList<>();
	private static boolean fin = false;

	public static List<Boolean> getCirculo() {
		return circulo;
	}

	public static void setCirculo(List<Boolean> circulo) {
		Main.circulo = circulo;
	}

	public static boolean isFin() {
		return fin;
	}

	public static void setFin(boolean fin) {
		Main.fin = fin;
	}

	private static Semaphore spCirculo = new Semaphore(1);

	public static void main(String[] args) {

		Random rn = new Random();

		for (int i = 0; i < 100; i++) {
			circulo.add(false);
		}

		for (int i = 0; i < 10;) {

			int rnum = rn.nextInt(100);
			if (circulo.get(rnum) != true) {
				circulo.set(rnum, true);
				i++;
			}

		}

		Equipo eq1 = new Equipo(1, spCirculo);
		Equipo eq2 = new Equipo(2, spCirculo);
		Equipo eq3 = new Equipo(3, spCirculo);
		System.out.println("Empieza el juego");
		eq1.start();
		eq2.start();
		eq3.start();

		do {
			try {
				System.out.println();
				Thread.sleep(Duration.ofSeconds(1));
			} catch (InterruptedException e) {
				System.out.println(e);
			}
		} while (!fin);
		System.out.println("Juego terminado.");
		cerrarHilos(eq1, eq2, eq3);

	}

	private static void cerrarHilos(Equipo eq1, Equipo eq2, Equipo eq3) {
		if (eq1.isAlive()) {
			if (eq1.getP1().isAlive())
				eq1.getP1().interrupt();
			if (eq1.getP2().isAlive())
				eq1.getP2().interrupt();
			if (eq1.getP3().isAlive())
				eq1.getP3().interrupt();
			eq1.interrupt();
		}
		if (eq2.isAlive()) {
			if (eq2.getP1().isAlive())
				eq2.getP1().interrupt();
			if (eq2.getP2().isAlive())
				eq2.getP2().interrupt();
			if (eq2.getP3().isAlive())
				eq2.getP3().interrupt();
			eq2.interrupt();
		}
		if (eq3.isAlive()) {
			if (eq3.getP1().isAlive())
				eq3.getP1().interrupt();
			if (eq3.getP2().isAlive())
				eq3.getP2().interrupt();
			if (eq3.getP3().isAlive())
				eq3.getP3().interrupt();
			eq3.interrupt();
		}
	}

}
