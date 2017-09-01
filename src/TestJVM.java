public class TestJVM {
	public static void main(String[] args) {

		long maxM = Runtime.getRuntime().maxMemory();
		long totalM = Runtime.getRuntime().totalMemory();
		long usedM = Runtime.getRuntime().freeMemory();
		System.out.println("maxM=" + maxM + ",\ntotalM=" + totalM + "\nusedM=" + usedM);
	}
}
