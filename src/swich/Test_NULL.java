package swich;

public class Test_NULL {
	public static void main(String args[]) {
		for (int a = 1; a < 6; a++) {
			String b = null;
			switch (b) {
			case "1":
				System.out.println("ccc :" + a);
				break;
			case "4":
				System.out.println("a :" + a);
				break;
			case "5":
				System.out.println("a :" + a);
				break;
			}
		}
	}
}
