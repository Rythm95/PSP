package consumoenergetico;

import java.util.ArrayList;
import java.util.List;

public class Comunidad extends Thread {

	private String nombre;
	private List<Vivienda> viviendas = new ArrayList<>();
	private double contadorComunidad;

	public Comunidad(String nombre, int numViviendas) {
		this.nombre = nombre;

		for (int i = 1; i <= numViviendas; i++) {
			viviendas.add(new Vivienda(nombre + "-" + i, this));
		}

	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Vivienda> getViviendas() {
		return viviendas;
	}

	public void setViviendas(List<Vivienda> viviendas) {
		this.viviendas = viviendas;
	}

	public double getContadorComunidad() {
		return contadorComunidad;
	}

	public void setContadorComunidad(double contadorComunidad) {
		this.contadorComunidad = contadorComunidad;
	}

	@Override
	public void run() {
		iniciarViviendas();
	}

	private void iniciarViviendas() {

		for (Vivienda v : viviendas) {
			v.start();
		}

		for (Vivienda v : viviendas) {
			try {
				v.join();
			} catch (InterruptedException e) {
				System.out.println("Error join: " + e);
			}
		}
	}

	public synchronized void sumarContador(double gasto) {
		this.contadorComunidad += gasto;
	}

	public void reiniciarContador() {
		this.contadorComunidad = 0;
	}

	public double gastoMedioVivienda() {
		return this.contadorComunidad / viviendas.size();

	}

}
