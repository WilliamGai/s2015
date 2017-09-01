package exception;

import java.util.concurrent.Callable;

public class TestException2 {

	public static void testThrowExceptions() throws Exception {
		int[] arr = new int[0];
		arr[0] = 10;
	}

	public static void test(Callable<String> call) {
		try {
			call.call();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		test(() -> {
			testThrowExceptions();
			return "ok";
		});
	}
}
