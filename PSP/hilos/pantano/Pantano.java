/**
* Clase Pantano.java
*
* @author Simao Fernandez Gervasoni
* @version 1.0
*/
package pantano;

import java.util.ArrayList;

public class Pantano {
	int capacidad;
	int [][] gastos = new int[5][12]; //Gastos por ciudadano y mes
	ArrayList<Integer> lluvias = new ArrayList<>();
	
	public Pantano(int capacidad) {
		this.capacidad = capacidad;
	}
	
	public void gastar(int valor, int mes, int ciudadano) {
		this.capacidad -= valor;
		gastos[ciudadano-1][mes-1] = valor;
	}
	
	public int valor () {
		
		// ???
		return 0;
	}
}
