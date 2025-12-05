package consumoenergetico;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Random rn = new Random();

		Map<Integer, String> meses = new HashMap<>();

		meses.put(1, "Enero");
		meses.put(2, "Febrero");
		meses.put(3, "Marzo");
		meses.put(4, "Abril");
		meses.put(5, "Mayo");
		meses.put(6, "Junio");
		meses.put(7, "Julio");
		meses.put(8, "Agosto");
		meses.put(9, "Septiembre");
		meses.put(10, "Octubre");
		meses.put(11, "Noviembre");
		meses.put(12, "Diciembre");

		DecimalFormat df = new DecimalFormat("###.##");

		double gastoGlobal = 0;

		for (int i = 1; i <= 12; i++) {

			List<Comunidad> comunidades = new ArrayList<>();

			for (int j = 1; j <= 100; j++) {
				Comunidad c = new Comunidad(j + "", rn.nextInt(1, 20));
				comunidades.add(c);
			}

			for (Comunidad c : comunidades) {
				c.start();
			}

			double gastoMedio = 0;
			Comunidad maxGastoMedio = null;
			double gastoVivienda = 0;
			Vivienda maxVivienda = null;

			System.out.println(" --- " + meses.get(i) + " --- ");
			for (Comunidad c : comunidades) {
				System.out
						.println("Comunidad " + c.getNombre() + " gastó " + df.format(c.getContadorComunidad()) + "kW");
				gastoGlobal += c.getContadorComunidad();
				System.out.println("Media por vivienda: " + df.format(c.gastoMedioVivienda()) + "kW");
				if (c.gastoMedioVivienda() > gastoMedio) {
					gastoMedio = c.gastoMedioVivienda();
					maxGastoMedio = c;
				}

				for (Vivienda v : c.getViviendas()) {
					if (gastoVivienda < v.getGasto()) {
						gastoVivienda = v.getGasto();
						maxVivienda = v;
					}
					v.reiniciarGasto();
				}
				c.reiniciarContador();

				System.out.println();

				try {
					c.join();
				} catch (InterruptedException e) {
					System.out.println("Error join 2: "+e);
				}
			}

			System.out.println("Comunidad con mayor gasto medio por vivienda en " + meses.get(i) + ": "
					+ maxGastoMedio.getNombre());
			System.out.println("Vivienda que más gastó en " + meses.get(i) + ": " + maxVivienda.getNombre() + " ("
					+ df.format(gastoVivienda) + "kW)");

			System.out.println("\n");

		}

		System.out.println("\nGasto anual de la localidad: " + df.format(gastoGlobal) + "kW");

	}

}
