package dat;

import java.io.Serializable;

public class DataClass implements Serializable {

	private static final long serialVersionUID = 1L;
	String val1;
	int val2;
	boolean val3;
	public DataClass(String val1, int val2, boolean val3) {
		this.val1 = val1;
		this.val2 = val2;
		this.val3 = val3;
	}
	
	@Override
	public String toString() {
		return "Val1: "+val1+" Val2: "+val2+" Val3: "+val3;
	}
	
}
