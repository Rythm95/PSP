package equipos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		
		Random rn = new Random();
		List<Boolean> circulo = new ArrayList<>();
		
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
		
		int numfalse = 0;
		for (Boolean b : circulo) {
			System.out.println(b);
			if (b == true) {
				numfalse++;
			}
		}
		System.out.println(numfalse);
		
	}
	
}
