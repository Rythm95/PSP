package consumoenergetico;

import java.util.Random;

public class Vivienda extends Thread {

	Random rn = new Random();
	private String nombre;
	private Comunidad comunidad;
	private double gasto = 0;

	public Vivienda(String nombre, Comunidad comunidad) {
		this.nombre = nombre;
		this.comunidad = comunidad;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Comunidad getComunidad() {
		return comunidad;
	}

	public void setComunidad(Comunidad comunidad) {
		this.comunidad = comunidad;
	}

	public double getGasto() {
		return gasto;
	}

	public void setGasto(double gasto) {
		this.gasto = gasto;
	}

	@Override
	public void run() {
		gasto = generarGasto();
		comunidad.sumarContador(gasto);
	}

	public double generarGasto() {
		return rn.nextDouble(100.00, 200.00);
	}
	
	public void reiniciarGasto() {
		gasto = 0;
	}

}
