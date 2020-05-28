package final_;

import java.util.Arrays;

public class TestFinalValue {

	public static void main(String[] args) {
		Boolean a = false;
		a = true;
		final boolean b = a;
		Arrays.asList(1, 2, 3, 4).forEach(i->{
			System.out.println(b);
			
		});

	}

}
