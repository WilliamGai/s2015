package jvm;

import java.text.DecimalFormat;

public class TestJVM {
	public static void main(String[] args) {
		printM();
	}
	private static void printM() {
		long maxM = Runtime.getRuntime().maxMemory();
		long totalM = Runtime.getRuntime().totalMemory();
		long usedM = Runtime.getRuntime().freeMemory();
		System.out.println("maxM=" + getM(maxM));
		System.out.println("totalM=" + getM(totalM));
		System.out.println("usedM=" + getM(usedM));
	}
    public static String getM(long availmem) {
        double result = availmem / 1024f / 1024f;
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(result) + " MB";
   }
}
