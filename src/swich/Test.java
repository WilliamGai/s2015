package swich;

public class Test {
	public static void main(String args[]) {
		for (int a = 1; a < 6; a++) {
			switch (a) {
			case 1:
			case 2:
			case 3:
				System.out.println("ccc :" + a);
				break;
			case 4:
				System.out.println("a :" + a);
				break;
			case 5:
				System.out.println("a :" + a);
				break;
			}
		}
	}
}
