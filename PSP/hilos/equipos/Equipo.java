package equipos;

import java.util.concurrent.Semaphore;

public class Equipo extends Thread {

	private String nombre;
	private Semaphore spCirculo;
	private final Semaphore spEquipo = new Semaphore(1);
	private int objEspe = 0;
	private boolean fin = false;

	private Participante p1;
	private Participante p2;
	private Participante p3;

	public Equipo(int num, Semaphore spCirculo) {
		this.nombre = "Equipo " + num;
		this.spCirculo = spCirculo;
		this.p1 = new Participante(1, this, spEquipo, spCirculo);
		this.p2 = new Participante(2, this, spEquipo, spCirculo);
		this.p3 = new Participante(3, this, spEquipo, spCirculo);
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Semaphore getSpCirculo() {
		return spCirculo;
	}

	public void setSpCirculo(Semaphore spCirculo) {
		this.spCirculo = spCirculo;
	}

	public int getObjEspe() {
		return objEspe;
	}

	public void setObjEspe(int objEspe) {
		this.objEspe = objEspe;
	}

	public boolean isFin() {
		return fin;
	}

	public void setFin(boolean fin) {
		this.fin = fin;
	}

	public Participante getP1() {
		return p1;
	}

	public void setP1(Participante p1) {
		this.p1 = p1;
	}

	public Participante getP2() {
		return p2;
	}

	public void setP2(Participante p2) {
		this.p2 = p2;
	}

	public Participante getP3() {
		return p3;
	}

	public void setP3(Participante p3) {
		this.p3 = p3;
	}

	public Semaphore getSpEquipo() {
		return spEquipo;
	}

	public void sumarObjeto() {
		objEspe += 1;
	}
	
	@Override
	public void run() {
		p1.start();
		p2.start();
		p3.start();
		do {
			try {
				p1.join();
				p2.join();
				p3.join();
				fin=true;
			} catch (InterruptedException e) {
				System.out.println(e);
			}
			
		}while (!fin);
		System.out.println("Finalización del hilo "+nombre);
		return;

	}

}
