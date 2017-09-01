package jvm;

import java.nio.ByteBuffer;
import java.text.DecimalFormat;

public class MemeryLeak2 {

	public static void main(String[] args) {
		dosleep(10);
		for (int i = 0; i < 100; i++) {
			final int threadNum = i;
			System.out.println("start create [" + threadNum + "]thread...");
			// create java thread
			// request xM memory from heap
			if (args.length > 0) {
				int x = Integer.parseInt(args[0]);
				byte[] bytes = new byte[x * 1024 * 1024];
				System.out.println("[" + threadNum + "]thread requested HeapMemory:" + x + "M");
				printM();
			}
			// request yM memory form DirectMemory
			if (args.length > 1) {
				int y = Integer.parseInt(args[1]);
				ByteBuffer directBuffer = ByteBuffer.allocate(y * 1024 * 1024);
				System.out.println("[" + threadNum + "]thread requested DirectMemory:" + y + "M");
				printM();
			}
			// keep this thread not exit
//			dosleep(10000);
			dosleep(1);
		}// for
			// keep this thread not exit
		dosleep(10000);
	}

	public static void dosleep(long seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void printM() {
		long maxM = Runtime.getRuntime().maxMemory();
		long totalM = Runtime.getRuntime().totalMemory();
		long freeM = Runtime.getRuntime().freeMemory();
		System.out.println("maxM=" + getM(maxM));
		System.out.println("totalM=" + getM(totalM));
		System.out.println("usedM=" + getM(totalM - freeM));
	}

	public static String getM(long availmem) {
		double result = availmem / 1024f / 1024f;
		DecimalFormat df = new DecimalFormat("#.##");
		return df.format(result) + " MB";
	}
}
