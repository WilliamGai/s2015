package thread;

import org.springframework.util.StopWatch;

public class ThreadJoin {
	public static void main(String args[]) throws Exception {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				final int fi = i;
				Thread t11 = new Thread(() -> {
					System.out.println("t1 " + fi);
				});
				t11.start();
				try {
					t11.join();
//					Thread.sleep(10);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < 10000; i++) {
				final int fi = i;
				new Thread(() -> {
					System.out.println("t2 " + fi);
				}).start();
			}
		});
		StopWatch stopWatch = new StopWatch("test");
		stopWatch.start("t1");
		t1.start();
		t1.join();
		stopWatch.stop();
		stopWatch.start("t2");
		t2.start();
		t2.join();
		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());

	}
}
