package equipos;

import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Participante extends Thread {
	private static final Random rn = new Random();

	private String nombre;
	private Equipo equipo;
	private Semaphore spEquipo;
	private Semaphore spCirculo;
	private boolean fin = false;

	public Participante(int num, Equipo equipo, Semaphore spEquipo, Semaphore spCirculo) {
		this.nombre = "Parcitipante " + num;
		this.equipo = equipo;
		this.spEquipo = spEquipo;
		this.spCirculo = spCirculo;
	}

	@Override
	public void run() {
		while (!fin) {
			if (Main.isFin()) finalizar();
			try {
				spEquipo.acquire();
				System.out.println(nombre + " del " + equipo.getNombre() + " corre al círculo");
				correr();
				System.out.println(nombre + " del " + equipo.getNombre() + " llega al circulo");
				spCirculo.acquire();
				System.out.println(nombre + " del " + equipo.getNombre() + " saca un objeto");
				List<Boolean> circulo = Main.getCirculo();
				int objCaja = rn.nextInt(circulo.size());
				
				System.out.println(objCaja + " - " + circulo.get(objCaja));
				
				if (circulo.get(objCaja) == true) {
					Main.getCirculo().remove(objCaja);
					System.out.println(nombre + " del " + equipo.getNombre() + " obtiene objeto especial.");
					equipo.sumarObjeto();
					if (equipo.getObjEspe() == 3 && !Main.isFin()) {
						System.out.println("Ha ganado el " + equipo.getNombre());
						finalizar();
						
					}

				} else {
					System.out.println(nombre + " del " + equipo.getNombre() + " no obtiene nada");
				}
				spCirculo.release();
				correr();
				spEquipo.release();

			} catch (InterruptedException e) {
			}
		}

	}

	public void correr() {
		try {
			sleep(rn.nextInt(500, 1000));
		} catch (InterruptedException e) {
		}
	}

	public void finalizar() {
		if (isAlive()) {
			spCirculo.release();
			spEquipo.release();
			System.out.println("Hilo " + nombre + " del " + equipo.getNombre() + " finalizado.");
			fin = true;
			Main.setFin(fin);
			return;
		}
	}

}
